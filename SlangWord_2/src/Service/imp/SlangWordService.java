/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.imp;

import Controller.imp.SlangWordController;
import Service.AbtractService;
import java.util.List;
import model.SlangWord;

/**
 *
 * @author lhqua
 */
public class SlangWordService implements AbtractService<model.SlangWord>{

    private Controller.imp.SlangWordController controller = new SlangWordController();
            
    @Override
    public boolean addSlang(SlangWord value) {
          return controller.addSlang(value);
          
    }

    @Override
    public void update(SlangWord value) {
           controller.update(value);
            
    }

    @Override
    public List<SlangWord> findAll() {
        return controller.findAll();
    }
    
    public List<SlangWord> findBySlangWord(String st)
    {
        return controller.findBySlangWord(st);
    }
    
    public List<model.SlangWord> findByDefinition(String definition)
    {
        return controller.findByDefinition(definition);
    }
    
    public void delete(SlangWord value)
    {
        controller.detele(value);
        
    }
    
    public void resetSlangWord()
    {
        controller.resetSlangWord();
    }
    
    public SlangWord random()
    {
        return controller.random();
    }
    
    public List<model.SlangWord> randomListSlangWord()
    {
        return controller.randomListSlangWord();
    }
}
