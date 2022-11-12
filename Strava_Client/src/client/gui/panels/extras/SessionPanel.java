package client.gui.panels.extras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import client.gui.ClientPanel;

public class SessionPanel extends JPanel {

	public enum SessionType{
		CYCLING("https://imgur.com/Pfwx0nA.png"),
		RUNNING("https://imgur.com/4xlBRWY.png"),
		BOTH("https://assets.ifttt.com/images/channels/1055884022/icons/monochrome_large.png");
		public final BufferedImage image;
		SessionType(String url){
			image = javaIsSpecialSometimes(url);
		}
		private BufferedImage javaIsSpecialSometimes(String url) {
			try {
				return ImageIO.read(new URL(url));
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	private static final long serialVersionUID = -329671660860291231L;
	JPanel front;
	JPanel back;
	boolean frontShowing = false;
	private static final Color BACKGROUND_COLOR = ClientPanel.STRAVA_COLOR;//new Color(50, 50, 50);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public SessionPanel(SessionType type,  String title, Date startDate, float distance, long duration) {
		setMinimumSize(new Dimension(100, 150));
		setBackground(BACKGROUND_COLOR);
		front = new JPanel(new BorderLayout());
		front.setBackground(BACKGROUND_COLOR);
		front.add(new JLabel(new ImageIcon(type.image.getScaledInstance(110, 110, Image.SCALE_SMOOTH))), BorderLayout.CENTER);
		JLabel label = new JLabel(title + " // " + DATE_FORMAT.format(startDate));
		label.setForeground(Color.WHITE);
		front.add(label, BorderLayout.SOUTH);
		add(front);
		back = new JPanel(new GridLayout(0, 1));
		JLabel titleLabel = new JLabel(title);
		titleLabel.setForeground(Color.WHITE);
		back.add(titleLabel);
		back.setBackground(BACKGROUND_COLOR);
		JLabel dateLabel = new JLabel(DATE_FORMAT.format(startDate));
		dateLabel.setForeground(Color.WHITE);
		back.add(dateLabel);
		back.add(new JSeparator());
		JLabel distanceLabel = new JLabel("Distance: "+distance+"km");
		distanceLabel.setForeground(Color.WHITE);
		back.add(distanceLabel);
		JLabel durationLabel = new JLabel("Duration: "+ duration/1000 + "s");
		durationLabel.setForeground(Color.WHITE);
		back.add(durationLabel);
		back.add(new JLabel(new ImageIcon(new BufferedImage(110, 21, BufferedImage.TYPE_INT_ARGB))));
		back.setVisible(false);
		add(back);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				front.setVisible(frontShowing);
				back.setVisible(!frontShowing);
				frontShowing =! frontShowing;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				update(getGraphics());
				repaint();
			}
		});
	}

}
