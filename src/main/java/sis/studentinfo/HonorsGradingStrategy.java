package sis.studentinfo;

class HonorsGradingStrategy implements GradingStrategy {
    private GradingStrategy regularStrategy = new RegularGradingStrategy();
    
    public int getGradePointsFor(Student.Grade grade) {
	int basicPoints = regularStrategy.getGradePointsFor(grade);
	if (basicPoints == 0) {
	    return basicPoints;
	} 
	return basicPoints + 1;
    }
}
