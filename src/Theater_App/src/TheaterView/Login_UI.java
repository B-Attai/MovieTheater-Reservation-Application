package TheaterView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Login_UI {

	private JFrame frmAuthetication;
	private JTextField usernameInput;
	private JTextField passwordInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_UI window = new Login_UI();
					window.frmAuthetication.setVisible(true);
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
		frmAuthetication = new JFrame();
		frmAuthetication.setTitle("Authentication");
		frmAuthetication.setBounds(100, 100, 450, 300);
		frmAuthetication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuthetication.getContentPane().setLayout(null);
		
		usernameInput = new JTextField();
		usernameInput.setBounds(136, 78, 136, 20);
		frmAuthetication.getContentPane().add(usernameInput);
		usernameInput.setColumns(10);
		
		passwordInput = new JTextField();
		passwordInput.setBounds(136, 129, 136, 20);
		frmAuthetication.getContentPane().add(passwordInput);
		passwordInput.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(136, 53, 127, 14);
		frmAuthetication.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(136, 109, 72, 14);
		frmAuthetication.getContentPane().add(passwordLabel);
		
		JButton Login = new JButton("Login");
		
		// When Button is pressed 
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Movie Update: Spiderman No Way Home in Theaters on December 17th!!", "Latest News for Registered User!",JOptionPane.PLAIN_MESSAGE);
				frmAuthetication.setVisible(false);
				Main_UI frame = new Main_UI();
				frame.setVisible(true);
			}
		});
		Login.setBounds(105, 186, 89, 23);
		frmAuthetication.getContentPane().add(Login);
		
		JButton ContinueAsGuest = new JButton("Continue as Guest");
		ContinueAsGuest.setBounds(214, 186, 145, 23);
		frmAuthetication.getContentPane().add(ContinueAsGuest);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		separator.setBounds(95, 35, 260, 130);
		frmAuthetication.getContentPane().add(separator);
	}
}
