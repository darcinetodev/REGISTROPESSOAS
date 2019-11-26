/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import registropessoas.helper.PessoaDAO;
import registropessoas.model.PessoaTModel;

/**
 *
 * @author neto_
 */
public class FXMLMainController implements Initializable {
    
    @FXML
    private Button btn_verMais;

    @FXML
    private TableColumn<PessoaTModel, Integer> clm_codigo_tbv_pessoas;

    @FXML
    private TableView<PessoaTModel> tbv_pessoas;

    @FXML
    private Button btn_editar;

    @FXML
    private TextField tlb_data_final;

    @FXML
    private TableColumn<PessoaTModel, String> clm_nome_tbv_pessoas;

    @FXML
    private Button btn_pesquisar;

    @FXML
    private Button btn_deletar;

    @FXML
    private TextField tlb_data_inicial;
    
     @FXML
    void action_btn_editar(ActionEvent event) {
        Parent root;
        try {        
            root = FXMLLoader.load(getClass().getClassLoader().getResource("/FXMLRegPessoa.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void action_btn_deletar(ActionEvent event) {

    }

    @FXML
    void action_btn_verMais(ActionEvent event) {

    }
    
    @FXML
    void action_btn_pesquisar(ActionEvent event) {
        PessoaDAO pdao = new PessoaDAO();
        
        if(!(tlb_data_inicial.getText().equals("") && tlb_data_final.getText().equals("")))
            tbv_pessoas.setItems(listaDeClientes(pdao.lerData(tlb_data_inicial.getText(), tlb_data_final.getText())));
        else
            tbv_pessoas.setItems(listaDeClientes(pdao.lerTudo()));
    }
    
    private ObservableList<PessoaTModel> listaDeClientes(List<PessoaTModel> list) {
        return FXCollections.observableArrayList(list);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clm_codigo_tbv_pessoas.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        clm_nome_tbv_pessoas.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        PessoaDAO pdao = new PessoaDAO();
        tbv_pessoas.setItems(listaDeClientes(pdao.lerTudo()));
    }    
    
}
