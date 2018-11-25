package com.example.eugen.loginapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import Model.Services.StudentDaoService;
import Model.conections.ConnectionManager;
import adapters.SimpleAdapter;
import utilities.Util;

public class MenuActivity extends AppCompatActivity {


    StudentDaoService studentDaoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        studentDaoService = new StudentDaoService(ConnectionManager.getConnection(this,"new"));
        setContentView(R.layout.activity_menu);
        SimpleAdapter adapter = new SimpleAdapter(this, studentDaoService.getStudents());
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        studentDaoService.close();
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent displayIntent = new Intent(view.getContext(), DisplayActivity.class);
            displayIntent.putExtra("pic",adapter.getStudents().get(position).getImg());
            displayIntent.putExtra("fullName",adapter.getStudents().get(position).getFullName());
            displayIntent.putExtra("career",adapter.getStudents().get(position).getCareer());
            displayIntent.putExtra("gender",adapter.getStudents().get(position).getGender());
            displayIntent.putExtra("address",adapter.getStudents().get(position).getAddress());
            displayIntent.putExtra("dateOfBirth",adapter.getStudents().get(position).getDateOfBirth());
            displayIntent.putExtra("status", adapter.isPresent());
            displayIntent.putExtra("object",adapter.getStudents().get(1));
            startActivity(displayIntent);
        });


        FloatingActionButton floatingActionButton  = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(v -> {
            studentDaoService = new StudentDaoService(ConnectionManager.getConnection(v.getContext(),"null"));
            studentDaoService.testDB();
            adapter.setStudents(studentDaoService.getStudents());
            studentDaoService.close();
            adapter.notifyDataSetChanged();




        });






    }


}
