package com.clinics.clinics;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.clinics.clinics.localDataBase.AddPatientDataBase;
import com.clinics.clinics.models.AddPatientModel;

import java.util.ArrayList;


public class PatientDetails extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<AddPatientModel> patientData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient_details);
        Toolbar toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);

        AddPatientDataBase addPatientDataBase = new AddPatientDataBase(this);
        patientData =addPatientDataBase.getData();
        listView = findViewById(R.id.listview);

        String[] names = new String[patientData.size()];
        for (int i = 0; i < patientData.size(); i++) {
            names[i] = patientData.get(i).getPatientName();
        }

       arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
       listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.action_serch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search For Patient.....");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedName = arrayAdapter.getItem(position); // الحصول على الاسم المحدد
                int actualPosition = -1;


                for (int i = 0; i < patientData.size(); i++) {
                    if (patientData.get(i).getPatientName().equals(selectedName)) {
                        actualPosition = i;
                        break;
                    }
                }

                if (actualPosition != -1) {
                    Intent intent = new Intent(PatientDetails.this, Profile.class);
                    intent.putExtra("obj", patientData.get(actualPosition));
                    startActivity(intent);
                }
            }
        });
        return true;
    }
}