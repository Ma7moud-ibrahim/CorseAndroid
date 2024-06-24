package com.clinics.clinics;
import android.app.AlertDialog;
import android.app.Dialog;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.clinics.clinics.MainActivity;
import com.clinics.clinics.R;

import java.util.Locale;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        darkMode();
        logOut();
        shareApp();
        contactUs();
    }
    private void setupSpinner() {
        Spinner languageSpinner = findViewById(R.id.language_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = parent.getItemAtPosition(position).toString();
                setLocale(selectedLanguage);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }
    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Restart the activity to apply language changes
        recreate();
    }


    private void darkMode(){
        TextView buttonDarkMode = findViewById(R.id.buttonDarkMode);

        buttonDarkMode.setOnClickListener(v -> {
            Toast.makeText(Setting.this, "Dark Mode Button Clicked", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Setting.this, "Sorry, no email client found!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
