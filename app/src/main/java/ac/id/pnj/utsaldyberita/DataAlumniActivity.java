package ac.id.pnj.utsaldyberita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ac.id.pnj.utsaldyberita.adapter.AdapterAlumni;
import ac.id.pnj.utsaldyberita.database.DatabaseHelper;
import ac.id.pnj.utsaldyberita.model.AlumniModel;

public class DataAlumniActivity extends AppCompatActivity {

    ListView listView;
    AdapterAlumni adapterAlumni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_alumni);
        listView = findViewById(R.id.listView);
        adapterAlumni = new AdapterAlumni(this, R.layout.layout_item_list_alumni);
        listView.setAdapter(adapterAlumni);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlumniModel model = (AlumniModel) adapterView.getAdapter().getItem(i);

                Intent intent = new Intent(DataAlumniActivity.this, DetailAlumniActivity.class);
                intent.putExtra("id", model.getId());
                intent.putExtra("nim", model.getNim());
                intent.putExtra("namaAlumni", model.getNamaAlumni());
                intent.putExtra("tempatLahir", model.getTempatLahir());
                intent.putExtra("tanggalLahir", model.getTanggalLahir());
                intent.putExtra("alamat", model.getAlamat());
                intent.putExtra("agama", model.getAgama());
                intent.putExtra("hp", model.getHp());
                intent.putExtra("tahunMasuk", model.getTahunMasuk());
                intent.putExtra("tahunLulus", model.getTahunLulus());
                intent.putExtra("pekerjaan", model.getPekerjaan());
                intent.putExtra("jabatan", model.getJabatan());

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    void getData() {
        adapterAlumni.clear();
        ArrayList<AlumniModel> datas = new ArrayList<>();
        SQLiteDatabase database = new DatabaseHelper(this).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM tb_alumni", null);

        if (cursor.moveToFirst()) {
            do {
                AlumniModel model = new AlumniModel();
                model.setId(cursor.getInt(0));
                model.setNim(cursor.getString(1));
                model.setNamaAlumni(cursor.getString(2));
                model.setTempatLahir(cursor.getString(3));
                model.setTanggalLahir(cursor.getString(4));
                model.setAlamat(cursor.getString(5));
                model.setAgama(cursor.getString(6));
                model.setHp(cursor.getString(7));
                model.setTahunMasuk(cursor.getString(8));
                model.setTahunLulus(cursor.getString(9));
                model.setPekerjaan(cursor.getString(10));
                model.setJabatan(cursor.getString(11));
                datas.add(model);
            } while(cursor.moveToNext());
        }
        adapterAlumni.addAll(datas);
        adapterAlumni.notifyDataSetChanged();
    }
}