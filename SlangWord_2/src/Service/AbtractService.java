/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;

/**
 *
 * @author lhqua
 */
public interface AbtractService<E>{
    public boolean addSlang(E value);
    public void update(E value);
    public List<E> findAll();
}
