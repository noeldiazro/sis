package sis.ui;

import sis.studentinfo.Course;

class CourseDisplayAdapter {
    private final Course course;
    
    CourseDisplayAdapter(final Course course) {
	this.course = course;
    }

    @Override public String toString() {
	return String.format("%s-%s", course.getDepartment(), course.getNumber());
    }
}
