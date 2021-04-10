/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lhqua
 */
public class SlangWord {
    private String slangWord;
    private String Definition;
    
    public SlangWord()
    {
        
    }
    
    public SlangWord(String slangWord,String Definition)
    {
        this.slangWord = slangWord;
        this.Definition = Definition;
    }
    
    public String getSlang()
    {
        return slangWord;
    }
    
    public String getDefinition()
    {
        return Definition;
    }
    
    public void setSlangWord(String slangWord)
    {
        this.slangWord = slangWord;
    }
    
    public void setDefinition(String Definition)
    {
        this.Definition = Definition;
    }
}
