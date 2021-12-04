package TheaterView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Login_UI extends JFrame {

	private JPanel contentPane;
	private JTextField usernameInput;
	private JTextField passwordInput;
	private JButton Login;
	public JButton ContinueAsGuest;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_UI window = new Login_UI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setTitle("Authentication");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameInput = new JTextField();
		usernameInput.setBounds(136, 78, 136, 20);
		contentPane.add(usernameInput);
		usernameInput.setColumns(10);
		
		passwordInput = new JTextField();
		passwordInput.setBounds(136, 129, 136, 20);
		contentPane.add(passwordInput);
		passwordInput.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(136, 53, 127, 14);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(136, 109, 72, 14);
		contentPane.add(passwordLabel);
		
		Login = new JButton("Login");
		
		// When Button is pressed 
//		Login.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null,"Movie Update: Spiderman No Way Home in Theaters on December 17th!!", "Latest News for Registered User!",JOptionPane.PLAIN_MESSAGE);
//				setVisible(false);
//				Movie_UI frame = new Movie_UI();
//				frame.setVisible(true);
//			}
//		});
		
		Login.setBounds(105, 186, 89, 23);
		contentPane.add(Login);
		
		ContinueAsGuest = new JButton("Continue as Guest");
		ContinueAsGuest.setBounds(214, 186, 145, 23);
		contentPane.add(ContinueAsGuest);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		separator.setBounds(95, 35, 260, 130);
		contentPane.add(separator);
	}

	public void addLoginListener(ActionListener listener) {
		Login.addActionListener(listener);
	}

	public void addGuestListener(ActionListener listener) {
		ContinueAsGuest.addActionListener(listener);
	}
	public String getUsernameInput() {
		return usernameInput.getText();
	}
	public String getPasswordInput() {
		return passwordInput.getText();
	}
	
	public void clearall() {
		usernameInput.setText("");
		passwordInput.setText("");
	}
}
