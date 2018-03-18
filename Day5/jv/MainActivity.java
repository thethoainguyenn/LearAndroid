package com.example.thoailun.day5;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnPush;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPush = (Button) findViewById(R.id.btnPush);
        btnPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Intent intent = new Intent(MainActivity.this, ShowNotiActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, intent, 0);

                Notification.Builder notifiBuilder = new Notification.Builder(MainActivity.this);
                notifiBuilder.setContentTitle("Thong bao");
                notifiBuilder.setContentText("Ban dang theo doi video");
                notifiBuilder.setSmallIcon(R.drawable.ic_launcher_background);
                notifiBuilder.setAutoCancel(true);

                // Event click status bar
                notifiBuilder.setContentIntent(pendingIntent);

                notificationManager.notify(1, notifiBuilder.build());
            }
        });
    }
}
