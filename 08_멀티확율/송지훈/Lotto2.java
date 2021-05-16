import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class Lotto2 {

  String fname = "우리반.txt";
  ArrayList names = new ArrayList();
  ArrayList weights = new ArrayList();
  Random r = new Random();
  BufferedReader br = null;
  FileReader fr = null;
  String line = "";
  int idx;
  String name;
  double size = names.size();

  Lotto2() {
    readFileName();
    addName();
    //in();
    rand();
  }

  void readFileName() {
    try {
      // p("읽을 파일 이름(기본:우리반.txt): ");
      line = fname;
    //  if (line != null) line = line.trim();
    //  if (line.length() == 0) line =fname;
      fr = new FileReader(line);

    } catch (IndexOutOfBoundsException iobe) {
      p("(우리반.txt) 파일을 찾지 못했씁니다.");
      readFileName();
    } catch (IOException fe) {
      p("(우리반.txt) 파일을 찾지 못했씁니다.");
      readFileName();
    }
  }
  void addName() {
    try {
      fr = new FileReader(line);
      br = new BufferedReader(fr);
      while ((name = br.readLine()) != null) {
        if (name != null) name = name.trim();
        idx = name.indexOf(" ");
        boolean check = (idx > 0);
        if (check) {

          String SWeight = name.substring(idx + 1);
          int weight =Integer.parseInt(SWeight.trim());
          if(weight==0){
            continue;
          }
          name = name.substring(0, idx);
          weights(name,weight);

        }
        names.add(name);
      }
      size = names.size();
      if (weights.size()>100){
        p("제시된 확률의 합이 100보다 큽니다. \n수정 후 다시 실행해주세요.");
        System.out.println("합: "+weights.size());
        System.exit(0);
      }
      while(weights.size()<100){
        weights.add(null);
      }
      if (names.size()==0){
        p("제시된 확률의 합이 0입니다.\n수정 후 다시 실행해주세요.");
        System.exit(0);

      }
    } catch (IOException ie) {
      p("제시된 확률을 확인해주세요.");
      System.exit(0);

    } catch (IndexOutOfBoundsException iobe) {
      p("제시된 확률을 확인해주세요.");
      System.exit(0);
    } catch (NumberFormatException ne) {
      p("제시된 확률을 확인해주세요.");
      System.exit(0);
    }catch (IllegalArgumentException ie){
      p("제시된 확률을 확인해주세요.");
    }
   /* System.out.println("<명단>" +
      "");

    for (String name : names) {
      p(name);
    }*/
  }


  void weights(String name, int weight) {
    for (int i = 0; i < weight; i++) {
      weights.add(name);
    }
    return;
  }

  void rand(){
    int a = r.nextInt(100);
    if(weights.get(a)!=null)p("당첨자: "+weights.get(a));
    else{
      a= r.nextInt(names.size());
      p("당첨자: "+names.get(a));
    }

  }
  void p(String str) {
    System.out.println(str);
  }

  public static void main(String[] args) {
    new Lotto2();
  }

}
