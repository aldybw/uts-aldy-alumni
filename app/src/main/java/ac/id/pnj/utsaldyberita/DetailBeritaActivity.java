package ac.id.pnj.utsaldyberita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailBeritaActivity extends AppCompatActivity {

    ImageView imgBerita;
    TextView txtJudul, txtIsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        imgBerita = findViewById(R.id.imgBerita);
        txtJudul = findViewById(R.id.txtJudul);
        txtIsi = findViewById(R.id.txtIsiBerita);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Picasso.get().load(extras.getString("image", "")).into(imgBerita);
            txtIsi.setText(extras.getString("isi", ""));
            txtJudul.setText(extras.getString("judul", ""));
        }
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
                Toast.makeText(this, "Menu Tambah Data dipilih", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionMenu2:
                Toast.makeText(this, "Menu Data Penduduk dipilih", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionMenu3:
                Toast.makeText(this, "Menu Logout dipilih", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}