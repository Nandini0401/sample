 package com.jayqu.partner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CatgActivity extends AppCompatActivity {

  //  TextView category;
     Button Tablets, Syrups,beauty,general,Other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

   // category.findViewById(R.id.category);
    Tablets=findViewById(R.id.tablets11);
    Syrups=findViewById(R.id.Syrups11);
    beauty=findViewById(R.id.beauty11);
    general=findViewById(R.id.general11);
    Other=findViewById(R.id.other11);
    Tablets.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CatgActivity.this, ItemActivity.class);
            startActivity(intent);

        }
    });


       Syrups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ent = new Intent(CatgActivity.this, ItemActivity.class);
                startActivity(ent);

            }
        });



       beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nt = new Intent(CatgActivity.this, ItemActivity.class);
                startActivity(nt);

            }
        });



       general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(CatgActivity.this, ItemActivity.class);
                startActivity(t);

            }
        });

        Other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(CatgActivity.this, AddcatActivity.class);
                startActivity(t);

            }
        });



    }
}