package ac.id.pnj.utsaldyberita.fragment.berita;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import ac.id.pnj.utsaldyberita.DetailBeritaActivity;
import ac.id.pnj.utsaldyberita.R;
import ac.id.pnj.utsaldyberita.adapter.AdapterBerita;
import ac.id.pnj.utsaldyberita.model.BeritaModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BeritaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeritaFragment extends Fragment {

    GridView gridView;
    AdapterBerita adapterBerita;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_berita, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = view.findViewById(R.id.gridView);

        adapterBerita = new AdapterBerita(getActivity(), R.layout.layout_item_list_berita);
        gridView.setAdapter(adapterBerita);
        loadDataList();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BeritaModel model = (BeritaModel) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getActivity(), DetailBeritaActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("judul", model.getJudulBerita());
                intent.putExtra("isi", model.getIsiBerita());
                startActivity(intent);

            }
        });
    }

    void loadDataList() {
        String[] image = new String[]{"https://s.kaskus.id/images/2022/01/22/11076539_202201220606470145.jpg",
                "https://awsimages.detik.net.id/content/2013/08/14/775/flipflop.jpg",
                "https://www.harapanrakyat.com/wp-content/uploads/2021/03/11.-Sandal-Jepit-Ukir-Hadir-dengan-Berbagai-Rekomendasi-Menarik.jpg"};

        String[] judul = new String[]{"Vaksin COVID-19 Ditemukan, Saatnya Berburu Investasi Properti",
                "Alarm Berbunyi, 2 Pria Ini Gagal Curi Motor di Mampang Jaksel",
                "Temuan Indikasi Kehidupan di Venus, Sebuah Kesalahan Pengukuran?"};

        String[] isiBerita = new String[]{"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."};

        for (int i = 0; i < image.length; i++) {
            BeritaModel model = new BeritaModel();
            model.setImage(image[i]);
            model.setJudulBerita(judul[i]);
            model.setIsiBerita(isiBerita[i]);
            adapterBerita.add(model);
        }
        adapterBerita.notifyDataSetChanged();
    }

//    void generateData(){
//
//        ArrayList<BeritaModel> datas = new ArrayList<>();
//
//        BeritaModel b1 = new BeritaModel();
//        b1.setImage("https://s.kaskus.id/images/2022/01/22/11076539_202201220606470145.jpg");
//        b1.setJudulBerita("Vaksin COVID-19 Ditemukan, Saatnya Berburu Investasi Properti");
//        b1.setIsiBerita("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
//
//        BeritaModel b2 = new BeritaModel();
//        b2.setImage("https://s.kaskus.id/images/2022/01/22/11076539_202201220606470145.jpg");
//        b2.setJudulBerita("Vaksin COVID-19 Ditemukan, Saatnya Berburu Investasi Properti");
//        b2.setIsiBerita("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
//
//        BeritaModel b3 = new BeritaModel();
//        b3.setImage("https://s.kaskus.id/images/2022/01/22/11076539_202201220606470145.jpg");
//        b3.setJudulBerita("Vaksin COVID-19 Ditemukan, Saatnya Berburu Investasi Properti");
//        b3.setIsiBerita("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
//
//        datas.add(b1);
//        datas.add(b2);
//        datas.add(b3);
//
//        adapterBerita.addAll(datas);
//        adapterBerita.notifyDataSetChanged();
//    }
}