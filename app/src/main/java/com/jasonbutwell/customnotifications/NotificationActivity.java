package com.jasonbutwell.customnotifications;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by J on 22/12/2016.
 */

public class NotificationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Extract the ID passed in

        Intent intent = getIntent();

        // get the notify ID passed in to the Intent with put Extra

        int notifyID = intent.getIntExtra("notifyID", 0);

        // get reference to the notification manager service

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);


        // using the notification manager reference, we cancel the Notification using its ID

        notificationManager.cancel(notifyID);

    }

}
