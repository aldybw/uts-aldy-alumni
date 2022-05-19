package ac.id.pnj.utsaldyberita.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import ac.id.pnj.utsaldyberita.R;
import ac.id.pnj.utsaldyberita.model.BeritaModel;

public class AdapterBerita extends ArrayAdapter<BeritaModel> {
    Context context;
    int resource;

    public AdapterBerita(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder = null;
        BeritaModel model = getItem(position);

        if(convertView==null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource,parent,false);
            holder.imageBerita = convertView.findViewById(R.id.imgBerita);
            holder.txtJudul = convertView.findViewById(R.id.txtJudul);
            holder.txtIsiBerita = convertView.findViewById(R.id.txtIsiBerita);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        Picasso.get().load(model.getImage()).into(holder.imageBerita);
        Log.e(this.context.toString(), model.getImage().toString());
        holder.txtJudul.setText(model.getJudulBerita());
        String isiBerita = model.getIsiBerita();
        String isiBeritaPendek = isiBerita.substring(0,50);
        holder.txtIsiBerita.setText(isiBeritaPendek);

        return convertView;
    }

    class Holder {
        ImageView imageBerita;
        TextView txtJudul, txtIsiBerita;
    }
}
