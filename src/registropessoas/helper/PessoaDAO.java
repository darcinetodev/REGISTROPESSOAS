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
import registropessoas.model.PessoaTModel;

/**
 *
 * @author neto_
 */
public class PessoaDAO implements DAO {

    @Override
    public List lerTudo() {
        Connection conn = new ConnectionFactory().getConnection();
        
        List<PessoaTModel> listPessoas = new ArrayList();
        
        try {
            try (CallableStatement cstmt = conn.prepareCall("{call P_OBTEM_PESSOAS(null,null,null)}")) {
                ResultSet rs = cstmt.executeQuery();          
                
		while(rs.next()){
                    listPessoas.add(new PessoaTModel(rs.getInt("PES_CODIGO"),
                                                     rs.getDouble("PES_CPF"),
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

    public List lerData(String dataIni, String dataFim) {
        Connection conn = new ConnectionFactory().getConnection();
        
        List<PessoaTModel> listPessoas = new ArrayList();
        
        try {
            try (CallableStatement cstmt = conn.prepareCall("{call P_OBTEM_PESSOAS(null,?,?)}")) {
                cstmt.setString(1, dataIni);
                cstmt.setString(2, dataFim);
                
                ResultSet rs = cstmt.executeQuery();
                
		while(rs.next()){
                    listPessoas.add(new PessoaTModel(rs.getInt("PES_CODIGO"),
                                                     rs.getDouble("PES_CPF"),
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

    @Override
    public boolean inserir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
