/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author neto_
 */
public class EnderecoTModel {
    
    private final SimpleIntegerProperty codigo;
    private final SimpleIntegerProperty cep;
    private final SimpleStringProperty logradouro;
    private final SimpleIntegerProperty numero;
    private final SimpleStringProperty bairro;
    private final SimpleStringProperty cidade;
    private final SimpleStringProperty estado;
    private final SimpleStringProperty pais;
    
    public EnderecoTModel(int codigo, int cep, String logradouro, int numero, String bairro, String cidade, String estado, String pais) {
        this.codigo = new SimpleIntegerProperty(codigo);
        this.cep = new SimpleIntegerProperty(cep);
        this.logradouro = new SimpleStringProperty(logradouro);
        this.numero = new SimpleIntegerProperty(numero);
        this.bairro = new SimpleStringProperty(bairro);
        this.cidade = new SimpleStringProperty(cidade);
        this.estado = new SimpleStringProperty(estado);
        this.pais = new SimpleStringProperty(pais);
    }

    public SimpleIntegerProperty codigoProperty() {
        return codigo;
    }

    public SimpleIntegerProperty cepProperty() {
        return cep;
    }

    public SimpleStringProperty logradouroProperty() {
        return logradouro;
    }

    public SimpleIntegerProperty numeroProperty() {
        return numero;
    }

    public SimpleStringProperty bairroProperty() {
        return bairro;
    }

    public SimpleStringProperty cidadeProperty() {
        return cidade;
    }

    public SimpleStringProperty estadoProperty() {
        return estado;
    }

    public SimpleStringProperty paisProperty() {
        return pais;
    }
    
    public int getCodigo() {
        return codigo.get();
    }

    public int getCep() {
        return cep.get();
    }
    
    public String getLogradouro() {
        return logradouro.get();
    }
    
    public int getNumero() {
        return numero.get();
    }
    
    public String getBairro() {
        return bairro.get();
    }
    
    public String getCidade() {
        return cidade.get();
    }
    
    public String getEstado() {
        return estado.get();
    }
    
    public String getPais() {
        return pais.get();
    }
    
}
