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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author neto_
 */
public class FXMLRegPessoaController implements Initializable {
    
    @FXML
    private PasswordField tlb_senha;

    @FXML
    private TextField tlb_email;

    @FXML
    private ComboBox<?> tlb_data_ano;

    @FXML
    private TextField tlb_cpf;

    @FXML
    private Button btn_enderecos;

    @FXML
    private PasswordField tlb_confirmar_senha;

    @FXML
    private Button btn_consultar;

    @FXML
    private Button btn_cancelar;

    @FXML
    private PasswordField tlb_cep_digito;

    @FXML
    private PasswordField tlb_cep;

    @FXML
    private ComboBox<?> tlb_data_dia;

    @FXML
    private Button btn_salvar;

    @FXML
    private TextField tlb_nome;

    @FXML
    private ComboBox<?> tlb_data_mes;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
