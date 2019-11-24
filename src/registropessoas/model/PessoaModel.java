/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.model;

import java.util.Date;

/**
 *
 * @author neto_
 */
public class PessoaModel {
    
    private int id;
    private int cpf;
    private String nome;
    private String senha;
    private Date data;
    private String email;
    private int CodEndereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodEndereco() {
        return CodEndereco;
    }

    public void setCodEndereco(int CodEndereco) {
        this.CodEndereco = CodEndereco;
    }
    
}
