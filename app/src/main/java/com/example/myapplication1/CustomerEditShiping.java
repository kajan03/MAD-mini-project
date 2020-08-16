package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomerEditShiping extends AppCompatActivity {

    Button but1,but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_edit_shiping);

            but1 = findViewById(R.id.savecont);
            but2 = findViewById(R.id.cancel3);

            but1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext(); //The context to use. Usually your Application or Activity object
                    CharSequence message = "Edit saved successfully";//Display string
                    int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
                    Toast toast = Toast.makeText(context, message, duration);
                    toast.show();

                    Intent intent = new Intent(CustomerEditShiping.this,Payment.class);
                    startActivity(intent);
                }
            });

            but2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext(); //The context to use. Usually your Application or Activity object
                    CharSequence message = "Shipping Detail Deleted";//Display string
                    int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
                    Toast toast = Toast.makeText(context, message, duration);
                    toast.show();

                    Intent intent = new Intent(CustomerEditShiping.this,ShippingDetails.class);
                    startActivity(intent);
                }
            });

        }


}