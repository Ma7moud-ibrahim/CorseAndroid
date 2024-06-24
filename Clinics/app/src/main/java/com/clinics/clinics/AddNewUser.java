package com.clinics.clinics;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.clinics.clinics.localDataBase.AuthDataBase;

public class AddNewUser extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Spinner roleSpinner;
    private Button createButton;
    private String selectedRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        roleSpinner = findViewById(R.id.role_spinner);
        createButton = findViewById(R.id.loginbtn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.roles_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

        roleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedRole = (String) parentView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                selectedRole = "employee"; // Default role
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(AddNewUser.this, "Enter the required data", Toast.LENGTH_SHORT).show();
                }else {
                    AuthDataBase authDataBase = new AuthDataBase(AddNewUser.this);
                    String addNewUserResult = authDataBase.insertData(username,password,selectedRole);
                    usernameEditText.setText("");
                    passwordEditText.setText("");
                    selectedRole = "employee";
                    Toast.makeText(AddNewUser.this, addNewUserResult, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}