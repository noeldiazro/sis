package sis.ui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import junit.framework.TestCase;
import sis.studentinfo.Course;

public class CoursePanelTest extends TestCase {
    private static final String PANEL_NAME = "coursePanel";
    private CoursePanel panel;
    private boolean wasClicked = false;
    
    @Override protected void setUp() {
	panel = new CoursePanel(PANEL_NAME);
    }
    
    public void testCreate() {
	assertEquals(PANEL_NAME, panel.getName());

	assertTrue(panel.getNames().contains(CoursePanel.COURSES_LIST_NAME));
	assertEquals(0, panel.getListSize());
		     
	assertTrue(panel.getNames().contains(CoursePanel.ADD_BUTTON_NAME));
	assertEquals(CoursePanel.ADD_BUTTON_TEXT, panel.getAddButtonText());

	assertTrue(panel.getNames().contains(CoursePanel.DEPARTMENT_LABEL_NAME));
	assertEquals(CoursePanel.DEPARTMENT_LABEL_TEXT, panel.getDepartmentLabelText());

	assertTrue(panel.getNames().contains(CoursePanel.DEPARTMENT_FIELD_NAME));
	assertEquals("", panel.getDepartmentFieldText());

	assertTrue(panel.getNames().contains(CoursePanel.NUMBER_LABEL_NAME));
	assertEquals(CoursePanel.NUMBER_LABEL_TEXT, panel.getNumberLabelText());

	assertTrue(panel.getNames().contains(CoursePanel.NUMBER_FIELD_NAME));
	assertEquals("", panel.getNumberFieldText());
    }

    public void testAddButtonClick() {
	panel.addButtonClickListener(makeListener());
	panel.clickButton();
	assertTrue(wasClicked);
    }

    private ActionListener makeListener() {
	return new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		wasClicked = true;
	    }
	};
    }

    public void testAddCourse() {
	Course course = new Course("ENGL", "101");
	panel.addCourse(course);
	assertEquals(1, panel.getListSize());
	assertEquals("ENGL-101", panel.getCourseAt(0).toString());
    }
}
