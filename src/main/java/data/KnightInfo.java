package data;
import database.Insert;
import knight.Knight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnightInfo {
    private List<Knight> arrayList = new ArrayList<>();
    public void cutMoney(int i,double money){
        double cut=arrayList.get(i).getAmountOfMoney();
        cut=cut-money;
        this.arrayList.get(i).setAmountOfMoney(cut);
//        Update update=new Update();
//        update.cutKnightMoney(i,cut);
    }
    public void printList(){
        for(int i=0;i<this.arrayList.size();i++)
            System.out.println(this.arrayList.get(i).toString(i));
    }
    public int chooseKnight(Scanner scan){
        System.out.println("Choose the knight you want to equip from list below:\n(if you want to add new knight enter 100)");
        printList();
        System.out.print("Your choice - ");
        int choice= scan.nextInt();
        if(choice>=this.arrayList.size()){
            addKnight();
        }
        System.out.println("You chose "+getknight(choice).toString(choice));
        return choice;
    }
    public void addMoney(int i,double money){
        double am=money+this.arrayList.get(i).getAmountOfMoney();
        this.arrayList.get(i).setAmountOfMoney(am);
//        Update update=new Update();
//        update.cutKnightMoney(i,am);
    }
    public int getsize(){
        return this.arrayList.size();
    }
    public void insertKnight(Knight knight){
        this.arrayList.add(arrayList.size(),knight);
    }//занесення лицарів з бд
    public void addKnight(){
        this.arrayList.add(arrayList.size(),new Knight());
    }//запис нового лицаря
    public void  addKnightInterface(String name,int age,int century,String nationality,double amountofmoney){
        this.arrayList.add(this.arrayList.size(),new Knight(name, age, century, nationality, amountofmoney));
        Insert insert=new Insert();
        insert.insertKnight(name, age, century, nationality, amountofmoney);
    }
    public Knight getknight(int i){
        return this.arrayList.get(i);
    }
    public void setArrayList(ArrayList<Knight> arrayList) {
        this.arrayList = arrayList;
    }

}
