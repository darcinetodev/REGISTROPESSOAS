/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import registropessoas.REGISTROPESSOAS;
import registropessoas.helper.PessoaDAO;
import registropessoas.model.PessoaModel;

/**
 * FXML Controller class
 *
 * @author neto_
 */
public class FXMLLoginController implements Initializable {
    
    @FXML
    private PasswordField tlb_senha;

    @FXML
    private Button btn_entrar;

    @FXML
    private TextField tlb_usuario;
    
    @FXML
    void action_btn_entrar(ActionEvent event) {
        PessoaDAO pdao = new PessoaDAO();
        PessoaModel pm;
        boolean entrou = false;
        
        for (Iterator it = pdao.lerLogin(tlb_usuario.getText(), tlb_senha.getText()).iterator(); it.hasNext();) {
            pm = (PessoaModel) it.next();
            
            if (!(pm.getCpf().trim().equals("")))
                entrou = true;
        }
        
        if (entrou) {
            try {
                FXMLLoader loader = new FXMLLoader(REGISTROPESSOAS.class.getResource("view/FXMLMain.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setResizable(false);
                stage.sizeToScene();
                stage.setTitle("Registro de Pessoas");
                stage.setScene(new Scene(root));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
