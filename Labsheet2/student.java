import java.io.IOException;
import java.util.ArrayList;
import static labsheet2.Labsheet2b.question;
import static labsheet2.Labsheet2b.scan;

/**
 *
 * @author Shashvat Kedia
 */
public class student {
    public static void student_options() throws IOException{
      System.out.println("Enter the password to enter student mode");
        String pass_stu=scan.readLine();
        if(pass_stu.equals("student@1234")){
            ;
        }
        else{
            System.out.println("Wrong Password");
            return;
        }
        while(true){
            student_mode();
            System.out.println("1. Continue in student mode");
            System.out.println("2. Exit student Mode");
            System.out.println("Enter your choice");
            int choice2=Integer.parseInt(scan.readLine());
            if(choice2==2){
                break;
            }
            else if(choice2==1){
                continue;
            }
        }
}

public static void student_mode() throws IOException{
    System.out.println("How many questions would you like to answer");
    int no_ques=Integer.parseInt(scan.readLine());
    int points=0;
    ArrayList<Integer> choosed=new ArrayList<Integer>();
    if(no_ques>question.size()){
        System.out.println("Enter a valid number of questions");
        return;
    }
    ArrayList<questions> used=new ArrayList<questions>();
    while(no_ques!=0){
        int que_num=(int)(Math.random()%question.size());
        questions que=question.get(que_num);
        System.out.println("Your question and options is:-");
        System.out.println(que.question);
        for(int i=0;i<=3;i++){
            System.out.println(que.options[i]);
        }
        System.out.println("Enter your answer from the given options:-");
        String ans=scan.readLine();
        if(ans.equals(que.answer)){
            points++;
        }
        used.add(que);
        question.remove(que);
        no_ques--;
    }
    System.out.println("The number of points you have scored is "+points);
    for(questions use : used){
        question.add(use);
    }
}
}
