package com.clinics.clinics;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.clinics.clinics.localDataBase.AddClinicDataBase;
import com.clinics.clinics.localDataBase.AddPatientDataBase;
import com.clinics.clinics.models.AddClinicModel;
import com.clinics.clinics.models.AddPatientModel;

import java.util.ArrayList;

public class FinancialDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_financial_details);
        TextView totalPatient = findViewById(R.id.totalPatient);
        TextView totalMoney = findViewById(R.id.totalMoney);

        AddClinicDataBase clinicDataBase = new AddClinicDataBase(this);
        AddPatientDataBase patientDataBase = new AddPatientDataBase(this);
        ArrayList<AddPatientModel> patientData = patientDataBase.getData();
        ArrayList<AddClinicModel> clinicData = clinicDataBase.getData();

        totalPatient.setText(String.valueOf(patientData.size()));

        int totalExaminationPrice = 0;
        int totalReExaminationPrice = 0;

        for (int i = 0; i < clinicData.size(); i++) {
            totalExaminationPrice += Integer.parseInt(clinicData.get(i).getExaminationPrice());
            totalReExaminationPrice += Integer.parseInt(clinicData.get(i).getReExaminationPrice());
        }

        int totalMoneyValue = totalExaminationPrice + totalReExaminationPrice;
        totalMoney.setText(String.valueOf(totalMoneyValue));
    }
}