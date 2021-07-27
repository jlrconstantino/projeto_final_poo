package utils;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

/** Utilitário para redimensionamento de imagens */
public class ImageResizer {

	public ImageResizer() {}
	
	// Obtém e redimensiona uma imagem
	public static ImageIcon getAndResize(URL url, String description, int w, int h) {
		ImageIcon raw = new ImageIcon(url, description);
		Image transformer = raw.getImage();
		transformer = transformer.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(transformer);
	}
}
