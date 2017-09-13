/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Shashvat Kedia
 */
public class items {
    public String item_name;
    public long price;
    public category type;
    public long qty=0;
    public String qty_denote;
    
    public items(String name,long cost,category type_name,String qty_den){
        item_name=name;
        price=cost;
        type=type_name;
        qty_denote=qty_den;
    }

    public String getName(){
        return item_name;
    }
   
    public long getPrice(){
        return price;
    }
    
    public double getTax(){
        return type.getGst();
    }
    
    public long getQuantity(){
        return qty;
    }
    
    public String getQtyDenote(){
        return qty_denote;
    }
}
