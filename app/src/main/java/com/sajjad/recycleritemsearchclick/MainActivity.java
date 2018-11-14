package com.sajjad.recycleritemsearchclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar v7Toolbar;
    RecyclerView employeeRecycler;
    List<String> employeeList;
    RecyclerView.LayoutManager linearLayout;
    EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v7Toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(v7Toolbar);
        //
        employeeRecycler = findViewById(R.id.employee_recycler);
        linearLayout = new LinearLayoutManager(this);
        employeeRecycler.setLayoutManager(linearLayout);

        employeeList = Arrays.asList(getResources().getStringArray(R.array.employeeList));

        employeeAdapter = new EmployeeAdapter(this, employeeList);
        employeeRecycler.setAdapter(employeeAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.searchItem);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                List<String> newList = new ArrayList<>();
                for (String item : employeeList) {
                    if (item.toLowerCase().contains(s.toLowerCase())) {
                        newList.add(item);
                    }
                }

                employeeAdapter = new EmployeeAdapter(getApplicationContext(), newList);
                employeeRecycler.setAdapter(employeeAdapter);
                employeeAdapter.notifyDataSetChanged();
                return true;
            }
        });
        return true;
    }
}