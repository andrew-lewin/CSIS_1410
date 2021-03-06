package guiWindowBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class LabGUIWindowBuilder extends JFrame {

	private JPanel contentPane;
	private JLabel mainLabel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGUIWindowBuilder frame = new LabGUIWindowBuilder();
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
	public LabGUIWindowBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane();
		setContentPane(contentPane);
		
		JLabel lblTitle = setJLabel();
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		newMainLabel();
		contentPane.add(mainLabel, BorderLayout.CENTER);
		
		
		JPanel controlPanel = newControlPanel();
		contentPane.add(controlPanel, BorderLayout.WEST);
	}

	private JPanel newControlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EmptyBorder(10, 7, 3, 7));
		controlPanel.setLayout(new GridLayout(7, 1, 0, 0));
		{
			JRadioButton rdbtnForegroundRadioButton = new JRadioButton("foreGround");
			buttonGroup.add(rdbtnForegroundRadioButton);
			rdbtnForegroundRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					JRadioButton radioButton = (JRadioButton) e.getSource();
//					if (radioButton.isSelected()){
//						mainLabel.setForeground(Color.RED);
//					} else {
//						mainLabel.setForeground(Color.BLACK);
//					}
					if (mainLabel.getForeground() == Color.BLACK){
						mainLabel.setForeground(Color.RED);
					} else {
						mainLabel.setForeground(Color.BLACK);
					}
				}
			});
			controlPanel.add(rdbtnForegroundRadioButton);
		}
		{
			JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
			buttonGroup.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					JRadioButton radioButton2 = (JRadioButton) e.getSource();
//					if (radioButton2.isSelected()){
//						mainLabel.setBackground(Color.GREEN);
//					} else {
//						mainLabel.setBackground(Color.YELLOW);
//					}
					if (mainLabel.getBackground() == Color.YELLOW){
						mainLabel.setBackground(Color.GREEN);
					} else {
						mainLabel.setBackground(Color.YELLOW);
					}
				}
			});
			controlPanel.add(rdbtnNewRadioButton);
		}
		{
			JButton btnNewButton = new JButton("Increment");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int number = Integer.parseInt(mainLabel.getText());
					number++;
					//mainLabel.setText(Integer.toString(number));
					mainLabel.setText(String.valueOf(number));
				}
			});
			controlPanel.add(btnNewButton);
		}
		return controlPanel;
	}

	private void newMainLabel() {
		mainLabel = new JLabel("10");
		mainLabel.setOpaque(true);
		mainLabel.setBackground(Color.YELLOW);
		mainLabel.setFont(new Font("Chiller", Font.BOLD, 77));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private JLabel setJLabel() {
		JLabel lblTitle = new JLabel("Title Label");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		lblTitle.setOpaque(true);
		lblTitle.setBackground(new Color(135, 206, 235));
		return lblTitle;
	}

	private void setContentPane() {
		contentPane = new JPanel();
		contentPane.setFont(new Font("Dialog", Font.PLAIN, 24));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
