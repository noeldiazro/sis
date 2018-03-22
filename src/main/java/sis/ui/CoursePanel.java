package sis.ui;

import java.util.Set;
import javax.swing.*;

class CoursePanel extends JPanel {
    static final String LABEL_NAME = "label";
    static final String LABEL_TEXT = "Courses:";
    static final String COURSES_LIST_NAME = "coursesList";
    static final String ADD_BUTTON_NAME = "addButton";
    static final String ADD_BUTTON_TEXT = "Add";
    static final String DEPARTMENT_LABEL_NAME = "deptLabel";
    static final String DEPARTMENT_LABEL_TEXT = "Department";
    static final String DEPARTMENT_FIELD_NAME = "deptField";
    static final String NUMBER_LABEL_NAME = "nmbrLabel";
    static final String NUMBER_LABEL_TEXT = "Number";
    static final String NUMBER_FIELD_NAME = "nmbrField";
    private static final int COLUMNS = 20;
    
    private JLabel label;
    private JList<String> list;    
    private JButton addButton;
    private JLabel deptLabel;
    private JTextField deptField;
    private JLabel nmbrLabel;
    private JTextField nmbrField;
    
    CoursePanel(String name) {
	initialize(name);
    }

    private void initialize(String name) {
	setName(name);
	
	label = new JLabel(LABEL_TEXT);
	label.setName(LABEL_NAME);
	add(label);

	list = new JList<String>();
	list.setName(COURSES_LIST_NAME);
	add(list);
	
	addButton = new JButton(ADD_BUTTON_TEXT);
	addButton.setName(ADD_BUTTON_NAME);
	add(addButton);

	deptLabel = new JLabel(DEPARTMENT_LABEL_TEXT);
	deptLabel.setName(DEPARTMENT_LABEL_NAME);
	add(deptLabel);

	deptField = new JTextField(COLUMNS);
	deptField.setName(DEPARTMENT_FIELD_NAME);
	add(deptField);

	nmbrLabel = new JLabel(NUMBER_LABEL_TEXT);
	nmbrLabel.setName(NUMBER_LABEL_NAME);
	add(nmbrLabel);

	nmbrField = new JTextField(COLUMNS);
	nmbrField.setName(NUMBER_FIELD_NAME);
	add(nmbrField);
    }
    
    String getLabelText() {
	return label.getText();
    }

    Set<String> getNames() {
	return Util.getNames(this);
    }

    String getAddButtonText() {
	return addButton.getText();
    }

    String getDepartmentLabelText() {
	return deptLabel.getText();
    }

    String getDepartmentFieldText() {
	return deptField.getText();
    }

    int getListSize() {
	return list.getModel().getSize();
    }

    String getNumberLabelText() {
	return nmbrLabel.getText();
    }

    String getNumberFieldText() {
	return nmbrField.getText();
    }
}
