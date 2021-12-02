package TheaterView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class Main_UI extends JFrame {

	private JPanel contentPane;
	private JTextField movienameInput;
	private JComboBox seatRowComboBoxInput;
	private JComboBox SeatColComboBoxInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_UI frame = new Main_UI();
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
	public Main_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 387);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(1440, 960));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPanel = new JLayeredPane();
		layeredPanel.setBounds(15, 11, 440, 326);
		contentPane.add(layeredPanel);
		
		JPanel moviePanel = new JPanel();
		moviePanel.setVerifyInputWhenFocusTarget(false);
		moviePanel.setVisible(false);
		layeredPanel.setLayout(new CardLayout(0, 0));
		layeredPanel.add(moviePanel, "name_193734830248700");
		moviePanel.setLayout(null);
		
		Button searchButton = new Button("Search");

		searchButton.setBounds(168, 83, 79, 22);
		moviePanel.add(searchButton);
		
		movienameInput = new JTextField();
		movienameInput.setBounds(168, 53, 175, 20);
		moviePanel.add(movienameInput);
		movienameInput.setColumns(10);
		
		JButton movieButton = new JButton("Confirm Selection");

		movieButton.setBounds(121, 254, 171, 23);
		moviePanel.add(movieButton);
		
		JLabel lblNewLabel_2 = new JLabel("Movie Name");
		lblNewLabel_2.setBounds(88, 55, 84, 14);
		moviePanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Movie Selection");
		lblNewLabel.setBounds(28, 11, 117, 28);
		moviePanel.add(lblNewLabel);
		
		JTextArea movieDisplayTextArea = new JTextArea();
		movieDisplayTextArea.setBounds(88, 123, 257, 123);
		moviePanel.add(movieDisplayTextArea);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		separator.setBounds(10, 11, 406, 292);
		moviePanel.add(separator);
		
		JPanel showtimePanel = new JPanel();

		showtimePanel.setVerifyInputWhenFocusTarget(false);
		layeredPanel.add(showtimePanel, "name_193734839386700");
		showtimePanel.setLayout(null);
		
		JButton showtimeButton = new JButton("Confirm Showtime");

		showtimeButton.setBounds(143, 213, 140, 23);
		showtimePanel.add(showtimeButton);
		
		JLabel lblNewLabel_1 = new JLabel("Showtime Selection");
		lblNewLabel_1.setBounds(28, 15, 140, 14);
		showtimePanel.add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 38, 371, 240);
		showtimePanel.add(separator_1);
		separator_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		
		JList showtimeList = new JList();
		showtimeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		showtimeList.setBounds(98, 80, 216, 110);
		showtimePanel.add(showtimeList);
		
		JPanel seatPanel = new JPanel();
		layeredPanel.add(seatPanel, "name_193734848070300");
		seatPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Seat Selection");
		lblNewLabel_3.setBounds(30, 25, 93, 14);
		seatPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Show Available Seats");
		lblNewLabel_4.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(107, 87, 215, 47);
		seatPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Row");
		lblNewLabel_5.setBounds(139, 192, 46, 14);
		seatPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Column");
		lblNewLabel_6.setBounds(139, 217, 46, 14);
		seatPanel.add(lblNewLabel_6);
		
		seatRowComboBoxInput = new JComboBox();
		seatRowComboBoxInput.setBounds(229, 188, 48, 22);
		seatPanel.add(seatRowComboBoxInput);
		
		SeatColComboBoxInput = new JComboBox();
		SeatColComboBoxInput.setBounds(229, 213, 48, 22);
		seatPanel.add(SeatColComboBoxInput);
		
		JButton seatButton = new JButton("Confirm Seat");

		seatButton.setBounds(164, 266, 113, 23);
		seatPanel.add(seatButton);
		
		JPanel buyPanel = new JPanel();
		layeredPanel.add(buyPanel, "name_193734857170300");
		buyPanel.setLayout(null);
		
		JButton buyButton = new JButton("Buy Ticket");
		buyButton.setBounds(141, 223, 138, 43);
		buyPanel.add(buyButton);
		buyButton.setBackground(Color.WHITE);
		
		JTextArea ConfirmationSummaryTextArea = new JTextArea();
		ConfirmationSummaryTextArea.setBounds(52, 33, 316, 157);
		buyPanel.add(ConfirmationSummaryTextArea);
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		// Next Page Listeners
		// These listeners should be in the UI (and not in the controller) since they are just changing pages
		// The controller s hould listen to the Buy seat
		
		
		// This should query and display all movies according to that list
		// Update or set text in 
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		movieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPanel.removeAll();
				layeredPanel.add(showtimePanel);
				showtimePanel.setVisible(true);
				layeredPanel.repaint();
			}
		});
		
		
		showtimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPanel.removeAll();
				layeredPanel.add(seatPanel);
				seatPanel.setVisible(true);
				layeredPanel.repaint();
			}
		});
		
		seatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPanel.removeAll();
				layeredPanel.add(buyPanel);
				buyPanel.setVisible(true);
				layeredPanel.repaint();
			}
		});
		
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Make controller get everything
			}
		});
	}
	
	
	
	// Getters and Setters
	public JTextField getMovienameInput() {
		return movienameInput;
	}
	public JComboBox getSeatRowComboBoxInput() {
		return seatRowComboBoxInput;
	}
	public JComboBox getSeatColComboBoxInput() {
		return SeatColComboBoxInput;
	}
}
