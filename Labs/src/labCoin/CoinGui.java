package labCoin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class CoinGui extends JFrame {
	private JPanel contentPane;
	private JLabel mainLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoinGui frame = new CoinGui();
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
	public CoinGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel menuPanel = new JPanel();
		newMenuPanel(menuPanel);
		
		mainLabel = new JLabel("Select a coin");
		mainLabel.setBackground(Color.LIGHT_GRAY);
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setFont(new Font("Dialog", Font.BOLD, 32));
		mainLabel.setOpaque(true);
		contentPane.add(mainLabel, BorderLayout.CENTER);
	}

	private void newMenuPanel(JPanel menuPanel) {
		contentPane.add(menuPanel, BorderLayout.NORTH);
		menuPanel.setLayout(new GridLayout(1, 4, 0, 0));
		
		JRadioButton rdbtnPenny = new JRadioButton("");
		rdbtnPenny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText(Coin.CENT.toString());
			}
		});
		rdbtnPenny.setIcon(new ImageIcon(CoinGui.class.getResource("/labCoin/images/UsCent.png")));
		menuPanel.add(rdbtnPenny);
		
		JRadioButton rdbtnNickel = new JRadioButton("");
		rdbtnNickel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText(Coin.NICKEL.toString());
				
			}
		});
		rdbtnNickel.setIcon(new ImageIcon(CoinGui.class.getResource("/labCoin/images/UsNickel.png")));
		menuPanel.add(rdbtnNickel);
		
		JRadioButton rdbtnDime = new JRadioButton("");
		rdbtnDime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText(Coin.DIME.toString());
			}
		});
		rdbtnDime.setIcon(new ImageIcon(CoinGui.class.getResource("/labCoin/images/UsDime.png")));
		menuPanel.add(rdbtnDime);
		
		JRadioButton rdbtnQuarter = new JRadioButton("");
		rdbtnQuarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText(Coin.QUARTER.toString());
			}
		});
		rdbtnQuarter.setIcon(new ImageIcon(CoinGui.class.getResource("/labCoin/images/UsQuarter.png")));
		menuPanel.add(rdbtnQuarter);
	}

}
