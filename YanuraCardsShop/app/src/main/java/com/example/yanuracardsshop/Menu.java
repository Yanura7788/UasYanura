package com.example.yanuracardsshop;

public class Menu {

    private String nama;
    private String harga;
    private String gambar;
    private String itemdetail;

    public Menu(String datanama, String dataharga, String datagambar, String dataitem) {
        nama = datanama;
        harga = dataharga;
        gambar = datagambar;
        itemdetail = dataitem;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public String getGambar() {
        return gambar;
    }

    public String getItemdetail() {
        return itemdetail;
    }
}