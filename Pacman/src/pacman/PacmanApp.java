package pacman;
/*
 * @authors Andrew Lewin & Joshua Hardesty
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PacmanApp extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JPanel gamePanel;
	private static Pacman pacMan = new Pacman();
	private static Player p1;
	private static Random rand = new Random();
	public static Timer ghostSpawnTimer;
	public static Timer repaintTimer;
	public static Boolean didWin;
	
	// Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacmanApp frame = new PacmanApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame
	public PacmanApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, getGrid()[0].length * 50, getGrid().length * 50 );
		createNewContentPane();
		
		createNewStartPanel();
		addKeyListener(this);
		setFocusable(true);
		String name = JOptionPane.showInputDialog("We're not asking you to pay to play,\n"  +
												"but we would like your name today.\n" +
												"The game is simple, and has a nice groove.\n" +
												"You can use the arrow or WASD keys to move. \n\n" +
												"(We apologize for this pop-up)");
		p1 = new Player(name);
		startRepaintTimer();
		
	}

	// Create new Start Panel
	private void createNewStartPanel() {
		JPanel startPanel = new JPanel();
		startPanel.setBackground(Color.BLACK);
		contentPane.add(startPanel, BorderLayout.CENTER);
		startPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblPacman = new JLabel("Pacman", SwingConstants.CENTER);
		lblPacman.setOpaque(true);
		lblPacman.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblPacman.setBackground(Color.BLACK);
		lblPacman.setForeground(new Color(173, 250, 145));
		startPanel.add(lblPacman);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setBackground(Color.BLACK);
		btnStartGame.setForeground(new Color(173, 250, 145));
		btnStartGame.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				newGamePanel();
			}
		});
		startPanel.add(btnStartGame);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBackground(Color.BLACK);
		btnCredits.setForeground(new Color(173, 250, 145));
		btnCredits.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				createNewCreditPanel();
			}

		});
		startPanel.add(btnCredits);
	}
	
	// Create new credit panel
	private void createNewCreditPanel() {
		JPanel creditPanel = new JPanel();
		creditPanel.setBackground(Color.BLACK);
		creditPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblCredits = new JLabel("Credits", SwingConstants.CENTER);
		lblCredits.setOpaque(true);
		lblCredits.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblCredits.setBackground(Color.BLACK);
		lblCredits.setForeground(new Color(173, 250, 145));
		creditPanel.add(lblCredits);
		
		JTextArea txtAreaCreated = new JTextArea();
		txtAreaCreated.setFont(new Font("OCR A Extended", Font.BOLD, 36));
		txtAreaCreated.setBackground(Color.BLACK);
		txtAreaCreated.setForeground(new Color(173, 250, 145));
		txtAreaCreated.setText("Created and coded by,\nAndrew Lewin & Joshua Hardesty\n" + 
								"Music provided by Ryan Augustine");
		txtAreaCreated.setEditable(false);
		creditPanel.add(txtAreaCreated);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(new Color(173, 250, 145));
		btnBack.setFont(new Font("OCR A Extended", Font.BOLD, 32));
		btnBack.addActionListener(new ActionListener() {
			// Takes user back to the start panel
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				createNewStartPanel();
			}
		});
		creditPanel.add(btnBack);
		
		contentPane.add(creditPanel, BorderLayout.CENTER);
	}

	// Create new content pain
	private void createNewContentPane() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	// Create new game panel
	public static void newGamePanel() {
		gamePanel = new JPanel();
		gamePanel.setBackground(Color.WHITE);
		gamePanel.setLayout(new GridLayout(getGrid().length, getGrid()[0].length, 0, 0));
		newBoardResources(); // Adds walls and food to the board
		setJLabels(new JLabel(pacMan.getImage()), Pacman.getLocation()); // add pacMan to board
		new Sound(PacmanApp.class.getResource("resources/pacmantheme.wav")).loop(); // Initializes and loops song
		createGhost(); // add Ghost to board
		contentPane.add(gamePanel);
	}
	
	// Allocates where walls and food should be set
	private static void newBoardResources() {
		for (int i = 0; i < getGrid().length; i++) {
			for (int j = 0; j < getGrid()[0].length; j++) {
				if (getGrid()[i][j] == 0) {
					// Locates all 0's on the board and sets the label to the food icon
					JLabel food = new JLabel(Images.FOOD.getIcon(), SwingConstants.CENTER);
					gamePanel.add(food);
				} else {
					// Locates all 1's on the board and sets the label to the wall icon
					JLabel wall = new JLabel (Images.WALL.getIcon(), SwingConstants.CENTER);
					gamePanel.add(wall);
				}
			}
		}
	}
	
	// Moves PacMan
	private void movePacman(int direction) {
		// Check if next space is a wall or ghost on a wall
		ImageIcon nextJLabelImage = (ImageIcon) ((JLabel) gamePanel.getComponents()[Pacman.getLocation() + direction]).getIcon();
		if (nextJLabelImage != Images.WALL.getIcon() && nextJLabelImage != Images.BLACKGHOST.getIcon()) {
			// Check if next space has food
			if (nextJLabelImage == Images.FOOD.getIcon()) {
				p1.addScore();
			}
			// Check if pacman ran into a ghost
			if (nextJLabelImage == Images.WHITEGHOST.getIcon()) {
				setDidWin(false); // game over, lost
			}
			// Swap images
			((JLabel) gamePanel.getComponents()[Pacman.getLocation()]).setIcon(null);
			((JLabel) gamePanel.getComponents()[Pacman.getLocation() + direction]).setIcon(pacMan.getImage());
			pacMan.setLocation(Pacman.getLocation() + direction);
			// Check if you won
			int countOfFood = 0;
			for (Component component : gamePanel.getComponents()) {
				if (((JLabel) component).getIcon() == Images.FOOD.getIcon()) {
					countOfFood += 1;
				}
			}
			if (countOfFood == 0) {
				setDidWin(true); // game over, win
			}
		}
	}
	
	// Stop ghost attack, calls game over panel, calls read/write methods
	public static void setDidWin(boolean win) {
		didWin = win;
		p1.setHighScore();
		Ghost.stopAllAttack();
		stopGhostTimer();
		createNewGameOverPanel();
	}

	// Create board layout
	public static int[][] getGrid() {
		int[][] grid = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	        {1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,1},
	        {1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,1},
	        {1,0,0,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,1,0,1},
	        {1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
	        {1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,1},
	        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	        {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
	        {1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1},
	        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
	        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
	        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
	        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
	        {1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};
		return grid;
	}
		
	public static Component[] getJLabels() {
		return gamePanel.getComponents();
	}
		
	public static void setJLabels(JLabel label, int location) {
		gamePanel.remove(location);
		gamePanel.add(label, location);
	}
		
	public static void createGhost() {
		ghostSpawnTimer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int nextFireLocation = (rand.nextInt(3) - 1) + (Pacman.getLocation() % getGrid()[0].length);
				new Ghost(nextFireLocation, getGrid()[0].length, getGrid().length);
			}
		});
		ghostSpawnTimer.start();
	}
		
	// Stops the ghost timer
	public static void stopGhostTimer() {
		ghostSpawnTimer.stop();
	}
		
	public void startRepaintTimer() {
		repaintTimer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				revalidate();
				repaint();
			}
		});
		repaintTimer.start();
	}
		
	// Stops the repaint timer
	public static void stopRepaintTimer() {
		repaintTimer.stop();
	}
	
	// Game Over Panel
	public static void createNewGameOverPanel() {  
		contentPane.removeAll();
		// Create game over panel and set layout
		JPanel gameOverPanel = new JPanel();
		gameOverPanel.setBackground(Color.BLACK);
		gameOverPanel.setLayout(new GridLayout(4, 1, 0, 0));
			
		// title panel
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		gameOverPanel.add(titlePanel);
		titlePanel.setLayout(new GridLayout(0, 3, 0, 0));
			
		// left image
		JLabel lblLeftImage = new JLabel(Images.GAMEOVERPACMAN.getIcon(), SwingConstants.CENTER);
		titlePanel.add(lblLeftImage);
			
		// game over title
		JLabel lblGameOver = new JLabel(didWin ? "YOU WIN" : "YOU DEAD", SwingConstants.CENTER);
		lblGameOver.setOpaque(true);
		lblGameOver.setForeground(Color.WHITE);
		lblGameOver.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblGameOver.setBackground(Color.BLACK);
		titlePanel.add(lblGameOver);
			
		// right image
		JLabel lblRightImage = new JLabel(Images.GAMEOVERGHOST.getIcon(), SwingConstants.CENTER);
		titlePanel.add(lblRightImage);
			
		// stats panel: name and score
		JPanel statsPanel = new JPanel();
		statsPanel.setBackground(Color.BLACK);
		gameOverPanel.add(statsPanel);
		statsPanel.setLayout(new GridLayout(2, 2, 0, 0));
			
		// Player Label
		JLabel lblPlayer = new JLabel("Player:", SwingConstants.CENTER);
		lblPlayer.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblPlayer.setBackground(Color.BLACK);
		lblPlayer.setForeground(Color.WHITE);
		lblPlayer.setOpaque(true);
		statsPanel.add(lblPlayer);
			
		// Player's Name
		JLabel lblPlayername = new JLabel(" " + p1.getName(), SwingConstants.CENTER);
		lblPlayername.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblPlayername.setBackground(Color.BLACK);
		lblPlayername.setForeground(new Color(173, 250, 145));
		lblPlayername.setOpaque(true);
		statsPanel.add(lblPlayername);
			
		// Score Label
		JLabel lblScore = new JLabel("Score:", SwingConstants.CENTER);
		lblScore.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblScore.setBackground(Color.BLACK);
		lblScore.setForeground(Color.WHITE);
		lblScore.setOpaque(true);
		statsPanel.add(lblScore);
			
		// Player's Score
		JLabel lblPoints = new JLabel(" " + p1.getScore(), SwingConstants.CENTER);
		lblPoints.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblPoints.setBackground(Color.BLACK);
		lblPoints.setForeground(new Color(173, 250, 145));
		lblPoints.setOpaque(true);
		statsPanel.add(lblPoints);
			
		// Play again panel
		JPanel playAgainPanel = new JPanel();
		playAgainPanel.setBorder(null);
		playAgainPanel.setBackground(Color.BLACK);
		gameOverPanel.add(playAgainPanel);
		playAgainPanel.setLayout(new GridLayout(0, 3, 0, 0));
			
		// Play again label
		JLabel lblPlayAgain = new JLabel("Play Again?", SwingConstants.CENTER);
		lblPlayAgain.setFont(new Font("OCR A Extended", Font.BOLD, 13));
		lblPlayAgain.setBackground(Color.BLACK);
		lblPlayAgain.setForeground(Color.WHITE);
		lblPlayAgain.setOpaque(true);
		playAgainPanel.add(lblPlayAgain);
			
		// Yes Button resets the the player's score to 0 and resets the main panel to the board
		JButton btnYes = new JButton("YES");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				gamePanel.removeAll();
				p1.setScore(0);
				newBoardResources(); // Adds walls and food to the board
				Pacman.reset();
				setJLabels(new JLabel(pacMan.getImage()), Pacman.getLocation()); // add pacMan to board
				createGhost(); // add Ghost to board
				contentPane.add(gamePanel);
			}
		});
		btnYes.setFont(new Font("OCR A Extended", Font.BOLD, 13));
		btnYes.setForeground(new Color(173, 250, 145));
		btnYes.setBackground(Color.BLACK);
		playAgainPanel.add(btnYes);
			
		// No Button exits the game
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNo.setBackground(Color.BLACK);
		btnNo.setForeground(new Color(173, 250, 145));
		btnNo.setFont(new Font("OCR A Extended", Font.BOLD, 13));
		playAgainPanel.add(btnNo);

		JLabel txtAreaResults = new JLabel("High Score: " + Integer.toString(p1.getHighScore()));
		txtAreaResults.setHorizontalAlignment(SwingConstants.CENTER);
		txtAreaResults.setBackground(Color.BLACK);
		txtAreaResults.setForeground(new Color(173, 250, 145));
		txtAreaResults.setFont(new Font("OCR A Extended", Font.BOLD, 13));
		txtAreaResults.setOpaque(true);
		gameOverPanel.add(txtAreaResults);
			
		contentPane.add(gameOverPanel, BorderLayout.CENTER);
	}
	
	// Controls to move Pacman
	@Override
	public void keyPressed(KeyEvent e) {
		if      (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			// Moving left & changing ImageIcon orientation
			pacMan.setImage(Images.PACKMANLEFT.getIcon());
			movePacman(-1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			// Moving up & changing ImageIcon orientation
			pacMan.setImage(Images.PACKMANUP.getIcon());
			movePacman((getGrid()[0].length) * -1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			// Moving right & changing ImageIcon orientation
			pacMan.setImage(Images.PACKMANRIGHT.getIcon());
			movePacman(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			// Moving down & changing ImageIcon orientation
			pacMan.setImage(Images.PACKMANDOWN.getIcon());
			movePacman(getGrid()[0].length);
		}
	}

	// Method not used, but must be left to properly implement KeyListener
	@Override
	public void keyReleased(KeyEvent arg0) {}

	//  Method not used, but must be left to properly implement KeyListener
	@Override
	public void keyTyped(KeyEvent arg0) {}	

}
