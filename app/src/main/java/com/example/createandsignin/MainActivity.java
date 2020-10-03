package com.example.createandsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void btnRegister(View view) {
        Intent regIntent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity( regIntent );
    }

    public void btnLogin(View view) {
        Intent regIntent = new Intent(MainActivity.this,SignInActivity.class);
        startActivity( regIntent );
    }
}