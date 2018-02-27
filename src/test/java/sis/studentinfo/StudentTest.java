package sis.studentinfo;

import junitx.extensions.EqualsHashCodeTestCase;

public class StudentTest extends EqualsHashCodeTestCase {
    private Student student;

    private static final double GPA_TOLERANCE = 0.005;
    
    public StudentTest() {
	super("StudentTest"); // Required by base class
    }
    
    @Override public void setUp() {
	try {
	    super.setUp();
	}
	catch (Exception e) {
	    fail();
	}
	student = new StudentImpl("Firstname Lastname");
    }
    
    public void testCreate() {
	assertEquals("Firstname Lastname", student.getName());
	assertEquals("Firstname", student.getFirstName());
	assertEquals("Lastname", student.getLastName());
	assertEquals("", student.getMiddleName());
    }
    
    public void testStudentStatus() {
	assertEquals(0, student.getCredits());
	assertFalse(student.isFullTime());

	student.addCredits(3);
	assertEquals(3, student.getCredits());
	assertFalse(student.isFullTime());

	student.addCredits(6);
	assertEquals(9, student.getCredits());
	assertFalse(student.isFullTime());

	student.addCredits(3);
	assertEquals(12, student.getCredits());
	assertTrue(student.isFullTime());
    }

    public void testStudentWithoutResidenceDataIsOutOfState() {
	assertFalse(student.isInState());
    }

    public void testStudentThatResidesInSchoolsStateIsInState() {
	student.setState(Student.IN_STATE);
	assertTrue(student.isInState());
    }

    public void testStudentThatDoesNotResideInSchoolsStateIsOutOfState() {
	student.setState(Student.IN_STATE);
	student.setState("MD");
	assertFalse(student.isInState());
    }

    public void testGpaIsZeroBeforeAnyGradesHaveBeenAddedToTheStudent() {
	assertEquals(0.0, student.getGpa(), GPA_TOLERANCE);
    }

    public void testStudentWithSeveralGradesGpa() {
	student.addGrade(Grade.A);
	student.addGrade(Grade.B);
	assertEquals(3.5, student.getGpa(), GPA_TOLERANCE);
    }

    public void testHonorsStudentGpa() {
	student.setGradingStrategy(new HonorsGradingStrategy());
	student.addGrade(Grade.A);
	student.addGrade(Grade.B);
	assertEquals(4.5, student.getGpa(), GPA_TOLERANCE);
    }

    public void testTotalChargesWhenNoCharges() {
	assertEquals(new Charge(0), student.totalCharges());
    }

    
    public void testTotalChargesWithOneCharge() {
	student.addCharge(new Charge(500));
	assertEquals(new Charge(500), student.totalCharges());
    }

    public void testTotalChargesWithSeveralCharges() {
	student.addCharge(new Charge(500));
	student.addCharge(new Charge(200));
	student.addCharge(new Charge(399));
	assertEquals(new Charge(1099), student.totalCharges());
    }

    public void testStudentId() {
	student.setId("1");
	assertEquals("1", student.getId());
    }

    @Override protected Object createInstance() {
	Student instance = new StudentImpl("Name");
	instance.setId("1");
	return instance;
    }
    
    @Override protected Object createNotEqualInstance() {
	Student instance = new StudentImpl("Name");
	instance.setId("2");
	return instance;
    }

    public void testDoesNotEqualNull() {
	Student instance = new StudentImpl("Name");
	instance.setId("1");
	assertFalse(instance.equals(null));
    }

    public void testDoesNotEqualNotStudentObjects() {
	Student instance = new StudentImpl("Name");
	instance.setId("1");
	assertFalse(instance.equals(new Object()));
    }

    public void testIsOnCampus() {
	StudentImpl student = new StudentImpl("a");
	assertFalse(student.isOnCampus());
    }

    public void testSetOnCampus() {
	StudentImpl student = new StudentImpl("a");
	student.setOnCampus();
	assertTrue(student.isOnCampus());
    }

    public void testUnsetOnCampus() {
	StudentImpl student = new StudentImpl("a");
	student.setOnCampus();
	student.unsetOnCampus();
	assertFalse(student.isOnCampus());
    }

    public void testStudentIsNotTaxExemptByDefault() {
	StudentImpl student = new StudentImpl("a");
	assertFalse(student.isTaxExempt());
    }

    public void testSetTaxExempt() {
	StudentImpl student = new StudentImpl("a");
	student.setTaxExempt();
	assertTrue(student.isTaxExempt());
    }

    public void testUnsetTaxExempt() {
	StudentImpl student = new StudentImpl("a");
	student.setTaxExempt();
	student.unsetTaxExempt();
	assertFalse(student.isTaxExempt());
    }

    public void testIsMinor() {
	StudentImpl student = new StudentImpl("a");
	assertFalse(student.isMinor());
    }

    public void testSetMinor() {
	StudentImpl student = new StudentImpl("a");
	student.setMinor();
	assertTrue(student.isMinor());
    }

    public void testUnsetMinor() {
	StudentImpl student = new StudentImpl("a");
	student.setMinor();
	student.unsetMinor();
	assertFalse(student.isMinor());
    }

    public void testIsNotTroublemakerByDefault() {
	StudentImpl student = new StudentImpl("a");
	assertFalse(student.isTroublemaker());
    }

    public void testSetTroublemaker() {
	StudentImpl student = new StudentImpl("a");
	student.setTroublemaker();
	assertTrue(student.isTroublemaker());
    }

    public void testUnsetTroublemaker() {
	StudentImpl student = new StudentImpl("a");
	student.setTroublemaker();
	student.unsetTroublemaker();
	assertFalse(student.isTroublemaker());
    }    
}
