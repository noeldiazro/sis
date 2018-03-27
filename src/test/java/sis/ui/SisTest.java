package sis.ui;

import java.awt.Image;
import java.awt.Robot;
import junit.framework.TestCase;

public class SisTest extends TestCase {

    private HumbleSis sis;
    
    @Override protected void setUp() throws Exception {
	super.setUp();
	sis = new HumbleSis(new Sis());
    }
    
    public void testCreate() {
	assertEquals(Sis.WIDTH, sis.getWidth());
	assertEquals(Sis.HEIGHT, sis.getHeight());
	assertFalse(sis.isVisible());
	assertTrue(sis.getNames().contains(Sis.COURSE_PANEL_NAME));
	assertEquals(Sis.TITLE, sis.getTitle());

	assertNotNull(sis.getIconImage());
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

    public void testKeyListeners() throws Exception {
	CoursePanel panel = sis.getPanel();
	Robot robot = new Robot();
	
	sis.show();

	assertFalse(panel.isAddButtonEnabled());

	sis.selectDepartmentField();
    }
    
    @Override protected void tearDown() throws Exception {
	super.tearDown();
	sis.close();
    }

    private class HumbleSis extends Sis {
	private Sis sis;
	
	HumbleSis(Sis sis) {
	    this.sis = sis;
	}

	void selectDepartmentField() {
	    getDepartmentFieldLocation();
	}

	private void getDepartmentFieldLocation() {}
    }
}

