/**
 *
 * @author Shashvat Kedia
 */
public class questions {
    public String question;
    public String options[]=new String[4];
    public String answer;

        public questions(String que, String opta, String optb, String optc,String optd, String ans) {
        question=que;
        options[0]=opta;
        options[1]=optb;
        options[2]=optc;
        options[3]=optd;
        answer=ans;
        }
}
