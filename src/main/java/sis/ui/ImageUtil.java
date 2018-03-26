package sis.ui;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

class ImageUtil {
    static Image create(String path) {
	URL location = ImageUtil.class.getResource(path);
	return location == null ? null : new ImageIcon(location).getImage();
    }
}
