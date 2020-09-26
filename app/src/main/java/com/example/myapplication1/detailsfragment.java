package com.example.myapplication1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;


public class detailsfragment extends Fragment {

     private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String name,brand,price,category,image;

    public detailsfragment() {
    }

    public detailsfragment(String name, String brand, String price, String category, String image) {
    this.name = name;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.image = image;

    }

    public static detailsfragment newInstance(String param1, String param2) {
        detailsfragment fragment = new detailsfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_detailsfragment, container, false);


        ImageView imageholder= view.findViewById(R.id.imageholder);
        TextView nameholder = view.findViewById(R.id.nameholder);
        TextView brandholder = view.findViewById(R.id.brandholder);
        TextView categotyholder = view.findViewById(R.id.categoryholder);
        TextView priceholder = view.findViewById(R.id.priceholder);

        nameholder.setText(name);
        brandholder.setText(brand);
        categotyholder.setText(category);
        priceholder.setText(price);
        Glide.with(getContext()).load(image).into(imageholder);




        return view;
    }

    public void OnBackPressed()
    {
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.main,new Productfrag()).addToBackStack(null).commit();
    }
}