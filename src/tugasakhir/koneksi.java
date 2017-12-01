/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

class koneksi {

   public koneksi() {
    }
public static Connection con;
public static Statement stm;
    public Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost/toko";
            String id_nama="root";
            String id_password="root";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, id_nama, id_password);
            stm=con.createStatement();
            System.out.println("berhasil");
        } catch (Exception e) {
            System.out.println("coba lagi ");
        }
        return con; 
    }
}
