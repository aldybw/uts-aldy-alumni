package ac.id.pnj.utsaldyberita.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ac.id.pnj.utsaldyberita.R;
import ac.id.pnj.utsaldyberita.model.AlumniModel;

public class AdapterAlumni extends ArrayAdapter<AlumniModel> {

    int resource;
    Context context;

    public AdapterAlumni(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder;

        AlumniModel model = getItem(position);

        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder = new Holder();
            holder.txtNim = convertView.findViewById(R.id.txtNim);
            holder.txtNamaAlumni = convertView.findViewById(R.id.txtNamaAlumni);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.txtNim.setText(model.getNim());
        holder.txtNamaAlumni.setText(model.getNamaAlumni());

        return convertView;
    }

    class Holder {
        TextView txtNim, txtNamaAlumni;
    }
}
