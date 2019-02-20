package com.gzeinnumer.mystore.Data;

public class DataModel {
    int id;
    String nama;
    String image;
    String jenis; // pants / dress
    double harga;
    String desc;
    String ukuran;
    int stok;

    public DataModel(int id, String nama, String image, String jenis, double harga, String desc, String ukuran, int stok) {
        this.id = id;
        this.nama = nama;
        this.image = image;
        this.jenis = jenis;
        this.harga = harga;
        this.desc = desc;
        this.ukuran = ukuran;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getImage() {
        return image;
    }

    public String getJenis() {
        return jenis;
    }

    public double getHarga() {
        return harga;
    }

    public String getDesc() {
        return desc;
    }

    public String getUkuran() {
        return ukuran;
    }

    public int getStok() {
        return stok;
    }
}
