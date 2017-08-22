package Calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Calculator {

	private JFrame frame;
	private JTextField expression;
	private JTable table;
	private JButton clearbtn;
	private JButton flipsignbtn;
	private JButton button_1;
	private JButton dividebtn;
	private JButton sevenbtn;
	private JButton eightbtn;
	private JButton ninebtn;
	private JButton probtn;
	private JButton fourbtn;
	private JButton fivebtn;
	private JButton sixbtn;
	private JButton minusbtn;
	private JButton threebtn;
	private JButton twobtn;
	private JButton onebtn;
	private JButton plusbtn;
	private JButton zerobtn;
	private JButton decibtn;
	private JButton base2btn;
	private JTextField result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 229, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		expression = new JTextField();
		expression.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		
		
		expression.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			//	System.out.println("");
			}
			
		});
		EvaluateString evt = new EvaluateString();
		expression.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
			//System.out.println(expression.getText());
				changedUpdate(arg0);
					
				
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				changedUpdate(arg0);
				// TODO Auto-generated method stub
				
			}
			@Override
			  public void changedUpdate(DocumentEvent e) {
				System.out.println(expression.getText());
				try{
				String s = evt.evaluate(expression.getText());
				if(s != "invalid")
					result.setText(s);
				}
				catch(Exception e1)
				{
					
				}
				}
			  

		});
		expression.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		expression.setFont(new Font("Tahoma", Font.PLAIN, 20));
		expression.setBounds(0, 18, 213, 31);
		frame.getContentPane().add(expression);
		expression.setColumns(10);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(0, 263, 219, -195);
		frame.getContentPane().add(table);
		
		clearbtn = new JButton("AC");
		clearbtn.setForeground(Color.RED);
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				expression.setText("");
				result.setText("");
				
			}
		});
		clearbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clearbtn.setBounds(0, 67, 54, 49);
		frame.getContentPane().add(clearbtn);
		
		flipsignbtn = new JButton(".");
		flipsignbtn.setBackground(UIManager.getColor("Button.background"));
		flipsignbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'.');

				
			}
		});
		flipsignbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		flipsignbtn.setBounds(53, 68, 54, 49);
		frame.getContentPane().add(flipsignbtn);
		
		button_1 = new JButton("%");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+button_1.getText());
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(106, 67, 54, 49);
		frame.getContentPane().add(button_1);
		
		dividebtn = new JButton("/");
		dividebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'/');

				
			}
		});
		dividebtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		dividebtn.setBackground(Color.ORANGE);
		dividebtn.setBounds(159, 67, 54, 49);
		frame.getContentPane().add(dividebtn);
		
		sevenbtn = new JButton("7");
		sevenbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'7');

			}
		});
		sevenbtn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sevenbtn.setBounds(0, 115, 54, 49);
		frame.getContentPane().add(sevenbtn);
		
		eightbtn = new JButton("8");
		eightbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				expression.setText(expression.getText()+'8');

			}
		});
		eightbtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		eightbtn.setBounds(53, 115, 54, 49);
		frame.getContentPane().add(eightbtn);
		
		ninebtn = new JButton("9");
		ninebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'9');

			}
		});
		ninebtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ninebtn.setForeground(Color.BLACK);
		ninebtn.setBounds(106, 115, 54, 49);
		frame.getContentPane().add(ninebtn);
		
		probtn = new JButton("*");
		probtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'*');

			}
		});
		probtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		probtn.setForeground(Color.BLACK);
		probtn.setBackground(Color.ORANGE);
		probtn.setBounds(159, 115, 54, 49);
		frame.getContentPane().add(probtn);
		
		fourbtn = new JButton("4");
		fourbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'4');

			}
		});
		fourbtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		fourbtn.setBounds(0, 163, 54, 49);
		frame.getContentPane().add(fourbtn);
		
		fivebtn = new JButton("5");
		fivebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'5');

			}
		});
		fivebtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		fivebtn.setBounds(53, 163, 54, 49);
		frame.getContentPane().add(fivebtn);
		
		sixbtn = new JButton("6");
		sixbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'6');

			}
		});
		sixbtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		sixbtn.setBounds(106, 163, 54, 49);
		frame.getContentPane().add(sixbtn);
		
		minusbtn = new JButton("-");
		minusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'-');

			}
		});
		minusbtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		minusbtn.setBackground(Color.ORANGE);
		minusbtn.setBounds(159, 163, 54, 49);
		frame.getContentPane().add(minusbtn);
		
		threebtn = new JButton("3");
		threebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'3');

			}
		});
		threebtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		threebtn.setBounds(106, 211, 54, 49);
		frame.getContentPane().add(threebtn);
		
		twobtn = new JButton("2");
		twobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'2');

			}
		});
		twobtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		twobtn.setBounds(53, 211, 54, 49);
		frame.getContentPane().add(twobtn);
		
		onebtn = new JButton("1");
		onebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'1');

			}
		});
		onebtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		onebtn.setBounds(0, 211, 54, 49);
		frame.getContentPane().add(onebtn);
		
		plusbtn = new JButton("+");
		plusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'+');

			}
		});
		plusbtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		plusbtn.setBackground(Color.ORANGE);
		plusbtn.setBounds(159, 211, 54, 49);
		frame.getContentPane().add(plusbtn);
		
		zerobtn = new JButton("0");
		zerobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'0');

			}
		});
		zerobtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		zerobtn.setBounds(0, 258, 107, 49);
		frame.getContentPane().add(zerobtn);
		
		decibtn = new JButton("(");
		decibtn.setBackground(Color.YELLOW);
		decibtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+'(');

			}
		});
		decibtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		decibtn.setBounds(106, 258, 54, 49);
		frame.getContentPane().add(decibtn);
		
		base2btn = new JButton(")");
		base2btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText()+')');

			}
		});
		base2btn.setFont(new Font("Tahoma", Font.BOLD, 17));
		base2btn.setBackground(Color.YELLOW);
		base2btn.setBounds(159, 258, 54, 49);
		frame.getContentPane().add(base2btn);
		
		result = new JTextField();
		result.setHorizontalAlignment(SwingConstants.RIGHT);
		result.setFont(new Font("Tahoma", Font.BOLD, 11));
		result.setEditable(false);
		result.setBounds(0, 48, 213, 20);
		frame.getContentPane().add(result);
		result.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 213, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Helper Functions");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNsnsdc = new JMenuItem("convert_to_binary");
		mntmNsnsdc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = result.getText();
				int a = (int)Double.parseDouble(s);
				String binarys = Integer.toString(a, 2);
				result.setText(binarys);
				System.out.println(a);
			}
		});
		mnNewMenu.add(mntmNsnsdc);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Is_prime?");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int i,m=0,flag=0; 
					int n = (int)Double.parseDouble(result.getText());

				 // int n=17;//it is the number to be checked  
				  m=(int)Math.sqrt(n);    
				  for(i=2;i<=m;i++){    
				   if(n%i==0){    
				   result.setText("Number is not prime");    
				   flag=1;    
				   break;    
				   }    
				  }    
				  if(flag==0)    
				  result.setText("Number is prime");    
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
	}
}
