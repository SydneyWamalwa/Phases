package com.example.phases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Seller_details extends AppCompatActivity {
EditText Name;
EditText Location;
EditText Contacts;
Button Reg;
Selling_Members members;
DatabaseReference ref;
TextView already;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_details);

        Name=(EditText)findViewById(R.id.Sellname);
        Location=(EditText)findViewById(R.id.sellLoc);
        Contacts=(EditText)findViewById(R.id.sellcont);
        Reg=(Button)findViewById(R.id.buttonreg);
        already=(TextView)findViewById(R.id.textView7);
        ref=FirebaseDatabase.getInstance().getReference().child("Selling_Members");
        members=new Selling_Members();
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Seller_details.this,Adminport.class);
                startActivity(intent);
            }
        });
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jina=Name.getText().toString();
                String mahali=Location.getText().toString();
                String no=Contacts.getText().toString();

                members.setName(jina);
                members.setContacts(no);
                members.setLocation(mahali);

                ref.push().setValue(members);
                Toast.makeText(Seller_details.this, "Seller info Registered", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Seller_details.this,Adminport.class);
                startActivity(intent);

            }
        });


    }
}
