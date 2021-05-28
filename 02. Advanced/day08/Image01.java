import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class Image01 extends JFrame{
    Container cp;
    ImageIcon imageIcon;
    JButton jb;

    void init(){
        cp = getContentPane();
        loadImg();
        jb = new JButton(imageIcon);
        cp.add(jb);
        setUI();
    }

    void loadImg(){
        try {
            File f = new File("02. Advanced/day08/image/01.jpg");
            BufferedImage bi = ImageIO.read(f); //static�̴�. Ŭ���� �����̱� ������ ������ ���� ��ü ���� �� �ִ�.
            //ImageIO: ImageReader �� ImageWriter�� ã�� ������ ���ڵ� �� ���ڵ��� �����ϱ����� ���� ���� �޼��尡 ���� �� Ŭ�����Դϴ�.
            //���� ��� �� ���� �߿��� �ڵ����� ���õ� ImageReader�� ������ ������ ���ڵ� �� ��� BufferedImage�� ��ȯ�մϴ�.
            imageIcon = new ImageIcon(bi);
            // imageIcon = new ImageIcon(ImageIO.read(new File("02. Advanced/day08/image/01.jpg")));
        } catch (Exception e) {
            //TODO: handle exception
        }
    }


        
    void setUI(){
		setTitle("Image Test Ver 1.0");
		setSize(300, 200);
        pack(); //�̹��� ũ�⿡ ���缭 ������ ����
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}




    public static void main(String[] args){
        new Image01().init();
    }
    
}
