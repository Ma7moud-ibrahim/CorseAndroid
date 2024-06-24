package com.clinics.clinics;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.card.MaterialCardView;

public class HomeClinic extends AppCompatActivity {
    MaterialCardView patient,doctor,clinic,money,patientDetails,clinicDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_clinic);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        patient = findViewById(R.id.patient);
        doctor = findViewById(R.id.doctor);
        clinic = findViewById(R.id.clinic);
        money = findViewById(R.id.money);
        Toolbar toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        patientDetails = findViewById(R.id.patientdetails);
        clinicDetails = findViewById(R.id.clinicdetails);
        Intent addPatient = new Intent(this,AddPatient.class);
        Intent addDoctor = new Intent(this,AddDoctor.class);
        Intent addClinic = new Intent(this,AddClinic.class);
        Intent patientDetailsIntent = new Intent(this,PatientDetails.class);
        Intent clinicDetailsIntent = new Intent(this,ClinicDetails.class);

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(addPatient);
            }
        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(addDoctor);
            }
        });

        clinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(addClinic);
            }
        });

        patientDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(patientDetailsIntent);
            }
        });
        clinicDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(clinicDetailsIntent);
            }
        });
        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeClinic.this, "Financial Details", Toast.LENGTH_SHORT).show();
            }
        });
        settings();
    }

    private  void settings(){
        ImageView imageView = findViewById(R.id.buttonSetting);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeClinic.this, Setting.class);
               startActivity(intent);
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.setting_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int ItemId = item.getItemId();
//        if (ItemId == R.id.setting) {
//            Intent intent = new Intent(HomeClinic.this, Setting.class);
//            startActivity(intent);
//        }
//        return true;
//    }
    }
