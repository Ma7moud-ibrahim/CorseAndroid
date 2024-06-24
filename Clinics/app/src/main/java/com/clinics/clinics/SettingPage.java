package com.clinics.clinics;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.clinics.clinics.localDataBase.AuthDataBase;

import java.util.Locale;

public class SettingPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting_page);
        logOut();
        shareApp();
        contactUs();

        TextView addNewUserButton = findViewById(R.id.buttonAddUser);
        TextView buttonLogOutButton = findViewById(R.id.buttonLogOut);
        Intent addNewUserIntent = new Intent(this, AddNewUser.class);
        Intent buttonLogOutIntent = new Intent(this, MainActivity.class);

        addNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addNewUserIntent);
            }
        });

        buttonLogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(buttonLogOutIntent);
            }
        });
    }
    private void logOut(){
        TextView buttonLogOut = findViewById(R.id.buttonLogOut);
        buttonLogOut.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("")
                    .setMessage("Log out of your account?")
                    .setPositiveButton("LOG OUT", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            dialog.dismiss(); // Dismiss the dialog
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Do something when Cancel button is clicked
                            dialog.dismiss(); // Dismiss the dialog
                        }
                    })
                    .show();
        });
    }
    private  void shareApp(){
        TextView textView = findViewById(R.id.buttonShare);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtshare = "Clinics";
                String sharelink = "https://play.google.com/store/apps/details?id=com.example.appsendpad";
                Intent sha = new Intent(Intent.ACTION_SEND);
                sha.setType("text/plain");
                sha.putExtra(Intent.EXTRA_TEXT, txtshare + "\n" + sharelink);

                startActivity(sha);
            }

        });
    }

    public void contactUs() {
        TextView textView = findViewById(R.id.buttonContant);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String txt = "My Suggestion is: ";
                    Intent sendEmail = new Intent(Intent.ACTION_SEND);
                    sendEmail.setData(Uri.parse("mailto:"));
                    sendEmail.setType("message/rfc822");
                    sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"ahmed.01090223081@gmail.com"});
                    sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Clinics");
                    sendEmail.putExtra(Intent.EXTRA_TEXT, txt);
                    startActivity(sendEmail);

                } catch (Exception e) {
                    Toast.makeText(SettingPage.this, "Sorry, no email client found!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}