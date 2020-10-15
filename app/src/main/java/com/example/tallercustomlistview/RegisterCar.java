package com.example.tallercustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class RegisterCar extends AppCompatActivity {

    private Spinner brands,models,colours;
    private EditText license_plate , price;
    private String[] options_brands, options_models, options_colours;
    private ArrayAdapter<String> adapterBrands,adapterModels,adapterColours;
    private int photos[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_car);

        license_plate = findViewById(R.id.txtLicensePlate);
        price = findViewById(R.id.txtPrice);
        brands = findViewById(R.id.spBrand);
        models = findViewById(R.id.spModel);
        colours = findViewById(R.id.spColour);
        photos= new int[3];
        photos[0] = R.drawable.img_1;
        photos[1] = R.drawable.img_2;
        photos[2] = R.drawable.img_3;

        options_brands = getResources().getStringArray(R.array.brands);
        options_models = getResources().getStringArray(R.array.models);
        options_colours = getResources().getStringArray(R.array.colours);

        adapterBrands = new ArrayAdapter<>(this,
                                            android.R.layout.simple_spinner_dropdown_item,
                                            options_brands);

        adapterModels = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                options_models);

        adapterColours = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                options_colours);

        brands.setAdapter(adapterBrands);
        models.setAdapter(adapterModels);
        colours.setAdapter(adapterColours);
    }

    public void SaveCar ( View v){
        Car car;
        String lp;
        int opcBrand , opcColor , opcModel , pho,bra = 0,col = 0,mol = 0,p;
        if(validate()){
            lp = license_plate.getText().toString();
            p = Integer.parseInt(String.valueOf(price.getText()));
            opcBrand = brands.getSelectedItemPosition();
            opcColor = colours.getSelectedItemPosition();
            opcModel = models.getSelectedItemPosition();

            switch (opcBrand){
                case 1:
                    bra = R.string.brand_kia;
                    break;
                case 2:
                    bra = R.string.brand_chevrolet;
                    break;
                case 3:
                    bra = R.string.brand_ford;
                    break;

            }

            switch (opcColor){
                case 1:
                    col = R.string.color_red;
                    break;
                case 2:
                    col = R.string.color_black;
                    break;
                case 3:
                    col = R.string.color_white;
                    break;

            }

            switch (opcModel){
                case 1:
                    mol = R.string.model_1;
                    break;
                case 2:
                    mol = R.string.model_2;
                    break;
                case 3:
                    mol = R.string.model_3;
                    break;
            }

            car = new Car(photoRandom(photos), lp, bra, mol, col, p);
            car.save();
            Toast.makeText(this, R.string.save_car , Toast.LENGTH_LONG).show();
        }
    }

    public void clear(View v){
        license_plate.setText("");
        price.setText("");
        brands.setSelection(0);
        colours.setSelection(0);
        models.setSelection(0);
    }
    public boolean validate(){
        if (license_plate.getText().toString().trim().isEmpty()) {
            license_plate.setError(getString(R.string.validate_license_plate));
            license_plate.requestFocus();
            return false;
        }

        if (price.getText().toString().isEmpty()) {
            price.setError(getString(R.string.validate_price));
            price.requestFocus();
            return false;
        }

        if (Integer.parseInt(price.getText().toString()) == 0) {
            price.setError(getString(R.string.validate_price));
            price.requestFocus();
            return false;
        }
        if(brands.getSelectedItemPosition() == 0){
            Toast.makeText(this, R.string.validate_brand,Toast.LENGTH_LONG).show();
            return false;
        }
        if(models.getSelectedItemPosition() == 0){
            Toast.makeText(this, R.string.validate_model,Toast.LENGTH_LONG).show();
            return false;
        }
        if(colours.getSelectedItemPosition() == 0){
            Toast.makeText(this, R.string.validate_color,Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public int photoRandom(int photo[]){
        int photoSelected;
        Random r = new Random();
        photoSelected = r.nextInt(photo.length);
        return photo[photoSelected];
    }
}