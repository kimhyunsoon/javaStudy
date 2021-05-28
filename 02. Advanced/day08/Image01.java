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
            BufferedImage bi = ImageIO.read(f); //static이다. 클래스 소유이기 때문에 생성자 없이 객체 만들 수 있다.
            //ImageIO: ImageReader 및 ImageWriter를 찾고 간단한 인코딩 및 디코딩을 수행하기위한 정적 편의 메서드가 포함 된 클래스입니다.
            //현재 등록 된 파일 중에서 자동으로 선택된 ImageReader로 제공된 파일을 디코딩 한 결과 BufferedImage를 반환합니다.
            imageIcon = new ImageIcon(bi);
            // imageIcon = new ImageIcon(ImageIO.read(new File("02. Advanced/day08/image/01.jpg")));
        } catch (Exception e) {
            //TODO: handle exception
        }
    }


        
    void setUI(){
		setTitle("Image Test Ver 1.0");
		setSize(300, 200);
        pack(); //이미지 크기에 맞춰서 사이즈 생성
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}




    public static void main(String[] args){
        new Image01().init();
    }
    
}
