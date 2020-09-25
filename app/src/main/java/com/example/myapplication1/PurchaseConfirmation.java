package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PurchaseConfirmation extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4;
    public static final String CHANNEL_ID = "Purchase confirmation pg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_confirmation);

            bt1 = findViewById(R.id.cpayment);
            bt2 = findViewById(R.id.cancel4);
            bt3 = findViewById(R.id.promo);
            bt4 = findViewById(R.id.checkprice);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // notification for purchase confirmation
            CharSequence name = "Purchase confirmation";
            String description = "Purchase confirmation";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);


        }


         bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addNotification();

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

                    Intent intent = new Intent(PurchaseConfirmation.this,ShippingDetails.class);
                    startActivity(intent);
                }
            });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence message = "Discount code";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();

                Intent intent = new Intent(PurchaseConfirmation.this,viewcodedetails.class);
                startActivity(intent);
            }
        });
    }

    public void addNotification(){


        Intent intent = new Intent(this, ShippingDetails.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Purchase Confirmation")
                .setContentText("You have successfully made your purchase!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, builder.build());
    }
}