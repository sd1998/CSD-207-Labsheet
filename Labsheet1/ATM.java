package javaapplication1;

import java.util.Scanner;
/**
 *
 * @author Shashvat Kedia
 */
public class ATM {

    public static long availAmount;
    public static long amount;
    public static long NO2000;
    public static long NO500;
    public static long NO100;
    public static int choice,choice1;
    public static long Thresh2000,Thresh500,Thresh100,temp;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        readInput();
        while(true){
			temp=0;
        if(choice==3){
            break;
        }
        if(choice==1 && choice1==1){
            if(availAmount>2000){
        NO2000=(int)(0.25*availAmount);
        if(NO2000%2000!=0){
            temp=NO2000%2000;
            NO2000=NO2000-temp;
        }
        NO2000=NO2000/2000;
            }
            if(availAmount>500){
        NO500=(int)(0.35*availAmount)+temp;
        if(NO500%500!=0){
            temp=NO500%500;
            NO500=NO500-temp;
        }
        else{
            temp=0;
        }
        NO500=NO500/500;
            }
        NO100=(long)(0.4*availAmount)+temp;
        if(NO100%100!=0){
            availAmount=availAmount-NO100%100;
        }
        NO100=NO100/100;
        Thresh2000=(long)(NO2000*0.05);
        Thresh500=(long)(NO500*0.05);
        Thresh100=(long)(NO100*0.05);;
        if(Thresh2000==0){
            Thresh2000++;
        }
        if(Thresh500==0){
            Thresh500++;
        }
        if(Thresh100==0){
            Thresh100++;
        }
        }
        if(amount%100!=0){
            amount=amount-amount%100;
        }
        transact(amount);
        readInput();
        }
    }
    
    public static void readInput(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter 1 to update the ATM system ");
        System.out.println("Enter 2 to withdraw money from ATM ");
        System.out.println("Enter 3 to exit ");
        choice=scan.nextInt();
        if(choice==1){
            System.out.println("1. Update ATM balance ");
            System.out.println("2. Check ATM status");
            choice1=scan.nextInt();
            if(choice1==1){
                System.out.println("Enter the amount in ATM ");
               availAmount=scan.nextLong();
                System.out.println("Enter the amount to be withdrawn");
                amount=scan.nextLong();
            }
            else if(choice1==2){
                System.out.println("No. Of 2000 rupee notes in ATM "+NO2000);
                System.out.println("No. of 500 rupee notes in ATM "+NO500);
                System.out.println("No. of 100 rupee notes in ATM "+NO100);
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
        else if(choice==2){
        System.out.println("Enter the amount to be withdrawn");
        amount=scan.nextLong();
        }
        else if(choice==3){
            return;
        }
        else{
            System.out.println("Invalid Choice");
        }
    }
    
    public static void transact(long amount){
      if(amount==2000){
         if(NO500-Thresh500<=3 && (amount-(NO500-Thresh500)*500)<=(NO100-Thresh100)*100){
             print(1,0,NO500-Thresh500,(amount-(NO500-Thresh500)*500)/100);
         }
         else if(NO500-Thresh500>=4 && NO100-Thresh100>=5){
             print(1,0,3,5);
         }
         else if(NO500-Thresh500>=4){
             print(1,0,4,0);
         }
         else if(NO2000-Thresh2000>=1){
             print(1,1,0,0);
         }
         else{
             print(0,0,0,0);
         }
      }
      else{
          long Disp2000=0,Disp500=0,Disp100=0;
          if(amount>2000){
          Disp2000=amount/2000;
          if(NO2000-Disp2000<Thresh2000){
              Disp2000=Disp2000-(Thresh2000-(NO2000-Disp2000));
          }
          amount=amount-Disp2000*2000;
          }
          if(amount>=500){
              Disp500=amount/500;
              if(NO500-Disp500<Thresh500){
                  Disp500=Disp500-(Thresh500-(NO500-Disp500));
              }
              Disp500--;
              amount=amount-Disp500*500;
              if(amount>=100){
                  Disp100=amount/100;
                  if(NO100-Disp100>=Thresh100){
                      print(1,Disp2000,Disp500,Disp100);
                      return;
                  }
              }
          }
          else if(amount>=500){
              Disp500=amount/500;
              if(NO500-Disp500<Thresh500){
                  Disp500=Disp500-(Thresh500-(NO500-Disp500));
              }
              amount=amount-Disp500*500;
          }
          Disp100=amount/100;
          if(NO100-Disp100<Thresh100){
              print(0,0,0,0);
          }
          else{
              print(1,Disp2000,Disp500,Disp100);
          }
      }
    }
    
    public static void print(int status,long Disp2000,long Disp500,long Disp100){
        if(status==1){
            NO2000=NO2000-Disp2000;
            NO500=NO500-Disp500;
            NO100=NO100-Disp100;
            System.out.println("No. of 2000 rupee notes Dispensed "+Disp2000);
            System.out.println("No. of Rs. 500 rupee notes Dispensed "+Disp500);
            System.out.println("No. of Rs. 100 rupee notes Dispensed "+Disp100);
    }
        else{
            System.out.println("The transaction cannot be precessed");
        }
    }
}
