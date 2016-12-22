package com.jasonbutwell.customnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    public int NOTIFY_ID = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create our custom notification

        createNotification();
    }

    public void createNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // Which intent should be called when notification is clicked?
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, NOTIFY_ID, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        // set the icon for the notification
        builder.setSmallIcon(android.R.drawable.sym_def_app_icon);

        // Set the title and the text of the notification

        builder.setContentTitle("Sample notification");
        builder.setContentText("This is a simple notification");

        // Set the Notification to cancel when it is tapped on

        builder.setAutoCancel(true);

        // Set large icon for apps Launcher icon

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        // Add subtext below message

        builder.setSubText("Tap to view");

        // Add the pending intent

        builder.setContentIntent(pendingIntent);

        // builds the notification ready for use

        Notification notification = builder.build();

        // pass the notification object returned to be used by the Notification Manager to create the notification

        NotificationManager mgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        mgr.notify(NOTIFY_ID, notification);
    }
}
