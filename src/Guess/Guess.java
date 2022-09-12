package Guess;

import java.awt.BorderLayout;
import java.util.*;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Guess extends JFrame implements KeyListener , MouseListener {

	static  JPanel contentPane;
	static  JTextField textField;
	static JTextArea textArea = new JTextArea();
	static JButton btnEnter = new JButton("重新開始");

	static int []a = shfful() ;
	//static int []c = shfful();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guess frame = new Guess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		Guess ff = new Guess();
		ff.textField.addKeyListener(ff);
		btnEnter.addMouseListener(ff);

	}

	/**
	 * Create the frame.
	 */
	public Guess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 234, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	   // JButton btnNewButton = new JButton("\u5E6B\u4F60\u731C!");
		//btnNewButton.setBounds(117, 26, 99, 28);
		//contentPane.add(btnNewButton);
		
		textArea.setBounds(0, 28, 216, 74);
		textArea.setText("");
		textArea.setEditable(true);
		contentPane.add(textArea);
		
		
		btnEnter.setBounds(117, 0, 99, 27);
		contentPane.add(btnEnter);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(0, 1, 116, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		textArea.setText("");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		String s;
		System.out.println(textField.getText());
		s = play(textField.getText());
		
		textArea.setText(s);
		
	}
	public static String play (String st) {
        if( st.length()== 0) {
        	return st;
        }
		
	    int [] ssum = new int[10];
	    int tho= 0;
	    int countA = 0;
	    int countB = 0;
		tho = Integer.parseInt(st);	

		ssum[3]= tho%10;
		tho = tho/10;
		ssum[2] = tho%10;
		tho = tho/10;
		ssum[1] = tho%10;
		tho = tho/10;
		ssum[0] = tho;

		if( st.length() != 4)
			st = "請輸入四位數!!" ;
		else {
		countA = testA(ssum , a);
		countB = testB(ssum ,a ,countA) ;
		st = countA+"A"+countB+"B" ;
		}
		if( countA == 4)
			st = "恭喜答對!!";
		return st;
		
	}
	///guessnumber 
	public static int  testA (int[] scan , int[] a) {
		int countA = 0;
		int countB = 0;
		for (int i = 0 ; i <4 ; i++ )
		{
			if(scan[i] == a[i] )
				countA++;
		}	
		return countA ;
	}
	public static int  testB (int[] scan , int[] a ,int countA) {
		int countB = 0 ;
		for(int i = 0 ; i <4 ; i++) {
			for(int j = 0 ; j<4 ; j++) {
				if(scan[i] == a[j])
					countB++;
			}
		}
		countB = countB-countA;
		return countB;
	}
	public static int[] shfful () {
		int []b = new int[4];
		List<Integer> w = new ArrayList<>();
		for(int i = 0 ; i <=9 ; i++) {
			w.add(i);
		}
		Collections.shuffle(w);
		for (int i = 0 ; i < 4 ; i++) {
			b[i] = w.get(i) ;
		}
		return b ;
		
	}

	public void mouseClicked(MouseEvent e ) {
		// TODO Auto-generated method stub
		//if( e.equals(btnEnter) )
		//{
		a = shfful();
		textArea.setText("���n�y") ;
	//	}
		/*if ( e.equals(btnNewButton)) {
			
	        String x =""+ c[0]+c[1]+c[2]+c[3] ;
			textField.setText(x);
			
		}*/
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
