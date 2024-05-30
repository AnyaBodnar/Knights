package commands;

import data.EquipList;
import data.KnightInfo;
import data.WeaponList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuildReport implements Commands {
//    private List<ResultOfCommand<String>> result;
//    private List<java.util.Date> dates;
    private KnightInfo knight;
    private List<EquipList> equipLists;
    private List<WeaponList> weaponLists;
    @Override
    public ResultOfCommand<String> execute() throws IOException {
        if(knight.getsize()==0){
            System.out.println("You have no knights");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","There is no knights",true);
            return result;
        }
        for(int i=0;i<knight.getsize();i++) {
            System.out.println(knight.getknight(i).toString(i));
            if (i<equipLists.size() && equipLists.get(i).getsize() != 0 ) {
                System.out.println("Your knight equipment:");
                equipLists.get(i).printList();
            }
            if (i<weaponLists.size() && weaponLists.get(i).getsize() != 0) {
                System.out.println("Your knight weapon :");
                weaponLists.get(i).printList();
            }
        }
        System.out.println("Building report works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Build report works",true);
        return result;
    }
    public BuildReport(KnightInfo knight, List<EquipList> equipLists, List<WeaponList> weaponLists){
        this.knight=knight;
        this.equipLists=equipLists;
        this.weaponLists=weaponLists;
    }
}

