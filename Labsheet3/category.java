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
public class category {
    public String cat_name;
    public double gst;
    public ArrayList<items> item=new ArrayList<items>();
    
    public category(String name, double tax) {
        cat_name=name;
        gst=tax;
    }
    
    public String getName(){
        return cat_name;
    }
   
    public double getGst(){
        return gst;
    }
}