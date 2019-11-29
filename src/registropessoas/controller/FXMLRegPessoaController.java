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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import registropessoas.REGISTROPESSOAS;
import registropessoas.helper.EnderecoDAO;
import registropessoas.helper.PessoaDAO;
import registropessoas.model.EnderecoModel;
import registropessoas.model.PessoaModel;

/**
 * FXML Controller class
 *
 * @author neto_
 */
public class FXMLRegPessoaController implements Initializable {
    
    private PessoaModel pm;
    private EnderecoModel em;
    private boolean chave = false;
    public static FXMLRegPessoaController fXMLRegPessoaController;
    
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
    
    @FXML
    private AnchorPane anchorPane_pessoas;
    
    @FXML
    void action_btn_salvar(ActionEvent event) {
        if (chave)
            salvarEdicao();
        else
            salvarNovo();
        
        FXMLMainController.fXMLMainController.carregaView();
    }
    
    @FXML
    void action_btn_adicionar(ActionEvent event) {
        pm = new PessoaModel();
        
        if (!(tlb_nome.getText().trim().equals("")))
            pm.setNome(tlb_nome.getText());
        
        if (!(tlb_cpf.getText().trim().equals("")))
            pm.setCpf(tlb_cpf.getText());
        
        if (!(tlb_email.getText().trim().equals("")))
            pm.setEmail(tlb_email.getText());
        
        if ((!(tlb_senha.getText().trim().equals("") && tlb_confirmar_senha.getText().trim().equals(""))) &&
            (!(tlb_senha.getText().trim().equals(tlb_confirmar_senha.getText().trim()))))
            pm.setSenha(tlb_confirmar_senha.getText());
        
        if (dp_data.getValue() != null)
            pm.setData(dp_data.getValue().toString().replaceAll("/", "-"));
        
        Parent root;
        try {        
            root = FXMLLoader.load(REGISTROPESSOAS.class.getResource("view/FXMLRegEndereco.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.sizeToScene();
            stage.setTitle("Registro de Pessoas - Inserir Endereco");
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
    void action_btn_enderecos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(REGISTROPESSOAS.class.getResource("view/FXMLEndereco.fxml"));
            Parent root = loader.load();
            
            FXMLEnderecoController controller = loader.getController();
            controller.initTela(pm.getCodigo());
            
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.sizeToScene();
            stage.setTitle("Registro de Pessoas - Endereços");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            //((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public void recebeEndereco(EnderecoModel em) {
        if (chave) {
            EnderecoDAO edao = new EnderecoDAO();
            edao.inserir(em,pm.getCodigo());
        } else {
            this.em = em;
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
        
        if (pm != null) {
            chave = true;
            btn_enderecos.setDisable(false);
        }
    }
    
    private boolean salvarEdicao(){
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
        
        return true;
    }
    
    private boolean salvarNovo() {
        PessoaDAO pdao = new PessoaDAO();
        
        if (!(tlb_nome.getText().trim().equals(""))  ||
            !(tlb_cpf.getText().trim().equals(""))   ||
            !(tlb_email.getText().trim().equals("")) ||
            !(tlb_senha.getText().trim().equals("") && tlb_confirmar_senha.getText().trim().equals(""))){
                if ((tlb_senha.getText().trim().equals(tlb_confirmar_senha.getText().trim()))) {
                    pm.setNome(tlb_nome.getText());
                    pm.setCpf(tlb_cpf.getText());
                    pm.setEmail(tlb_email.getText());
                    pm.setSenha(tlb_confirmar_senha.getText());
                    pm.setData(dp_data.getValue().toString().replaceAll("/", "-"));
                    
                    if (pdao.inserir(pm, em)) {
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
                } else {
                    Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                    dialogoInfo.setTitle("Alerta");
                    dialogoInfo.setHeaderText("Mensagem");
                    dialogoInfo.setContentText("Senhas não correspondem!");
                    dialogoInfo.showAndWait();
                }
        }
        
        return true;
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fXMLRegPessoaController = this;
    }    
    
}
