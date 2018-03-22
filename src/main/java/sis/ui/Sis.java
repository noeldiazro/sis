package sis.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

final class Sis {
    static final int WIDTH = 350;
    static final int HEIGHT = 200;
    
    private final JFrame frame = new JFrame();
    
    public static void main(String[] args) {
	new Sis().show();
    }
    
    Sis() {
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(new CoursePanel());
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

    JPanel getPanel() {
	return (JPanel)frame.getContentPane().getComponents()[0];
    }
}
