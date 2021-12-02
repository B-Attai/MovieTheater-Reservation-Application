package TheaterView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Menu_UI extends JFrame {

	private JPanel contentPane;
	private JButton RefundButton;
	private JButton buyButton;
	private JButton goBackButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_UI frame = new Menu_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RefundButton = new JButton("Request Refund");

		RefundButton.setBounds(136, 179, 148, 23);
		contentPane.add(RefundButton);
		
		buyButton = new JButton("Buy or View movies");

		buyButton.setBounds(136, 117, 148, 23);
		contentPane.add(buyButton);
		
		goBackButton = new JButton("Go Back to Login");

		goBackButton.setBounds(136, 57, 148, 23);
		contentPane.add(goBackButton);
		
	}
	// Event Listeners
	public void addLoginListener(ActionListener listener) {
		goBackButton.addActionListener(listener);
		// TODO Auto-generated method stub
		
	}

	public void addMovieListener(ActionListener listener) {
		buyButton.addActionListener(listener);
		
	}

	public void addRefundListener(ActionListener listener) {
		RefundButton.addActionListener(listener);
		
	}
}
