import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import labsheet2.questions;

public class Labsheet2b {
    public static BufferedReader scan=new BufferedReader(new InputStreamReader(System.in));

public static ArrayList<questions> question=new ArrayList<questions>();
public static int choice;

public static void main(String args[]) throws IOException{
    while(true){
    take_input();
    if(choice==3){
        break;
    }
    }
}

public static void take_input() throws IOException{
    System.out.println("1.Enter Teacher Mode");
    System.out.println("2.Enter Student Mode");
    System.out.println("3.Exit");
    System.out.println("Enter your choice");
    choice=Integer.parseInt(scan.readLine());
    if(choice==1){
        teacher.teacher_options();
    }
    else if(choice==2){
      student.student_options();
    }
    else if(choice==3){
        return;
    }
}
}

