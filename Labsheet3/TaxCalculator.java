 /* and open the template in the editor.
 */


/**
 *
 * @author Shashvat Kedia
 */
public class TaxCalculator {
 public static void calculate(customer custo){
     if(custo.item.size()==0){
         System.out.println("No items present in cart");
         System.out.println("Try Again");
         return;
     }
     System.out.println("Total Bill Amount:-");
     double sum=0;
     for(items itm : custo.item){
         System.out.print(itm.getName());
         System.out.print(" "+itm.getQuantity()+itm.getQtyDenote()+" =");
         System.out.print(itm.getQuantity()*itm.getPrice()+" + "+"CGST"+" = ");
         System.out.print(itm.getTax()+"%"+" + "+"SGST"+" = "+itm.getTax()+" = ");
         double final_cost=itm.getQuantity()*itm.getPrice()*1+(2*itm.getTax())/(itm.getQuantity()*itm.getPrice())*100;
         sum=sum+final_cost;
         System.out.print(final_cost);
         System.out.println("");
     }
     System.out.print("Total = "+sum);
     return;
 }
}
