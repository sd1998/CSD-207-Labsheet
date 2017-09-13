
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author Shashvat Kedia
 */
public class Main {
    public static ArrayList<customer> customers=new ArrayList<customer>();
    public static ArrayList<category> categories=new ArrayList<category>();
    public static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        manager_mode();
        while(true){
        System.out.println("1.Customer Mode");
        System.out.println("2.Manager Mode");
        System.out.println("3.Exit");
        System.out.println("Select your option");
        int choice=Integer.parseInt(buffer.readLine());
        if(choice==1){
        take_input();
        }
        else if(choice==2){
            manager_mode();
        }
        else{
            break;
        }
        }
    }
    
    public static void manager_mode() throws IOException{
        while(true){
            String name;
            double gst;
            category cat;
            System.out.println("1. Add a category");
            System.out.println("2. Add an item in category");
            System.out.println("3. Delete an item from category");
            System.out.println("4. Delete a category");
            System.out.println("5. Exit");
            System.out.println("Select yout choice");
            int choice1=Integer.parseInt(buffer.readLine());
            switch(choice1){
                case 1:
                    System.out.println("Enter the name of the category");
                    name=buffer.readLine();
                    System.out.println("Enter the gst percentage for the category");
                    gst=Double.parseDouble(buffer.readLine());
                    ArrayList<items> item=new ArrayList<items>();
                    cat=new category(name,gst);
                    item_input(cat);
                    categories.add(cat);
                    break;
                    
                case 2:
                    System.out.println("Enter the name of the category");
                    name=buffer.readLine();
                    cat=find_category(name);
                    if(cat==null){
                        System.out.println("The category is not present");
                        System.out.println("Try Again");
                        continue;
                    }
                    item_input(cat);
                    break;
                    
                case 3:
                    int temp=0;
                    System.out.println("Enter name of the cataegory");
                    name=buffer.readLine();
                    cat=find_category(name);
                    if(cat==null){
                        System.out.println("The category is not present");
                        System.out.println("Try Again");
                        continue;
                    }
                    System.out.println("Enter the name of the item you want to delete");
                    String item_name=buffer.readLine();
                    for(items itm: cat.item){
                        if(itm.getName().equals(item_name)){
                            cat.item.remove(itm);
                            System.out.println("Item has been deleted");
                            temp++;
                            break;
                        }
                    }
                    if(temp==0){
                        System.out.println("Item does not exists Try Again");
                    }
                    break;
                    
                case 4:
                    System.out.println("Enter the name of the category");
                    name=buffer.readLine();
                    cat=find_category(name);
                    if(name==null){
                         System.out.println("The category is not present");
                        System.out.println("Try Again");
                        continue;
                    }
                    categories.remove(cat);
                    System.out.println("The category has been deleted");
                    break;
                    
            }
            if(choice1==5){
                break;
            }
        }
    }
    
    public static category find_category(String name){
    for(category cate : categories){
        if(cate.getName().equals(name)){
            return cate;
        }
    }
return null;    
    }
    
    public static void item_input(category cat) throws IOException{
        System.out.println("Enter the no. of items yout would like to add in the category "+cat.getName());
        int no_items=Integer.parseInt(buffer.readLine());
        String item_name;
        long item_price;
        for(int i=1;i<=no_items;i++){
            System.out.println("Enter the name of the item");
            item_name=buffer.readLine();
            System.out.println("Enter price for the item");
            item_price=Long.parseLong(buffer.readLine());
            System.out.println("Enter the unit for the quantity");
            String qty_type=buffer.readLine();
            items itm=new items(item_name,item_price,cat,qty_type);
            cat.item.add(itm);
        }
        System.out.println("The items have been added");
        return;
    }
    
    public static void take_input() throws IOException{
        while(true){
        customer custo;
        System.out.println("New Customer?(Y for yes & N for no) enter anything else to exit");
        String ans=buffer.readLine();
        if(ans.equals("Y")){
            String name,add;
            long ph_no,id;
            System.out.println("Enter your name");
            name=buffer.readLine();
            System.out.println("Enter your address");
            add=buffer.readLine();
            System.out.println("Enter your phone number");
            ph_no=Integer.parseInt(buffer.readLine());
            customer.count++;
            id=customer.count;            
            customer cust=new customer(name,id,add,ph_no);
            custo=cust;
            customers.add(cust);
            System.out.println("You have been added");
            System.out.println("Your customer_id is "+id);
        }
        else if(ans.equals("N")){
            System.out.println("Enter your customer id");
            long id=Integer.parseInt(buffer.readLine());
            custo=check_cust(id);
            if(custo==null){
                System.out.println("No customer with entered id found");
                System.out.println("Try Again");
                continue;
            }
        }
        else{
            break;
        }
        options(custo);
        }
    }
    
    public static void options(customer custo) throws IOException{
        while(true){
        System.out.println("1.See the list of items");
        System.out.println("2.Find gst for a item");
        System.out.println("3.Add item in cart");
        System.out.println("4.Delete item from cart");
        System.out.println("5.Generate Bill");
        System.out.println("6.Exit");
        System.out.println("Enter your choice");
        int choice2=Integer.parseInt(buffer.readLine()),qty;
        String name;
        items itm;
        switch(choice2){
            case 1:
                find(0,null);
            break;
    
            case 2:
                System.out.println("Enter the name of the item you would like to buy");
                name=buffer.readLine();
                itm=find(1,name);
                if(itm==null){
                    System.out.println("No such item exists Try Again");
                    continue;
                }
                System.out.println("Gst percentage for the item is "+itm.getTax());
                break;
                
            case 3:
                System.out.println("Enter the name of the item you would like to buy");
                name=buffer.readLine();
                itm=find(1,name);
                if(itm==null){
                    System.out.println("No such item exists Try Again");
                    continue;
                }
                System.out.println("Ente the quantity your would like to buy");
                qty=Integer.parseInt(buffer.readLine());
                itm.qty=qty;
                custo.item.add(itm);
                break;
                
            case 4:
                System.out.println("Enter the name of the item you would like to delete");
                name=buffer.readLine();
                for(items item : custo.item){
                    if(item.getName().equals(name)){
                        custo.item.remove(item);
                        System.out.println("The item hase been deleted");
                    }
                }
                break;
                
            case 5:
                TaxCalculator.calculate(custo);
                break;
                
        }
             if(choice2==6){
               break;
             }
        }
    }
    
    public static items find(int type,String item){
        for(category cat:categories){
            if(type==0){
                System.out.println(cat.getName());
            }
            for(items itm : cat.item){
                if(type==0){
                    System.out.println(itm.getName());
                }
                else{
                   if(itm.getName().equals(item)){
                       return itm;
                   }
                }
            }
        }
        return null;
    }
    
    public static customer check_cust(long id){
        for(customer cust:customers){
            if(cust.id==id){
                return cust;
            }
        }
        return null;
    }
}
