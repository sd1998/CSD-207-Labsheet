import java.io.IOException;
import static labsheet2.Labsheet2b.question;
import static labsheet2.Labsheet2b.scan;

/**
 *
 * @author Shashvat Kedia
 */
public class teacher {
    public static void teacher_options() throws IOException{
           System.out.println("Enter the password to enter teacher mode ");
        String pass_teach=scan.readLine();
        if(pass_teach.equals("teacher@1234")){
            ;
        }
        else{
            System.out.println("Worng Password");
            return;
        }
        while(true){
            teacher_mode();
            System.out.println("1. Continue in teacher mode");
            System.out.println("2. Exit teacher Mode");
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
//
    public static void teacher_mode() throws IOException{
    System.out.println("1.Enter a new question in the question bank");
    System.out.println("2.Delete a question from the question bank");
    System.out.println("Enter your choice");
    int choice1=Integer.parseInt(scan.readLine());
    if(choice1==1){
        String option[]=new String[4];
        System.out.println("Enter the question you would like to add");
        String questio=scan.readLine();
        System.out.println("Enter the four options for the question");
        for(int i=0;i<=3;i++){
            option[i]=scan.readLine();
        }
        System.out.println("Enter the correct option");
        String ans=scan.readLine();
        questions que=new questions(questio,option[0],option[1],option[2],option[3],ans);
        question.add(que);
        System.out.println("Question Successfully added");
    }
    else if(choice1==2){
        int count=0;
        System.out.println("List of question in the question bank");
        for(questions que : question){
            count++;
            System.out.println(count+"."+que.question);
        }
        System.out.println("Enter the question number of the question you would like to delete");
        int num=Integer.parseInt(scan.readLine());
        questions que=question.get(num-1);
        question.remove(que);
        System.out.println("The question has been deleted successfully deleted");
    }
}
}
