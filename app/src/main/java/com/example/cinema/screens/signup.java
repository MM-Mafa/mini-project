package com.example.cinema.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinema.R;

public class signup extends AppCompatActivity {
    TextView textView;
    Button signup;
    EditText password, email,name, surname, contact;
    public static int READ_BLOCK_SIZE=100;
    boolean infoCorrect = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        textView =  findViewById(R.id.textView_login);
        signup = findViewById(R.id.button_signup);

        password = findViewById(R.id.editTextTextPassword);
        email = findViewById(R.id.editTextTextEmailAddress);
        contact = findViewById(R.id.editTextPhone);
        surname = findViewById(R.id.editTextTextPersonName2);
        name = findViewById(R.id.editTextTextPersonName);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().contains("@")){
                    if(contact.getText().toString().length()>0 && name.getText().toString().length()>0 && surname.getText().toString().length()>0){
                        if(password.getText().toString().length()>0){
                            infoCorrect = true;

                        }else if (password.getText().toString().length()==0  || password.getText().toString().length()<4){

                            Toast.makeText(getApplicationContext(), "password must contain min 4 char",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "please fill in all information",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "invalid email",Toast.LENGTH_SHORT).show();
                }
                if(infoCorrect) {
                        startActivity(new Intent(signup.this, MainMenu.class));
                    finish();
                }
            }
        });
    }


}