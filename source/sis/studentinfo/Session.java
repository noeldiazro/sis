package sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * Tracks all information pertinent to a course session
 */
public class Session implements Iterable<Student> {
    private Course course;
    private List<Student> students = new ArrayList<Student>();
    private Date startDate;


    public Session(Course course, Date startDate) {
	this.course = course;
	this.startDate = startDate;
    }

    String getDepartment() {
	return course.getDepartment();
    }

    String getNumber() {
	return course.getNumber();
    }
    
    public int getNumberOfStudents() {
	return students.size();
    }

    public void enroll(Student student) {
	students.add(student);
    }

    Student get(int index) {
	return students.get(index);
    }

    Date getStartDate() {
	return startDate;
    }

    Date getEndDate() {
	Calendar calendar = new GregorianCalendar();
	calendar.setTime(startDate);
	final int courseDurationInWeeks = 16;
	final int daysPerWeek = 7;
	final int daysFromFridayToMonday = 3;
	final int numberOfDays =
	    courseDurationInWeeks * daysPerWeek - daysFromFridayToMonday;
	calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
      	return calendar.getTime();
    }

    public Iterator<Student> iterator() {
	return students.iterator();
    }
}
