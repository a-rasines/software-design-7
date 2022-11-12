package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.JPanel;

public abstract class ClientPanel extends JPanel{
	private static final long serialVersionUID = 2192152045139250311L;
	public static final Color TRANSPARENT = new Color(0, 0, 0, 0);
	public static final Color STRAVA_COLOR = new Color(252, 75, 0);
	
	private static HashMap<Class<? extends ClientPanel>, ClientPanel> instanceMap = new HashMap<>();
	@SuppressWarnings("unchecked")
	public static <T extends ClientPanel> T getInstanceOf(Class<T> clazz) {
		ClientPanel panel = instanceMap.get(clazz);
		if(panel == null) {
			try {
				panel = clazz.getConstructor().newInstance();
				instanceMap.put(clazz, panel);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (T)panel;
		
	}
	public abstract Dimension getPreferredSize();
	public abstract void showPanel();
}
