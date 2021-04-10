/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.imp;

import Controller.imp.HisSlangWordController;
import Service.AbtractService;
import java.util.List;
import model.HistorySlangWord;

/**
 *
 * @author lhqua
 */
public class HisSlangWordService implements AbtractService<model.HistorySlangWord>{

    private Controller.imp.HisSlangWordController controllerHistory = new HisSlangWordController();
    
    @Override
    public boolean addSlang(HistorySlangWord value) {
        return this.controllerHistory.addSlang(value);
    }

    @Override
    public void update(HistorySlangWord value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistorySlangWord> findAll() {
        return this.controllerHistory.findAll();
    }
    
    
}
