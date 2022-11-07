package com.if3b.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bnvMusikKita;
    private FrameLayout flContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        bnvMusikKita.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_musik:
                        bukaFragmen(new MusikFragment());
                        getSupportActionBar().setTitle("Musik");
                        return true;

                    case  R.id.menu_album:
                        bukaFragmen(new AlbumFragment());
                        getSupportActionBar().setTitle("Album");
                        return true;

                    case  R.id.menu_artis:
                        bukaFragmen(new ArtisFragment());
                        getSupportActionBar().setTitle("Artis");
                        return true;
                }
                return false;
            }
        });
    }
    private void initView(){
        bnvMusikKita = findViewById(R.id.bnv_musik_kita);
         flContainer = findViewById(R.id.fl_container);
        bukaFragmen(new MusikFragment());
        getSupportActionBar().setTitle("Musik");
    }

    private void bukaFragmen(Fragment frm){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_container, frm);
        ft.commit();

    }
}