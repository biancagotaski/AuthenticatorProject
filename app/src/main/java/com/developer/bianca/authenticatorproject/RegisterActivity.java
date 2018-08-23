package com.developer.bianca.authenticatorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void newRegister(View view){
        //TODO: verificar se formulário está preenchido corretamente
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
