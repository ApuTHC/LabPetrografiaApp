package com.example.geomap12;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        DrawerLayout.DrawerListener {

  private DrawerLayout drawerLayout;
  private int currentMenuItemId;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

    drawerLayout = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();

    FragmentManager fragmentManager=getSupportFragmentManager();
    fragmentManager.beginTransaction().add(R.id.home_content, new HomeContentFragment()).commit();

    NavigationView navigationView = findViewById(R.id.navigation_view);
    navigationView.setNavigationItemSelectedListener(this);
    MenuItem menuItem = navigationView.getMenu().getItem(0);
    onNavigationItemSelected(menuItem);
    menuItem.setChecked(true);

    drawerLayout.addDrawerListener(this);

    View header = navigationView.getHeaderView(0);
    header.findViewById(R.id.header_title).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        //setTitle(getString(R.string.app_name));
        drawerLayout.closeDrawer(GravityCompat.START);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.home_content, new HomeContentFragment()).addToBackStack(null).commit();


        NavigationView navigationView = findViewById(R.id.navigation_view);
        MenuItem menuItem = navigationView.getMenu().findItem(currentMenuItemId);
        menuItem.setChecked(false);

      }
    });
  }

  @Override
  public void onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    int title;
    FragmentManager fragmentManager=getSupportFragmentManager();
    currentMenuItemId=menuItem.getItemId();
    switch (menuItem.getItemId()) {
      case R.id.nav_manual:
        //title = R.string.menu_manual;
        fragmentManager.beginTransaction().replace(R.id.home_content, new ManualContentFragment()).addToBackStack(null).commit();
        break;
      case R.id.nav_recono:
        //title = R.string.menu_recono;
        fragmentManager.beginTransaction().replace(R.id.home_content, new ReconoContentFragment()).addToBackStack(null).commit();
        break;
      case R.id.nav_rutas:
        //title = R.string.menu_rutas;
        fragmentManager.beginTransaction().replace(R.id.home_content, new RutaContentFragment()).addToBackStack(null).commit();
        break;
      case R.id.nav_virtualmicro:
        //title = R.string.menu_virtualmicro;
        fragmentManager.beginTransaction().replace(R.id.home_content, new VirtualmicroContentFragment()).addToBackStack(null).commit();
        break;
      case R.id.nav_geomap:
        //title = R.string.menu_geomap;
        fragmentManager.beginTransaction().replace(R.id.home_content, new GeomapContentFragment()).addToBackStack(null).commit();
        break;
      case R.id.nav_macro:
        //title = R.string.menu_macro;
        fragmentManager.beginTransaction().replace(R.id.home_content, new RocamacroContentFragment()).addToBackStack(null).commit();
        break;
      case R.id.nav_micro:
        //title = R.string.menu_micro;
        fragmentManager.beginTransaction().replace(R.id.home_content, new RocamicroContentFragment()).addToBackStack(null).commit();
        break;
      case R.id.nav_fosil:
        //title = R.string.menu_fosil;
        fragmentManager.beginTransaction().replace(R.id.home_content, new FosilContentFragment()).addToBackStack(null).commit();
        break;
      default:
        //title = R.string.no_data;
        fragmentManager.beginTransaction().replace(R.id.home_content, new HomeContentFragment()).addToBackStack(null).commit();
    }

    //setTitle(getString(title));

    drawerLayout.closeDrawer(GravityCompat.START);

    return true;
  }

  @Override
  public void onDrawerSlide(@NonNull View view, float v) {
    //cambio en la posición del drawer
  }

  @Override
  public void onDrawerOpened(@NonNull View view) {
    //el drawer se ha abierto completamente

  }

  @Override
  public void onDrawerClosed(@NonNull View view) {
    //el drawer se ha cerrado completamente
  }

  @Override
  public void onDrawerStateChanged(int i) {
    //cambio de estado, puede ser STATE_IDLE, STATE_DRAGGING or STATE_SETTLING
  }


  public void setTitulo(int title) {
    setTitle(getString(title));
  }



}
