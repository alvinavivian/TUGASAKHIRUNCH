/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author alvin
 */
public class PaketEksController implements Initializable {

    @FXML
    private Button id_bayar;
    @FXML
    private RadioButton id_cash;
    @FXML
    private ToggleGroup pembayaran;
    @FXML
    private RadioButton id_card;
    @FXML
    private TextField id_pin;
    @FXML
    private DatePicker id_date;
    @FXML
    private JFXButton id_back;
    
    public static String tanggal,carabayar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    void  tanggal(){
            if(id_date.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Harap pilih Tanggal Kembali");
        }
    }
    
    @FXML
    private void bayar(ActionEvent event) throws IOException { 
     tanggal();
     tanggal = id_date.getValue().toString();
     if(id_cash.isSelected()){
        ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("nota.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),830,450);
                Stage stage = new Stage();
                stage.setScene (scene);
                stage.setTitle("MenuAwal");
                stage.show();
    }  
     else if(id_pin.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Harap Masukkan PIN");
     }
     
    }

    @FXML
    private void cash(ActionEvent event) {
    if(id_cash.isSelected()){
        id_pin.setDisable(true);
        carabayar="CASH";
    }
    }

    @FXML
    private void card(ActionEvent event) {
    if(id_card.isSelected()){
        id_pin.setDisable(false);
    }
        carabayar ="CARD";
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
    ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ISI.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),830,450);
                Stage stage = new Stage();
                stage.setScene (scene);
                stage.setTitle("MenuAwal");
                stage.show();
    }
    
}
