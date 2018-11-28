package com.example.eugen.loginapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import Model.Services.StudentDaoService;
import Model.conections.ConnectionManager;

public class RegistryActivity extends AppCompatActivity {

    private Button btnAdd;
    private EditText editFullName;
    private EditText editCareer;
    private EditText editAddress;
    private EditText editGender;
    private EditText editBirthDate;
    private StudentDaoService studentDaoService;
    private Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        initComponents();
        btnAdd.setOnClickListener(v ->{

            studentDaoService = new StudentDaoService(ConnectionManager.getConnection(v.getContext(), "null"));
            studentDaoService.add(
                    editFullName.getText().toString(),
                    editCareer.getText().toString(),
                    editGender.getText().toString(),
                    editAddress.getText().toString(),
                    editBirthDate.getText().toString(),
                    0
            );



        } );






    }

    private  void initComponents() {
        editFullName = findViewById(R.id.fullName);
        editCareer = findViewById(R.id.career);
        editAddress = findViewById(R.id.address);
        editGender = findViewById(R.id.gender);
        editBirthDate = findViewById(R.id.bornDate);
        btnAdd = findViewById(R.id.btnAdd);
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("New Student");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());






    }



}
