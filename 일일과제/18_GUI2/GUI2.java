import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class GUI2 extends JFrame{
    Container cp = getContentPane() ;
    JPanel btnPad = new JPanel();
    JButton clearBtn = new JButton("Clear");
    JTextArea textArea = new JTextArea();
    JButton openBtn = new JButton("Open");
    JButton saveBtn = new JButton("Save");
    ArrayList<String> extenArr = new ArrayList<String>();
    JFileChooser fileChooser;
    
    void init(){        
        extenArr.add("txt");
        extenArr.add("svg");
        extenArr.add("java");
        String infoMsg = "=====읽을수 없는 확장자 입니다.=====\n";
        infoMsg += infoMsg + "읽을 수 있는 확장자 : ";
        for(int i = 0; i<extenArr.size(); i++){
            if(i == extenArr.size() - 1){
                infoMsg +="." + extenArr.get(i);
            }else {
                infoMsg +="." + extenArr.get(i) + ",";
            }
        }


        clearBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.setText("");
            }
        });
        openBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(btnPad); //???? ???? ???? ??
                if (result == JFileChooser.APPROVE_OPTION) { //???? , ?? 1 , ?? 0
                    File selectedFile = fileChooser.getSelectedFile();
                    String selectedFileName = selectedFile.getName();
                    String fileExten = selectedFileName.substring(selectedFileName.lastIndexOf(".")+1);

                    
                    if (extenArr.contains(fileExten)){
                        textArea.setText("");
                        BufferedReader br = null;
                        try{
                            br = new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile)));
                            String line;
                            while((line = br.readLine()) != null){
                                textArea.setText(textArea.getText() + line);
                            }
                        } catch (Exception eee) {}
                    } else {
                        
                    }
                    
                }
            }
        });

        saveBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String content = textArea.getText();
                String infoMsg2 = "내용을 입력해주세요.";
                if(content.length() == 0 || content == infoMsg2){
                    textArea.setText(infoMsg2);
                }else {
                    fileChooser = new JFileChooser();
                    int file = fileChooser.showSaveDialog(btnPad);
                    if (file == JFileChooser.APPROVE_OPTION) {
                        try{
                            FileWriter writer = null;
                            writer = new FileWriter(fileChooser.getSelectedFile());
                            writer.write(textArea.getText().replaceAll("\n", "\r\n"));
                            writer.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                }
            }
        });


        
        btnPad.setLayout(new GridLayout(0,2));
        btnPad.add(openBtn);
        btnPad.add(saveBtn);
        textArea.setLineWrap(true); 

        cp.add(clearBtn, BorderLayout.NORTH);
        cp.add(textArea, BorderLayout.CENTER);
        cp.add(btnPad, BorderLayout.SOUTH);
        setUI();
    }
    
    
    void setUI(){
		setTitle("FileChooser");
		setSize(500, 800);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String [] args) {
        GUI2 view = new GUI2();
        view.init();
    }
}