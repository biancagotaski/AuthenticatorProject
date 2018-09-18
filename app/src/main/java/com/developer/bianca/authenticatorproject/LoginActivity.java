package com.developer.bianca.authenticatorproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.bianca.authenticatorproject.domain.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText emailLoginField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        emailLoginField = findViewById(R.id.input_email);
        passwordField = findViewById(R.id.input_password);
    }

    public void signIn(View view) {
        mAuth = DataAccess.getFireBaseAuthentication();
        mAuth.signInWithEmailAndPassword(emailLoginField.getText().toString().trim(), passwordField.getText().toString().trim())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(
                                    getApplicationContext(),
                                    TasksActivity.class));
                            Toast.makeText(getApplicationContext(), "Login efetuado", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                            Log.d(task.getException().getMessage(), "Erro auth firebase: ");
                        }
                    }
                });
    }
}
