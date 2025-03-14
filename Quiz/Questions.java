package playQuiz;
public class Questions{
private int ID;
private String Question;
private String opt1;
private String opt2;
private String opt3;
private String opt4;
private String ans;

public Questions(int iD, String question, String opt1, String opt2, String opt3, String opt4, String ans) {
    ID = iD;
    Question = question;
    this.opt1 = opt1;
    this.opt2 = opt2;
    this.opt3 = opt3;
    this.opt4 = opt4;
    this.ans = ans;
}
public Questions(String str){
  this.ans=str;
}
public String getOpt1() {
    return opt1;
}
public void setOpt1(String opt1) {
    this.opt1 = opt1;
}
public String getOpt2() {
    return opt2;
}
public void setOpt2(String opt2) {
    this.opt2 = opt2;
}
public String getOpt3() {
    return opt3;
}
public void setOpt3(String opt3) {
    this.opt3 = opt3;
}
public String getOpt4() {
    return opt4;
}
public void setOpt4(String opt4) {
    this.opt4 = opt4;
}
public String getAns() {
    return ans;
}
public void setAns(String ans) {
    this.ans = ans;
}
public String getQuestion() {
    return Question;
}
public void setQuestion(String question) {
    Question = question;
}
public int getID() {
    return ID;
}
public void setID(int iD) {
    ID = iD;
}
}
