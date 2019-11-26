/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author neto_
 */
public class ConnectionFactory {
    
    private final String BANCO = "bd_registra_pessoas";
    private final String USUARIO = "root";
    private final String SENHA = "002531";
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/" + BANCO + "?useTimezone=true&serverTimezone=UTC", USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
