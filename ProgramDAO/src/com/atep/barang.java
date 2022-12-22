/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atep;
import com.stripbandunk.jwidget.annotation.TableColumn;

/**
 *
 * @author Muhammad Ilham
 */
public class barang {
    @TableColumn(number=1, name ="KODE BARANG")
    private String kodeBarang;
    @TableColumn(number=2, name ="NAMA BARANG")
    private String namaBarang;
    @TableColumn(number=3, name ="JUMLAH")
    private int jumlah;
    @TableColumn(number=4, name ="HARGA")
    private long harga;
    
    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }
    
    
}
