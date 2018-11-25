package com.example.eugen.loginapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import Model.Services.StudentDaoService;
import Model.conections.ConnectionManager;
import adapters.SimpleAdapter;


public class DisplayListActivity extends AppCompatActivity {


    StudentDaoService studentDaoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        studentDaoService = new StudentDaoService(ConnectionManager.getConnection(this, "new"));
        setContentView(R.layout.activity_menu);
        SimpleAdapter adapter = new SimpleAdapter(this, studentDaoService.getStudents());
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        studentDaoService.close();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent displayIntent = new Intent(view.getContext(), InfoStudentActivity.class);
            displayIntent.putExtra("pic", adapter.getStudents().get(position).getImg());
            displayIntent.putExtra("fullName", adapter.getStudents().get(position).getFullName());
            displayIntent.putExtra("career", adapter.getStudents().get(position).getCareer());
            displayIntent.putExtra("gender", adapter.getStudents().get(position).getGender());
            displayIntent.putExtra("address", adapter.getStudents().get(position).getAddress());
            displayIntent.putExtra("dateOfBirth", adapter.getStudents().get(position).getDateOfBirth());
            displayIntent.putExtra("status", adapter.isPresent());
            displayIntent.putExtra("object", adapter.getStudents().get(1));
            startActivity(displayIntent);
        });


        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setImageResource(R.drawable.baseline_add_circle_outline_24);
        floatingActionButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        floatingActionButton.setOnClickListener(v -> {
            studentDaoService = new StudentDaoService(ConnectionManager.getConnection(v.getContext(), "null"));
            studentDaoService.testDB();
            adapter.setStudents(studentDaoService.getStudents());
            studentDaoService.close();
            adapter.notifyDataSetChanged();

        });

        floatingActionButton.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) ->
        floatingActionButton.setCustomSize(FloatingActionButton.SIZE_MINI));
    }

}
