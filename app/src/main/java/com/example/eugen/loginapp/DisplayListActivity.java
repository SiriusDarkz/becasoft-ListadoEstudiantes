package com.example.eugen.loginapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import Model.Services.StudentDaoService;
import Model.conections.ConnectionManager;
import adapters.SimpleAdapter;


public class DisplayListActivity extends AppCompatActivity {


    private  StudentDaoService studentDaoService;
    private  SimpleAdapter adapter;
    private  RecyclerView recyclerView;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        studentDaoService = new StudentDaoService(ConnectionManager.getConnection(this, "new"));
        setContentView(R.layout.activity_displaylist);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Listado Estudiantil");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());


        adapter = new SimpleAdapter(studentDaoService.getStudents());
        adapter.setOnItemClickListener((view, i) -> {
            Intent displayIntent = new Intent(view.getContext(), InfoStudentActivity.class);
            displayIntent.putExtra("pic", adapter.getStudents().get(i).getImg());
            displayIntent.putExtra("fullName", adapter.getStudents().get(i).getFullName());
            displayIntent.putExtra("career", adapter.getStudents().get(i).getCareer());
            displayIntent.putExtra("gender", adapter.getStudents().get(i).getGender());
            displayIntent.putExtra("address", adapter.getStudents().get(i).getAddress());
            displayIntent.putExtra("dateOfBirth", adapter.getStudents().get(i).getDateOfBirth());
            displayIntent.putExtra("status", adapter.isPresent());
            startActivity(displayIntent);
        });
        recyclerView = findViewById(R.id.listStudents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);
        studentDaoService.close();

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setImageResource(R.drawable.add);
            floatingActionButton.setScaleType(ImageView.ScaleType.CENTER);
        floatingActionButton.setOnClickListener(v -> {
            Intent registryIntent = new Intent(this, RegistryActivity.class);
            startActivity(registryIntent);

        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                             @Override
                                             public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                                                 super.onScrolled(recyclerView, dx, dy);
                                                 if (dy > 0 && floatingActionButton.getVisibility() == View.VISIBLE) {
                                                     floatingActionButton.hide();
                                                 } else if (dy < 0 && floatingActionButton.getVisibility() != View.VISIBLE) {
                                                     floatingActionButton.show();
                                                 }
                                             }
                                         }
        );

    }


}
