package com.example.prak_pt03_2072030.Model;

public class Barang {
    private int id;
    private String nama;
    private String Supplier;

    public Barang(int id, String nama, String supplier) {
        this.id = id;
        this.nama = nama;
        Supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }
}
