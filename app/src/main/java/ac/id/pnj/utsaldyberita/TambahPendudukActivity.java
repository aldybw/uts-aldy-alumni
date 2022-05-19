package ac.id.pnj.utsaldyberita;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TambahPendudukActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtNik, edtNama, edtTempatLahir, edtTanggalLahir, edtAlamat, edtAgama, edtHp, edtKepalaKeluarga;
    Button actionSimpan;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_penduduk);
        edtNik = findViewById(R.id.edtNik);
        edtNama = findViewById(R.id.edtNama);
        edtTempatLahir = findViewById(R.id.edtTempatLahir);
        edtTanggalLahir = findViewById(R.id.edtTanggalLahir);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtAgama = findViewById(R.id.edtAgama);
        edtHp = findViewById(R.id.edtHp);
        edtKepalaKeluarga = findViewById(R.id.edtKepalaKeluarga);
        actionSimpan = findViewById(R.id.actionSimpan);

        edtTanggalLahir.setOnClickListener(this);
        actionSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edtTanggalLahir:
                new DatePickerDialog(this, onDateSetListener, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
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
}