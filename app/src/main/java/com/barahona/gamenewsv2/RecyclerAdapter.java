package com.barahona.gamenewsv2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterViewHolder> {

    private Context context;
    private List<Noticia> data;

    public RecyclerAdapter(Context context, List<Noticia> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.nosexd, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.AdapterViewHolder holder, int position) {
        holder.titulo_noticia.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() { return data.size(); }


    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView img_noticia;
        TextView titulo_noticia;
        ImageButton btn_fav;

        public AdapterViewHolder(View itemView) {
            super(itemView);

            img_noticia = itemView.findViewById(R.id.img_noticia1);
            titulo_noticia = itemView.findViewById(R.id.titulo_noticia1);
            btn_fav = itemView.findViewById(R.id.imgbtn_fav);

        }
    }
}
