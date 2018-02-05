package studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author Administrator
 */
class Session {
    private Course course;
    private List<Student> students = new ArrayList<Student>();
    private Date startDate;

    Session(Course course, Date startDate) {
	this.course = course;
	this.startDate = startDate;
    }

    String getDepartment() {
	return course.getDepartment();
    }

    String getNumber() {
	return course.getNumber();
    }
    
    int getNumberOfStudents() {
	return students.size();
    }

    void enroll(Student student) {
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
}
