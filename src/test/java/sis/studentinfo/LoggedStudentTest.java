package sis.studentinfo;

import junit.framework.TestCase;

public class LoggedStudentTest extends TestCase {
    private Logger logger;
    private Student student;

    @Override public void setUp() {
	logger = new LoggerMock();
	student = new LoggedStudent(new FakeStudent(), logger);
    }
    
    public void testGettingGpaLogsTwice() {
	student.getGpa();
	assertEquals(2, ((LoggerMock)logger).getLogCount());
    }

    public void testGetFirstName() {
	assertEquals(FakeStudent.FIRST_NAME, student.getFirstName());
    }
	    
    private class FakeStudent implements Student {
	static final String FIRST_NAME = "FirstName";
	
	public String getFirstName() {
	    return FIRST_NAME;
	}
	
	public String getLastName() { return ""; }
	public String getMiddleName() { return ""; }
	public String getName() { return ""; }
	public void addCredits(int credits) { }
	public int getCredits() { return 0; }
	public boolean isFullTime() { return false; }
	public void setState(String state) { }
	public boolean isInState() { return false; }
	public void addGrade(Grade grade) { }
	public double getGpa() { return 0.0; }
	public void setGradingStrategy(GradingStrategy strategy) {}
	public void addCharge(Charge charge) {}
	public Charge totalCharges() { return new Charge(0); }
	public void setId(String id) {}
	public String getId() { return ""; }
    }

    private class LoggerMock implements Logger {
	private int logCount = 0;
	
	public void log(String message) {
	    logCount++;
	}

	int getLogCount() {
	    return logCount;
	}
    }
}
