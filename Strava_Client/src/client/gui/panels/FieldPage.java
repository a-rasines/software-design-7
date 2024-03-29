package client.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import client.gui.ClientPanel;

public abstract class FieldPage extends ClientPanel{
	private static final long serialVersionUID = -8845423676269496329L;
	@Override
	public abstract Dimension getPreferredSize();

	protected JPanel createField(String name, JComponent field) {
		return createField(name, field, Color.WHITE);
	}
	protected JPanel createField(String name, JComponent field, Color c) {
		JPanel end = new JPanel(new FlowLayout());
		end.setBackground(TRANSPARENT);
		JLabel temp = new JLabel(name);
		temp.setForeground(c);
		end.add(temp);
		end.add(field);
		return end;
	}
	private static final BufferedImage BACKGROUND_IMAGE;
	static {
		BufferedImage javaIsSpecialSometimes = null;
		try {
			javaIsSpecialSometimes = ImageIO.read(new URL("https://imgur.com/7gVDNZk.png").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		BACKGROUND_IMAGE = javaIsSpecialSometimes;
	}
	@Override
	protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
		    g.setColor(STRAVA_COLOR);
		    Dimension pSize = getPreferredSize();
		    g.fillRect(0, 0, pSize.width, pSize.height);
	        int size = Math.min(pSize.width, pSize.height);
			g.drawImage(
					BACKGROUND_IMAGE.getScaledInstance(size, size, Image.SCALE_SMOOTH),
					(getPreferredSize().width - size)/2, 
					(getPreferredSize().height - size)/2, 
					null);
	}
	protected JLabel createImageLabel(String url, String alternativeText, int sizeX, int sizeY) {
		ImageIcon icon;
		try {
			icon = new ImageIcon(ImageIO.read(new URL(url).openStream()).getScaledInstance(sizeX, sizeY, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			icon = null;
			e.printStackTrace();
		}
		return icon==null ? new JLabel(alternativeText):new JLabel(icon);
	}

}
