package ac.id.pnj.utsaldyberita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ac.id.pnj.utsaldyberita.fragment.home.HomeFragment;
import ac.id.pnj.utsaldyberita.fragment.profile.FragmentProfile;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button actionHome, actionProfile;
    HomeFragment homeFragment = new HomeFragment();
    FragmentProfile fragmentProfile = new FragmentProfile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        actionHome = findViewById(R.id.actionHome);
        actionProfile = findViewById(R.id.actionProfile);

        actionHome.setOnClickListener(this);
        actionProfile.setOnClickListener(this);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, homeFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.actionHome:
                fragmentTransaction.replace(R.id.container, homeFragment);
                fragmentTransaction.commit();
                break;
            case R.id.actionProfile:
                fragmentTransaction.replace(R.id.container, fragmentProfile);
                fragmentTransaction.commit();
                break;
        }
    }
}