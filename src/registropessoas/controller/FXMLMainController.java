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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author neto_
 */
public class FXMLMainController implements Initializable {
    
    @FXML
    private Button btn_verMais;

    @FXML
    private TableColumn<?, ?> clm_codigo_tbv_pessoas;

    @FXML
    private TableView<?> tbv_pessoas;

    @FXML
    private Button btn_editar;

    @FXML
    private TextField tlb_data_final;

    @FXML
    private TableColumn<?, ?> clm_nome_tbv_pessoas;

    @FXML
    private Button btn_pesquisar;

    @FXML
    private Button btn_deletar;

    @FXML
    private TextField tlb_data_inicial;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
