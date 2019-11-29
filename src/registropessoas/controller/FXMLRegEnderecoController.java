/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import registropessoas.model.EnderecoModel;

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
    
    @FXML
    private AnchorPane anchorPane_endereco;
    
    @FXML
    void action_btn_salvar(ActionEvent event) {
        salvarNovo();
    }
    
    private boolean salvarNovo() {
        EnderecoModel em = new EnderecoModel();
        
        em.setCep(Integer.parseInt(tlb_cep.getText() + tlb_cep_digito.getText()));
        em.setLogradouro(tlb_logradouro.getText());
        em.setNumero(Integer.parseInt(tlb_numero.getText()));
        em.setBairro(tlb_bairro.getText());
        em.setCidade(tlb_cidade.getText());
        em.setEstado(tlb_estado.getText());
        em.setPais(tlb_pais.getText());
        
        FXMLRegPessoaController.fXMLRegPessoaController.recebeEndereco(em);
        
        return true;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
