import java.util.Scanner;
/**
 *
 * @author Shashvat Kedia
 */
public class Labsheet2a{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text;
        Scanner scan=new Scanner(System.in);
		System.out.println("Enter the line to be reversed");
        text=scan.nextLine();
        int end=text.length();
        for(int i=text.length()-1;i>=0;i--){
            if(text.charAt(i)==' '){
            System.out.print(text.substring(i+1,end));
            System.out.print(" ");
            end=i;
            }
        }
        System.out.print(text.substring(0,end));
        // TODO code application logic here
    }
    
}