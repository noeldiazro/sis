package sis.studentinfo;

class BasicGradingStrategy implements GradingStrategy {
    public int getGradePointsFor(Student.Grade grade) {
	return grade.getPoints();
    }
}
