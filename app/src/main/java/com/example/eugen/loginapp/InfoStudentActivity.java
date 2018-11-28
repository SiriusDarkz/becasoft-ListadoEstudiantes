package com.example.eugen.loginapp;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;

public class InfoStudentActivity extends AppCompatActivity {

    private ImageView img;
    private EditText fullName;
    private EditText career;
    private EditText gender;
    private EditText address;
    private EditText dateOfBirth;
    private EditText status;
    private Toolbar toolbar;
    private de.hdodenhof.circleimageview.CircleImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infostudent);
        initializeComponents();
        fillUpComponents();

    }


    private  void initializeComponents() {

//        img = findViewById(R.id.img);
        fullName = findViewById(R.id.fullName);
        career = findViewById(R.id.career);
        gender = findViewById(R.id.gender);
        address = findViewById(R.id.address);
        dateOfBirth = findViewById(R.id.bornDate);
        status = findViewById(R.id.status);
        toolbar = findViewById(R.id.my_toolbar);
        imageView = findViewById(R.id.img);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getIntent().getStringExtra("fullName"));
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }
    private void fillUpComponents() {

        imageView.setImageResource(getIntent().getIntExtra("pic",0));
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
