package sis.studentinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Tracks all information pertinent to a course session
 */
public class Session implements Iterable<Student> {
    private Course course;
    private List<Student> students = new ArrayList<Student>();
    private Date startDate;

    private static int count;
    static {
	count = 0;
    }

    private Session(Course course, Date startDate) {
	this.course = course;
	this.startDate = startDate;
    }

    public static Session create(Course course, Date startDate) {
	Session.incrementCount();	
	return new Session(course, startDate);
    }
    
    public int getNumberOfStudents() {
	return students.size();
    }

    public void enroll(Student student) {
	students.add(student);
	student.addCredits(course.getNumberOfCredits());
    }

    public Iterator<Student> iterator() {
	return students.iterator();
    }

    String getDepartment() {
	return course.getDepartment();
    }

    String getNumber() {
	return course.getNumber();
    }
    
    Student get(int index) {
	return students.get(index);
    }

    Date getStartDate() {
	return startDate;
    }

    Date getEndDate() {
	final int courseDurationInWeeks = 16;
	final int daysPerWeek = 7;
	final int daysFromFridayToMonday = 3;
	final int numberOfDays =
	    courseDurationInWeeks * daysPerWeek - daysFromFridayToMonday;
	return DateUtil.addDays(startDate, numberOfDays);
    }

    static int getCount() {
	return count;
    }

    static void resetCount() {
	count = 0;
    }

    private static void incrementCount() {
	count++;
    }
}
