package balloon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.Color;

public class BalloonGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Icon[] allIcons;
	private Random rand = new Random(17);
	private Balloon balloonA;
	private JButton btnBalloonA;
	private Balloon balloonB;
	private JButton btnBalloonB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalloonGui frame = new BalloonGui();
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
	public BalloonGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// initialize
		initAllIcons();
		
		JLabel titleLabel = newTitleLabel();
		contentPane.add(titleLabel, BorderLayout.NORTH);
		
		JPanel controlPanel = newControlPanel();
		
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		
		JPanel mainPanel = newMainPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
	}

	private void initAllIcons() {
		allIcons = new ImageIcon[] {
			new ImageIcon(getClass().getResource("images/balloon20.jpg")),
			new ImageIcon(getClass().getResource("images/balloon40.jpg")),
			new ImageIcon(getClass().getResource("images/balloon60.jpg")),
			new ImageIcon(getClass().getResource("images/balloon80.jpg")),
			new ImageIcon(getClass().getResource("images/balloon100.jpg"))
		};
				
	}

	private JPanel newMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 2, 6, 0));
		
		balloonA = newRandomBalloon();
		btnBalloonA = new JButton(balloonA.toString(), balloonA.getIcon());
		initBalloonButton(btnBalloonA);
		mainPanel.add(btnBalloonA);
		
		balloonB = newRandomBalloon();
		btnBalloonB = new JButton(balloonB.toString(), balloonB.getIcon());
		initBalloonButton(btnBalloonB);
		mainPanel.add(btnBalloonB);
		
		return mainPanel;
	}

	private void initBalloonButton(JButton balloonButton) {
		balloonButton.setForeground(Color.GRAY);
		balloonButton.setHorizontalTextPosition(SwingConstants.CENTER);
		balloonButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		balloonButton.setFont(new Font(null, Font.BOLD, 24));
		balloonButton.setFocusable(false);
		balloonButton.setBackground(Color.WHITE);
	}

	private Balloon newRandomBalloon() {
		Size[] allSizes = Size.values();
		int randIndex = rand.nextInt(allSizes.length);
		
		Size size = allSizes[randIndex];
		boolean helium = rand.nextBoolean();
		Icon icon = allIcons[randIndex];
		
		return new Balloon(size, helium, icon);
	}

	private JPanel newControlPanel() {
		JPanel controlPanel = new JPanel();
		
		JButton btnGetRandomBalloons = new JButton("Get Random Balloons");
		btnGetRandomBalloons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balloonA = newRandomBalloon();
				btnBalloonA.setText(balloonA.toString());
				btnBalloonA.setIcon(balloonA.getIcon());
				
				balloonB = newRandomBalloon();
				btnBalloonB.setText(balloonB.toString());
				btnBalloonB.setIcon(balloonB.getIcon());
				
				if (balloonA.equals(balloonB)){
					textField.setText("   EQUAL!!");
					textField.setBackground(Color.ORANGE);
				} else {
					textField.setText("   Not Equal");
					textField.setBackground(null);
				}
			}
		});
		controlPanel.add(btnGetRandomBalloons);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		controlPanel.add(textField);
		return controlPanel;
	}

	private JLabel newTitleLabel() {
		JLabel titleLabel = new JLabel("titleLabel");
		titleLabel.setBorder(new EmptyBorder(8, 8, 8, 8));
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return titleLabel;
	}

}
