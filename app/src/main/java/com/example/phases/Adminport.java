package com.example.phases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Adminport extends AppCompatActivity {
ImageView clothes;
ImageView House;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminport);
        clothes=(ImageView)findViewById(R.id.imageView3);
        House=(ImageView)findViewById(R.id.imageView4);
        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Adminport.this,Uploading.class);
                startActivity(intent);
            }
        });
    }
}
