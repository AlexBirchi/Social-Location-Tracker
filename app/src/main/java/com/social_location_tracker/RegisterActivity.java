package com.social_location_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText registerEmail;
    EditText registerPassword;
    EditText registerRepeatPassword;
    TextView loginLink;
    Button registerButton;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerEmail = findViewById(R.id.username);
        registerPassword = findViewById(R.id.password);
        registerRepeatPassword = findViewById(R.id.repeat_password);
        loginLink = findViewById(R.id.loginLink);
        registerButton = findViewById(R.id.register_button);

        auth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(view -> {
            createUser();
        });

        loginLink.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }

    private void createUser() {
        String email = registerEmail.getText().toString();
        String password = registerPassword.getText().toString();
        String repeatPassword = registerRepeatPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            registerEmail.setError("Email cannot be empty.");
            registerEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            registerPassword.setError("Password cannot be empty.");
            registerPassword.requestFocus();
        } else if (TextUtils.isEmpty(repeatPassword)) {
            registerRepeatPassword.setError("Password cannot be empty.");
            registerRepeatPassword.requestFocus();
        }

        if (!TextUtils.equals(password, repeatPassword)) {
            registerPassword.setError("Passwords must match.");
            registerPassword.requestFocus();
        }

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}