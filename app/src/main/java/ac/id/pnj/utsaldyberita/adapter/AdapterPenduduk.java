package ac.id.pnj.utsaldyberita.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ac.id.pnj.utsaldyberita.R;
import ac.id.pnj.utsaldyberita.model.PendudukModel;

public class AdapterPenduduk extends ArrayAdapter<PendudukModel> {

    int resource;
    Context context;

    public AdapterPenduduk(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder;

        PendudukModel model = getItem(position);

        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder = new Holder();
            holder.txtNik = convertView.findViewById(R.id.txtNik);
            holder.txtNama = convertView.findViewById(R.id.txtNama);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.txtNik.setText(model.getNik());
        holder.txtNama.setText(model.getNama());
//        Log.e(this.context.toString(), model.getNik().toString());
//        Log.e(this.context.toString(), model.getNama().toString());

        return convertView;
    }

    class Holder {
        TextView txtNik, txtNama;
    }
}
