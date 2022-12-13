// Java Program to create a text editor using java
import javax.swing.*;
import java.awt.event.*;
import javax.swing.UIManager;
class editor extends JFrame implements ActionListener 
{
	// Text component
	JTextArea t;

	// Frame
	JFrame f;

	// Constructor
	editor()
	{
		// Create a frame
		f = new JFrame("Text Editor");

		try {
			
			// Set look and feel
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		
		}
		catch (Exception e) {
		}

		// Text component
		t = new JTextArea();

		// Create a menubar
		JMenuBar mb = new JMenuBar();

		// Create amenu for menu
		JMenu m = new JMenu("Edit");

		// Create menu items
		JMenuItem mi1 = new JMenuItem("Cut");
		JMenuItem mi2 = new JMenuItem("Copy");
		JMenuItem mi3 = new JMenuItem("Paste");

		// Add action listener
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);

		m.add(mi1);
		m.add(mi2);
		m.add(mi3);

		mb.add(m);
		
		f.setJMenuBar(mb);
		f.add(t);
		f.setSize(500, 500);
		f.show();
	}

	// If a button is pressed
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		if (s.equals("Cut")) 
		{
			t.cut();
		}
		else if (s.equals("Copy")) 
		{
			t.copy();
		}
		else if (s.equals("Paste")) 
		{
			t.paste();
		}
	}

	// Main class
	public static void main(String args[])
	{
		editor e = new editor();
	}
}
