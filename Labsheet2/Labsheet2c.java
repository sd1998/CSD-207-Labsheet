/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
/**
 *
 * @author Shashvat Kedia
 */
public class Labsheet2c{
public static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
public static String[] primitives={"int","double","char","boolean","byte","long","short","Int"};
public static int no_vari=0,no_obj=0;
public static ArrayList<String> variables=new ArrayList<String>();
public static ArrayList<String> objects=new ArrayList<String>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String code=buffer.readLine();
        code=code.trim();
        while(!code.equals(";;;")){
            check_variable(code);
            code=buffer.readLine();
            code=code.trim();
        }
        System.out.print("The no. of variables:-");
        System.out.print(" "+no_vari+": ");
        for(String vari : variables){
            System.out.print(vari+" ");
        }
        System.out.println("");
        System.out.print("The no. of objects are:-");
        System.out.print(" "+no_obj+": ");
        for(String obj : objects){
            System.out.print(obj+" ");
        }
    }
    
    public static void check_variable(String code){
        int prev=0,count=0;
        String type="";
     for(int i=0;i<=code.length()-1;i++){
         if(code.charAt(i)==' '){
             String temp=code.substring(prev,i).trim();
             int val_index=find(temp);
             if(val_index>=0){
                 count++;
                 type=primitives[val_index];
                 break;
             }
             else{
                 prev=i+1;
             }
         }
     }
     if(count!=0){
    count_entity(0,code,type);
     }
     else{
         check_obj(code);
     }
}
    
    public static void count_entity(int ty,String code,String type){
         ArrayList<String> list=new ArrayList<String>();
         int ver=-1;
         list=break_code(code,type,list);
         if(ty==0){
             ver = check_brackets(list,code);
         }
         if(ver==0 && ty==0){
             check_obj(code);
         }
         else{
             for(int j=0;j<=list.size()-1;j++){
          String temp=list.get(j);
          if(temp.charAt(temp.length()-1)!=';'){
              continue;
          }
          int te=0;
          for(int i=0;i<=temp.length()-1;i++){
              if(temp.charAt(i)==',' || temp.charAt(i)==';'){
                  String var=temp.substring(te,i);
                  StringTokenizer tk=new StringTokenizer(var,"=");
                  String variable=tk.nextToken().trim();
                  if(ty==0){
                      variables.add(variable);
                      no_vari++;
                  }
                  else{
                      for(int k=0;k<=variable.length()-2;k++){
                          if(variable.charAt(k)=='[' && variable.charAt(k+1)==']'){
                              variable=variable.substring(0,k);
                              break;
                          }
                      }
                      objects.add(variable);
                      no_obj++;
                  }
                  te=i+1;
                  if(temp.charAt(i)==';'){
                      if(i!=temp.length()){
                          check_variable(temp.substring(i+1,temp.length()).trim());
                          break;
                      }
                  }
              }
          }
         }
         }
    }
    
    public static int find(String temp){
     for(int i=0;i<=primitives.length-1;i++){
         if(temp.equals(primitives[i])){
             return i;
         }
     }
     return -1;
    }
    
    public static ArrayList<String> break_code(String code,String type,ArrayList<String> list){
        int temp=0,initial=0;
    for(int i=0;i<=code.length()-1;i++){
        if(code.charAt(i)==' '){
            String tempo=code.substring(temp,i);
            if(tempo.equals(type)){
                  if(i!=type.length()){
                      list.add(code.substring(initial,temp).trim());
                  }
                  initial=i+1;
            }
                        temp=i+1;
        }
    }
    list.add(code.substring(initial,code.length()).trim());
return list;    
    }
    
    public static int check_brackets(ArrayList<String> list,String code){
        char opening[]={'(','[','<'};
        char closing[]={')',']','>'};
         for(String cd : list){
            for(int i=0;i<=closing.length-1;i++){
                if(cd.charAt(0)==closing[i] || cd.charAt(0)==opening[i]){
                    return 0;
                }
            }
            for(int i=0;i<=opening.length-1;i++){
                if(cd.charAt(cd.length()-2)==opening[i] || cd.charAt(cd.length()-2)==closing[i]){
                    return 0;
                }
            }
    }
         return 1;
}
    
    public static void check_obj(String code){
        int temp=0,count=0;
        ArrayList<String> objects =new ArrayList<String>();
        for(int i=0;i<=code.length()-1;i++){
            if(code.charAt(i)==' ' || code.charAt(i)==';'){
                int index=0;
                String tempo=code.substring(temp,i);
                if(tempo.contains("new")){
                    for(int j=0;j<=tempo.length()-3;j++){
                        if(tempo.substring(j,j+3).trim().equals("new")){
                            index=j;
                            break;
                        }
                    }
                    check_numof_obj(code.substring(0,index+temp).trim());
                }
                else if(tempo.equals("String")){
                    count_entity(1,code,"String");
                    count++;
                    break;
                }
                int foun=find(tempo);
                if(foun!=-1){
                    count_entity(1,code,primitives[foun]);
                    count++;
                    break;
                }
                if(code.charAt(i)==';'){
                    if(i!=code.length()){
                        check_variable(code.substring(i+1,code.length()).trim());
                        count++;
                        break;
                    }
                }              
                temp=i+1;
            }
        }
    }
    
    public static void check_numof_obj(String obj){
        String object="";
        int state=0;
        for(int i=obj.length()-1;i>=0;i--){
            if(obj.charAt(i)!='=' && obj.charAt(i)!=' ' && state==0){
                object=obj.charAt(i)+object;
                state++;
                continue;
            }
            if(obj.charAt(i)!='=' && obj.charAt(i)!=' ' && state==1){
                object=obj.charAt(i)+object;
            }
            else if(state==1){
                break;
            }
        }
        if(!object.equals("")){
        objects.add(object);
        no_obj++;
        }
    }
}
