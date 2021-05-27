import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonHandler implements ActionListener 
{
	CalUI c;
	ButtonHandler(CalUI c){
		this.c = c;
	}

    String formula=""; //식 ( ex: 12+23+1-55 ) 
 
	StringBuffer sb = new StringBuffer();
	public void actionPerformed(ActionEvent ae){
		Object obj = ae.getSource();
		JButton btn = (JButton)obj; 
		String label = btn.getLabel();
		
	    if(getNum(label) != -1L){
			if(!(sb.length() == 0 && label.equals("0"))) 
				sb.append(label);
		}
		c.tf.setText(sb.toString());

		switch(label){
			case "가은": 
				//c.pln("가은"); 
			    break;
            case "Clear": 
				//c.pln("Clear"); 
			    clear();
				formula = "";
			    break;
			case "Back": 
				//c.pln("Back"); 
			    if(sb.length() != 0) sb.deleteCharAt(sb.length()-1);
			    break;
			case "÷": 
				//c.pln("÷"); 
			    break;
			case "x": 
				//c.pln("x"); 
			    break;
			case "-": 
			    //c.pln("-"); 
			    formula = formula + sb.toString() + " - ";
				clear();

			    break;
			case "+": 
				//c.pln("+"); 
				formula = formula + sb.toString() + " + ";
				clear();

			    break;
			case "=": 
				//c.pln("="); 
			    formula = formula + sb.toString();
			    c.pln(formula);

				long result = calFormula(formula);
				c.tf.setValue(result);

				sb.delete(0, sb.length());

			    break;
			case ".": 
				//c.pln("."); 
			    break;
			case "±": 
				//c.pln("±"); 
			    break; 
		}
	}
	void clear(){
		c.tf.setText("");
		sb.delete(0, sb.length());
	}
	long getNum(String label){
        try{
			long lo = Long.parseLong(label);
			return lo;
		}catch(NumberFormatException ie){
			return -1L;
		}
	}

    long calFormula(String formula){
		long temp = 0L;
		String oper = null;

		String items[] = formula.split(" ");
		//for(String item: items) c.pln(item);

		for(int i=0; i<items.length; i++){
		    if(i%2 == 0){ //숫자 
				long num = Long.parseLong(items[i]);	
                if(i==0) {
					temp = num;
				}else{
					if(oper != null){
						switch(oper){
							case "+": temp += num; break;
							case "-": temp -= num; break;
						}
					}
				}
			}else{ //연산자
                switch(items[i]){
                    case "+": oper = "+"; break;
					case "-": oper = "-"; break;
				}
			}
		}
        //c.pln("temp: " + temp);
  
		return temp;
	}
}
