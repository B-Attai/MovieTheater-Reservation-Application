package TheaterView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ticket_UI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public Ticket_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Ticket Information");
		titleLabel.setBounds(30, 23, 132, 14);
		contentPane.add(titleLabel);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(103, 97, 94, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(222, 97, 120, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("TicketID");
		lblNewLabel_1.setBounds(103, 137, 94, 22);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(222, 137, 120, 22);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Movie");
		lblNewLabel_2.setBounds(103, 179, 94, 22);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(222, 179, 120, 22);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Showtime");
		lblNewLabel_3.setBounds(103, 222, 94, 22);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(222, 222, 120, 22);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cost");
		lblNewLabel_4.setBounds(103, 265, 94, 22);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(222, 265, 120, 22);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date");
		lblNewLabel_5.setBounds(105, 308, 94, 22);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(222, 308, 120, 22);
		contentPane.add(textField_5);
		
		JButton requestRefundButton = new JButton("Request Refund");
		requestRefundButton.setVisible(false);
		requestRefundButton.setBounds(158, 371, 127, 23);
		contentPane.add(requestRefundButton);
		
		JButton printReceiptButton = new JButton("Print Receipt");
		printReceiptButton.setVisible(false);
		printReceiptButton.setBounds(158, 371, 127, 23);
		contentPane.add(printReceiptButton);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		separator.setBounds(40, 48, 363, 447);
		contentPane.add(separator);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket_UI frame = new Ticket_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
