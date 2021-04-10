package com.example.tolate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

   private TextView txtSingUP,txtFPass;
    private EditText txtEmail,txtPass;
    private Button btLog;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtSingUP = findViewById(R.id.txtSingUp);
        txtSingUP.setOnClickListener(this);
        txtEmail = findViewById(R.id.txtEmail);
        txtFPass = findViewById(R.id.txtFPass);
        txtFPass.setOnClickListener(this);
        txtPass = findViewById(R.id.txtPass);
        btLog = findViewById(R.id.btLog);
        btLog.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.txtSingUp:
                Intent intent = new Intent(LoginActivity.this,SingUpActivity.class);
                startActivity(intent);
                break;
            case R.id.btLog:
                userLogin();
                break;
            case R.id.txtFPass:
                Intent intent1 = new Intent(LoginActivity.this,ForgotPassword.class);
                startActivity(intent1);
                break;

        }

    }

    private void userLogin() {

        String email = txtEmail.getText().toString().trim();
        String password = txtPass.getText().toString().trim();

        if(email.isEmpty()){
            txtEmail.setError("Email is requird");
            txtEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            txtEmail.setError("Invalid Mail address!");
            txtEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            txtPass.setError("Password is requird");
            txtPass.requestFocus();
            return;
        }
        if(password.length()<6){
            txtPass.setError("password must be at lest 6 charecters!");
            txtPass.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Intent intent = new Intent(LoginActivity.this,NavigationActivity.class);
                    startActivity(intent);
                    progressBar.setVisibility(View.INVISIBLE);
                    finish();

                }
                else {
                    Toast.makeText(LoginActivity.this,"Login Faild",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });


    }
}