package com.clinics.clinics;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.clinics.clinics.models.AddPatientModel;


public class Profile extends AppCompatActivity {
    TextView name , email,des,age,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.textView);
        email = findViewById(R.id.textView2);
        des = findViewById(R.id.deseas);
        age = findViewById(R.id.age);
        phone = findViewById(R.id.phone);

        AddPatientModel p =  getIntent().getParcelableExtra("obj");

        name.setText(p.getPatientName());
        age.setText(p.getDateOfBirth());
        des.setText(p.getDoctorName());
        email.setText(p.getGender());
        phone.setText(p.getPhoneNumber());
    }
}