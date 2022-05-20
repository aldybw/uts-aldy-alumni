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

import ac.id.pnj.utsaldyberita.adapter.AdapterPenduduk;
import ac.id.pnj.utsaldyberita.database.DatabaseHelper;
import ac.id.pnj.utsaldyberita.model.BeritaModel;
import ac.id.pnj.utsaldyberita.model.PendudukModel;

public class DataPendudukActivity extends AppCompatActivity {

    ListView listView;
    AdapterPenduduk adapterPenduduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_penduduk);
        listView = findViewById(R.id.listView);
        adapterPenduduk = new AdapterPenduduk(this, R.layout.layout_item_list_penduduk);
        listView.setAdapter(adapterPenduduk);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PendudukModel model = (PendudukModel) adapterView.getAdapter().getItem(i);

                Intent intent = new Intent(DataPendudukActivity.this, DetailPendudukActivity.class);
                intent.putExtra("id", model.getId());
                intent.putExtra("nik", model.getNik());
                intent.putExtra("nama", model.getNama());
                intent.putExtra("tempatLahir", model.getTempatLahir());
                intent.putExtra("tanggalLahir", model.getTanggalLahir());
                intent.putExtra("alamat", model.getAlamat());
                intent.putExtra("agama", model.getAgama());
                intent.putExtra("hp", model.getHp());
                intent.putExtra("kepalaKeluarga", model.getKepalaKeluarga());

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
        adapterPenduduk.clear();
        ArrayList<PendudukModel> datas = new ArrayList<>();
        SQLiteDatabase database = new DatabaseHelper(this).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM tb_penduduk", null);

        if (cursor.moveToFirst()) {
            do {
                PendudukModel model = new PendudukModel();
                model.setId(cursor.getInt(0));
                model.setNik(cursor.getString(1));
                model.setNama(cursor.getString(2));
                model.setTempatLahir(cursor.getString(3));
                model.setTanggalLahir(cursor.getString(4));
                model.setAlamat(cursor.getString(5));
                model.setAgama(cursor.getString(6));
                model.setHp(cursor.getString(7));
                model.setKepalaKeluarga(cursor.getString(8));
                datas.add(model);
            } while(cursor.moveToNext());
        }
        adapterPenduduk.addAll(datas);
        adapterPenduduk.notifyDataSetChanged();
    }
}