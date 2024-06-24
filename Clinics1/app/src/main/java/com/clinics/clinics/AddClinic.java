package com.clinics.clinics;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.clinics.clinics.localDataBase.AddClinicDataBase;
import com.clinics.clinics.models.AddClinicModel;
import com.google.android.material.textfield.TextInputEditText;

public class AddClinic extends AppCompatActivity {
    private Button buttonSend;
    private TextInputEditText editTextClinicName, editTextClinicSpecialty, editTextExaminationPrice, editTextReExaminationPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_clinic);
        AddClinicDataBase addClinicDataBase = new AddClinicDataBase(this);
        buttonSend = findViewById(R.id.buttonSend);
        editTextClinicName = findViewById(R.id.editTextClinicName);
        editTextClinicSpecialty = findViewById(R.id.editTextClinicSpecialty);
        editTextExaminationPrice = findViewById(R.id.editTextExaminationPrice);
        editTextReExaminationPrice = findViewById(R.id.editTextReExaminationPrice);

        buttonSend.setOnClickListener(v -> {
            String clinicName = editTextClinicName.getText().toString().trim();
            String clinicSpecialty = editTextClinicSpecialty.getText().toString().trim();
            String examinationPrice = editTextExaminationPrice.getText().toString().trim();
            String reExaminationPrice = editTextReExaminationPrice.getText().toString().trim();
            if (clinicName.isEmpty()) {
                Toast.makeText(this, "Please enter clinic name", Toast.LENGTH_SHORT).show();

            }
           else if (clinicSpecialty.isEmpty()) {
                Toast.makeText(this, "Please enter clinic specialty", Toast.LENGTH_SHORT).show();
            }
            else if (examinationPrice.isEmpty()) {
                Toast.makeText(this, "Please enter examination price", Toast.LENGTH_SHORT).show();
            }
            else if (reExaminationPrice.isEmpty()) {
                Toast.makeText(this, "Please enter re-examination price", Toast.LENGTH_SHORT).show();
            }else {
                AddClinicModel addClinicModel = new AddClinicModel(
                        clinicName,
                        clinicSpecialty,
                        examinationPrice,
                        reExaminationPrice
                );
                String result = addClinicDataBase.insertData(addClinicModel);
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                editTextClinicName.setText("");
                editTextClinicSpecialty.setText("");
                editTextExaminationPrice.setText("");
                editTextReExaminationPrice.setText("");
            }
        });
    }
}