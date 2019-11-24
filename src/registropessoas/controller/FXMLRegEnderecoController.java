/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author neto_
 */
public class FXMLRegEnderecoController implements Initializable {

   @FXML
    private Button btn_cancelar;

    @FXML
    private TextField tlb_logradouro;

    @FXML
    private TextField tlb_numero;

    @FXML
    private TextField tlb_pais;

    @FXML
    private TextField tlb_cep_digito;

    @FXML
    private TextField tlb_cep;

    @FXML
    private TextField tlb_bairro;

    @FXML
    private TextField tlb_cidade;

    @FXML
    private TextField tlb_estado;

    @FXML
    private TextField tlb_codigo;

    @FXML
    private Button btn_salvar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
