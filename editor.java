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
		f = new JFrame("editor");

		try {
			
			// Set look and feel
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
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
		JMenuItem mi1 = new JMenuItem("cut");
		JMenuItem mi2 = new JMenuItem("copy");
		JMenuItem mi3 = new JMenuItem("paste");

		// Add action listener
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);

		m.add(mi1);
		m.add(mi2);
		m.add(mi3);

		JMenuItem mc = new JMenuItem("close");

		mc.addActionListener(this);

		mb.add(m);
		mb.add(mc);

		f.setJMenuBar(mb);
		f.add(t);
		f.setSize(500, 500);
		f.show();
	}

	// If a button is pressed
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		if (s.equals("cut")) 
		{
			t.cut();
		}
		else if (s.equals("copy")) 
		{
			t.copy();
		}
		else if (s.equals("paste")) 
		{
			t.paste();
		}
		else if (s.equals("close")) 
		{
			f.setVisible(false);
		}
	}

	// Main class
	public static void main(String args[])
	{
		editor e = new editor();
	}
}
