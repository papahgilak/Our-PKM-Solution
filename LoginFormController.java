/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.User;
import model.ListUser;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class LoginFormController implements Initializable {

    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField tf_password;
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_register;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label label1;
    
    private String username, password,type;
    User tmpUser;
    ListUser larikUser = new ListUser();
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            // TODO
            larikUser.openXMLtoList(larikUser);
        } catch (Exception ex) {
            Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void LoginButtonAction(ActionEvent event) throws Exception{
        username = tf_username.getText();
        password = tf_password.getText();
        int posisi = larikUser.cariElemen(username, password, larikUser);
        if (posisi < larikUser.user.size()){
            if(larikUser.user.get(posisi).getType().equals("Mahasiswa")){
                AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                rootPane.getChildren().setAll(pane);
            }else if(larikUser.user.get(posisi).getType().equals("Dosen")){
                label1.setText("Anda Seorang Dosen");
            }else if(larikUser.user.get(posisi).getType().equals("Kemahasiswaan")){
                label1.setText("Anda Seorang Kemahasiswaan");
            }
        } else {
            label1.setText("Maaf, Username dan atau Password Salah");
        }
    }

    @FXML
    private void RegisterButtonAction(ActionEvent event) throws Exception {
        username = tf_username.getText();
        password = tf_password.getText();
        type = "Mahasiswa";//hanya template, nanti diganti
        int posisi = larikUser.cariElemen1(username, larikUser);
        if (posisi < larikUser.user.size()){
            label1.setText("Username sudah terdaftar");
        } else {
            tmpUser = new User(username, password, type);
            larikUser.nambahElemen(larikUser, tmpUser);
            larikUser.saveDataToXML(larikUser);
        }
    }
}
