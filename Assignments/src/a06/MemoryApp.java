package a06;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryApp extends JFrame {

	private JPanel contentPane;
	private JButton btnRow1Col1;
	private JButton btnRow1Col2;
	private JButton btnRow1Col3;
	private JButton btnRow1Col4;
	private JButton btnRow2Col1;
	private JButton btnRow2Col2;
	private JButton btnRow2Col3;
	private JButton btnRow2Col4;
	private JButton btnRow3Col1;
	private JButton btnRow3Col2;
	private JButton btnRow3Col3;
	private JButton btnRow3Col4;
	private ArrayList<ImageIcon> allIcons = new ArrayList<ImageIcon>();
	//private Icon[] allIcons;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoryApp frame = new MemoryApp();
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
	public MemoryApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		initAllIcons();
		
		Collections.shuffle(allIcons);
		
		JLabel titleLabel = newTitleLabel();
		contentPane.add(titleLabel, BorderLayout.NORTH);
		
		JPanel mainPanel = newMainPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
	}

	private void initAllIcons() {
		ImageIcon icon1 = new ImageIcon(getClass().getResource("images/cat1.jpg"));
		ImageIcon icon2 = new ImageIcon(getClass().getResource("images/cat2.jpg"));
		ImageIcon icon3 = new ImageIcon(getClass().getResource("images/cat3.jpg"));
		ImageIcon icon4 = new ImageIcon(getClass().getResource("images/cat4.jpg"));
		ImageIcon icon5 = new ImageIcon(getClass().getResource("images/cat5.jpg"));
		ImageIcon icon6 = new ImageIcon(getClass().getResource("images/cat6.jpg"));
		
		Image img1 = icon1.getImage();
		Image img2 = icon2.getImage();
		Image img3 = icon3.getImage();
		Image img4 = icon4.getImage();
		Image img5 = icon5.getImage();
		Image img6 = icon6.getImage();
		
		Image newimg1 = img1.getScaledInstance(187, 209, java.awt.Image.SCALE_SMOOTH);
		Image newimg2 = img2.getScaledInstance(187, 209, java.awt.Image.SCALE_SMOOTH);
		Image newimg3 = img3.getScaledInstance(187, 209, java.awt.Image.SCALE_SMOOTH);
		Image newimg4 = img4.getScaledInstance(187, 209, java.awt.Image.SCALE_SMOOTH);
		Image newimg5 = img5.getScaledInstance(187, 209, java.awt.Image.SCALE_SMOOTH);
		Image newimg6 = img6.getScaledInstance(187, 209, java.awt.Image.SCALE_SMOOTH);
		
		ImageIcon newIcon1 = new ImageIcon(newimg1);
		ImageIcon newIcon2 = new ImageIcon(newimg2);
		ImageIcon newIcon3 = new ImageIcon(newimg3);
		ImageIcon newIcon4 = new ImageIcon(newimg4);
		ImageIcon newIcon5 = new ImageIcon(newimg5);
		ImageIcon newIcon6 = new ImageIcon(newimg6);
		
		allIcons.add(newIcon1);
		allIcons.add(newIcon1);
		allIcons.add(newIcon2);
		allIcons.add(newIcon2);
		allIcons.add(newIcon3);
		allIcons.add(newIcon3);
		allIcons.add(newIcon4);
		allIcons.add(newIcon4);
		allIcons.add(newIcon5);
		allIcons.add(newIcon5);
		allIcons.add(newIcon6);
		allIcons.add(newIcon6);
	}

	private JPanel newMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setLayout(new GridLayout(3, 4, 10, 10));
		
		btnRow1Col1 = new JButton();
		btnRow1Col1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow1Col1, 0);
			}
		});
		mainPanel.add(btnRow1Col1);
		
		btnRow1Col2 = new JButton();
		btnRow1Col2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow1Col2, 1);
			}
		});
		mainPanel.add(btnRow1Col2);
		
		btnRow1Col3 = new JButton();
		btnRow1Col3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow1Col3, 2);
			}
		});
		mainPanel.add(btnRow1Col3);
		
		btnRow1Col4 = new JButton();
		btnRow1Col4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow1Col4, 3);
			}
		});
		mainPanel.add(btnRow1Col4);
		
		btnRow2Col1 = new JButton();
		btnRow2Col1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow2Col1, 4);
			}
		});
		mainPanel.add(btnRow2Col1);
		
		btnRow2Col2 = new JButton();
		btnRow2Col2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow2Col2, 5);
			}
		});
		mainPanel.add(btnRow2Col2);
		
		btnRow2Col3 = new JButton();
		btnRow2Col3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow2Col3, 6);
			}
		});
		mainPanel.add(btnRow2Col3);
		
		btnRow2Col4 = new JButton();
		btnRow2Col4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow2Col4, 7);
			}
		});
		mainPanel.add(btnRow2Col4);
		
		btnRow3Col1 = new JButton();
		btnRow3Col1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow3Col1, 8);
			}
		});
		mainPanel.add(btnRow3Col1);
		
		btnRow3Col2 = new JButton();
		btnRow3Col2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow3Col2, 9);
			}
		});
		mainPanel.add(btnRow3Col2);
		
		btnRow3Col3 = new JButton();
		btnRow3Col3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow3Col3, 10);
			}
		});
		mainPanel.add(btnRow3Col3);
		
		btnRow3Col4 = new JButton();
		btnRow3Col4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipIcon(btnRow3Col4, 11);
			}
		});
		mainPanel.add(btnRow3Col4);
		return mainPanel;
	}

	private JLabel newTitleLabel() {
		JLabel titleLabel = new JLabel("Memory Game");
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		titleLabel.setForeground(Color.LIGHT_GRAY);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return titleLabel;
	}
	
	private void flipIcon(JButton btn, int i) {
		if (btn.getIcon() == null) {
			btn.setIcon(allIcons.get(i));
		} else {
			btn.setIcon(null);
		}
	}

}
