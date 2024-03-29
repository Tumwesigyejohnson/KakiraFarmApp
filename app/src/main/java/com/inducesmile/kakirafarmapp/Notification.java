package com.inducesmile.kakirafarmapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.IntentFilter;

import android.os.Bundle;
import android.content.Intent;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import android.widget.Toast;

import android.content.BroadcastReceiver;
import android.content.Context;
public class Notification extends AppCompatActivity {
    BroadcastReceiver receiver;
    IntentFilter filter;
    Button sendbroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // to register local receiver
        filter = new IntentFilter();
        // specify the action to which receiver will listen
        filter.addAction("com.local.receiver");

        registerReceiver(receiver,filter);


        BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Toast.makeText(context, "Broadcast Received Device is connected to Power",Toast.LENGTH_LONG).show();
            }
        };
        Button b1;
        b1 = (Button)findViewById(R.id.decline);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
            }
        });

    }

    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_message)

                        .setContentText("Check Your Email For The Password Reset Link");

        Intent notificationIntent = new Intent(this, Notification.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }


}
