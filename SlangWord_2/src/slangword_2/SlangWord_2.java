/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slangword_2;

import Service.imp.HisSlangWordService;
import Service.imp.SlangWordService;
import java.util.List;
import java.util.Scanner;
import model.HistorySlangWord;
import model.SlangWord;

/**
 *
 * @author lhqua
 */
public class SlangWord_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        SlangWordService SlangService = new SlangWordService();
        HisSlangWordService HisService = new HisSlangWordService ();
        int select;
        do{
        System.out.println("1.Chức năng tìm kiếm theo slang word");
        System.out.println("2.Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong defintion có chứa keyword gõ vào.");
        System.out.println("3.Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.");
        System.out.println("4.Chức năng add 1 slang words mới. Nếu slang words trùng thì thông báo cho người dùng, confirm có overwrite hay duplicate ra 1 slang word mới");
        System.out.println("5.Chức năng edit 1 slang word");
        System.out.println("6.Chức năng delete 1 slang word. Confirm trước khi xoá");
        System.out.println("7.Chức năng reset danh sách slang words gốc.");
        System.out.println("8.Chức năng random 1 slang word (On this day slang word)");
        System.out.println("9.Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.");
        System.out.println("10.Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn");
        System.out.println("Nhan 0 de thoat!!");
        select=sc.nextInt();
        sc.nextLine();
        switch(select){
            case 1:
            {
                String st;
                System.out.println("Nhập từ khóa cần tìm kiếm");
                st=sc.nextLine();
                
                List<model.SlangWord> listSlang = SlangService.findBySlangWord(st);
                for (model.SlangWord slangWord : listSlang) {
                    System.out.println(slangWord.getSlang() + " : " + slangWord.getDefinition());
                    HistorySlangWord hs = new HistorySlangWord(slangWord.getSlang(), slangWord.getDefinition());
                    HisService.addSlang(hs);
                }
                break;
            }
            case 2:
            {
                String st;
                System.out.println("Nhập từ khóa cần tìm kiếm");
                st=sc.nextLine();
              
                List<model.SlangWord> listSlang = SlangService.findByDefinition(st);
                for (model.SlangWord slangWord : listSlang) {
                    System.out.println(slangWord.getSlang() + " : " + slangWord.getDefinition());
                    HistorySlangWord hs = new HistorySlangWord(slangWord.getSlang(), slangWord.getDefinition());
                    HisService.addSlang(hs);
                }
                break;
            }
            case 3:
            {
                List<HistorySlangWord> listSlangHistory = HisService.findAll();
                for (HistorySlangWord slangWordHistory : listSlangHistory) {
                    System.out.println(slangWordHistory.getSlangWord() + " \t\t " + slangWordHistory.getDefinition() + "\t\t\t\t" + slangWordHistory.getDate());
                }
                break;
            }
            case 4:
            {
                String slang;
                String definition;
                System.out.println("Nhập slang word: ");
                slang = sc.nextLine();
                System.out.println("Nhập ý nghĩa: ");
                definition = sc.nextLine();
                model.SlangWord addSlang = new model.SlangWord(slang,definition);
                
                if(SlangService.addSlang(addSlang))
                {
                    System.out.println("Đã thêm Slang Word mới\n");
                }
                else
                {
                    System.out.println("Lỗi không thêm được\n");
                }
                break;
            }
            case 5:
            {
                String sl;
                String def;
                System.out.println("Nhập từ Slang Word cần thay đổi: ");
                sl = sc.nextLine();
                System.out.println("Nhập ý nghĩa Slang Word cần thay đổi: ");
                def = sc.nextLine();
                SlangService.update(new SlangWord(sl,def));
                break;
            }
            case 6:
            {
                String sl;
                String def;
                String choose;
                System.out.println("Nhập từ Slang Word cần xóa: ");
                sl = sc.nextLine();
                System.out.println("Nhập ý nghĩa Slang Word cần xóa (có thể gần giống nghĩa): ");
                def = sc.nextLine();
                List<model.SlangWord> listSlang = SlangService.findBySlangWord(sl);
                System.out.println("Bạn có chắc muốn xóa những từ dưới không\n"
                        + "1.Chọn 1 để xóa!\n "
                        + "2.Chọn 2 để thoát!\n");
                for (SlangWord slangWord : listSlang) {
                     System.out.println(slangWord.getSlang() + " : " + slangWord.getDefinition());
                }
                choose = sc.nextLine();
                if(choose.equals("1"))
                {
                    SlangService.delete(new SlangWord(sl,def));
                }
                
                break;
            }
            case 7:
            {
                SlangService.resetSlangWord();
                
                break;
            }
            case 8:
            {
                model.SlangWord random = SlangService.random();
                System.out.println("Slang Word đã random la:\n " + random.getSlang() + " : " + random.getDefinition());
                break;
            }
            case 9:
            {
                List<model.SlangWord> dovui = SlangService.randomListSlangWord();
                System.out.println("Từ" + dovui.get(4).getSlang() + "  : có nghĩa là gì: ");
                for (int i = 0; i < 4; i++) {
                    System.out.println(dovui.get(i).getDefinition());
                }
                int qq = sc.nextInt();
                if(dovui.get(qq).getDefinition().equals(dovui.get(4).getDefinition()))
                {
                    System.out.println("dung roi");
                }
                else
                {
                    System.out.println("sai roi");
                }
                break;
            }
          
            case 10:
            {
                List<model.SlangWord> dovui = SlangService.randomListSlangWord();
                System.out.println(dovui.get(4).getDefinition()+ "  : có nghĩa la: ");
                for (int i = 0; i < 4; i++) {
                    System.out.println(dovui.get(i).getSlang());
                }
                int qq = sc.nextInt();
                if(dovui.get(qq).getSlang().equals(dovui.get(4).getSlang()))
                {
                    System.out.println("dung roi");
                }
                else
                {
                    System.out.println("sai roi");
                }
                
                break;
            }
        }
       
        
        }while(select!=0);
    }   
    
    
}
