package com.example.instagramido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    private final String TAG = "SignupActivity";
    private EditText etUsernameSU;
    private EditText etPassword;
    private EditText etConfirmPswd;
    private EditText etEmail;
    Button btnSignUpDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsernameSU = findViewById(R.id.etUsernameSU);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPswd = findViewById(R.id.etConfirmPswd);
        etEmail = findViewById(R.id.etEmail);
        btnSignUpDone = findViewById(R.id.btnSignUpDone);

        btnSignUpDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the ParseUser
                String username = etUsernameSU.getText().toString();
                String password = etPassword.getText().toString();
               // String confirmPasswordUS = etConfirmPswd.getText().toString();
                String email = etEmail.getText().toString();
               SigningUS(username,password,email);

            }
        });
    }

    private void SigningUS(String username, String password, String email) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignupActivity.this, "We are in ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignupActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                // Hooray! Let them use the app now.
                    Toast.makeText(SignupActivity.this, "Fuck it", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Shit is Popping everywhere: ERROR");
                }

            }
        });



    }
}
