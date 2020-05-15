package com.example.phases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText E_mail;
    EditText passworrd;
    Button signin;
    TextView next;
    TextView AD;
    FirebaseAuth Auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        E_mail=(EditText) findViewById(R.id.email);
        passworrd=(EditText)findViewById(R.id.password);
        signin=(Button)findViewById(R.id.signin);
        next=(TextView)findViewById(R.id.textView);
        AD=(TextView)findViewById(R.id.adm);
        Auth=FirebaseAuth.getInstance();
        AD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nw=new Intent(MainActivity.this,Seller_details.class);
                startActivity(nw);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });
    }
    public void validate(){
        String mailing=E_mail.getText().toString();
        String words=passworrd.getText().toString();
        if (mailing.isEmpty()||words.isEmpty()){
            Toast.makeText(this, "Enter all the credentials correctly", Toast.LENGTH_SHORT).show(); }
        Auth.signInWithEmailAndPassword(mailing,words).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent intent=new Intent(MainActivity.this,Start.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Error signing in", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
