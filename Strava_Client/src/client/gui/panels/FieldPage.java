package client.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

import client.gui.ClientPanel;

public abstract class FieldPage extends ClientPanel{
	private static final long serialVersionUID = -8845423676269496329L;
	@Override
	public abstract Dimension getPreferredSize();

	@Override
	public abstract void showPanel();
	
	protected JPanel createField(String name, JTextComponent field) {
		JPanel end = new JPanel(new FlowLayout());
		end.setBackground(TRANSPARENT);
		JLabel temp = new JLabel(name);
		temp.setForeground(Color.WHITE);
		end.add(temp);
		end.add(field);
		return end;
	}
	
	@Override
	protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
		    g.setColor(STRAVA_COLOR);
		    Dimension pSize = getPreferredSize();
		    g.fillRect(0, 0, pSize.width, pSize.height);
	        try {
	        	int size = Math.min(pSize.width, pSize.height);
				g.drawImage(
						ImageIO.read(
								new URL("https://imgur.com/7gVDNZk.png")
									.openStream())
							.getScaledInstance(size, size, Image.SCALE_SMOOTH),
						(getPreferredSize().width - size)/2, 
						(getPreferredSize().height - size)/2, 
						null);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
