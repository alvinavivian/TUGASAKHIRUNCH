/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXTextField;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alvin
 */
public class NotaController implements Initializable {

    @FXML
    private JFXTextField id_namanot;
    @FXML
    private JFXTextField id_mapelnot;
    @FXML
    private JFXTextField id_bayar;
    @FXML
    private JFXTextField id_carabayar;
    @FXML
    private Button id_keluar;
    @FXML
    private JFXTextField id_date;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tampil();
    }    

    @FXML
    private void keluar(ActionEvent event) throws IOException {
    ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),830,450);
                Stage stage = new Stage();
                stage.setScene (scene);
                stage.setTitle("MenuAwal");
                stage.show();
   
    }
    
    private void tampil(){
        id_namanot.setText(FXMLDocumentController.namauser);
        id_mapelnot.setText(ISIController.mapel);
        id_carabayar.setText(PaketEksController.carabayar);
        id_bayar.setText(ISIController.tampilTotalBayar);
        id_date.setText(PaketEksController.tanggal);
}
}
