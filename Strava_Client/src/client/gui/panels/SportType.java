package client.gui.panels;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import server.data.enums.Sport;

public enum SportType {
	CYCLING("https://imgur.com/Pfwx0nA.png", Sport.CYCLING),
	RUNNING("https://imgur.com/4xlBRWY.png", Sport.RUNNING),
	BOTH("https://assets.ifttt.com/images/channels/1055884022/icons/monochrome_large.png", Sport.BOTH);
	public final BufferedImage image;
	public final Sport dto;
	SportType(String url, Sport dtos){
		image = javaIsSpecialSometimes(url);
		this.dto = dtos;
	}
	private BufferedImage javaIsSpecialSometimes(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static SportType of(Sport s) {
		return SportType.valueOf(s.toString());
	}
	public Sport toSport() {
		return Sport.valueOf(toString());
	}
}
