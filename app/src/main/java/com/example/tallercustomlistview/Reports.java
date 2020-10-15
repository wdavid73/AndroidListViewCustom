package com.example.tallercustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class Reports extends AppCompatActivity {

    private TextView numberCarRegistered,
            numberKiaRegistered, numberFordRegistered, numberChevRegistered ,
            numberCarRed,numberCarWhite,numberCarBlack,
            priceBig,priceSmall,colorBig,colorSmall,brandBig,
            brandSmall,modelBig,modelSmall,license_plateBig,license_plateSmall;
    private ImageView imgBigCar,imgSmallCar;

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
        priceBig = findViewById(R.id.lblPrice);
        priceSmall = findViewById(R.id.lblPrice_small);
        colorBig= findViewById(R.id.lblColor);
        colorSmall= findViewById(R.id.lblColor_small);
        brandBig= findViewById(R.id.lblBrand);
        brandSmall= findViewById(R.id.lblBrand_small);
        modelBig= findViewById(R.id.lblModel);
        modelSmall= findViewById(R.id.lblModel_small);
        license_plateBig= findViewById(R.id.lblLicense_plate_data);
        license_plateSmall= findViewById(R.id.lblLicense_plate_small);
        imgBigCar = findViewById(R.id.imgPhotoBigCar);
        imgSmallCar = findViewById(R.id.imgPhotoSmallCar);

        ArrayList<Car> data = Data.get();

        int countKia = 0 , countFord = 0 , countChevrolet = 0,
                countRed = 0, countWhite = 0, countBlack = 0 ;
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

    }
}