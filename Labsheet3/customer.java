/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
/**
 *
 * @author Shashvat Kedia
 */
public class customer {
    public String name;
    public long id;
    public String address;
    public long phoneNumber;
    public static long count=0;
    public ArrayList<items> item=new ArrayList<items>();
    
    public customer(String nm,long identification,String add,long no){
        name=nm;
        id=identification;
        address=add;
        phoneNumber=no;
    }
    
    public String getName(){
        return name;
    }
    
    public long getId(){
        return id;
    }
    
    
}
