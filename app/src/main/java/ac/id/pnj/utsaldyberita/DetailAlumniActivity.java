package ac.id.pnj.utsaldyberita;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ac.id.pnj.utsaldyberita.database.DatabaseHelper;

public class DetailAlumniActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtNim, edtNamaAlumni, edtTempatLahir, edtTanggalLahir, edtAlamat, edtAgama, edtHp, edtTahunMasuk, edtTahunLulus, edtPekerjaan, edtJabatan;
    Button actionUbah, actionHapus;
    Calendar calendar = Calendar.getInstance();
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_alumni);
        edtNim = findViewById(R.id.edtNim);
        edtNamaAlumni = findViewById(R.id.edtNamaAlumni);
        edtTempatLahir = findViewById(R.id.edtTempatLahir);
        edtTanggalLahir = findViewById(R.id.edtTanggalLahir);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtAgama = findViewById(R.id.edtAgama);
        edtHp = findViewById(R.id.edtHp);
        edtTahunMasuk = findViewById(R.id.edtTahunMasuk);
        edtTahunLulus = findViewById(R.id.edtTahunLulus);
        edtPekerjaan = findViewById(R.id.edtPekerjaan);
        edtJabatan = findViewById(R.id.edtJabatan);
        actionUbah = findViewById(R.id.actionUbah);
        actionHapus = findViewById(R.id.actionHapus);

        edtTanggalLahir.setOnClickListener(this);
        edtTahunMasuk.setOnClickListener(this);
        edtTahunLulus.setOnClickListener(this);
        actionUbah.setOnClickListener(this);
        actionHapus.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("id");
            edtNim.setText(extras.getString("nim", ""));
            edtNamaAlumni.setText(extras.getString("namaAlumni", ""));
            edtTempatLahir.setText(extras.getString("tempatLahir", ""));
            edtTanggalLahir.setText(extras.getString("tanggalLahir", ""));
            edtAlamat.setText(extras.getString("alamat", ""));
            edtAgama.setText(extras.getString("agama", ""));
            edtHp.setText(extras.getString("hp", ""));
            edtTahunMasuk.setText(extras.getString("tahunMasuk", ""));
            edtTahunLulus.setText(extras.getString("tahunLulus", ""));
            edtPekerjaan.setText(extras.getString("pekerjaan", ""));
            edtJabatan.setText(extras.getString("jabatan", ""));
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.actionUbah:
                if (edtNim.getText().toString().length() > 0 && edtNamaAlumni.getText().toString().length() > 0 && edtTempatLahir.getText().toString().length() > 0 && edtTanggalLahir.getText().toString().length() > 0 && edtAlamat.getText().toString().length() > 0 && edtAgama.getText().toString().length() > 0 && edtHp.getText().toString().length() > 0 && edtTahunMasuk.getText().toString().length() > 0 && edtTahunLulus.getText().toString().length() > 0 && edtPekerjaan.getText().toString().length() > 0 && edtJabatan.getText().toString().length() > 0) {
                    simpan();
                } else {
                    Toast.makeText(this, "Mohon Lengkapi Data", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.actionHapus:
                SQLiteDatabase database2 = new DatabaseHelper(this).getWritableDatabase();
                long delete = database2.delete("tb_alumni", "id=?", new String[]{"" + id});
                if (delete != -1) {
                    Toast.makeText(this, "Hapus Alumni Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DetailAlumniActivity.this, DataAlumniActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Hapus Alumni Gagal", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.edtTanggalLahir:
                new DatePickerDialog(this, onDateSetListener1, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.edtTahunMasuk:
                new DatePickerDialog(this, onDateSetListener2, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.edtTahunLulus:
                new DatePickerDialog(this, onDateSetListener3, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }

    DatePickerDialog.OnDateSetListener onDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
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

    DatePickerDialog.OnDateSetListener onDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, i);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            edtTahunMasuk.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

    DatePickerDialog.OnDateSetListener onDateSetListener3 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, i);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            edtTahunLulus.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

    void simpan() {
        SQLiteDatabase database = new DatabaseHelper(this).getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nim", edtNim.getText().toString());
        contentValues.put("nama_alumni", edtNamaAlumni.getText().toString());
        contentValues.put("tempat_lahir", edtTempatLahir.getText().toString());
        contentValues.put("tanggal_lahir", edtTanggalLahir.getText().toString());
        contentValues.put("alamat", edtAlamat.getText().toString());
        contentValues.put("agama", edtAgama.getText().toString());
        contentValues.put("hp", edtHp.getText().toString());
        contentValues.put("tahun_masuk", edtTahunMasuk.getText().toString());
        contentValues.put("tahun_lulus", edtTahunLulus.getText().toString());
        contentValues.put("pekerjaan", edtPekerjaan.getText().toString());
        contentValues.put("jabatan", edtJabatan.getText().toString());

        long update = database.update("tb_alumni", contentValues, "id=?", new String[]{"" + id});

        if (update !=-1) {
            Toast.makeText(this, "Update Alumni Berhasil", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Update Alumni Gagal", Toast.LENGTH_SHORT).show();
        }

        database.close();
    }
}