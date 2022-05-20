package ac.id.pnj.utsaldyberita;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ac.id.pnj.utsaldyberita.database.DatabaseHelper;
import ac.id.pnj.utsaldyberita.model.PendudukModel;

public class DetailPendudukActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtNik, edtNama, edtTempatLahir, edtTanggalLahir, edtAlamat, edtAgama, edtHp, edtKepalaKeluarga;
    Button actionUbah, actionHapus;
    Calendar calendar = Calendar.getInstance();
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penduduk);
        edtNik = findViewById(R.id.edtNik);
        edtNama = findViewById(R.id.edtNama);
        edtTempatLahir = findViewById(R.id.edtTempatLahir);
        edtTanggalLahir = findViewById(R.id.edtTanggalLahir);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtAgama = findViewById(R.id.edtAgama);
        edtHp = findViewById(R.id.edtHp);
        edtKepalaKeluarga = findViewById(R.id.edtKepalaKeluarga);
        actionUbah = findViewById(R.id.actionUbah);
        actionHapus = findViewById(R.id.actionHapus);

        edtTanggalLahir.setOnClickListener(this);
        actionUbah.setOnClickListener(this);
        actionHapus.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("id");
            edtNik.setText(extras.getString("nik", ""));
            edtNama.setText(extras.getString("nama", ""));
            edtTempatLahir.setText(extras.getString("tempatLahir", ""));
            edtTanggalLahir.setText(extras.getString("tanggalLahir", ""));
            edtAlamat.setText(extras.getString("alamat", ""));
            edtAgama.setText(extras.getString("agama", ""));
            edtHp.setText(extras.getString("hp", ""));
            edtKepalaKeluarga.setText(extras.getString("kepalaKeluarga", ""));
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.actionUbah:
                if (edtNik.getText().toString().length() > 0 && edtNama.getText().toString().length() > 0 && edtTempatLahir.getText().toString().length() > 0 && edtTanggalLahir.getText().toString().length() > 0 && edtAlamat.getText().toString().length() > 0 && edtAgama.getText().toString().length() > 0 && edtHp.getText().toString().length() > 0 && edtKepalaKeluarga.getText().toString().length() > 0) {
                    simpan();
                } else {
                    Toast.makeText(this, "Mohon Lengkapi Data", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.actionHapus:
                SQLiteDatabase database2 = new DatabaseHelper(this).getWritableDatabase();
                long delete = database2.delete("tb_penduduk", "id=?", new String[]{"" + id});
                if (delete != -1) {
                    Toast.makeText(this, "Hapus Penduduk Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DetailPendudukActivity.this, DataPendudukActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Hapus Penduduk Gagal", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.edtTanggalLahir:
                new DatePickerDialog(this, onDateSetListener, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }

    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.MONTH, i1);
            calendar.set(Calendar.DAY_OF_MONTH, i2);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
            edtTanggalLahir.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

    void simpan() {
        SQLiteDatabase database = new DatabaseHelper(this).getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nik", edtNik.getText().toString());
        contentValues.put("nama", edtNama.getText().toString());
        contentValues.put("tempat_lahir", edtTempatLahir.getText().toString());
        contentValues.put("tanggal_lahir", edtTanggalLahir.getText().toString());
        contentValues.put("alamat", edtAlamat.getText().toString());
        contentValues.put("agama", edtAgama.getText().toString());
        contentValues.put("hp", edtHp.getText().toString());
        contentValues.put("kepala_keluarga", edtKepalaKeluarga.getText().toString());

        long update = database.update("tb_penduduk", contentValues, "id=?", new String[]{"" + id});

        if (update !=-1) {
            Toast.makeText(this, "Update Penduduk Berhasil", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Update Penduduk Gagal", Toast.LENGTH_SHORT).show();
        }

        database.close();
    }
}