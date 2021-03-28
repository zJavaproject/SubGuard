package com.example.subguardapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LoginActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    public static final String CHANNEL_1 = "channel1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.supportActionBar?.hide();

        Button login = (Button) findViewById(R.id.tvLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if ("Boiling Point K".equals(login.getText().toString()))
//                    login.setText("2792");
//                else
//                    login.setText("Boiling Point K");
                Intent intent = new Intent(LoginActivity.this, navigation_drawer.class);
//                EditText editText = (EditText) findViewById(R.id.editText);
//                String message = editText.getText().toString();
//                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        createNotificationChannel();

        String title = "Przypominajka";
        String body = "Hej! Dawno nie przeglądałeś swoich subskrypcji!";

        Intent intent = new Intent(this, LoginActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_1)
                .setSmallIcon(R.mipmap.ic_logo_foreground)
                .setContentTitle(title)
                .setContentText(body)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_1, "Channel 1", importance);
            channel.setDescription("Remind to check subscriptions");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}