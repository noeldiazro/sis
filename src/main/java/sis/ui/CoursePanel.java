package sis.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.*;
import sis.studentinfo.Course;

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
    private JList<CourseDisplayAdapter> list;    
    private JButton addButton;
    private JLabel deptLabel;
    private JTextField deptField;
    private JLabel nmbrLabel;
    private JTextField nmbrField;

    private DefaultListModel<CourseDisplayAdapter> listModel =
	new DefaultListModel<CourseDisplayAdapter>();
    
    CoursePanel(String name) {
	initialize(name);
    }

    private void initialize(String name) {
	setName(name);

	label = createLabel(LABEL_NAME, LABEL_TEXT);
	list = createList(COURSES_LIST_NAME);
	JPanel bottomPanel = createBottomPanel();
	
	setLayout(new BorderLayout());
	
	add(label, BorderLayout.NORTH);
	add(list, BorderLayout.CENTER);
	add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createBottomPanel() {
	final JPanel panel = new JPanel();
	
	addButton = createButton(ADD_BUTTON_NAME, ADD_BUTTON_TEXT);
	final JPanel fieldsPanel = createFieldsPanel();

	panel.setLayout(new BorderLayout());
	
	panel.add(addButton, BorderLayout.NORTH);
	panel.add(createFieldsPanel(), BorderLayout.SOUTH);
	
	return panel;
    }

    private JPanel createFieldsPanel() {
	final JPanel panel = new JPanel();

	deptLabel = createLabel(DEPARTMENT_LABEL_NAME, DEPARTMENT_LABEL_TEXT);
	deptField = createTextField(DEPARTMENT_FIELD_NAME, COLUMNS);
	nmbrLabel = createLabel(NUMBER_LABEL_NAME, NUMBER_LABEL_TEXT);
	nmbrField = createTextField(NUMBER_FIELD_NAME, COLUMNS);

	panel.setLayout(new GridLayout(2, 2));
	
	panel.add(deptLabel);
	panel.add(deptField);
	panel.add(nmbrLabel);
	panel.add(nmbrField);

	return panel;
    }
    
    private JLabel createLabel(final String name, final String text) {
	final JLabel label = new JLabel(text);
	label.setName(name);
	return label;
    }

    private JList<CourseDisplayAdapter> createList(final String name) {
	final JList<CourseDisplayAdapter> list = new JList<CourseDisplayAdapter>(listModel);
	list.setName(name);
	return list;
    }

    private JButton createButton(final String name, final String text) {
	final JButton button = new JButton(text);
	button.setName(name);
	return button;
    }

    private JTextField createTextField(final String name, final int columns) {
	final JTextField field = new JTextField(columns);
	field.setName(name);
	return field;
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

    void addButtonClickListener(ActionListener listener) {
	addButton.addActionListener(listener);
    }

    void clickButton() {
	addButton.doClick();
    }

    void addCourse(Course course) {
	listModel.addElement(new CourseDisplayAdapter(course));
    }

    CourseDisplayAdapter getCourseAt(int index) {
	return listModel.getElementAt(index);
    }

    void setDepartment(final String department) {
	deptField.setText(department);
    }

    void setNumber(final String number) {
	nmbrField.setText(number);
    }
}
