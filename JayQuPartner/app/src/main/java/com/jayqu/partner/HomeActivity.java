package com.jayqu.partner;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
     Button category1;
     DrawerLayout mNavDrawer;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.drawer_nav_layout);

         Toolbar toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

         mNavDrawer = findViewById(R.id.drawer_layout);
         NavigationView navigationView = findViewById(R.id.navigation_view);


         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                 this, mNavDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
         );
         mNavDrawer.addDrawerListener(toggle);

         toggle.syncState();
         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
         {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 switch (item.getItemId()) {
                     case R.id.navi_home:
                         startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                         overridePendingTransition(0, 0);
                         return true;
                     case R.id.navi_item:
                         startActivity(new Intent(getApplicationContext(), viewitem.class));
                         overridePendingTransition(0, 0);
                         return true;
                     case R.id.navi_payment:
                         startActivity(new Intent(getApplicationContext(), paymentrequest.class));
                         overridePendingTransition(0, 0);
                         return true;
                     case R.id.navi_logout:
                       startActivity(new Intent(getApplicationContext(), logout.class));
                         overridePendingTransition(0, 0);
                         return true;
                   
                 }


                 return false;
             }
         });



       category1 = (Button) findViewById(R.id.addCategoryBtn);
       category1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               try {
                   startActivity(new Intent(HomeActivity.this, CatgActivity.class));
               }
               catch (Exception e)
               {
                   Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_LONG).show();
               }
               /*Intent intent = new Intent(HomeActivity.this, CatgActivity.class);
               startActivity(intent);*/
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
                    case R.id.nav_new:
                        startActivity(new Intent(getApplicationContext(),NewRequest.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();


                return false;
            }


        });
    }
}