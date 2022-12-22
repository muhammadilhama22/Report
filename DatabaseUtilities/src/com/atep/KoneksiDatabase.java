/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atep;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Ilham
 */
public class KoneksiDatabase {
    private static Connection koneksi;
    public static Connection getKoneksi(){
        if (koneksi == null){
            try{
                Driver driver = new Driver();
                DriverManager.registerDriver(driver);
                String url="jdbc:mysql://localhost:3306/db_oop";
                String user="root";
                String pass ="";
                koneksi = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi berhasil");
            }catch(SQLException ex){
                System.out.println("Koneksi gagal");
                System.out.println("Pesan : "+ ex.getMessage());
            }
        }
        return koneksi;
    }
    
    
    
}
