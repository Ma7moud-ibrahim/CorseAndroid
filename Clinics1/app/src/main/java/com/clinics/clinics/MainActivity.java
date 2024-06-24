package com.clinics.clinics;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.clinics.clinics.localDataBase.AuthDataBase;
import com.clinics.clinics.models.AuthModel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.loginbtn);
        AuthDataBase authDataBase = new AuthDataBase(this);
        Intent intent = new Intent(this,HomeClinic.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<AuthModel> authDataBaseData = authDataBase.getData();
                boolean loginSuccessful = false;
                for (int i = 0; i < authDataBaseData.size(); i++) {
                    if (username.getText().toString().equals(authDataBaseData.get(i).getUsername()) &&
                            pass.getText().toString().equals(authDataBaseData.get(i).getPassword())) {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                        loginSuccessful = true;
                        break;
                    }
                }
                if (!loginSuccessful) {
                    Toast.makeText(MainActivity.this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}