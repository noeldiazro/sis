package sis.ui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.BevelBorder;
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
    static final char ADD_BUTTON_MNEMONIC = 'A';
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

	list = createList(COURSES_LIST_NAME);
	JScrollPane coursesScroll = new JScrollPane(list);
	coursesScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	
	JPanel bottomPanel = createBottomPanel();
	
	setLayout(new BorderLayout());

	makeBorder();
	
	add(coursesScroll, BorderLayout.CENTER);
	add(bottomPanel, BorderLayout.SOUTH);
    }

    private void makeBorder() {
	final int pad = 6;
	final Border emptyBorder =
	    BorderFactory.createEmptyBorder(pad, pad, pad, pad);

	final Border bevelBorder =
	    BorderFactory.createBevelBorder(BevelBorder.RAISED);

	final Border titledBorder =
	    BorderFactory.createTitledBorder(bevelBorder, LABEL_TEXT);
	
	setBorder(BorderFactory.createCompoundBorder(emptyBorder, titledBorder));
    }
    
    private JPanel createBottomPanel() {
	final JPanel panel = new JPanel();
	
	addButton = createButton(ADD_BUTTON_NAME, ADD_BUTTON_TEXT);
	addButton.setMnemonic(ADD_BUTTON_MNEMONIC);
	final JPanel fieldsPanel = createFieldsPanel();

	panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	
	addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	panel.add(addButton);
	panel.add(createVerticalSeparator(6));
	panel.add(createFieldsPanel());
	
	panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
	
	return panel;
    }

    private Component createVerticalSeparator(int height) {
	return Box.createRigidArea(new Dimension(0, height));
    }
    
    private JPanel createFieldsPanel() {
	final GridBagLayout layout = new GridBagLayout();
	final JPanel panel = new JPanel(layout);

	deptLabel = createLabel(DEPARTMENT_LABEL_NAME, DEPARTMENT_LABEL_TEXT);
	deptField = createTextField(DEPARTMENT_FIELD_NAME, COLUMNS);
	nmbrLabel = createLabel(NUMBER_LABEL_NAME, NUMBER_LABEL_TEXT);
	nmbrField = createTextField(NUMBER_FIELD_NAME, COLUMNS);

	layout.setConstraints(deptLabel,
			      new GridBagConstraints(0, 0, // gridx, gridy
						  1, 1, // gridwidth, gridheight
						  40, 1, // weightx, weighty
						  GridBagConstraints.LINE_END, // anchor
						  GridBagConstraints.NONE, // fill
						  new Insets(3, 3, 3, 3), // top-left-bottom-right
						  0, 0)); // padx, pady

	layout.setConstraints(deptField,
			      new GridBagConstraints(1, 0, 2, 1, 60, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						     new Insets(3, 3, 3, 3), 0, 0));

	layout.setConstraints(nmbrLabel,
			      new GridBagConstraints(0, 1, 1, 1, 40, 1, GridBagConstraints.LINE_END, GridBagConstraints.NONE,
						  new Insets(3, 3, 3, 3), 0, 0));


	layout.setConstraints(nmbrField,
			      new GridBagConstraints(1, 1, 2, 1, 60, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						     new Insets(3, 3, 3, 3), 0, 0));

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

    char getAddButtonMnemonic() {
	return (char)addButton.getMnemonic();
    }

    void enableAddButton() {
	addButton.setEnabled(true);
    }

    boolean isAddButtonEnabled() {
	return addButton.isEnabled();
    }

    void disableAddButton() {
	addButton.setEnabled(false);
    }

    void addDepartmentFieldListener(KeyListener listener) {
	deptField.addKeyListener(listener);
    }

    KeyListener getDepartmentFieldKeyListenerAt(int index) {
	return deptField.getKeyListeners()[index];
    }
}
