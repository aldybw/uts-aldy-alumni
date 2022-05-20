package ac.id.pnj.utsaldyberita.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String _NAMA_DATABASE = "db_alumni";
    public static int _VERSION = 1;
    public static String _CREATE_TABLE = "create table tb_alumni (id INTEGER PRIMARY KEY AUTOINCREMENT," + "nim TEXT,nama_alumni TEXT,tempat_lahir TEXT,tanggal_lahir TEXT,alamat TEXT,agama TEXT,hp TEXT,tahun_masuk TEXT,tahun_lulus TEXT,pekerjaan TEXT,jabatan TEXT)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, _NAMA_DATABASE, null, _VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
