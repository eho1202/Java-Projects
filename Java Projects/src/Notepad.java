import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;

import java.io.*;
import java.io.IOException;

public class Notepad implements ActionListener {

	// Properties
	JFrame theframe = new JFrame("Notepad");
	JPanel thepanel = new JPanel();
	JTextArea thearea = new JTextArea();
	JScrollPane thescroll = new JScrollPane(thearea);
	JMenuBar thebar = new JMenuBar();
	JMenu thefile = new JMenu("File");
	JMenuItem theopen = new JMenuItem("Open");
	JMenuItem thesave = new JMenuItem("Save");

	// Method
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == theopen) {
			open();

		} else if (evt.getSource() == thesave) {
			save();

		}
	}

	public void open() {
		JFileChooser chooser = new JFileChooser(new File("c:\\"));
		chooser.setDialogTitle("Open a File");
		int result = chooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				File file = chooser.getSelectedFile();
				BufferedReader br = new BufferedReader(new FileReader (file.getPath()));
				String line = "";
				String s = "";
				
				while ((line = br.readLine()) != null) {
					s += line;
				}
				thearea.setText(s);
				if (br != null) {
					br.close();
				}
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}
	
	public void save() {
		JFileChooser chooser = new JFileChooser(new File("c:\\"));
		chooser.setDialogTitle("Save a File");
		int result = chooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			String content = thearea.getText();
			File file = chooser.getSelectedFile();
			try {
				FileWriter thewriter = new FileWriter(file.getPath());
				thewriter.write(content);
				thewriter.flush();
				thewriter.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
	}

	// Constructor
	public Notepad() {
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(960, 480));

		thebar.setSize(new Dimension(960, 25));
		thebar.setLocation(0, 0);
		thepanel.add(thebar);

		thebar.add(thefile);
		thefile.add(theopen);
		theopen.addActionListener(this);
		thefile.add(thesave);
		thesave.addActionListener(this);

		thescroll.setSize(new Dimension(960, 455));
		thescroll.setLocation(0, 25);
		thepanel.add(thescroll); // setting the border layout to center will use up all the available space

		theframe.setContentPane(thepanel);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.pack();
		theframe.setVisible(true);
		theframe.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new Notepad();

		try {
			// gets Windows 10 UI
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
