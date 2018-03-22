package sis.ui;

import junit.framework.TestCase;

public class CoursePanelTest extends TestCase {
    public void testCreate() {
	final String panelName = "coursePanel";
	CoursePanel panel = new CoursePanel(panelName);
	assertEquals(panelName, panel.getName());
	assertEquals(CoursePanel.LABEL_TEXT, panel.getLabelText());
	assertTrue(panel.getNames().contains(CoursePanel.LABEL_NAME));
    }
}
