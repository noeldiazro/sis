package sis.studentinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Tracks all information pertinent to a course session
 */
abstract public class Session implements Iterable<Student> {
    private Course course;
    private List<Student> students = new ArrayList<Student>();
    private Date startDate;

    protected Session(Course course, Date startDate) {
	this.course = course;
	this.startDate = startDate;
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

    protected Date getStartDate() {
	return startDate;
    }

    public Date getEndDate() {
	final int daysPerWeek = 7;
	final int daysFromFridayToMonday = 3;
	final int numberOfDays =
	    getDurationInWeeks() * daysPerWeek - daysFromFridayToMonday;
	return DateUtil.addDays(getStartDate(), numberOfDays);
    }

    abstract protected int getDurationInWeeks();
}
