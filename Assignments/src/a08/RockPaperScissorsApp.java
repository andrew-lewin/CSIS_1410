package a08;

/**
 * Andrew Lewin
 * CSIS 1410
 * Assignment 8
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsApp extends JFrame {

	private JPanel contentPane;
	private JPanel scorePanel;
	private JPanel rockPaperScissorsPanel;
	private JPanel rockPaperScissorsLizardSpockPanel;
	private JPanel showResultsPanel;
	private JPanel countdownPanel;
	private JPanel statisticsPanel;
	private JLabel userScoreLabel;
	private JLabel computerScoreLabel;
	private JLabel titleLabel;
	
	static RockPaperScissors playerChoice;
	static RockPaperScissors cpuChoice;
	
	private RockPaperScissors cpuChoices[] = {
				RockPaperScissors.ROCK, RockPaperScissors.PAPER, RockPaperScissors.SCISSORS};
	private RockPaperScissors cpuChoicesLizardSpock[] = {
				RockPaperScissors.ROCK, RockPaperScissors.PAPER,
				RockPaperScissors.SCISSORS, RockPaperScissors.LIZARD, RockPaperScissors.SPOCK };
	private Random rand = new Random();
	private int userScore = 0;
	private int computerScore = 0;
	private JLabel lblCountdown;
	private JLabel lblResultTextResult;
	private JLabel lblCpuChoiceResult;
	private JLabel lblPlayerChoiceResult;
	private int cpuChoiceCount;
	private int numberOfGames;
	private int winStreak;
	private int loseStreak;
	private int winStreakChecker;
	private int loseStreakChecker;
	private JLabel gamesWonNumber;
	private JLabel gamesTiedNumber;
	private JLabel gamesLostNumber;
	private JLabel totalGamesNumber;
	private JLabel percentWonNumber;
	private JLabel percentLostNumber;
	private JLabel longestWinStreakNumber;
	private JLabel longestLoseStreakNumber;
	private JPanel welcomePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RockPaperScissorsApp frame = new RockPaperScissorsApp();
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
	public RockPaperScissorsApp() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 525);
		
		createMenu();
		createScorePanel();
		createPanelRockPaperScissors();
		createPanelRockPaperScissorsLizardSpock();
		createPanelCountdown();
		createShowResultsPanel();
		createStatisticsPanel();
		createWelcomePanel();
		
		createContentPane();
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmRockPaperScissors = new JMenuItem("Rock Paper Scissors");
		mntmRockPaperScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				titleLabel.setText("Rock Paper Scissors");
				contentPane.add(scorePanel, BorderLayout.SOUTH);
				contentPane.add(titleLabel, BorderLayout.NORTH);
				contentPane.add(rockPaperScissorsPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		mntmRockPaperScissors.setPreferredSize(new Dimension(200, 20));
		menuBar.add(mntmRockPaperScissors);
		
		JMenuItem mntmRockPaperScissorsLizardSpock = new JMenuItem("Rock Paper Scissors Lizard Spock");
		mntmRockPaperScissorsLizardSpock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				titleLabel.setText("Rock Paper Scissors Lizard Spock");
				contentPane.add(scorePanel, BorderLayout.SOUTH);
				contentPane.add(titleLabel, BorderLayout.NORTH);
				contentPane.add(rockPaperScissorsLizardSpockPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		mntmRockPaperScissorsLizardSpock.setPreferredSize(new Dimension(325, 20));
		menuBar.add(mntmRockPaperScissorsLizardSpock);
		
		JMenuItem mntmStatistics = new JMenuItem("Statistics");
		mntmStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gamesTied = numberOfGames - (userScore + computerScore);
				double percentWon = (double) userScore / numberOfGames * 100;
				double percentLost = (double) computerScore / numberOfGames * 100;
				titleLabel.setText("Statistics");
				gamesWonNumber.setText(Integer.toString(userScore));
				gamesTiedNumber.setText(Integer.toString(gamesTied));
				gamesLostNumber.setText(Integer.toString(computerScore));
				totalGamesNumber.setText(Integer.toString(numberOfGames));
				percentWonNumber.setText(String.format("%.2f%%", percentWon));
				percentLostNumber.setText(String.format("%.2f%%", percentLost));
				longestWinStreakNumber.setText(Integer.toString(winStreak));
				longestLoseStreakNumber.setText(Integer.toString(loseStreak));
				contentPane.removeAll();
				contentPane.add(titleLabel, BorderLayout.NORTH);
				contentPane.add(statisticsPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		mntmStatistics.setPreferredSize(new Dimension(175, 20));
		menuBar.add(mntmStatistics);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setPreferredSize(new Dimension(75, 20));
		menuBar.add(mntmExit);
	}

	private void createContentPane() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(welcomePanel);
		
		titleLabel = new JLabel("How to Play");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		contentPane.add(titleLabel, BorderLayout.NORTH);
	}
	
	private void createShowResultsPanel() {
		showResultsPanel = new JPanel();
		showResultsPanel.setBackground(Color.WHITE);
		showResultsPanel.setLayout(new GridLayout(2, 0));
		
		JPanel showIconResultsPanel = new JPanel();
		showIconResultsPanel.setBackground(Color.WHITE);
		showIconResultsPanel.setLayout(new GridLayout(0, 3));
		
		JPanel showTextResultsPanel = new JPanel();
		showTextResultsPanel.setBackground(Color.WHITE);
		showTextResultsPanel.setLayout(new BorderLayout());
		
		showResultsPanel.add(showIconResultsPanel);
		showResultsPanel.add(showTextResultsPanel);
		
		lblPlayerChoiceResult = new JLabel("Your choice");
		lblPlayerChoiceResult.setBackground(Color.WHITE);
		lblPlayerChoiceResult.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlayerChoiceResult.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlayerChoiceResult.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblPlayerChoiceResult.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JLabel lblVs = new JLabel("<html><br>VS</html>");
		lblVs.setBackground(Color.WHITE);
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblVs.setVerticalAlignment(SwingConstants.CENTER);
		lblVs.setFont(new Font("Dialog", Font.BOLD, 36));
		
		lblCpuChoiceResult = new JLabel("CPU's choice");
		lblCpuChoiceResult.setBackground(Color.WHITE);
		lblCpuChoiceResult.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpuChoiceResult.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCpuChoiceResult.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCpuChoiceResult.setHorizontalTextPosition(SwingConstants.CENTER);
		
		showIconResultsPanel.add(lblPlayerChoiceResult);
		showIconResultsPanel.add(lblVs);
		showIconResultsPanel.add(lblCpuChoiceResult);
		
		lblResultTextResult = new JLabel("", SwingConstants.CENTER);
		lblResultTextResult.setVerticalAlignment(SwingConstants.CENTER);
		lblResultTextResult.setVerticalTextPosition(SwingConstants.CENTER);
		lblResultTextResult.setBackground(Color.WHITE);
		lblResultTextResult.setFont(new Font("Dialog", Font.ITALIC, 24));
		
		showTextResultsPanel.add(lblResultTextResult);
	}
	
	private void createPanelCountdown() {
		countdownPanel = new JPanel();
		countdownPanel.setBackground(Color.WHITE);
		countdownPanel.setLayout(new BorderLayout());
		
		lblCountdown = new JLabel("Rock!", RockPaperScissors.ROCK.getIcon(), SwingConstants.CENTER);
		lblCountdown.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCountdown.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCountdown.setBackground(Color.WHITE);
		lblCountdown.setFont(new Font("Dialog", Font.ITALIC, 36));
		countdownPanel.add(lblCountdown);
	}
	
	private void createPanelRockPaperScissors() {
		rockPaperScissorsPanel = new JPanel();
		rockPaperScissorsPanel.setBackground(Color.WHITE);
		rockPaperScissorsPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JRadioButton rdbtnRock = new JRadioButton("");
		rdbtnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChoice = RockPaperScissors.ROCK;
				evaluateRockPaperScissors(cpuChoices);
			}
		});
		rdbtnRock.setIcon(RockPaperScissors.ROCK.getIcon());
		rdbtnRock.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnRock.setBackground(Color.WHITE);
		rockPaperScissorsPanel.add(rdbtnRock);
		
		JRadioButton rdbtnPaper = new JRadioButton("");
		rdbtnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChoice = RockPaperScissors.PAPER;
				evaluateRockPaperScissors(cpuChoices);
			}
		});
		rdbtnPaper.setIcon(RockPaperScissors.PAPER.getIcon());
		rdbtnPaper.setBackground(Color.WHITE);
		rdbtnPaper.setHorizontalAlignment(SwingConstants.CENTER);
		rockPaperScissorsPanel.add(rdbtnPaper);
		
		JRadioButton rdbtnScissors = new JRadioButton("");
		rdbtnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChoice = RockPaperScissors.SCISSORS;
				evaluateRockPaperScissors(cpuChoices);
			}
		});
		rdbtnScissors.setIcon(RockPaperScissors.SCISSORS.getIcon());
		rdbtnScissors.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnScissors.setBackground(Color.WHITE);
		rockPaperScissorsPanel.add(rdbtnScissors);
	}
	
	private void createPanelRockPaperScissorsLizardSpock() {
		rockPaperScissorsLizardSpockPanel = new JPanel();
		rockPaperScissorsLizardSpockPanel.setBackground(Color.WHITE);
		rockPaperScissorsLizardSpockPanel.setLayout(new GridLayout(0, 5));
		
		JRadioButton rdbtnRock = new JRadioButton("");
		rdbtnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChoice = RockPaperScissors.ROCK;
				evaluateRockPaperScissors(cpuChoicesLizardSpock);
			}
		});
		rdbtnRock.setIcon(RockPaperScissors.ROCK.getIcon());
		rdbtnRock.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnRock.setBackground(Color.WHITE);
		rockPaperScissorsLizardSpockPanel.add(rdbtnRock);
		
		JRadioButton rdbtnPaper = new JRadioButton("");
		rdbtnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChoice = RockPaperScissors.PAPER;
				evaluateRockPaperScissors(cpuChoicesLizardSpock);
			}
		});
		rdbtnPaper.setIcon(RockPaperScissors.PAPER.getIcon());
		rdbtnPaper.setBackground(Color.WHITE);
		rdbtnPaper.setHorizontalAlignment(SwingConstants.CENTER);
		rockPaperScissorsLizardSpockPanel.add(rdbtnPaper);
		
		JRadioButton rdbtnScissors = new JRadioButton("");
		rdbtnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChoice = RockPaperScissors.SCISSORS;
				evaluateRockPaperScissors(cpuChoicesLizardSpock);
			}
		});
		rdbtnScissors.setIcon(RockPaperScissors.SCISSORS.getIcon());
		rdbtnScissors.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnScissors.setBackground(Color.WHITE);
		rockPaperScissorsLizardSpockPanel.add(rdbtnScissors);
		
		JRadioButton rdbtnLizard = new JRadioButton("");
		rdbtnLizard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChoice = RockPaperScissors.LIZARD;
				evaluateRockPaperScissors(cpuChoicesLizardSpock);
			}
		});
		rdbtnLizard.setIcon(RockPaperScissors.LIZARD.getIcon());
		rdbtnLizard.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnLizard.setBackground(Color.WHITE);
		rockPaperScissorsLizardSpockPanel.add(rdbtnLizard);
		
		JRadioButton rdbtnSpock = new JRadioButton("");
		rdbtnSpock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChoice = RockPaperScissors.SPOCK;
				evaluateRockPaperScissors(cpuChoicesLizardSpock);
			}
		});
		rdbtnSpock.setIcon(RockPaperScissors.SPOCK.getIcon());
		rdbtnSpock.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSpock.setBackground(Color.WHITE);
		rockPaperScissorsLizardSpockPanel.add(rdbtnSpock);
	}

	private void createScorePanel() {
		scorePanel = new JPanel();
		scorePanel.setBackground(Color.WHITE);
		scorePanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		userScoreLabel = new JLabel("User: " + userScore);
		userScoreLabel.setForeground(Color.BLACK);
		userScoreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		userScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scorePanel.add(userScoreLabel);
		
		computerScoreLabel = new JLabel("Computer: " + computerScore);
		computerScoreLabel.setForeground(Color.BLACK);
		computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scorePanel.add(computerScoreLabel);
	}
	
	private void createStatisticsPanel() {
		statisticsPanel = new JPanel();
		statisticsPanel.setBackground(Color.WHITE);
		statisticsPanel.setLayout(new GridLayout(8, 2));
		statisticsPanel.setBorder(BorderFactory.createMatteBorder(20, 50, 20, 0, Color.WHITE));
		
		JLabel gamesWon = new JLabel("Games won:");
		gamesWonNumber = new JLabel("0");
		JLabel gamesTied = new JLabel("Games Tied:");
		gamesTiedNumber = new JLabel("0");
		JLabel gamesLost = new JLabel("Games Lost:");
		gamesLostNumber = new JLabel("0");
		JLabel totalGames = new JLabel("Total Games:");
		totalGamesNumber = new JLabel("0");
		JLabel percentWon = new JLabel("Percent of games won:");
		percentWonNumber = new JLabel("0");
		JLabel percentLost = new JLabel("Percent of games lost:");
		percentLostNumber = new JLabel("0");
		JLabel longestWinStreak = new JLabel("Longest win streak:");
		longestWinStreakNumber = new JLabel("0");
		JLabel longestLoseStreak = new JLabel("Longest lose streak:");
		longestLoseStreakNumber = new JLabel("0");
		
		JLabel allStatisticsLabels[] = { gamesWon, gamesWonNumber, gamesTied, gamesTiedNumber, gamesLost, gamesLostNumber,
				totalGames, totalGamesNumber, percentWon, percentWonNumber, percentLost, percentLostNumber, longestWinStreak,
				longestWinStreakNumber, longestLoseStreak, longestLoseStreakNumber };
		
		for (JLabel label : allStatisticsLabels) {
			label.setBackground(Color.WHITE);
			label.setFont(new Font("Dialog", Font.PLAIN, 24));
			if (label.getText().equals("0")) {
				label.setHorizontalAlignment(SwingConstants.CENTER);
			}
			statisticsPanel.add(label);
		}
	}
	
	private void createWelcomePanel() {
		welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.WHITE);
		welcomePanel.setLayout(new GridLayout(6, 0));
		
		JLabel instructions[] = {
				new JLabel("1. Select a game from the top"),
				new JLabel("2. Choose your move"),
				new JLabel("3. View your results"),
				new JLabel("4. Select another game from the top"),
				new JLabel("5. Check out your stats from the top")
		};
		
		for (JLabel label : instructions) {
			label.setBackground(Color.WHITE);
			label.setFont(new Font("Dialog", Font.ITALIC, 24));
			label.setBorder(BorderFactory.createMatteBorder(0, 50, 0, 0, Color.WHITE));
			welcomePanel.add(label);
		}
		
		JButton welcomeButton = new JButton("Got it, let's go!");
		welcomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				titleLabel.setText("Rock Paper Scissors");
				contentPane.add(scorePanel, BorderLayout.SOUTH);
				contentPane.add(titleLabel, BorderLayout.NORTH);
				contentPane.add(rockPaperScissorsPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		welcomeButton.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeButton.setFont(new Font("Dialog", Font.BOLD, 24));
		welcomeButton.setBorder(BorderFactory.createMatteBorder(5, 200, 5, 200, Color.WHITE));
		welcomePanel.add(welcomeButton);
	}
	
	private void evaluateRockPaperScissors(RockPaperScissors[] randomCpuChoice) {
		numberOfGames += 1;
		cpuChoiceCount = randomCpuChoice.length;
		cpuChoice = randomCpuChoice[rand.nextInt(randomCpuChoice.length)];
		playerChoice.evaluate(cpuChoice);
		userScore += playerChoice.didWin().getScore();
		cpuChoice.evaluate(playerChoice);
		computerScore += cpuChoice.didWin().getScore();
		
		if (playerChoice.didWin() == DidWin.WIN) {
			winStreakChecker += 1;
			if (winStreakChecker > winStreak) {
				winStreak = winStreakChecker;
			}
		} else {
			winStreakChecker = 0;
		}
		
		if (cpuChoice.didWin() == DidWin.WIN) {
			loseStreakChecker += 1;
			if (loseStreakChecker > loseStreak) {
				loseStreak = loseStreakChecker;
			}
		} else {
			loseStreakChecker = 0;
		}
		
		lblPlayerChoiceResult.setIcon(playerChoice.getIcon());
		lblCpuChoiceResult.setIcon(cpuChoice.getIcon());
		lblResultTextResult.setText(playerChoice.evaluate(cpuChoice) + playerChoice.didWin());
		
		contentPane.removeAll();
		contentPane.add(scorePanel, BorderLayout.SOUTH);
		contentPane.add(titleLabel, BorderLayout.NORTH);
		contentPane.add(countdownPanel, BorderLayout.CENTER);
		revalidate();
		repaint();
		
		Timer myTimer = new Timer(750, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCountdown.setText("Paper!");
				lblCountdown.setIcon(RockPaperScissors.PAPER.getIcon());
				Timer myTimer = new Timer(750, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lblCountdown.setText("Scissors!");
						lblCountdown.setIcon(RockPaperScissors.SCISSORS.getIcon());
						Timer myTimer = new Timer(750, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (cpuChoiceCount == 5) {
									lblCountdown.setText("Lizard!");
									lblCountdown.setIcon(RockPaperScissors.LIZARD.getIcon());
									Timer myTimer = new Timer(750, new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											lblCountdown.setText("Spock!");
											lblCountdown.setIcon(RockPaperScissors.SPOCK.getIcon());
											Timer myTimer = new Timer(750, new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													userScoreLabel.setText("User: " + userScore);
													computerScoreLabel.setText("Computer: " + computerScore);
													
													lblCountdown.setText("Rock!");
													lblCountdown.setIcon(RockPaperScissors.ROCK.getIcon());
													
													lblPlayerChoiceResult.setIcon(playerChoice.getIcon());
													lblCpuChoiceResult.setIcon(cpuChoice.getIcon());
													lblResultTextResult.setText(playerChoice.evaluate(cpuChoice) + playerChoice.didWin());
													
													contentPane.removeAll();
													contentPane.add(scorePanel, BorderLayout.SOUTH);
													contentPane.add(titleLabel, BorderLayout.NORTH);
													contentPane.add(showResultsPanel, BorderLayout.CENTER);
													revalidate();
													repaint();
												}
											});
											myTimer.setRepeats(false);
											myTimer.start();
										}
									});
									myTimer.setRepeats(false);
									myTimer.start();
								} else {
									userScoreLabel.setText("User: " + userScore);
									computerScoreLabel.setText("Computer: " + computerScore);
									
									lblCountdown.setText("Rock!");
									lblCountdown.setIcon(RockPaperScissors.ROCK.getIcon());
									
									lblPlayerChoiceResult.setIcon(playerChoice.getIcon());
									lblCpuChoiceResult.setIcon(cpuChoice.getIcon());
									lblResultTextResult.setText(playerChoice.evaluate(cpuChoice) + playerChoice.didWin());
									
									contentPane.removeAll();
									contentPane.add(scorePanel, BorderLayout.SOUTH);
									contentPane.add(titleLabel, BorderLayout.NORTH);
									contentPane.add(showResultsPanel, BorderLayout.CENTER);
									revalidate();
									repaint();
								}
							}
						});
						myTimer.setRepeats(false);
						myTimer.start();
					}
				});
				myTimer.setRepeats(false);
				myTimer.start();
			}
		});
		myTimer.setRepeats(false);
		myTimer.start();
	}
}