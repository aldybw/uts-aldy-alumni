package ac.id.pnj.utsaldyberita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import ac.id.pnj.utsaldyberita.fragment.berita.BeritaFragment;
import ac.id.pnj.utsaldyberita.fragment.home.HomeFragment;
import ac.id.pnj.utsaldyberita.fragment.profile.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreferences = getSharedPreferences("UtsAldyBerita", MODE_PRIVATE);
        bottomNavigation = findViewById(R.id.bottom_navigation);
//        setTitle(sharedPreferences.getString("nama", ""));
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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.actionMenu1:
                Intent intent1 = new Intent(HomeActivity.this, TambahPendudukActivity.class);
                startActivity(intent1);
//                Toast.makeText(this, "Menu Tambah Data dipilih", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionMenu2:
                Intent intent2 = new Intent(HomeActivity.this, DataPendudukActivity.class);
                startActivity(intent2);
//                Toast.makeText(this, "Menu Data Penduduk dipilih", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionMenu3:
                SharedPreferences sharedPreferences = getSharedPreferences("UtsAldyBerita", MODE_PRIVATE);
                SharedPreferences.Editor edit= sharedPreferences.edit();
                edit.clear();
                edit.commit();

                Intent intent3 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent3);
                finish();

                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}