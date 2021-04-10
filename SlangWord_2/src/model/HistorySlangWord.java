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
public class HistorySlangWord {
     private String slangWord;
    private String Definition;
    private String date;
    
    public HistorySlangWord()
    {
        
    }
    
    public HistorySlangWord(String slangWord,String Definition)
    {
        this.slangWord = slangWord;
        this.Definition = Definition;
    }
    
    public HistorySlangWord(String slangWord,String Definition,String date)
    {
        this.slangWord = slangWord;
        this.Definition = Definition;
        this.date = date;
    }
    
    public String getSlangWord()
    {
        return this.slangWord;
    }
    
    public String getDefinition()
    {
        return this.Definition;
    }
    
    public String getDate()
    {
        return this.date;
    }
    
    public void setSlangWord(String slangWord)
    {
        this.slangWord = slangWord;
    }
    
    public void setDefinition(String Definition)
    {
        this.Definition = Definition;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
}
