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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author neto_
 */
public class FXMLEnderecoController implements Initializable {
    
    @FXML
    private TableColumn<?, ?> clm_logradouro_tbv_enderecos;

    @FXML
    private TableColumn<?, ?> clm_pais_tbv_enderecos;

    @FXML
    private TableColumn<?, ?> clm_cep_tbv_enderecos;

    @FXML
    private TableView<?> tbv_enderecos;

    @FXML
    private TableColumn<?, ?> clm_estado_tbv_enderecos;

    @FXML
    private TableColumn<?, ?> clm_codigo_tbv_enderecos;

    @FXML
    private TableColumn<?, ?> clm_numero_tbv_enderecos;

    @FXML
    private TableColumn<?, ?> clm_bairro_tbv_enderecos;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
