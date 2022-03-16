package com.social_location_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSendFriendRequestActivity(View view) {
        Intent intent = new Intent(this, SendFriendRequestActivity.class);
        startActivity(intent);
    }

    public void launchViewFriendRequestsActivity(View view) {
        Intent intent = new Intent(this, ViewFriendRequestsActivity.class);
        startActivity(intent);
    }

    public void launchViewLocationsActivity(View view) {
        Intent intent = new Intent(this, ViewLocationsActivity.class);
        startActivity(intent);
    }
}