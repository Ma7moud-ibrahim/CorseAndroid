package com.clinics.clinics;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.clinics.clinics.localDataBase.AddDoctorDatabase;
import com.clinics.clinics.models.AddDoctorModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;


public class AddDoctor extends AppCompatActivity {
    private TextInputEditText editTextName, editTextNationalID, editTextAddress, editTextPhoneNumber, editTextMedicalSpecialty;
    private RadioButton radioButtonMale, radioButtonFemale, radioButtonMarried, radioButtonUnmarried;
    private Button buttonAddDoctor, btnDatePicker;
    private TextView textViewDateOfBirth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AddDoctorDatabase addDoctorDatabase  = new AddDoctorDatabase(this);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_doctor);
        editTextName = findViewById(R.id.editTextName);
        editTextNationalID = findViewById(R.id.editTextNationalID);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextMedicalSpecialty = findViewById(R.id.editTextMedicalSpecialty);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonMarried = findViewById(R.id.radioButtonMarried);
        radioButtonUnmarried = findViewById(R.id.radioButtonUnmarried);
        buttonAddDoctor = findViewById(R.id.buttonAddDoctor);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        textViewDateOfBirth = findViewById(R.id.dateOfBirthTextView);
        btnDatePicker.setOnClickListener(v -> showDatePicker());
        buttonAddDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String nationalID = editTextNationalID.getText().toString();
                String address = editTextAddress.getText().toString();
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String medicalSpecialty = editTextMedicalSpecialty.getText().toString();
                String gender = radioButtonMale.isChecked() ? "Male" : "Female";
                String maritalStatus = radioButtonMarried.isChecked() ? "Married" : "Unmarried";
                String dateOfBirth = textViewDateOfBirth.getText().toString();

                if (name.isEmpty() || nationalID.isEmpty() || address.isEmpty() || phoneNumber.isEmpty() || medicalSpecialty.isEmpty() || dateOfBirth.isEmpty()) {
                    Toast.makeText(AddDoctor.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    AddDoctorModel addDoctorModel = new AddDoctorModel(
                            name,
                            nationalID,
                            address,
                            phoneNumber,
                            medicalSpecialty,
                            gender,
                            maritalStatus,
                            dateOfBirth
                    );
                    String result = addDoctorDatabase.insertData(addDoctorModel);
                    Toast.makeText(AddDoctor.this,result,Toast.LENGTH_SHORT).show();
                    editTextName.setText("");
                    editTextNationalID.setText("");
                    editTextAddress.setText("");
                    editTextPhoneNumber.setText("");
                    editTextMedicalSpecialty.setText("");
                    textViewDateOfBirth.setText("Date of Birth");
                    radioButtonMale.setChecked(false);
                    radioButtonFemale.setChecked(false);
                    radioButtonMarried.setChecked(false);


                }
            }
        });
    }
    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) -> {
                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    textViewDateOfBirth.setText(date);
                },
                year, month, dayOfMonth);
        datePickerDialog.show();
    }

}