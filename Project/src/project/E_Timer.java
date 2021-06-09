package project;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class E_Timer extends TimerTask  {
   private Timer timer;
   int count = 5 ; 
   int wating_count = 4;
    
    
       @Override
        public void run() {

           if(count > 0) {
            count--; 
           }else if(wating_count > 0) {
              System.out.println(wating_count);
              wating_count--;
           }else {
              count = 5;
              wating_count = 3;
           }
        }
    
    
    public void setTimer(long delay, long period) {
        timer = new Timer();
        timer.schedule(new E_Timer(), delay, period);
    }
    
    public static void main(String args[]) {
       E_Timer time30 = new E_Timer();
       time30.setTimer(0, 1000);
    }
}