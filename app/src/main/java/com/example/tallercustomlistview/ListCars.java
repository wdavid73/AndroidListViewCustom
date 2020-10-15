package com.example.tallercustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListCars extends AppCompatActivity {

    private ListView lstCustom;
    private ArrayList<Car> cars;
    private Context context;
    private AdapterCar adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cars);

        lstCustom = findViewById(R.id.lstCustomCars);
        context = this.getApplicationContext();
        cars = Data.get();
        adapter = new AdapterCar(context , cars);
        lstCustom.setAdapter(adapter);
    }
}