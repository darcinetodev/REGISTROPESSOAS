/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.helper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import registropessoas.connection.ConnectionFactory;
import registropessoas.model.EnderecoModel;
import registropessoas.model.PessoaModel;
import registropessoas.model.PessoaTModel;

/**
 *
 * @author neto_
 */
public class PessoaDAO implements DAO<PessoaModel> {

    @Override
    public List lerTudo() {
        Connection conn = new ConnectionFactory().getConnection();
        
        List<PessoaTModel> listPessoas = new ArrayList();
        
        try {
            try (CallableStatement cstmt = conn.prepareCall("{call P_OBTEM_PESSOAS(null,null,null)}")) {
                ResultSet rs = cstmt.executeQuery();          
                
		while(rs.next()){
                    listPessoas.add(new PessoaTModel(rs.getInt("PES_CODIGO"),
                                                     rs.getString("PES_CPF"),
                                                     rs.getString("PES_NOME"),
                                                     rs.getDate("PES_DATA_NASCIMENTO"),
                                                     rs.getString("PES_EMAIL"),
                                                     rs.getInt("BRP_PES_END_CODIGO")));
		}
                
                cstmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPessoas;
    }
    
    public List lerCodigo(int codigo) {
        Connection conn = new ConnectionFactory().getConnection();
        
        List<PessoaModel> listPessoas = new ArrayList<>();
        
        try (CallableStatement cstmt = conn.prepareCall("{call P_OBTEM_PESSOAS(?,null,null)}")) {
            cstmt.setInt(1, codigo);
                
            ResultSet rs = cstmt.executeQuery();
                
            while(rs.next()){
                PessoaModel pm = new PessoaModel();
                
                pm.setCodigo(rs.getInt("PES_CODIGO"));
                pm.setCpf(rs.getString("PES_CPF"));
                pm.setNome(rs.getString("PES_NOME"));
                
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                pm.setData(formatter.format(new Date(rs.getDate("PES_DATA_NASCIMENTO").getTime() + (24*60*60*1000))));
                
                pm.setEmail(rs.getString("PES_EMAIL"));
                pm.setCodEndereco(rs.getInt("BRP_PES_END_CODIGO"));
                
                listPessoas.add(pm);
            }
                
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPessoas;
    }
    
    public List lerLogin(String usuario, String senha) {
        Connection conn = new ConnectionFactory().getConnection();
        
        List<PessoaModel> listPessoas = new ArrayList<>();
        
        try (CallableStatement cstmt = conn.prepareCall("{call P_LOGIN_PESSOA(?,?)}")) {
            cstmt.setString(1, usuario);
            cstmt.setString(2, senha);
                
            ResultSet rs = cstmt.executeQuery();
                
            while(rs.next()){
                PessoaModel pm = new PessoaModel();
                
                pm.setCodigo(rs.getInt("PES_CODIGO"));
                pm.setCpf(rs.getString("PES_CPF"));
                pm.setNome(rs.getString("PES_NOME"));
                
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                pm.setData(formatter.format(new Date(rs.getDate("PES_DATA_NASCIMENTO").getTime() + (24*60*60*1000))));
                
                pm.setEmail(rs.getString("PES_EMAIL"));
                pm.setCodEndereco(rs.getInt("BRP_PES_END_CODIGO"));
                
                listPessoas.add(pm);
            }
                
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPessoas;
    }

    public List lerData(String dataIni, String dataFim) {
        Connection conn = new ConnectionFactory().getConnection();
        
        List<PessoaTModel> listPessoas = new ArrayList();
        
        try (CallableStatement cstmt = conn.prepareCall("{call P_OBTEM_PESSOAS(null,?,?)}")) {
            cstmt.setString(1, dataIni);
            cstmt.setString(2, dataFim);
                
            ResultSet rs = cstmt.executeQuery();
                
            while(rs.next()){
                listPessoas.add(new PessoaTModel(rs.getInt("PES_CODIGO"),
                                                 rs.getString("PES_CPF"),
                                                 rs.getString("PES_NOME"),
                                                 rs.getDate("PES_DATA_NASCIMENTO"),
                                                 rs.getString("PES_EMAIL"),
                                                 rs.getInt("BRP_PES_END_CODIGO")));
            }
                
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPessoas;
    }

    public boolean inserir(PessoaModel p, EnderecoModel e) {
        Connection conn = new ConnectionFactory().getConnection();
        
        try (CallableStatement cstmt = conn.prepareCall("{call P_INSERE_PESSOA_ENDERECO(?,?,?,?,?,?,?,?,?,?,?,?)}")){
            cstmt.setString(1, p.getCpf());
            cstmt.setString(2, p.getNome());
            cstmt.setString(3, p.getSenha());
            cstmt.setString(4, p.getData());
            cstmt.setString(5, p.getEmail());
            
            cstmt.setInt(6, e.getCep());
            cstmt.setString(7, e.getLogradouro());
            cstmt.setInt(8, e.getNumero());
            cstmt.setString(9, e.getBairro());
            cstmt.setString(10, e.getCidade());
            cstmt.setString(11, e.getEstado());
            cstmt.setString(12, e.getPais());
            
            cstmt.executeUpdate();
            
            cstmt.close();
            conn.close();
	} catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
	}
        return true;
    }

    @Override
    public boolean editar(PessoaModel p) {
        Connection conn = new ConnectionFactory().getConnection();
        
        try (CallableStatement cstmt = conn.prepareCall("{call P_MANUT_PESSOA('A',?,?,?,?,?,?)}")){
            cstmt.setInt(1, p.getCodigo());
            cstmt.setString(2, p.getCpf());
            cstmt.setString(3, p.getNome());
            cstmt.setString(4, p.getSenha());
            cstmt.setString(5, p.getData());
            cstmt.setString(6, p.getEmail());
            
            cstmt.executeUpdate();
            
            cstmt.close();
            conn.close();
	} catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
	}
        return true;
    }

    @Override
    public boolean deletar(int id) {
        Connection conn = new ConnectionFactory().getConnection();
        
        try (CallableStatement cstmt = conn.prepareCall("{call P_MANUT_PESSOA('R',?,null,null,null,null,null)}")){
            cstmt.setInt(1, id);
            
            cstmt.executeUpdate();
            
            cstmt.close();
            conn.close();
	} catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
	}
        return true;
    }
    
}
