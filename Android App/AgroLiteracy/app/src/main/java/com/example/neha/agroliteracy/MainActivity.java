package com.example.neha.agroliteracy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText e1,e2;
    FirebaseAuth mAuth;
    String phone,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        mAuth=FirebaseAuth.getInstance();
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = e1.getText().toString();
                password = e2.getText().toString();
                if (!(Patterns.EMAIL_ADDRESS.matcher(phone).matches())) {
                    e1.setError("Invalid Phone Number");
                }
              mAuth.signInWithEmailAndPassword(phone, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Sign in successfully", Toast.LENGTH_SHORT).show();
                            Intent it = new Intent(MainActivity.this, web.class);
                            startActivity(it);
                        } else

                        {
                            Toast.makeText(getApplicationContext(), "Sign in failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


                }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Sign_up.class);
                startActivity(it);

            }
        });
    }


    }




