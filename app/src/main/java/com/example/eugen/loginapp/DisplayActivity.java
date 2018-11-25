package com.example.eugen.loginapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class DisplayActivity extends AppCompatActivity {

    private ImageView img;
    private EditText fullName;
    private EditText career;
    private EditText gender;
    private EditText address;
    private EditText dateOfBirth;
    private EditText status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        initializeComponents();
        fillUpComponents();

    }


    private  void initializeComponents() {

        img = findViewById(R.id.img);
        fullName = findViewById(R.id.fullName);
        career = findViewById(R.id.career);
        gender = findViewById(R.id.gender);
        address = findViewById(R.id.address);
        dateOfBirth = findViewById(R.id.bornDate);
        status = findViewById(R.id.status);
    }
    private void fillUpComponents() {

        img.setImageResource(getIntent().getIntExtra("pic",0));
        fullName.setText(getIntent().getStringExtra("fullName"));
        career.setText(getIntent().getStringExtra("career"));
        gender.setText(getIntent().getStringExtra("gender"));
        address.setText(getIntent().getStringExtra("address"));
        //Student s = (Student) getIntent().getSerializableExtra("object");
        dateOfBirth.setText(getIntent().getStringExtra("dateOfBirth"));
        if(getIntent().getBooleanExtra("status",false))
        status.setText("Presente");
        else
            status.setText("Ausente");


    }
}
