/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atep;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Muhammad Ilham
 */
public class fasilitas {
    private Connection koneksi;

    public fasilitas() {
       koneksi = KoneksiDatabase.getKoneksi();
    }
    
    public void insert(barang barang){
        PreparedStatement prepare = null;
        try {
            String sql ="INSERT INTO barang(kode_barang,nama_barang,jumlah,harga)VALUES(?,?,?,?)";
            prepare = (PreparedStatement) koneksi.prepareStatement(sql);
            prepare.setString(1, barang.getKodeBarang());
            prepare.setString(2, barang.getNamaBarang());
            prepare.setInt(3, barang.getJumlah());
            prepare.setLong(4, barang.getHarga());
            prepare.executeUpdate();
            System.out.println("Prepare statement berhasil dibuat");
        }catch(SQLException ex){
            System.out.println("Prepare statement gagal dibuat");
            System.out.println("Pesan : " + ex.getMessage());
        }finally{
            if (prepare != null){
                try{
                    prepare.close();
                    System.out.println("Prepare statemen berhasil ditutup");
                }catch(SQLException ex){
                    System.out.println("Prepare statemen gagal ditutup");
                    System.out.println("Pesan : " + ex.getMessage());
                }
                
            }
        }
    }
    
    public void update(barang barang){
        PreparedStatement prepare = null;
        try {
            String sql ="UPDATE barang SET nama_barang=?,jumlah=?,harga=? WHERE kode_barang=?";
            prepare = (PreparedStatement) koneksi.prepareStatement(sql);
            prepare.setString(1, barang.getNamaBarang());
            prepare.setInt(2, barang.getJumlah());
            prepare.setLong(3, barang.getHarga());
            prepare.setString(4, barang.getKodeBarang());
            prepare.executeUpdate();
            System.out.println("Prepare statement berhasil dibuat");
        }catch(SQLException ex){
            System.out.println("Prepare statement gagal dibuat");
            System.out.println("Pesan : " + ex.getMessage());
        }finally{
            if (prepare != null){
                try{
                    prepare.close();
                    System.out.println("Prepare statemen berhasil ditutup");
                }catch(SQLException ex){
                System.out.println("Prepare statemen gagal ditutup");
                System.out.println("Pesan : " + ex.getMessage());
                }
            }
        }
    }   
    
    public void delete(String kode_barang){
        PreparedStatement prepare = null;
        try {
            String sql ="DELETE FROM barang WHERE kode_barang=?";
            prepare = (PreparedStatement) koneksi.prepareStatement(sql);
            prepare.setString(1, kode_barang);
            prepare.executeUpdate();
            System.out.println("Prepare statement berhasil dibuat");
        }catch(SQLException ex){
            System.out.println("Prepare statement gagal dibuat");
            System.out.println("Pesan : " + ex.getMessage());
        }finally{
            if (prepare != null){
                try{
                    prepare.close();
                    System.out.println("Prepare statemen berhasil ditutup");
                }catch(SQLException ex){
                    System.out.println("Prepare statemen gagal ditutup");
                    System.out.println("Pesan : " + ex.getMessage());
                }
            }
        }
    } 

    public List<barang> selectAll(){
        PreparedStatement prepare = null;
        ResultSet result = null;
        List<barang> list = new ArrayList<>();
        try {
            String sql ="SELECT * FROM barang";
            prepare = (PreparedStatement) koneksi.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()){
                barang barang = new barang();
                barang.setKodeBarang(result.getString("kode_barang"));
                barang.setNamaBarang(result.getString("nama_barang"));
                barang.setJumlah(result.getInt("jumlah"));
                barang.setHarga(result.getLong("harga"));
                list.add(barang);
            }
        System.out.println("Prepare statement berhasil dibuat");
        return list;
        }catch(SQLException ex){
            System.out.println("Prepare statement gagal dibuat");
            System.out.println("Pesan : " + ex.getMessage());
            return list;
        }finally{
            if (prepare != null){
                try{
                    prepare.close();
                    System.out.println("Prepare statemen berhasil ditutup");
                }catch(SQLException ex){
                    System.out.println("Prepare statemen gagal ditutup");
                    System.out.println("Pesan : " + ex.getMessage());
                }
            }
            if (result != null){
                try{
                    result.close();
                    System.out.println("Resultset berhasil ditutup");
                }catch(SQLException ex){
                    System.out.println("Resultset gagal ditutup");
                    System.out.println("Pesan : " + ex.getMessage());
                }
            }
        }
    }
    
    private String ReportPath="C:/Users/Muhammad Ilham/Documents/NetBeansProjects/AplikasiInputBarang/src/report/";
    public void viewReport(String nm_report){
        String reportSource;
        String reportDest;
        reportSource=ReportPath +"laporan/"+ nm_report +".jrxml";
        reportDest=ReportPath +"hasil/"+ nm_report +".html";
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,koneksi);
            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
            JasperViewer.viewReport(jasperPrint, false);
        }catch(JRException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
