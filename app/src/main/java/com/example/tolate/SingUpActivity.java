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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SingUpActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private ProgressBar progressBar2;

    private EditText txtEmail,txtPass,txtConPass,txtFName,txtLName,txtNum;
    private Button btSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        mAuth = FirebaseAuth.getInstance();

        txtFName = findViewById(R.id.txtFName);
        txtLName = findViewById(R.id.txtLName);
        txtNum = findViewById(R.id.txtNum);
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
        txtConPass = findViewById(R.id.txtConPass);
        btSignUp = findViewById(R.id.btSignUp);
        btSignUp.setOnClickListener(this);
        progressBar2 = findViewById(R.id.progressBar2);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSignUp:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String firstName = txtFName.getText().toString().trim();
        String LastName = txtLName.getText().toString().trim();
        String phoneNumber = txtNum.getText().toString().trim();
        String Email = txtEmail.getText().toString().trim();
        String password = txtPass.getText().toString().trim();
        String conPassword = txtConPass.getText().toString().trim();


        if(firstName.isEmpty()){
            txtFName.setError("First Name is requird");
            txtFName.requestFocus();
            return;
        }
        if(LastName.isEmpty()){
            txtLName.setError("Last Name is requird");
            txtLName.requestFocus();
            return;
        }
        if(phoneNumber.isEmpty()){
            txtNum.setError("Phone Number is requird");
            txtNum.requestFocus();
            return;
        }
        if(Email.isEmpty()){
            txtEmail.setError("Email is requird");
            txtEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            txtEmail.setError("Invalid Mail address!");
            txtEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            txtFName.setError("Password is requird");
            txtFName.requestFocus();
            return;
        }
        if(password.length()<6){
            txtPass.setError("password must be at lest 6 charecters!");
            txtPass.requestFocus();
            return;
        }
        if(!password.equals(conPassword)){
            txtConPass.setError("password not match");
            txtConPass.requestFocus();
            return;
        }

        progressBar2.setVisibility(View.VISIBLE);


        mAuth.createUserWithEmailAndPassword(Email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(firstName,LastName,phoneNumber,Email,password,conPassword);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(SingUpActivity.this,"successfull",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SingUpActivity.this,LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(SingUpActivity.this,"Email can not taken use another Email account",Toast.LENGTH_SHORT).show();
                                        progressBar2.setVisibility(View.INVISIBLE);
                                    }
                                }
                            });
                        }
                        else {
                            Toast.makeText(SingUpActivity.this,"faild",Toast.LENGTH_SHORT).show();
                            progressBar2.setVisibility(View.INVISIBLE);
                        }
                    }
                });


    }
}