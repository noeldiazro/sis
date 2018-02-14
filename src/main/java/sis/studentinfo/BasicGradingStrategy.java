package sis.studentinfo;

class BasicGradingStrategy implements GradingStrategy {
    public int getGradePointsFor(Grade grade) {
	return grade.getPoints();
    }
}
