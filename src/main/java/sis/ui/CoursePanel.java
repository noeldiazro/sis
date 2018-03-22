package sis.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

class CoursePanel extends JPanel {
    static final String LABEL_TEXT = "Courses:";

    private final JLabel label;

    CoursePanel() {
	label = new JLabel(LABEL_TEXT);
	add(label);
    }
    
    String getLabelText() {
	return label.getText();
    }
}
