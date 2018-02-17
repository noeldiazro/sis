package sis.studentinfo;

import java.net.MalformedURLException;
import java.net.URL;
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
    private URL url;
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

    double getPartialStudentsAverageGpa() {
	if (getNumberOfStudents() == 0) {
	    return 0;
	}

	double total = 0.0;
	int count = 0;
	for (Student student: students) {
	    if (!student.isFullTime()) {
		total += student.getGpa();
		count++;
	    }
	}
	if (count == 0) {
	    return 0;
	} else {
	    return total / count;
	}
    }

    void setURL(String spec) throws InvalidURLException {
	try {
	    url = new URL(spec);
	}
	catch (MalformedURLException e) {
	    log(e);
	    throw new InvalidURLException(e.getMessage(), e);
	}
    }

    private void log(Exception e) {
	e.printStackTrace();
    }
    
    String getURL() {
	return url.toString();
    }
}
