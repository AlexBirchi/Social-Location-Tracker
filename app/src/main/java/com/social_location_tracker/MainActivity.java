package com.social_location_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    Button logoutButton;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoutButton = findViewById(R.id.logout_button);
        auth = FirebaseAuth.getInstance();

        logoutButton.setOnClickListener(view -> {
            auth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = auth.getCurrentUser();
        if (user == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
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