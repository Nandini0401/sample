package com.jayqu.partner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private Button Item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       Item = findViewById(R.id.Add_Item);
       Item.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this,ItemActivity.class);
               startActivity(intent);
           }
       });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
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
                }

                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();


                return false;
            }


        });
    }
}