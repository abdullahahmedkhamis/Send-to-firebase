package com.example.createandsignin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private Button btnREg;
    private EditText etEmail,etPass;

    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        mAuth = FirebaseAuth.getInstance();

        btnREg =(Button)findViewById( R.id.butCreateAcc );
        etEmail =(EditText) findViewById( R.id.editRegEmail );
        etPass =(EditText) findViewById( R.id.etRegPass );


        progressDialog = new ProgressDialog( this );


        btnREg.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString();
                String pass = etPass.getText().toString();

                RegisterUser(email,pass);
            }
        } );
    }

    private void RegisterUser(String email,String pass) {

        progressDialog.show();

        mAuth.createUserWithEmailAndPassword( email,pass ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressDialog.dismiss();
                if(task.isSuccessful()){
                    Intent i = new Intent( RegisterActivity.this,SignInActivity.class);
                    startActivity( i );

                    Toast.makeText( RegisterActivity.this, "Created Succeed", Toast.LENGTH_SHORT ).show();
                }else {
                    Toast.makeText( RegisterActivity.this, "Error" + task.getException(), Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }
}