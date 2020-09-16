package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Payment extends AppCompatActivity {

    Button b1,b2,b3,proceed;
    EditText e1,e2,e3,e4,e5,e6,e7,e8;
    TextView t1,t2,t3,t4,t5;
    DatabaseReference dbref;
    DetailsOfPayment DPay;

    private void clearControls() {
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
        e7.setText("");
        e8.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        e1 = (EditText) findViewById(R.id.text1); // code1
        e2 = (EditText) findViewById(R.id.text2); // code2
        e3 = (EditText) findViewById(R.id.text3); // code3
        e4 = (EditText) findViewById(R.id.text4); // code4
        e5 = (EditText) findViewById(R.id.text5); // name
        e6 = (EditText) findViewById(R.id.text6); // Month
        e7 = (EditText) findViewById(R.id.text7); // year
        e8 = (EditText) findViewById(R.id.text8); // cvv

        t1 = (TextView)findViewById(R.id.code);
        t2 = (TextView)findViewById(R.id.cardholder);
        t3 = (TextView)findViewById(R.id.month);
        t4 = (TextView)findViewById(R.id.year);
        t5 = (TextView)findViewById(R.id.cvv);

        DPay = new DetailsOfPayment();

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


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //Cancel button
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
            public void onClick(View view) { //Edit Shippiing Button
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

    protected void onResume(){
        super.onResume();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref = FirebaseDatabase.getInstance().getReference().child("DetailsOfPayment");
                try{
                    if(TextUtils.isEmpty(e1.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your Card Number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your Card Number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e3.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your Card Number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e4.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your Card Number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e5.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your Name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e6.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter expire month",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e7.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter expire year",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e8.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your Card CVV",Toast.LENGTH_SHORT).show();
                    else{
                        DPay.setCard1(Integer.parseInt(e1.getText().toString().trim()));
                        DPay.setCard2(Integer.parseInt(e2.getText().toString().trim()));
                        DPay.setCard3(Integer.parseInt(e3.getText().toString().trim()));
                        DPay.setCard4(Integer.parseInt(e4.getText().toString().trim()));
                        DPay.setName(e5.getText().toString().trim());
                        DPay.setMonth(Integer.parseInt(e6.getText().toString().trim()));
                        DPay.setYear(Integer.parseInt(e7.getText().toString().trim()));
                        DPay.setCvv(Integer.parseInt(e8.getText().toString().trim()));

                        dbref.push().setValue(DPay);

                        Toast.makeText(getApplicationContext(),"Data Saved Successfully, Proseeding to Checkout",Toast.LENGTH_SHORT).show();
                        clearControls();
                        Intent intent = new Intent(Payment.this,PurchaseConfirmation.class);
                        startActivity(intent);
                    }
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Data, check again",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}