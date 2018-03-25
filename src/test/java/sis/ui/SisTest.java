package sis.ui;

import junit.framework.TestCase;

public class SisTest extends TestCase {

    private Sis sis;
    
    @Override protected void setUp() throws Exception {
	super.setUp();
	sis = new Sis();
    }
    
    public void testCreate() {
	assertEquals(Sis.WIDTH, sis.getWidth());
	assertEquals(Sis.HEIGHT, sis.getHeight());
	assertFalse(sis.isVisible());
	assertTrue(sis.getNames().contains(Sis.COURSE_PANEL_NAME));
    }

    public void testShow() {
	sis.show();
	assertTrue(sis.isVisible());
    }

    public void testAddCourse() {
	CoursePanel panel = sis.getPanel();
	
	panel.setDepartment("MATH");
	panel.setNumber("300");
	panel.clickButton();
	
	assertEquals("MATH-300", panel.getCourseAt(0).toString());
    }
    
    @Override protected void tearDown() throws Exception {
	super.tearDown();
	sis.close();
    }
}
