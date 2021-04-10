/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.imp;

import Controller.Controller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.HistorySlangWord;


/**
 *
 * @author lhqua
 */
public class HisSlangWordController implements Controller<model.HistorySlangWord>{
    private static  String fileHistory = "HistorySlangWord.txt";
    
    @Override
    public boolean addSlang(HistorySlangWord value) {
        List<HistorySlangWord> set = this.findAll();
        FileWriter out = null;
    
        try {
            out = new FileWriter( HisSlangWordController.fileHistory);
            
            if (set.isEmpty()) {
                long millis = System.currentTimeMillis();
                Timestamp time = new Timestamp(millis);
                out.write(value.getSlangWord()+ "`" + value.getDefinition() + "`" + time.toString() + "\n");
            } else {
                long millis = System.currentTimeMillis();
                Timestamp time = new Timestamp(millis);
                value.setDate(time.toString());
                set.add(value);
                for (HistorySlangWord e : set) {
                    out.write(e.getSlangWord()+ "`" + e.getDefinition() + "`" + e.getDate() + "\n");
                }
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Loi");
        } 
        return true;
    }

    @Override
    public void update(HistorySlangWord value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistorySlangWord> findAll() {
        Scanner sc = null;
        List<HistorySlangWord> listHistorySlang = new ArrayList<>();
        try {
            sc = new Scanner(new File(HisSlangWordController.fileHistory));
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                HistorySlangWord slang = this.stringToSlangWord(line);
                listHistorySlang.add(slang);
            }
        } catch (Exception e) {
        }finally {
            if (sc != null) {
                sc.close();
            }
        }
        
        return listHistorySlang;
    }
    
    public model.HistorySlangWord stringToSlangWord(String st)
    {
        String[] list = st.split("`");
        model.HistorySlangWord history = new model.HistorySlangWord(list[0],list[1],list[2]);
        return history;
    }    
    
    @Override
    public void detele(HistorySlangWord value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
