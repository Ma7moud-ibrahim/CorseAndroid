package com.example.listview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GymsViewModel(private val stateHandle: SavedStateHandle) : ViewModel() {
    var state by mutableStateOf(emptyList<Gym>())
    private val apiService: GymsApiService

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
    }
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://gyms-cario-default-rtdb.firebaseio.com/")
            .build()
        apiService = retrofit.create(GymsApiService::class.java)

        getGyms()
    }

    private fun getGyms() {
        viewModelScope.launch(errorHandler) {
            val gyms = getGymsFromRemoteDB()
            withContext(Dispatchers.Main){
                state = gyms.restoreSelectedGyms()
            }
        }
    }

    private suspend fun getGymsFromRemoteDB() = withContext(Dispatchers.IO) {
        apiService.getGyms()
    }
    fun toggleFavouriteState(gymId: Int) {
        val gyms = state.toMutableStateList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }
        if (itemIndex != -1) {
            gyms[itemIndex] = gyms[itemIndex].copy(isFavourite = !gyms[itemIndex].isFavourite)
            storeSelectedGyms(gyms[itemIndex])
            state = gyms
        }
    }

    private fun storeSelectedGyms(gym: Gym) {
        val savedHandleList = stateHandle.get<List<Int>?>(FAV_IDS).orEmpty().toMutableList()
        if (gym.isFavourite) savedHandleList.add(gym.id)
        else savedHandleList.remove(gym.id)
        stateHandle[FAV_IDS] = savedHandleList
    }

    private fun List<Gym>.restoreSelectedGyms(): List<Gym> {
        val gyms = this
        stateHandle.get<List<Int>?>(FAV_IDS)?.let { savedIds ->
            savedIds.forEach { gymId ->
                gyms.find { it.id == gymId }?.isFavourite = true
            }
        }
        return gyms
    }

    companion object {
        const val FAV_IDS = "favouriteGymIds"
    }
}