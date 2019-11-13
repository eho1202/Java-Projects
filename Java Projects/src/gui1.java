import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class gui1 implements ActionListener{
	// Properties
		// if you don't put public, it is assumed the object is public
	JFrame theframe;
	JPanel thepanel;
	JTextArea theta;
	JScrollPane scroll;
	
	JTextField fielda;
	JTextField fieldb;
	JButton butcalc;
	JLabel labelc;
	JLabel thelabel;
	JLabel thelabel1;
	
	JTextField fieldaa;
	JButton butcalca;
	JLabel labela;
	JLabel labela1;
	JLabel labelaa;
	
	JTextField fieldab;
	JLabel labelb;
	JLabel labelb1;
	JLabel labelbb;
	JButton butcalcb;
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == butcalc){
			if (fielda.getText().equals("") || fieldb.getText().equals("")) {
				thelabel.setText("You did not enter the numbers for side A and/or side B");
			}else if (fielda.getText().equals("0") || fieldb.getText().equals("0")) {
				thelabel.setText("The triangle does not exist");
			}else {
				try {
					double dblA = Double.parseDouble(fielda.getText());
					double dblB = Double.parseDouble(fieldb.getText());
					double dblC = Math.sqrt(Math.pow(dblA, 2) + Math.pow(dblB, 2));
					labelc.setText(String.valueOf(dblC));
					thelabel.setText("");
					theta.append("Hypoteneuse: " + String.valueOf(dblC) + "\n");
				}catch (NumberFormatException e) {
					thelabel.setText("The triangle does not exist");
				}
			}
		}else if (evt.getSource() == butcalca) {
			if (fieldaa.getText().equals("")) {
				labelaa.setText("You did not enter any number in degrees");
			}else {
				double dblA = Double.parseDouble(fieldaa.getText());
				double dblB = Math.toRadians(dblA);
				labela.setText(String.valueOf(dblB));
				labelaa.setText("");
				theta.append("Radian: " + String.valueOf(dblB) + "\n");
			}
		}else if (evt.getSource() == butcalcb) {
			if (fieldab.getText().equals("")) {	
				labelbb.setText("You did not enter any number in celsius");
			}else {
				double dblA = Double.parseDouble(fieldab.getText());
				double dblB = dblA * 9 / 5 + 32;
				labelb.setText(String.valueOf(dblB) + "F");
				labelbb.setText("");
				theta.append("Fahrenheit: " + String.valueOf(dblB) + "F\n");
			}
		}
	}
	

	// Constructor
	public gui1(){
		// if there is a local panel and this is added infront of thepanel in the constructor
		// java will take the jpanel property instead of the local thepanel
		thepanel = new JPanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(700,400));
		
		theta = new JTextArea(10,10);
		theta.setEditable(false);
		
		scroll = new JScrollPane(theta);
		scroll.setSize(400,100);
		scroll.setLocation(150,275);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		thepanel.add(scroll);
		
		
		// Hypotenuse of triangle
		thelabel1 = new JLabel("Find the hypoteneuse of a right triangle here");
		thelabel1.setSize(500,20);
		thelabel1.setLocation(35,5);
		thepanel.add(thelabel1);
		
		fielda = new JTextField(10);
		fielda.setSize(100,20);
		fielda.setLocation(85,30);
		thepanel.add(fielda);
		
		fieldb = new JTextField(10);
		fieldb.setSize(100,20);
		fieldb.setLocation(225,30);
		thepanel.add(fieldb);
			
		butcalc = new JButton("Calculate");
		butcalc.setSize(100,20);
		butcalc.setLocation(385, 30);
		butcalc.addActionListener(this);
		thepanel.add(butcalc);

		labelc = new JLabel("Hypotenuse: ", SwingConstants.LEFT);
		labelc.setSize(new Dimension(150, 20));
		labelc.setLocation(535,30);
		thepanel.add(labelc);
		
		thelabel = new JLabel();
		thelabel.setSize(new Dimension(500, 20));
		thelabel.setLocation(200,50);
		thepanel.add(thelabel);
		
		// Degree to Radians
		fieldaa = new JTextField(10);
		fieldaa.setSize(100,20);
		fieldaa.setLocation(150,120);
		thepanel.add(fieldaa);
		
		butcalca = new JButton("To Radians");
		butcalca.setSize(100,20);
		butcalca.setLocation(300,120);
		butcalca.addActionListener(this);
		thepanel.add(butcalca);
		
		labela = new JLabel("Radians:");
		labela.setSize(new Dimension(300,20));
		labela.setLocation(450,120);
		thepanel.add(labela);
		
		labelaa = new JLabel();
		labelaa.setSize(new Dimension(450,20));
		labelaa.setLocation(250,140);
		thepanel.add(labelaa);
		
		labela1 = new JLabel("Convert angles from degrees to radians here");
		labela1.setSize(new Dimension(450,20));
		labela1.setLocation(25,95);
		thepanel.add(labela1);
		
		//celsius to fahrenheit
		fieldab = new JTextField(10);
		fieldab.setSize(100,20);
		fieldab.setLocation(150,210);
		thepanel.add(fieldab);
		
		butcalcb = new JButton("To fahrenheit");
		butcalcb.setSize(120,20);
		butcalcb.setLocation(300,210);
		butcalcb.addActionListener(this);
		thepanel.add(butcalcb);
		
		labelb = new JLabel("Fahrenheit:");
		labelb.setSize(new Dimension(100,20));
		labelb.setLocation(450,210);
		thepanel.add(labelb);
		
		labelbb = new JLabel();
		labelbb.setSize(new Dimension(450,20));
		labelbb.setLocation(250,230);
		thepanel.add(labelbb);
		
		labelb1 = new JLabel("Convert celsius to fahrenheit here");
		labelb1.setSize(new Dimension(450,20));
		labelb1.setLocation(25,185);;
		thepanel.add(labelb1);
		
		theframe = new JFrame("Math");
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setContentPane(thepanel);// pane and panel mean the same thing, the glass that you put into the frame
		theframe.pack();
		theframe.setVisible(true);
		theframe.setLocationRelativeTo(null); // to center frame
	}
	
	// main method
	public static void main(String[] args){
		new gui1(); // calls constructor and activates constructor and panel
	}
}

