/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author alvin
 */
public class FXMLDocumentController implements Initializable {
    NotaController nota;

    @FXML
    public TextField id_username;
    @FXML
    private Button id_ok;
    @FXML
    private PasswordField id_pass;
    @FXML
    private TextField id_usernamedaftar;
    @FXML
    private TextField id_namadaftar;
    @FXML
    private TextField id_passdaftar;
    @FXML
    private Button id_daftar;

   public static String namauser;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    @FXML
    
    private void OK(ActionEvent event) throws IOException {
   Connection con = new koneksi().getConnection(); 
            Connection connection;
       
        namauser=id_username.getText();
        try { 
            PreparedStatement ps;
            connection = DriverManager.getConnection("jdbc:mysql://localhost/toko?zeroDate TimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, id_username.getText());
            ps.setString(2, id_pass.getText());
            ResultSet result = ps.executeQuery();
             if (result.next()) {
                ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ISI.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),830,450);
                Stage stage = new Stage();
                stage.setScene (scene);
                stage.setTitle("MenuAwal");
                stage.show();
                
                namauser=id_username.getText();
                    NotaController nota = new NotaController();
            nota = fxmlLoader.getController();
          
            } else {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                id_pass.setText("");
                id_username.requestFocus();
                
            }
        } catch (SQLException ex) {
        Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Gagal!");
        }
    }

    @FXML
    private void daftar(ActionEvent event) {
        String nama =id_namadaftar.getText();
        String user = id_usernamedaftar.getText();
        String p = id_passdaftar.getText();
        
        try{
            try(Statement statement = (Statement) login_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO tb_akun VALUES ('"+user+"', '"+p+"')");
            } 
            JOptionPane.showMessageDialog(null, "Sign Up Berhasil");
            id_namadaftar.setText("");
            id_usernamedaftar.setText("");
            id_passdaftar.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "GAGAL! Silahkan Ulangi");
        }
    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
