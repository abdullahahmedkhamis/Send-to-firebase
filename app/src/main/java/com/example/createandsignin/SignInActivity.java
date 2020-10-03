package com.example.createandsignin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private Button btnREg;
    private EditText etEmail,etPass;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_in );

        mAuth = FirebaseAuth.getInstance();

        btnREg =(Button)findViewById( R.id.butSignInAcc );
        etEmail =(EditText) findViewById( R.id.editLoginEmail );
        etPass =(EditText) findViewById( R.id.etLoginPass );


        progressDialog = new ProgressDialog( this );

        btnREg.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString();
                String pass = etPass.getText().toString();

                SiginInUser(email,pass);
            }
        } );
    }

    private void SiginInUser(String email, String pass) {
        mAuth.signInWithEmailAndPassword( email, pass ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        } );
    }


}