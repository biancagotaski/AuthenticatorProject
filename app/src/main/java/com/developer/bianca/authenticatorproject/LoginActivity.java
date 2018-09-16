package com.developer.bianca.authenticatorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //PARA DEIXAR A TELA EM MODO FULL SCREEN
        //TESTAR PARA VERIFICAR A DIFERENÇA ENTRE DECLARAR AQUI OU DECLARAR NO MANIFESTO COMO THEME.
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
    }
}
