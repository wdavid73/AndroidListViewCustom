package com.example.tallercustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class Reports extends AppCompatActivity {

    private TextView numberCarRegistered,
            numberKiaRegistered, numberFordRegistered, numberChevRegistered ,
            numberCarRed,numberCarWhite,numberCarBlack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        numberCarRegistered = findViewById(R.id.lblNumberCarRegitered);
        numberKiaRegistered = findViewById(R.id.lblNumberKiaRegitered);
        numberFordRegistered = findViewById(R.id.lblNumberFordsRegistered);
        numberChevRegistered = findViewById(R.id.lblNumberChevRegistered);
        numberCarRed = findViewById(R.id.lblNumberRed);
        numberCarWhite = findViewById(R.id.lblNumberWhite);
        numberCarBlack = findViewById(R.id.lblNumberBlack);

        ArrayList<Car> data = Data.get();
        int countKia = 0 , countFord = 0 , countChevrolet = 0,
                countRed = 0, countWhite = 0, countBlack = 0 ;
        if(data.size() > 0){
            int bigNumber = data.get(0).getPrice() , smallNumber = data.get(0).getPrice();
            Car carBig = null ;
            Car carSmall = null;
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).getBrand() == R.string.brand_kia){ countKia++; }
                if (data.get(i).getBrand() == R.string.brand_ford){ countFord++; }
                if (data.get(i).getBrand() == R.string.brand_chevrolet){ countChevrolet++; }

                if (data.get(i).getColour() == R.string.color_red){ countRed++; }
                if (data.get(i).getColour() == R.string.color_black){ countBlack++; }
                if (data.get(i).getColour() == R.string.color_white){ countWhite++; }

                if ( data.get(i).getPrice() > bigNumber ){
                    bigNumber = data.get(i).getPrice();
                    carBig = data.get(i);
                }

                if ( data.get(i).getPrice() < smallNumber ){
                    smallNumber = data.get(i).getPrice();
                    carSmall = data.get(i);
                }
            }
        }else{
            Toast.makeText(this, R.string.cars_empty,Toast.LENGTH_LONG).show();
        }
            numberCarRegistered.setText(String.valueOf(data.size()));
            numberKiaRegistered.setText(String.valueOf(countKia));
            numberFordRegistered.setText(String.valueOf(countFord));
            numberChevRegistered.setText(String.valueOf(countChevrolet));
            numberCarRed.setText(String.valueOf(countRed));
            numberCarWhite.setText(String.valueOf(countWhite));
            numberCarBlack.setText(String.valueOf(countBlack));
    }
}