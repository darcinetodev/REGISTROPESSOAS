/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import registropessoas.helper.PessoaDAO;
import registropessoas.model.PessoaModel;

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
    private TextField tlb_cpf;

    @FXML
    private Button btn_enderecos;

    @FXML
    private PasswordField tlb_confirmar_senha;

    @FXML
    private Button btn_adicionar;

    @FXML
    private Button btn_cancelar;
    
    @FXML
    private Button btn_salvar;

    @FXML
    private TextField tlb_nome;
    
    @FXML
    private DatePicker dp_data;
    
    private PessoaModel pm;
    
    @FXML
    void action_btn_salvar(ActionEvent event) {
        PessoaDAO pdao = new PessoaDAO();
        
        if (!(tlb_nome.getText().trim().equals("")))
            pm.setNome(tlb_nome.getText());
        
        if (!(tlb_cpf.getText().trim().equals("")))
            pm.setCpf(tlb_cpf.getText());
        
        if (!(tlb_email.getText().trim().equals("")))
            pm.setEmail(tlb_email.getText());
        
        if ((!(tlb_senha.getText().trim().equals("") && tlb_confirmar_senha.getText().trim().equals(""))) &&
              (tlb_senha.getText().trim().equals(tlb_confirmar_senha.getText().trim())))
            pm.setSenha(tlb_confirmar_senha.getText());
        
        pm.setData(dp_data.getValue().toString().replaceAll("/", "-"));
        
        if (pdao.editar(pm)) {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Alerta");
            dialogoInfo.setHeaderText("Mensagem");
            dialogoInfo.setContentText("Salvo com sucesso!");
            dialogoInfo.showAndWait();
        } else {
            Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
            dialogoInfo.setTitle("Alerta");
            dialogoInfo.setHeaderText("Mensagem");
            dialogoInfo.setContentText("Erro ao salvar!");
            dialogoInfo.showAndWait();
        }
    }

    public void iniTela(int codigo){
        PessoaDAO pdao = new PessoaDAO();
        pdao.lerCodigo(codigo);
        
        for (Iterator it = pdao.lerCodigo(codigo).iterator(); it.hasNext();) {
            pm = (PessoaModel) it.next();
            tlb_nome.setText(pm.getNome());
            tlb_cpf.setText(pm.getCpf());
            tlb_email.setText(pm.getEmail());
            dp_data.setValue(LocalDate.parse(pm.getData(), DateTimeFormatter.ISO_LOCAL_DATE));
        }
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
