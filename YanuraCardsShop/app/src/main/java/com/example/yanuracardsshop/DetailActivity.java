package com.example.yanuracardsshop;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String nama="nama";
    public static final String harga="harga";
    public static final String item="item";
    public static final String gambar="NULL";
    public ImageView image;
    public TextView tvhargadata;
    public TextView tvnamadata;
    public TextView tvitemdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );

        tvnamadata= findViewById( R.id.tv_nama );
        tvhargadata = findViewById( R.id.tv_harga );
        tvitemdata = findViewById( R.id.tv_item);
        image = findViewById( R.id.img_menu );

        String simpanama = getIntent().getStringExtra(nama);
        String simpanharga = getIntent().getStringExtra(harga);
        String simpanitem = getIntent().getStringExtra(item);
        String simpangambar = getIntent().getStringExtra(gambar);

        tvnamadata.setText(simpanama);
        tvhargadata.setText(simpanharga);
        tvitemdata.setText(simpanitem);
        Glide
                .with(this)
                .load(simpangambar)
                .centerCrop()
                .into(image);
    }
}