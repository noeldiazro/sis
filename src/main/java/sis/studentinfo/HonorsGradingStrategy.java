package sis.studentinfo;

class HonorsGradingStrategy extends BasicGradingStrategy {

    public int getGradePointsFor(Grade grade) {
	int basicPoints = super.getGradePointsFor(grade);
	if (basicPoints == 0) {
	    return basicPoints;
	} 
	return basicPoints + 1;
    }
}
