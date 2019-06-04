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

public class Sign_up extends AppCompatActivity {

    EditText name,mail,pass,date,place;
    FirebaseAuth mAuth ;
    Button b1,b2;
    String Email,Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=(EditText)findViewById(R.id.edt1);
        pass=(EditText)findViewById(R.id.edt5);
        place=(EditText)findViewById(R.id.edt3);
        mail=(EditText)findViewById(R.id.edt2);
        date=(EditText)findViewById(R.id.edt4);
        b1=(Button)findViewById(R.id.btn1);
        b2=(Button)findViewById(R.id.btn2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*SharedPreferences sharePref=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharePref.edit();
                editor.putString("name",name.getText().toString());
                editor.putString("password",pass.getText().toString());
                editor.putString("place",place.getText().toString());ss
                editor.putString("phone",phone.getText().toString());
                editor.putString("date",date.getText().toString());
                editor.apply();*/

                Email=mail.getText().toString();
                Pass =pass.getText().toString();

                if(!(Patterns.EMAIL_ADDRESS.matcher(Email).matches()))
                {
                    mail.setError("invalid email");

                }
                mAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"registered successfully",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Sign_up.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"registered failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                pass.setText("");
                date.setText("");
                mail.setText("");
                place.setText("");
            }
        });

    }
}
