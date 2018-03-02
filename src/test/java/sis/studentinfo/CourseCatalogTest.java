package sis.studentinfo;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;

public class CourseCatalogTest extends TestCase {
    private static final String FILENAME = "CourseCatalogTest.txt";
    private static final Date START_DATE;
    static {
	START_DATE = DateUtil.createDate(2018, 1, 8);
    }

    private CourseCatalog catalog;
    
    @Override public void setUp() throws Exception {
	super.setUp();
	catalog = new CourseCatalog(FILENAME);
    }

    @Override public void tearDown() throws Exception {
	super.setUp();
	File db = new File(FILENAME);
	if (db.exists())
	    db.delete();
    }

    public void testGetSessions_NoSessions() {
	List<Session> sessions = catalog.getSessions();
	assertTrue(sessions.isEmpty());
    }

    public void testGetSessions_OneSessionAdded() {
	catalog.add(createSession("ENGL", "101"));

	List<Session> sessions = catalog.getSessions();

	assertEquals(1, sessions.size());
    }

    public void testGetSessions_TwoSessionsAdded() {
	catalog.add(createSession("ENGL", "101"));
	catalog.add(createSession("MATH", "200"));

	List<Session> sessions = catalog.getSessions();

	assertEquals(2, sessions.size());
    }

    public void testGetSessions_ClearAfterTwoSessionsAdded() {
	catalog.add(createSession("ENGL", "101"));
	catalog.add(createSession("MATH", "200"));
	catalog.clear();

	List<Session> sessions = catalog.getSessions();

	assertEquals(0, sessions.size());
    }

    public void testLoad_NoSessionsStored() throws IOException {
	catalog.load();

	assertEquals(0, catalog.getSessions().size());
    }

    
    public void testLoad_OneSessionStored() throws IOException {
	catalog.add(createSession("ENGL", "101"));
	catalog.store();
	catalog.clear();
	catalog.load();

	List<Session> sessions = catalog.getSessions();
	
	assertEquals(1, sessions.size());
	assertEquals("ENGL", sessions.get(0).getDepartment());
	assertEquals("101", sessions.get(0).getNumber());
	assertEquals(START_DATE, sessions.get(0).getStartDate());
    }

    public void testLoad_TwoSessionsStored() throws IOException {
	catalog.add(createSession("ENGL", "101"));
	catalog.add(createSession("MATH", "200"));
	catalog.store();
	catalog.clear();
	catalog.load();
	
	List<Session> sessions = catalog.getSessions();
	
	assertEquals(2, sessions.size());
	assertEquals("ENGL", sessions.get(0).getDepartment());
	assertEquals("101", sessions.get(0).getNumber());
	assertEquals(START_DATE, sessions.get(0).getStartDate());
	assertEquals("MATH", sessions.get(1).getDepartment());
	assertEquals("200", sessions.get(1).getNumber());
	assertEquals(START_DATE, sessions.get(1).getStartDate());
    }
    
    private Session createSession(String department, String number) {
	Course course = new Course(department, number);
	return RegularSession.create(course, START_DATE);
    }
}
