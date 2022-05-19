package ac.id.pnj.utsaldyberita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import ac.id.pnj.utsaldyberita.fragment.berita.BeritaFragment;
import ac.id.pnj.utsaldyberita.fragment.home.HomeFragment;
import ac.id.pnj.utsaldyberita.fragment.profile.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigation = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_berita:
                        selectedFragment = new BeritaFragment();
                        break;
                    case R.id.nav_profile:
                        selectedFragment = new ProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });

//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.frame_container, homeFragment);
//        fragmentTransaction.commit();
    }

//    @Override
//    public void onClick(View v) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        switch (v.getId()) {
//            case R.id.actionHome:
//                fragmentTransaction.replace(R.id.frame_container, homeFragment);
//                fragmentTransaction.commit();
//                break;
//            case R.id.actionProfile:
//                fragmentTransaction.replace(R.id.frame_container, profileFragment);
//                fragmentTransaction.commit();
//                break;
//        }
//    }
}