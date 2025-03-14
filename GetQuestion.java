package playQuiz;


import java.util.Scanner;

public class GetQuestion {
       Questions q[]=new Questions[5];
       Questions a[]=new Questions[5];
        public void displayQuestions(){
        q[0]=new Questions(1,"what is my name?","Daranishwar","hari Raaghav","Deepan","Sai Vignesh","Daranishwar");
        q[1]=new Questions(2,"what is my favorite food?","Upma","Biriyani","Chicken Rice","egg puffs","Chicken Rice");
        q[2]=new Questions(3,"what is my favorite colour?","Yellow","Black","Blue","Red","Blue");
        q[3]=new Questions(4,"who is my favorite cricket player?","V,Kohli","Sachin Tendulkar","M.S.Dhoni","Hardik Pandiya","M.S.Dhoni");
        q[4]=new Questions(5,"which is my favorite show?","Cook with Comali","UFC","BiggBoss","WWE","WWE");
    }
    Scanner sc=new Scanner(System.in);
    int i=0;
    String str;
    public void show(){
        for (Questions questions : q) {
            System.out.println(questions.getQuestion());
            System.out.println();
            System.out.println(questions.getOpt1());
            System.out.println(questions.getOpt2());
            System.out.println(questions.getOpt3());
            System.out.println(questions.getOpt4());
            System.out.print("your answer:");
             str=sc.nextLine();
           a[i++]=new Questions(str);
            System.out.println();
        }
    }
    int mark=0;
    public void showans(){
        for (int i = 0; i < a.length; i++) {
            if(a[i].getAns().equals(q[i].getAns())){
                mark++;
            }
        }
        System.out.println("your score:"+mark+"/"+q.length);
    }
}
