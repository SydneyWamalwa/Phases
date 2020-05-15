package com.example.phases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class SignUp extends AppCompatActivity {
    EditText EMAL;
    EditText PASSW;
    Button sig;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EMAL = (EditText) findViewById(R.id.mailer);
        PASSW = (EditText) findViewById(R.id.passsssss);
        sig = (Button) findViewById(R.id.btnup);
        firebaseAuth = FirebaseAuth.getInstance();
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    public void validate() {
        String mailing = EMAL.getText().toString();
        String words = PASSW.getText().toString();
        if (mailing.isEmpty() || words.isEmpty()) {
            Toast.makeText(this, "Enter all the credentials correctly", Toast.LENGTH_SHORT).show();
        } else {
            firebaseAuth.createUserWithEmailAndPassword(mailing, words).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignUp.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this, Seller_details.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignUp.this, "Error signing up", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
