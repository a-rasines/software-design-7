package client.gui.panels.extras;

import java.awt.BorderLayout;
import java.awt.Color;
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
import client.gui.panels.extras.SessionPanel.SessionType;

public class ChallengePanel extends JPanel {
	private static final long serialVersionUID = -329671660860291231L;
	JPanel front;
	JPanel back;
	boolean frontShowing = false;
	private static final Color BACKGROUND_COLOR = ClientPanel.STRAVA_COLOR;//new Color(50, 50, 50);
	private static final Color COMPLETED_COLOR = new Color(252, 135, 60);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public ChallengePanel(SessionType type,  String title, Date startDate, Date endDate, float target, boolean isDistance, boolean completed) {
		update(type, title, startDate, endDate, target, isDistance, completed);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				front.setVisible(frontShowing);
				back.setVisible(!frontShowing);
				frontShowing =! frontShowing;
			}
		});
	}
	Consumer<ChallengePanel> onComplete;
	public ChallengePanel onComplete(Consumer<ChallengePanel> onComplete) {
		this.onComplete = onComplete;
		return this;
	}
	private void update(SessionType type,  String title, Date startDate, Date endDate, float target, boolean isDistance, boolean completed) {
		setBackground(completed? COMPLETED_COLOR : BACKGROUND_COLOR);
		front = new JPanel(new BorderLayout());
		front.setBackground(completed? COMPLETED_COLOR : BACKGROUND_COLOR);
		front.add(new JLabel(new ImageIcon(type.image.getScaledInstance(110, 110, Image.SCALE_SMOOTH))), BorderLayout.CENTER);
		JLabel label = new JLabel(title);
		label.setForeground(Color.WHITE);
		front.add(label, BorderLayout.SOUTH);
		add(front);
		back = new JPanel(new GridLayout(0, 1));
		JLabel titleLabel = new JLabel(title);
		titleLabel.setForeground(Color.WHITE);
		back.add(titleLabel);
		back.setBackground(completed? COMPLETED_COLOR : BACKGROUND_COLOR);
		back.add(new JSeparator());
		JLabel dateLabel = new JLabel("Start: " + DATE_FORMAT.format(startDate));
		dateLabel.setForeground(Color.WHITE);
		back.add(dateLabel);
		dateLabel = new JLabel("End: " + DATE_FORMAT.format(endDate));
		dateLabel.setForeground(Color.WHITE);
		back.add(dateLabel);
		JLabel distanceLabel = new JLabel((isDistance ?"Distance: " : "Time: ")+target+(isDistance?"km":"s"));
		distanceLabel.setForeground(Color.WHITE);
		back.add(distanceLabel);
		JLabel completedLabel = new JLabel((completed ?"COMPLETED!" : "Pending..."));
		completedLabel.setForeground(Color.WHITE);
		back.add(completedLabel);
		if(completed)
			back.add(new JLabel(new ImageIcon(new BufferedImage(110, 18, BufferedImage.TYPE_INT_ARGB))));
		else {
			JPanel clickPanel = new JPanel();
			BoxLayout bl = new BoxLayout(clickPanel, BoxLayout.Y_AXIS);
			clickPanel.setLayout(bl);
			clickPanel.setBackground(BACKGROUND_COLOR);
			JLabel completeLabel = new JLabel("Click to complete");
			ChallengePanel instance = this;
			completeLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					removeAll();
					if(onComplete != null)
						onComplete.accept(instance);
					//TODO Update the server info
					update(type, title, startDate, endDate, target, isDistance, true);
					frontShowing = false;
				}
			});
			completeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			clickPanel.add(completeLabel);
			clickPanel.add(new JLabel(new ImageIcon(new BufferedImage(110, 2, BufferedImage.TYPE_INT_ARGB))));
			back.add(clickPanel);
		}
		back.setVisible(false);
		add(back);
	}

}
