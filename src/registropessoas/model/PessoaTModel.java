/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author neto_
 */
public class PessoaTModel {
    
    private final SimpleIntegerProperty codigo;
    private final SimpleDoubleProperty cpf;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty data;
    private final SimpleStringProperty email;
    private final SimpleIntegerProperty codEndereco;
    
    public PessoaTModel(int codigo, double cpf, String nome, Date data, String email, int codEndereco) {
        this.codigo = new SimpleIntegerProperty(codigo);
        this.cpf = new SimpleDoubleProperty(cpf);
        this.nome = new SimpleStringProperty(nome);
        this.data = new SimpleStringProperty(dataParaString(data));
        this.email = new SimpleStringProperty(email);
        this.codEndereco = new SimpleIntegerProperty(codEndereco);
    }
    
    private String dataParaString(Date data){
        data = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        return dateFormat.format(data);  
    }

    public SimpleIntegerProperty CodigoProperty() {
        return codigo;
    }

    public SimpleDoubleProperty CpfProperty() {
        return cpf;
    }

    public SimpleStringProperty NomeProperty() {
        return nome;
    }

    public SimpleStringProperty DataProperty() {
        return data;
    }

    public SimpleStringProperty EmailProperty() {
        return email;
    }

    public SimpleIntegerProperty CodEnderecoProperty() {
        return codEndereco;
    }
    
    public int getCodigo() {
        return codigo.get();
    }

    public Double getCpf() {
        return cpf.get();
    }

    public String getNome() {
        return nome.get();
    }

    public String getData() {
        return data.get();
    }

    public String getEmail() {
        return email.get();
    }

    public int getCodEndereco() {
        return codEndereco.get();
    }
    
}
