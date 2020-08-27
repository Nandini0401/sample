package com.jayqu.partner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {
    private static final int GALLERY_REQUEST_CODE = 123;
    ImageView itimageview;
    Button itimage;
    public Uri imageUri;
    Button itsave;
   private Spinner quantity1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        itimageview = findViewById(R.id.itimageview);
        itimage = findViewById(R.id.itimage);
        itsave = findViewById(R.id.itsave);
        quantity1 = findViewById(R.id.quantity1);

        List<String> categories = new ArrayList<>();
        categories.add(0,"Choose");
        categories.add("Kg");
        categories.add("Litres");
        categories.add("dozen");
        categories.add("Pieces");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantity1.setAdapter(dataAdapter);




        itsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ItemActivity.this,HomeActivity.class);
                startActivity(i);


            }
        });

        itimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"CHOOSE IMAGE"),GALLERY_REQUEST_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data !=null){
            imageUri = data.getData();
           itimageview.setImageURI(imageUri);


        }
    }


  /*  BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
    //bottomNavigationView.setOnNavigationItemReselectedListener(navListener);

        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.nav_history:
                    startActivity(new Intent(getApplicationContext(), history_nav_bar.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.nav_home:
                    return true;
                case R.id.nav_pending:
                    startActivity(new Intent(getApplicationContext(), pending_nav_bar.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.nav_completed:
                    startActivity(new Intent(getApplicationContext(), completed_nav_bar.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.nav_new:
                    startActivity(new Intent(getApplicationContext(),NewRequest.class));
                    overridePendingTransition(0,0);
                    return true;
            }

            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();


            return false;
        }


    });

*/

}