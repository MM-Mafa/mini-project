package com.example.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinema.screens.MainMenu;
import com.example.cinema.screens.signup;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText email, password;
    boolean  infoCorrect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button_login);
        textView = findViewById(R.id.textview_signup);
        email = findViewById(R.id.editText_loginmail);
        password = findViewById(R.id.editText_login_password);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), signup.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().contains("@") && password.getText().toString().length()>4){
                    infoCorrect = true;
                }

                if(infoCorrect) {
                    startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "incorrect email or password",Toast.LENGTH_SHORT).show();
                    if(password.getText().toString().length()<4){
                        Toast.makeText(MainActivity.this, "password must contain min 4 char",Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
    }
}