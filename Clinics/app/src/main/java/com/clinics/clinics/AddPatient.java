package com.clinics.clinics;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.clinics.clinics.localDataBase.AddDoctorDatabase;
import com.clinics.clinics.localDataBase.AddPatientDataBase;
import com.clinics.clinics.models.AddDoctorModel;
import com.clinics.clinics.models.AddPatientModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
public class AddPatient extends AppCompatActivity {
    private Button btnDatePicker, buttonSend;
    private RadioButton radioButtonMale, radioButtonFemale;
    private TextInputEditText editTextPatientName, editTextPhoneNumber;
    private TextView textViewDateOfBirth;
    private AutoCompleteTextView editTextDoctorName, patient_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_patient);
        AddPatientDataBase addPatientDataBase = new AddPatientDataBase(this);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        buttonSend = findViewById(R.id.buttonSend);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        editTextPatientName = findViewById(R.id.editTextPatientName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        textViewDateOfBirth = findViewById(R.id.dateOfBirthTextView);
        editTextDoctorName = findViewById(R.id.editTextDoctorName);
        patient_type = findViewById(R.id.patient_type);

        AddDoctorDatabase doctorDatabase = new AddDoctorDatabase(this);
        ArrayList<AddDoctorModel> allDoctor = doctorDatabase.getData();
        String[] doctorNames = new String[allDoctor.size()];
        for (int i = 0; i < allDoctor.size(); i++) {
            doctorNames[i] = allDoctor.get(i).getName();
        }

        // Create an ArrayAdapter for doctor names
        ArrayAdapter<String> doctorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, doctorNames);
        editTextDoctorName.setAdapter(doctorAdapter);

        // Create an ArrayAdapter for patient types
        String[] patientTypes = {"New Consultation", "Follow-up"};
        ArrayAdapter<String> patientTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, patientTypes);
        patient_type.setAdapter(patientTypeAdapter);

        btnDatePicker.setOnClickListener(v -> showDatePicker());
        buttonSend.setOnClickListener(v -> {
            String patientName = editTextPatientName.getText().toString().trim();
            String doctorName = editTextDoctorName.getText().toString().trim();
            String patientType = patient_type.getText().toString().trim();
            String phoneNumber = editTextPhoneNumber.getText().toString().trim();
            String dateOfBirth = textViewDateOfBirth.getText().toString().trim();
            String gender = radioButtonMale.isChecked() ? "Male" : "Female";

            if (patientName.isEmpty()) {
                Toast.makeText(this, "Please enter patient name", Toast.LENGTH_SHORT).show();
            } else if (doctorName.isEmpty()) {
                Toast.makeText(this, "Please enter doctor name", Toast.LENGTH_SHORT).show();
            } else if (phoneNumber.isEmpty()) {
                Toast.makeText(this, "Please enter phone number", Toast.LENGTH_SHORT).show();
            } else {
                String price = patientType.equals("New Consultation") ? "100" : "75";
                AddPatientModel addPatientModel = new AddPatientModel(
                        patientName,
                        doctorName,
                        phoneNumber,
                        gender,
                        dateOfBirth,
                        price
                );
                String result = addPatientDataBase.insertData(addPatientModel);
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                editTextPatientName.setText("");
                editTextDoctorName.setText("");
                patient_type.setText("");
                editTextPhoneNumber.setText("");
                textViewDateOfBirth.setText("Date of Birth");
                radioButtonMale.setChecked(false);
                radioButtonFemale.setChecked(false);
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
