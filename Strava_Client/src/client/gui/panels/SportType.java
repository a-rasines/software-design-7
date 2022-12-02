package client.gui.panels;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import server.data.enums.Sport;

public enum SportType {
	CYCLING("https://imgur.com/Pfwx0nA.png", Sport.CYCLING),
	RUNNING("https://imgur.com/4xlBRWY.png", Sport.RUNNING),
	BOTH("https://assets.ifttt.com/images/channels/1055884022/icons/monochrome_large.png", Sport.values());
	public final BufferedImage image;
	public final Sport[] dtos;
	SportType(String url, Sport... dtos){
		image = javaIsSpecialSometimes(url);
		this.dtos = dtos;
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
