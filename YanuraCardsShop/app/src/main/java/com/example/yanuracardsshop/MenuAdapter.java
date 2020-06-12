package com.example.yanuracardsshop;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private Context context;
    private ArrayList<Menu> menus;
    private Button btn;

    public MenuAdapter(Context mcontext, ArrayList<Menu> resepmakanan) {
        context = mcontext;
        menus = resepmakanan;

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);

        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menubaru = menus.get(position);
        String gambarbaru = menubaru.getGambar();
        String harga = menubaru.getHarga();
        String nama = menubaru.getNama();

        holder.tvnamadata.setText(nama);
        holder.tvhargadata.setText(harga);
        Glide
                .with(context)
                .load(gambarbaru)
                .centerCrop()
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView tvhargadata;
        public TextView tvnamadata;
        public TextView tvitemdata;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_menu);
            tvhargadata = itemView.findViewById(R.id.tv_harga);
            tvnamadata = itemView.findViewById(R.id.tv_nama);
            tvitemdata = itemView.findViewById(R.id.tv_item);

            btn = itemView.findViewById(R.id.detail);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.nama, menus.get(getAdapterPosition()).getNama());
                    intent.putExtra(DetailActivity.harga, menus.get(getAdapterPosition()).getHarga());
                    intent.putExtra(DetailActivity.item, menus.get(getAdapterPosition()).getItemdetail());
                    intent.putExtra(DetailActivity.gambar, menus.get(getAdapterPosition()).getGambar());
                    context.startActivity(intent);

                }

            });
        }
    }
}
