package sis.ui;

import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CoursePanel extends JPanel {
    static final String LABEL_NAME = "label";
    static final String LABEL_TEXT = "Courses:";

    private JLabel label;

    CoursePanel(String name) {
	initialize(name);
    }

    private void initialize(String name) {
	setName(name);
	label = new JLabel(LABEL_TEXT);
	label.setName(LABEL_NAME);
	add(label);
    }
    
    String getLabelText() {
	return label.getText();
    }

    Set<String> getNames() {
	return Util.getNames(this);
    }
}
