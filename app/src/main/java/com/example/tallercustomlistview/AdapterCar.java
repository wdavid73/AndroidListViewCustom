package com.example.tallercustomlistview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class AdapterCar extends BaseAdapter {

    private Context context;
    private ArrayList<Car> cars;
    private Resources res;

    public AdapterCar(Context context , ArrayList<Car> cars){
        this.context = context;
        this.cars = cars;
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int i) {
        return cars.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        res = context.getResources();
        View v  = view;

        // Creamos el objeto layout
        LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inf.inflate(R.layout.item_cars, null);

        // Creamos un objeto car
        Car c = cars.get(i);
        ImageView photo = v.findViewById(R.id.idImgPhoto);
        TextView license_plate = v.findViewById(R.id.lblLicense_Plate);
        TextView brand = v.findViewById(R.id.lblBrand);
        TextView model = v.findViewById(R.id.lblModel);
        TextView price = v.findViewById(R.id.lblPrice);

        //Seteamos los elementos
        photo.setImageDrawable(res.getDrawable(c.getPhoto(),null));
        license_plate.setText(c.getLicense_plate());
        brand.setText(c.getBrand());
        model.setText(c.getModel());
        price.setText(String.valueOf(c.getPrice()));

        return v;
    }
}
