package com.example.tolate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private EditText email;
    private Button btForget;
    private ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.email);
        btForget = findViewById(R.id.btForget);
        progressBar = findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

        btForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetpassowrd();
            }
        });

    }

    private void resetpassowrd(){
        String emailtext = email.getText().toString().trim();
        if(emailtext.isEmpty()){
            email.setError("Email is requird!");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailtext).matches()){
            email.setError("Please enter a valid email");
            email.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(emailtext).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this,"Check your email to reset your password",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ForgotPassword.this,"Try again!Something is worng",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}