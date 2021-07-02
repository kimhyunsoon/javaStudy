import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import java.io.*;

class class01 {     
    
    public static void main(String[] args) {   
            
        JFrame f = new JFrame("����������");        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setSize(200,200);
        f.setVisible(true);            
          
        File file = new File("C:\\KAEUN\\gitStudy\\Project\\src\\starHospital\\bgm.wav");
        System.out.println(file.exists()); //true
        try {
            
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            
        } catch(Exception e) {
            
            e.printStackTrace();
        }
        
    }      
}