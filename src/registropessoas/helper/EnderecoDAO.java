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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import registropessoas.connection.ConnectionFactory;
import registropessoas.model.EnderecoModel;
import registropessoas.model.EnderecoTModel;

/**
 *
 * @author neto_
 */
public class EnderecoDAO implements DAO {

    @Override
    public List lerTudo() {
        return null;
    }
    
    public List lerCodigo(int codigo){
        Connection conn = new ConnectionFactory().getConnection();
        
        List<EnderecoTModel> listPessoas = new ArrayList();
        
        try {
            try (CallableStatement cstmt = conn.prepareCall("{call P_OBTEM_ENDERECOS(?,null)}")) {
                cstmt.setInt(1, codigo);
                
                ResultSet rs = cstmt.executeQuery();          
                
		while(rs.next()){
                    listPessoas.add(new EnderecoTModel(rs.getInt("END_CODIGO"),
                                                       rs.getInt("END_CEP"),
                                                       rs.getString("END_LOGRADOURO"),
                                                       rs.getInt("END_NUMERO"),
                                                       rs.getString("END_BAIRRO"),
                                                       rs.getString("END_CIDADE"),
                                                       rs.getString("END_ESTADO"),
                                                       rs.getString("END_PAIS")));
		}
                
                cstmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPessoas;
    }

    public Object idPessoa(int id) {
        return null;
    }

    public boolean inserir(EnderecoModel e, int codPessoa) {
        Connection conn = new ConnectionFactory().getConnection();
        
        try (CallableStatement cstmt = conn.prepareCall("{call P_MANUT_ENDERECO('I',null,?,?,?,?,?,?,?,?)}")){
            cstmt.setInt(1, codPessoa);
            cstmt.setInt(2, e.getCep());
            cstmt.setString(3, e.getLogradouro());
            cstmt.setInt(4, e.getNumero());
            cstmt.setString(5, e.getBairro());
            cstmt.setString(6, e.getCidade());
            cstmt.setString(7, e.getEstado());
            cstmt.setString(8, e.getPais());
            
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
    public boolean editar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        Connection conn = new ConnectionFactory().getConnection();
        
        try (CallableStatement cstmt = conn.prepareCall("{call P_MANUT_ENDERECO('R',?,null,null,null,null,null,null,null,null)}")){
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
