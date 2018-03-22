package sis.ui;

import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;

final class Sis {
    static final int WIDTH = 350;
    static final int HEIGHT = 200;
    static final String COURSE_PANEL_NAME = "coursePanel";
    
    private final JFrame frame = new JFrame();
    
    public static void main(String[] args) {
	new Sis().show();
    }
    
    Sis() {
	initialize();
    }

    private void initialize() {
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(new CoursePanel(COURSE_PANEL_NAME));
    }
    
    int getWidth() {
	return frame.getWidth();
    }

    int getHeight() {
	return frame.getHeight();
    }

    boolean isVisible() {
	return frame.isVisible();
    }

    void show() {
	frame.setVisible(true);
    }

    void close() {
	frame.dispose();
    }

    Set<String> getNames() {
	return Util.getNames(frame.getContentPane());
    }
}
