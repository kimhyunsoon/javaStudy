import java.io.*;

class Grade02 
{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   int totalScore;
   int subjectsNum;

   void inputHangul(){
      System.out.print("Hangul Score (input): ");
      try{
         String line = br.readLine();
         line = line.trim();
         int score = Integer.parseInt(line);
         subjectsNum +=1;
         totalScore += score;
         //System.out.println("Hangul Score (output): " + score);
      }catch(IOException ie){
      }catch(NumberFormatException ne){
         System.out.println("Scores can only be numeric!!");
         inputHangul();
      }
   }
   void inputEng(){
      System.out.print("Eng Score (input): ");
      try{
         String line = br.readLine();
         line = line.trim();
         int score = Integer.parseInt(line);
         subjectsNum +=1;
         totalScore += score;
         System.out.println("Eng Score (output): " + score);
      }catch(IOException ie){
      }catch(NumberFormatException ne){
         System.out.println("Scores can only be numeric!!");
         inputEng();
      }
   }
   void inputMath(){
      System.out.print("Math Score (input): ");
      try{
         String line = br.readLine();
         line = line.trim();
         int score = Integer.parseInt(line);
         subjectsNum +=1;
         totalScore += score;
         System.out.println("Math Score (output): " + score);
         System.out.println("Total Score: " + totalScore);
         System.out.println("Average Score: " + totalScore/subjectsNum);

      }catch(IOException ie){
      }catch(NumberFormatException ne){
         System.out.println("Scores can only be numeric!!");
         inputMath();
      }
   }
   public static void main(String[] args){
      Grade02 ip = new Grade02();
      ip.inputHangul();
      ip.inputEng();
      ip.inputMath();
   }
}