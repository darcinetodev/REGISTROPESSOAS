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
 * @param <T>
 */
public interface DAO<T> {
    
    public List lerTudo();
    public boolean editar(T o);
    public boolean deletar(int id);
    
}
