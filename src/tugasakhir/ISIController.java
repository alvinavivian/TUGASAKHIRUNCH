/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author alvin
 */
public class ISIController implements Initializable {

    @FXML
    private RadioButton id_siswa;
    @FXML
    private ToggleGroup kategorisiswa;
    @FXML
    private RadioButton id_mahasiswa;
    @FXML
    private CheckBox id_dkv;
    @FXML
    private CheckBox id_filmatografi;
    @FXML
    private CheckBox id_multimedia;
    @FXML
    private CheckBox id_animasi;
    @FXML
    private CheckBox id_design;
    @FXML
    private Button pilihjurusan;
    @FXML
    private TextArea hasil;
     
    @FXML
    private Button next;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void siswa(ActionEvent event) {
    }

    @FXML
    void mahasiswa(ActionEvent event) {
    }

    @FXML
    void dkv(ActionEvent event) {
    }

    @FXML
    void film(ActionEvent event) {
    }

    @FXML
    void MM(ActionEvent event) {
    }

    @FXML
    void animasi(ActionEvent event) {
    }

    @FXML
    void design(ActionEvent event) {
    }
        
    String ndkv,nfil,nmm,nan,ndes;
    String menu1="";
    String menu2="";
    String kasir="";
    int jdkv,jfil,jmm,jani,jdes;
    public static String atasnama, tampilTotalBayar, ket,mapeldk="",mapelani="",mapeldes="",mapelfil="",mapelmm="",mapel;
    int harga, kembalian;
    int totalbayar, jmlUangBayar,jurusan;
   
    @FXML
    public void pilihjurus(ActionEvent event) {
    
        if (id_siswa.isSelected()) {
            ket = "Kamu adalah siswa";
        } else if (id_mahasiswa.isSelected()) {
            ket = "Kamu adalah Mahasiswa";
        }
        
        
        if(id_dkv.isSelected()){     
        jdkv = 10000;
        System.out.println(jdkv);
        mapeldk ="DKV";
        }
        else if(id_filmatografi.isSelected()){     
        jfil = 15000;
        System.out.println(jfil);
        id_filmatografi.setText("Filmatografi");
        mapelfil ="Filmatografi";
    }
        else if(id_multimedia.isSelected()){     
        jmm = 13000;
        System.out.println(jmm);
        id_multimedia.setText("Multimedia");
        mapelmm ="Multimedia";
        }
        else if(id_animasi.isSelected()){     
        jani = 15000;
        System.out.println(jani);
        id_animasi.setText("animasi");
        mapelani ="Animasi";
        }
        else if(id_design.isSelected()){     
        jdes = 15000;
        System.out.println(jdes);
        id_design.setText("Design");
        mapeldes ="Design";
    }
    else{
    mapel ="";
    
    }
    totalbayar = jdkv+jfil+jmm+jani+jdes;
    mapel=mapeldk+mapelfil+mapelmm+mapelani+mapeldes;
        tampilTotalBayar=String.valueOf(totalbayar);
        hasil.setText("Jadi,"+ket+"\n TOTAL harga = "+tampilTotalBayar+"\n Pilihan jurusan" + mapel);
        
    }
  
     @FXML
    void next(ActionEvent event) throws IOException {
         ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("PaketEks.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),830,450);
                Stage stage = new Stage();
                stage.setScene (scene);
                stage.setTitle("MenuAwal");
                stage.show();
                
                NotaController Data = new NotaController();
            Data = fxmlLoader.getController();
            
           
    }
      

    
}
