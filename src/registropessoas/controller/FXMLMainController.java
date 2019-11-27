/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import registropessoas.REGISTROPESSOAS;
import registropessoas.helper.PessoaDAO;
import registropessoas.model.PessoaTModel;

/**
 *
 * @author neto_
 */
public class FXMLMainController implements Initializable {
    
    @FXML
    private Button btn_inserir;

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
        PessoaTModel selectedPerson = tbv_pessoas.getSelectionModel().getSelectedItem();
        
        try {
            FXMLLoader loader = new FXMLLoader(REGISTROPESSOAS.class.getResource("view/FXMLRegPessoa.fxml"));
            Parent root = loader.load();
            
            FXMLRegPessoaController controller = loader.getController();
            controller.iniTela(selectedPerson.getCodigo());
            
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.sizeToScene();
            stage.setTitle("Registro de Pessoas - Editar Pessoa");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            //((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    @FXML
    void action_btn_deletar(ActionEvent event) {
        PessoaDAO pdao = new PessoaDAO();
        PessoaTModel selectedPerson = tbv_pessoas.getSelectionModel().getSelectedItem();
        pdao.deletar(selectedPerson.getCodigo());
        carregaView();
    }

    @FXML
    void action_btn_inserir(ActionEvent event) {
        Parent root;
        try {        
            root = FXMLLoader.load(REGISTROPESSOAS.class.getResource("view/FXMLRegPessoa.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.sizeToScene();
            stage.setTitle("Registro de Pessoas - Inserir Pessoa");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            //((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
    
    @FXML
    void action_btn_pesquisar(ActionEvent event) {
        PessoaDAO pdao = new PessoaDAO();
        
        if(!(tlb_data_inicial.getText().equals("") && tlb_data_final.getText().equals("")))
            tbv_pessoas.setItems(listaDeClientes(pdao.lerData(tlb_data_inicial.getText(), tlb_data_final.getText())));
        else
            tbv_pessoas.setItems(listaDeClientes(pdao.lerTudo()));
    }
    
    
    @FXML
    void keyPress_tbv_pessoas(ActionEvent event) {
        btn_editar.setDisable(false);
    }
    
    private ObservableList<PessoaTModel> listaDeClientes(List<PessoaTModel> list) {
        return FXCollections.observableArrayList(list);
    }
    
    private void carregaView(){
        PessoaDAO pdao = new PessoaDAO();
        tbv_pessoas.getColumns().removeAll();
        tbv_pessoas.setItems(listaDeClientes(pdao.lerTudo()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clm_codigo_tbv_pessoas.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        clm_nome_tbv_pessoas.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        carregaView();
    }    
    
}
