package com.jayqu.partner;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NewRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_nav_bar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //bottomNavigationView.setOnNavigationItemReselectedListener(navListener);

        bottomNavigationView.setSelectedItemId(R.id.nav_new);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_history:
                        startActivity(new Intent(getApplicationContext(),history_nav_bar.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_completed:
                        startActivity(new Intent(getApplicationContext(),completed_nav_bar.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_pending:
                        startActivity(new Intent(getApplicationContext(),pending_nav_bar.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_new:
                        return true;
                }

                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();


                return false;
            }
        });
    }
}
