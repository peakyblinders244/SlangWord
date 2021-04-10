/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.imp;

import Controller.Controller;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import model.SlangWord;

/**
 *
 * @author lhqua
 */
public class SlangWordController implements Controller<model.SlangWord>{
    private static String fileName = "Slang.txt";

    @Override
    public boolean addSlang(SlangWord value) {
        List<SlangWord> listSlang = this.findAll();
        boolean flag = false;
        int pos = -1;
        
        for(int i = 0; i < listSlang.size(); i++)
        {
            if(value.getSlang().equals(listSlang.get(i).getSlang()))
            {
                flag = true;
                pos = i;
                break;
            }
        }
        
        Scanner sc = new Scanner(System.in);
        int select = 0;
        if(flag == true)
        {     
            System.out.println("Đã bị trùng SlangWord!!\n"
                        + "1.Chọn 1 để ghi đè lên\n"
                        + "2.Chọn 2 để in ra thêm SlangWord mới");
           
            select = sc.nextInt();       
            do 
            {
                if(select == 1)  
                {
                    listSlang.set(pos, value);
                    break;
                }
            
                if(select == 2)
            
                {
                    SlangWord slangNew = new SlangWord(listSlang.get(pos).getSlang(),listSlang.get(pos).getDefinition() + "| " + value.getDefinition());
                    listSlang.set(pos, slangNew);
                    break;
                }
                break;
            }while(true);
        }
        else
        {
            listSlang.add(value);
        }
        FileWriter out = null;
        
        try {
            out = new FileWriter(SlangWordController.fileName);
            for (SlangWord slangWord : listSlang) {
                out.write(slangWord.getSlang() + "`" + slangWord.getDefinition() + "\n" );
            }
            out.close();
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public void update(SlangWord value) {
        List<SlangWord> listSlang = this.findAll();
        
        boolean flag = false;
        for (SlangWord slangWord : listSlang) {
            if(slangWord.getSlang().equals(value.getSlang()))
            {
                slangWord.setDefinition(value.getDefinition());
                flag = true;
            }
        }
        
        if(flag == false)
        {
            System.out.println("Không tìm thấy SlangWord trong danh sách cần edit!!");
            return;
        }
        
        FileWriter out = null;
        
        try {
            out = new FileWriter(SlangWordController.fileName);
            for (SlangWord slangWord : listSlang) {
                out.write(slangWord.getSlang() + "`" + slangWord.getDefinition() + "\n" );
            }
            out.close();
        } catch (Exception e) {
        }
        System.out.println("Đã edit SlangWord xong");
    }

    @Override
    public List<SlangWord> findAll() {
        Scanner sc = null;
        List<SlangWord> listSlang = new ArrayList<>();
        try {
            File f = new File(SlangWordController.fileName);
            sc = new Scanner(f);
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                SlangWord slang = this.stringToSlangWord(line);
                listSlang.add(slang);
            }
            sc.close();
        } catch (Exception e) {
        }finally {
            if (sc != null) {
                sc.close();
            }
        }
        
        return listSlang;
    }
    
    private SlangWord stringToSlangWord(String st)
    {
        String[] list = st.split("`");
        SlangWord slangword = new SlangWord(list[0],list[1]);
        return slangword;
    }

    @Override
    public void detele(SlangWord value) {
        List<SlangWord> listSlang = this.findAll();
        boolean flag = false;
        
        int pos = -1;
        for(int i = 0; i < listSlang.size(); i++)
        {
            if(listSlang.get(i).getSlang().equals(value.getSlang()))
            {
                pos = i;
                listSlang.remove(pos);
                flag = true;
                break;
            }
        }
       
        
        if(flag == false)
        {
            System.out.println("Không tìm thấy SlangWord trong danh sách cần xóa!!");
            return;
        }
        
        FileWriter out = null;
        try {
            out = new FileWriter(SlangWordController.fileName);
            for (SlangWord slangWord : listSlang) {
                out.write(slangWord.getSlang() + "`" + slangWord.getDefinition() + "\n" );
            }
            System.out.println("Đã xóa SlangWord xong");
            out.close();
        } catch (Exception e) {
        }
        
    }
    
    public List<model.SlangWord> findBySlangWord(String slang)
    {
        List<model.SlangWord> list = this.findAll();
        List<model.SlangWord> listFind = new ArrayList<>();
        for (SlangWord slangWord : list) {
            if(slangWord.getSlang().contains(slang))
            {
                listFind.add(slangWord);
            }  
        }
        return listFind;
    }
    
    public List<model.SlangWord> findByDefinition(String definition)
    {
        List<model.SlangWord> list = this.findAll();
        List<model.SlangWord> listFind = new ArrayList<>();
        for (SlangWord slangWord : list) {
            if(slangWord.getDefinition().contains(definition))
            {
                listFind.add(slangWord);
            }  
        }
        return listFind;
    }
    
    public void resetSlangWord()
    {
        Scanner sc = null;
        List<SlangWord> listSlang = new ArrayList<>();
        try {
            File f = new File("SlangWordOriginal.txt");
            
            sc = new Scanner(f);
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                SlangWord slang = this.stringToSlangWord(line);
                listSlang.add(slang);
            }
            sc.close();
        } catch (Exception e) {
        }finally {
            if (sc != null) {
                sc.close();
            }
        }
        
        FileWriter out = null;
        
        try {
            out = new FileWriter(SlangWordController.fileName);
            for (SlangWord slangWord : listSlang) {
                out.write(slangWord.getSlang() + "`" + slangWord.getDefinition() + "\n" );
            }
            out.close();
        } catch (Exception e) {
        }
        System.out.println("Da reset xong!!");
    }
    
    public SlangWord random() {
        List<model.SlangWord> list = this.findAll();
        Random rd = new Random(); 
        int n = rd.nextInt(list.size());
        return list.get(n);
    }
    
    public List<model.SlangWord> randomListSlangWord() {
        List<SlangWord> list = this.findAll();
        List<SlangWord> listRandom = new ArrayList<>();
        List<Integer> listInt = new ArrayList<>();
        Random rd = new Random();
        while (listInt.size() < 4) {
            int n = rd.nextInt(list.size());
            if (!listInt.contains(n)) {
                listInt.add(n);
            }
        }
        for (Integer integer : listInt) {
            listRandom.add(list.get(integer.intValue()));
        }
        listRandom.add(listRandom.get(rd.nextInt(listRandom.size())));
        return listRandom;
    }

    
}
