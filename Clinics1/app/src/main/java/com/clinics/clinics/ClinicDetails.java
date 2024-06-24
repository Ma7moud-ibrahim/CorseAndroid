package com.clinics.clinics;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import com.clinics.clinics.localDataBase.AddClinicDataBase;
import com.clinics.clinics.models.AddClinicModel;
import java.util.ArrayList;

public class ClinicDetails extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<AddClinicModel> clinicData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clinic_details);
        Toolbar toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        AddClinicDataBase addClinicDataBase = new AddClinicDataBase(this);
        clinicData = addClinicDataBase.getData();
        listView = findViewById(R.id.listview);

        String[] names = new String[clinicData.size()];

        for (int i = 0; i < clinicData.size(); i++) {
            names[i] = clinicData.get(i).getClinicName();
        }

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        listView.setAdapter(arrayAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.action_serch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search For Clinic.....");
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
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ClinicDetails.this, ClinicProfile.class);
                intent.putExtra("obj",clinicData.get(i));
                startActivity(intent);
            }
        });
        return true;
    }
}