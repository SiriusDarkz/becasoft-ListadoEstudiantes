package com.example.eugen.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private ImageButton btnClear;
    private ImageButton btnAccept;
    private EditText email;
    private EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         initializeComponents();
        btnClear.setOnClickListener(v -> {
                email.setText("");
                pass.setText("");
                }
        );

        btnAccept.setOnClickListener(v ->
        {
            if(verify(email.getText().toString(),pass.getText().toString()))
            {
                Intent intent  = new Intent(this, DisplayListActivity.class);
                intent.setFlags()
                startActivity(intent);
            }
            else {
                Toast.makeText(this,"Wrong User/Password, please verify",Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void initializeComponents() {

        email = findViewById(R.id.email);
        pass = findViewById(R.id.passwd);
        btnClear = findViewById(R.id.btnclear);
        btnAccept = findViewById(R.id.loginlogo);
    }

    private boolean verify(String email, String passwd) {

        return email.equals("profesor@oym.edu.do") && passwd.equals("1234");
    }
}
