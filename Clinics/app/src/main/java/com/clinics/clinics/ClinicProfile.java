package com.clinics.clinics;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.clinics.clinics.models.AddClinicModel;

public class ClinicProfile extends AppCompatActivity {
    TextView name , email,des,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clinic_profile);
        name = findViewById(R.id.textView);
        email = findViewById(R.id.textView2);
        des = findViewById(R.id.deseas);
        price = findViewById(R.id.price);

        AddClinicModel data =  getIntent().getParcelableExtra("obj");

        name.setText(data.getClinicName());
        price.setText(data.getExaminationPrice());
        des.setText(data.getClinicSpecialty());
    }
}