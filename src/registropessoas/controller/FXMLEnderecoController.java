/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import registropessoas.helper.EnderecoDAO;
import registropessoas.model.EnderecoTModel;

/**
 * FXML Controller class
 *
 * @author neto_
 */
public class FXMLEnderecoController implements Initializable {
    
    @FXML
    private Button btn_remover;
    
    @FXML
    private TableColumn<EnderecoTModel, String> clm_logradouro_tbv_enderecos;

    @FXML
    private TableColumn<EnderecoTModel, String> clm_pais_tbv_enderecos;

    @FXML
    private TableColumn<EnderecoTModel, Integer> clm_cep_tbv_enderecos;

    @FXML
    private TableView<EnderecoTModel> tbv_enderecos;

    @FXML
    private TableColumn<EnderecoTModel, String> clm_estado_tbv_enderecos;

    @FXML
    private TableColumn<EnderecoTModel, Integer> clm_codigo_tbv_enderecos;

    @FXML
    private TableColumn<EnderecoTModel, Integer> clm_numero_tbv_enderecos;

    @FXML
    private TableColumn<EnderecoTModel, String> clm_bairro_tbv_enderecos;
    
    private ObservableList<EnderecoTModel> listaDeClientes(List<EnderecoTModel> list) {
        return FXCollections.observableArrayList(list);
    }
    
    public void initTela(int codigo){
        clm_logradouro_tbv_enderecos.setCellValueFactory(new PropertyValueFactory<>("logradouro"));
        clm_pais_tbv_enderecos.setCellValueFactory(new PropertyValueFactory<>("pais"));
        clm_cep_tbv_enderecos.setCellValueFactory(new PropertyValueFactory<>("cep"));
        clm_estado_tbv_enderecos.setCellValueFactory(new PropertyValueFactory<>("estado"));
        clm_codigo_tbv_enderecos.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        clm_numero_tbv_enderecos.setCellValueFactory(new PropertyValueFactory<>("numero"));
        clm_bairro_tbv_enderecos.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        
        EnderecoDAO edao = new EnderecoDAO();
        tbv_enderecos.getColumns().removeAll();
        tbv_enderecos.setItems(listaDeClientes(edao.lerCodigo(codigo)));
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
