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
    }

    public void testShow() {
	sis.show();
	assertTrue(sis.isVisible());
    }

    @Override protected void tearDown() throws Exception {
	super.tearDown();
	sis.close();
    }
}
