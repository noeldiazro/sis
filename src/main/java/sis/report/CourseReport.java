package sis.report;

import java.util.ArrayList;
import java.util.List;
import sis.studentinfo.Course;
import static sis.report.ReportConstant.NEWLINE;

class CourseReport {
    private String text = "";
    private List<Course> courses = new ArrayList<Course>();
    
    String getText() {
	StringBuilder buffer = new StringBuilder();
	for (Course course: courses) {
	    buffer.append(getLineFor(course));
	}
	return buffer.toString();
    }

    void add(Course course) {
	courses.add(course);
    }

    private String getLineFor(Course course) {
	return course.getDepartment() + "\t" + course.getNumber() + NEWLINE; 
    }
}
