package com.example.navigationjetpack;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;

import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavController navController;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigation();


    }

    public void setupNavigation()
    {
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        drawerLayout=findViewById(R.id.drawer_layout);

        navigationView=findViewById(R.id.navigationView);

        navController= Navigation.findNavController(this,R.id.host_fragment);

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);

        NavigationUI.setupWithNavController(navigationView,navController);

        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen((GravityCompat.START)))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {

        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.host_fragment),drawerLayout);
    }

    public boolean onNavigationItemSelected(MenuItem menuItem){


         menuItem.setCheckable(true);
         drawerLayout.closeDrawers();
         int id= menuItem.getItemId();

         switch (id)
         {
             case R.id.first:
                 navController.navigate(R.id.firstfregment);
                 break;
             case R.id.Second:
                 navController.navigate(R.id.secoundFregment);
                 break;
             case R.id.Third:
                 navController.navigate(R.id.thirdFregment);
                 break;


         }

        return false;
   }

}
