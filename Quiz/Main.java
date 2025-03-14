package playQuiz;

public class Main {
    public static void main(String []args){
      GetQuestion Question=new GetQuestion();
      Question.displayQuestions();
      System.out.println("lets see how much u know about me");
        Question.show();
        Question.showans();
      
    }
}
