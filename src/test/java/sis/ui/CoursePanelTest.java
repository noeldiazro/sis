package sis.ui;

import junit.framework.TestCase;

public class CoursePanelTest extends TestCase {
    public void testCreate() {
	final String panelName = "coursePanel";
	CoursePanel panel = new CoursePanel(panelName);
	assertEquals(panelName, panel.getName());

	assertEquals(CoursePanel.LABEL_TEXT, panel.getLabelText());
	assertTrue(panel.getNames().contains(CoursePanel.LABEL_NAME));

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
}
