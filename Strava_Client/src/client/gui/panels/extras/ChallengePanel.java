package client.gui.panels.extras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import client.gui.ClientPanel;
import client.gui.panels.HomePage;
import client.gui.panels.SportType;
import server.data.dto.ChallengeDTO;

public class ChallengePanel extends JPanel {
	private static final long serialVersionUID = -329671660860291231L;
	JPanel front;
	JPanel back;
	boolean frontShowing = false;
	private static final Color BACKGROUND_COLOR = ClientPanel.STRAVA_COLOR;//new Color(50, 50, 50);
	private static final Color COMPLETED_COLOR = new Color(252, 135, 60);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Create a visual representation of a claimed challenge
	 * @param type Sport(s) of the challenge
	 * @param title Name of the challenge
	 * @param startDate Date where the challenge starts
	 * @param endDate Date where the challenge ends
	 * @param target Targeted distance or time
	 * @param isDistance if true, target is distance, else time
	 * @param completed if true, the challenge is treated as completed
	 */
	public ChallengePanel(ChallengeDTO c) {
		update(SportType.of(c.getSport()), c.getName(), c.getStartDate(), c.getEndDate(), Math.max(c.getDistanceTarget(), c.getTimeTarget()), c.getTimeTarget() == 0, c.progress);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				front.setVisible(frontShowing);
				back.setVisible(!frontShowing);
				frontShowing =! frontShowing;
			}
		});
	}
	/**
	 * This function is called when challenge status it's set to completed
	 * @param onComplete
	 * @return
	 */
	private Consumer<ChallengePanel> onAccept;
	/**
	 * This function is called when a challenge is accepted
	 * @param onAccept
	 * @return
	 */
	public ChallengePanel onAccept(Consumer<ChallengePanel> onAccept) {
		this.onAccept = onAccept;
		return this;
	}
	/**
	 * Updates the complete status of the challenge
	 * All params are taken directly from the constructor
	 * @param type
	 * @param title
	 * @param startDate
	 * @param endDate
	 * @param target
	 * @param isDistance
	 * @param completed
	 */
	private void update(SportType type,  String title, long startDate, long endDate, double target, boolean isDistance, byte progress) {
		setBackground(progress == 100? COMPLETED_COLOR : BACKGROUND_COLOR);
		front = new JPanel(new BorderLayout());
		front.setBackground(progress == 100? COMPLETED_COLOR : BACKGROUND_COLOR);
		front.add(new JLabel(new ImageIcon(type.image.getScaledInstance(110, 110, Image.SCALE_SMOOTH))), BorderLayout.CENTER);
		JLabel label = new JLabel(title);
		label.setForeground(Color.WHITE);
		front.add(label, BorderLayout.SOUTH);
		add(front);
		back = new JPanel(new GridLayout(0, 1));
		JLabel titleLabel = new JLabel(title);
		titleLabel.setForeground(Color.WHITE);
		back.add(titleLabel);
		back.setBackground(progress == 100? COMPLETED_COLOR : BACKGROUND_COLOR);
		back.add(new JSeparator());
		JLabel dateLabel = new JLabel("Start: " + DATE_FORMAT.format(new Date(startDate)));
		dateLabel.setForeground(Color.WHITE);
		back.add(dateLabel);
		dateLabel = new JLabel("End: " + DATE_FORMAT.format(new Date(endDate)));
		dateLabel.setForeground(Color.WHITE);
		back.add(dateLabel);
		JLabel distanceLabel = new JLabel((isDistance ?"Distance: " : "Time: ")+target+(isDistance?"km":"s"));
		distanceLabel.setForeground(Color.WHITE);
		back.add(distanceLabel);
		JLabel completedLabel = new JLabel((progress == 100 ?"COMPLETED!" : "Progress: "+progress +"%"));
		completedLabel.setForeground(Color.WHITE);
		back.add(completedLabel);
		if(progress == 100)
			back.add(new JLabel(new ImageIcon(new BufferedImage(110, 18, BufferedImage.TYPE_INT_ARGB))));
		else {
			JPanel clickPanel = new JPanel();
			BoxLayout bl = new BoxLayout(clickPanel, BoxLayout.Y_AXIS);
			clickPanel.setLayout(bl);
			clickPanel.setBackground(BACKGROUND_COLOR);
			clickPanel.add(new JLabel(new ImageIcon(new BufferedImage(110, 18, BufferedImage.TYPE_INT_ARGB))));
			back.add(clickPanel);
		}
		back.setVisible(false);
		add(back);
	}
	/**
	 * Create a visual representation of an UNCLAIMED challenge
	 * @param type Sport(s) of the challenge
	 * @param title Name of the challenge
	 * @param startDate Date where the challenge starts
	 * @param endDate Date where the challenge ends
	 * @param d Targeted distance or time
	 * @param isDistance if true, target is distance, else time
	 */
	public ChallengePanel(ChallengeDTO c, boolean claimed) {
		if(!claimed)
		setBackground(BACKGROUND_COLOR);
		front = new JPanel(new BorderLayout());
		front.setBackground(BACKGROUND_COLOR);
		front.add(new JLabel(new ImageIcon(SportType.of(c.getSport()).image.getScaledInstance(110, 110, Image.SCALE_SMOOTH))), BorderLayout.CENTER);
		JLabel label = new JLabel(c.getName());
		label.setForeground(Color.WHITE);
		front.add(label, BorderLayout.SOUTH);
		add(front);
		back = new JPanel(new GridLayout(0, 1));
		JLabel titleLabel = new JLabel(c.getName());
		titleLabel.setForeground(Color.WHITE);
		back.add(titleLabel);
		back.setBackground(BACKGROUND_COLOR);
		back.add(new JSeparator());
		JLabel dateLabel = new JLabel("Start: " + DATE_FORMAT.format(c.getStartDate()));
		dateLabel.setForeground(Color.WHITE);
		back.add(dateLabel);
		dateLabel = new JLabel("End: " + DATE_FORMAT.format(c.getEndDate()));
		dateLabel.setForeground(Color.WHITE);
		back.add(dateLabel);
		JLabel distanceLabel = new JLabel((c.getTimeTarget() == 0 ?"Distance: " : "Time: ")+(c.getTimeTarget() == 0?c.getDistanceTarget():c.getTimeTarget())+(c.getTimeTarget() == 0?"km":"s"));
		distanceLabel.setForeground(Color.WHITE);
		back.add(distanceLabel);
		JPanel clickPanel = new JPanel();
		BoxLayout bl = new BoxLayout(clickPanel, BoxLayout.Y_AXIS);
		clickPanel.setLayout(bl);
		clickPanel.setBackground(BACKGROUND_COLOR);
		JLabel completeLabel = new JLabel("Click to claim");
		ChallengePanel instance = this;
		completeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeAll();
				if(onAccept != null)
					onAccept.accept(instance);
				//TODO Update the server info
				Container co = instance.getParent();
				co.remove(instance);
				co.repaint();
				ClientPanel.getInstanceOf(HomePage.class).addChallenge(c);
				update(SportType.of(c.getSport()), c.getName(), c.getStartDate(), c.getEndDate(), c.getTimeTarget() == 0?c.getDistanceTarget():c.getTimeTarget(), c.getTimeTarget() == 0, c.progress);
				frontShowing = false;
			}
		});
		completeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clickPanel.add(completeLabel);
		clickPanel.add(new JLabel(new ImageIcon(new BufferedImage(110, 5, BufferedImage.TYPE_INT_ARGB))));
		back.add(clickPanel);
		back.setVisible(false);
		add(back);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				front.setVisible(frontShowing);
				back.setVisible(!frontShowing);
				frontShowing =! frontShowing;
			}
		});
	}

}
