/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropessoas.helper;

import java.util.List;

/**
 *
 * @author neto_
 */
public interface DAO {
    
    public List todasPessoas(int id);
    public Object idPessoa(int id);
    public boolean inserir(Object o);
    public boolean editar(Object o);
    public boolean deletar(int id);
    
}
