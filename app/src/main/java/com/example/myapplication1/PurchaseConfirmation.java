package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PurchaseConfirmation extends AppCompatActivity {

    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_confirmation);

            bt1 = findViewById(R.id.cpayment);
            bt2 = findViewById(R.id.cancel4);

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext(); //The context to use. Usually your Application or Activity object
                    CharSequence message = "Paid Successfully";//Display string
                    int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
                    Toast toast = Toast.makeText(context, message, duration);
                    toast.show();

                    Intent intent = new Intent(PurchaseConfirmation.this,home.class);
                    startActivity(intent);
                }
            });

            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext();
                    CharSequence message = "Payment Cancled";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, message, duration);
                    toast.show();

                    Intent intent = new Intent(PurchaseConfirmation.this,home.class);
                    startActivity(intent);
                }
            });


        }
    }