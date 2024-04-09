package com.example.bt1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.bt1.model.SanPham;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Navigation extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    public static List<SanPham> ghList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        setControl();
        setEvent();
    }

    private void setEvent() {
        ghList= new ArrayList<SanPham>();

        drawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment= null;

                if(item.getItemId()==R.id.mnDanhSach)
                {
                    Toast.makeText(Navigation.this, "Danh Sách", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(Navigation.this, MainActivity8.class);
                    //startActivity(intent);
                    fragment= new DanhSachFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.flContent,fragment).commit();

                }
                if(item.getItemId()==R.id.mnCaiDat)
                {
                    Toast.makeText(Navigation.this, "Cài Đặt", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.mnGioHang)
                {
                    Toast.makeText(Navigation.this, "Giỏ hàng", Toast.LENGTH_SHORT).show();
                    fragment= new GioHangFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.flContent,fragment).commit();
                }

                drawerLayout.closeDrawers();

                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    private void setControl(){

        drawerLayout= findViewById(R.id.main);
        navigationView= findViewById(R.id.nvTrangChu);
    }


}