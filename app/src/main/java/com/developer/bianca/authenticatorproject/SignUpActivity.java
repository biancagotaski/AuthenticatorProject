package com.developer.bianca.authenticatorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.bianca.authenticatorproject.Utils.Constants;
import com.developer.bianca.authenticatorproject.domain.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference signupRef;

    EditText nameField, emailField, passwordField, passwordConfirmField, cpfField;
    boolean isNameValid, isEmailValid, isPasswordValid, isPasswordConfirmedValid, isCpfValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        database = FirebaseDatabase.getInstance();
        signupRef = database.getReference(Constants.REGISTERS_ENDPOINT);

        nameField = findViewById(R.id.name_edit_text);
        emailField = findViewById(R.id.email_to_login_et);
        passwordField = findViewById(R.id.password_edit_text);
        passwordConfirmField = findViewById(R.id.confirm_password_et);
        cpfField = findViewById(R.id.cpf_edit_text);

        nameField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus && (!nameField.getText().toString().matches("[a-zA-Z ]+") || nameField.getText().toString().trim().equals(""))) {
                    nameField.setError("Somente letras podem compor o nome. Campo obrigatório.");
                    isNameValid = false;
                } else {
                    isNameValid = true;
                }
            }
        });

        emailField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus && ((isEmailValid(emailField.getText().toString())) == false)){
                    emailField.setError("Campo obrigatório. Digite um e-mail válido");
                    isEmailValid = false;
                } else {
                    isEmailValid = true;
                }
            }
        });

        //FIXME: por algum motivo está salvando o mesmo input que o e-mail. E está dizendo que as senhas são iguais.
        //E por isso, está salvando no banco normalmente, por estar tudo com valided = true;
        final String password = emailField.getText().toString();
        final String passwordConfirm = passwordConfirmField.getText().toString();
        passwordField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus && passwordField.getText().toString().trim().equals("")){
                    passwordField.setError("Campo obrigatório. As senhas devem ser iguais.");
                    isPasswordValid = false;
                } else {
                    isPasswordValid = true;
                }
            }
        });

        passwordConfirmField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus && ((!password.equals(passwordConfirm)) || (passwordField.getText().toString().trim().equals("")))){
                    passwordConfirmField.setError("Campo obrigatório. As senhas devem ser iguais.");
                    isPasswordConfirmedValid = false;
                } else {
                    isPasswordConfirmedValid = true;
                }
            }
        });

        cpfField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus && cpfField.getText().toString().trim().equals("")){
                    cpfField.setError("Campo obrigatório");
                    isCpfValid = false;
                } else {
                    isCpfValid = true;
                }
            }
        });
    }

    public boolean isEmailValid(String email) {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }

    public void newUser(View view) {

        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String password = emailField.getText().toString();
        String passwordConfirm = passwordConfirmField.getText().toString();
        String cpf = cpfField.getText().toString();

        final User user = new User(name, email, password, passwordConfirm, cpf);

        if (isNameValid && isEmailValid && isPasswordValid && isPasswordConfirmedValid && isCpfValid){
            signupRef.push().setValue(user);
        }

        signupRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Toast.makeText(getApplicationContext(), "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao registrar novo usuário. Entre em contato com o suporte.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //FIXME: dessa maneira está iniciando a activity. Se for o caso de já está em memória, não sei como chamar.
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    public void clearFormSignUp(View view) {
        nameField.getText().clear();
        emailField.getText().clear();
        passwordField.getText().clear();
        passwordConfirmField.getText().clear();
        cpfField.getText().clear();
        isNameValid = false;
        isEmailValid = false;
        isPasswordValid = false;
        isPasswordConfirmedValid = false;
        isCpfValid = false;
    }
}