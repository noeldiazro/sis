package sis.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

public class StudentUITest extends TestCase {
    private static final String NAME = "Student Name";
    
    private OutputStream out;
    private TestSetup setup;
    
    @Override public void setUp() throws Exception {
	super.setUp();
	out = new ByteArrayOutputStream();
	setup = new TestSetup();
    }

    public void testAddNoStudents() throws IOException {
	setup.selectQuit();
	StudentUI ui = new StudentUI(setup.getInput(), new PrintStream(out));

	ui.run();

	assertEquals(String.format("%s%n", StudentUI.MENU),
		     out.toString());
    }

    public void testAddStudents() throws IOException {
	setup.selectAdd();
	setup.enterName(NAME);
	setup.selectAdd();
	setup.enterName("PEPE");
	StudentUI ui = new StudentUI(setup.getInput(), new PrintStream(out));

	ui.run();

	assertEquals(String.format("%s%n%s%s%n",
				   StudentUI.MENU,
				   StudentUI.NAME_PROMPT,
				   StudentUI.MENU),
		     out.toString());
	assertEquals("PEPE", ui.getStudent().getName());
    }
    
    private class TestSetup {
	private StringBuilder input = new StringBuilder();

	private void selectQuit() {
	    input.append(String.format("%s%n", StudentUI.QUIT_OPTION));
	}

	private void selectAdd() {
	    input.append(String.format("%s%n", StudentUI.ADD_OPTION));
	}

	private void enterName(String name) {
	    input.append(String.format("%s%n", name));
	}
	
	private InputStream getInput() {
	    return new ByteArrayInputStream(input.toString().getBytes());
	}
    }
}
