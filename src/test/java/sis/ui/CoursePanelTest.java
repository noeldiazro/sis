package sis.ui;

import junit.framework.TestCase;

public class CoursePanelTest extends TestCase {
    public void testCreate() {
	CoursePanel panel = new CoursePanel();
	assertEquals(CoursePanel.LABEL_TEXT, panel.getLabelText());
    }
}
