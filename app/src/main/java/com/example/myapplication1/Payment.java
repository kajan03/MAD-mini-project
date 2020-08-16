package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    Button b1,b2,b3,proceed;
    EditText e1,e2,e3,e4,e5,e6,e7,e8;
    TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        e1 = (EditText) findViewById(R.id.text1); // code1
        e2 = (EditText) findViewById(R.id.text2);
        e3 = (EditText) findViewById(R.id.text3);
        e4 = (EditText) findViewById(R.id.text4); // code4
        e5 = (EditText) findViewById(R.id.text5);
        e6 = (EditText) findViewById(R.id.text6);
        e7 = (EditText) findViewById(R.id.text7);
        e8 = (EditText) findViewById(R.id.text8);

        t1 = (TextView)findViewById(R.id.code);
        t2 = (TextView)findViewById(R.id.cardholder);
        t3 = (TextView)findViewById(R.id.month);
        t4 = (TextView)findViewById(R.id.year);
        t5 = (TextView)findViewById(R.id.cvv);

        proceed = (Button) findViewById(R.id.view);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_down);
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl1);
                relativeLayout.setAnimation(animation);
                String code1, code2, code3, code4;

                code1 = e1.getText().toString();
                code2 = e2.getText().toString();
                code3 = e3.getText().toString();
                code4 = e4.getText().toString();

                t1.setText(code1 + "\t\t" + code2 + "\t\t" + code3 + "\t\t" + code4);

                String nam,mont,yea,cv;

                nam = e5.getText().toString();
                t2.setText(nam);
                mont= e6.getText().toString();
                t3.setText(mont);
                yea = e7.getText().toString();
                t4.setText(yea);
                cv = e8.getText().toString();
                t5.setText(cv);
            }
        });

        b1 = findViewById(R.id.proceed1);
        b2 = findViewById(R.id.cancel1);
        b3 = findViewById(R.id.edit);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext(); //The context to use. Usually your Application or Activity object
                CharSequence message = "Confirm Payment";//Display string
                int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();

                Intent intent = new Intent(Payment.this,PurchaseConfirmation.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext(); //The context to use. Usually your Application or Activity object
                CharSequence message = "Payment Cancled";//Display string
                int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();

                Intent intent = new Intent(Payment.this,ShippingDetails.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext(); //The context to use. Usually your Application or Activity object
                CharSequence message = "Edit Shipping Details";//Display string
                int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();

                Intent intent = new Intent(Payment.this,CustomerEditShiping.class);
                startActivity(intent);

            }
        });

    }
}