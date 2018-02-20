package sis.studentinfo;

class LoggedStudent implements Student {
    private Student student;
    private Logger logger;
    
    LoggedStudent(Student student, Logger logger) {
	this.student = student;
	this.logger = logger;
    }

    public String getFirstName() {
	return student.getFirstName();
    }
    
    public String getLastName() {
	return student.getLastName();
    }
    
    public String getMiddleName() {
	return student.getMiddleName();
    }
    
    public String getName() {
	return student.getName();
    }
    
    public void addCredits(int credits) {
	student.addCredits(credits);
    }
    
    public int getCredits() {
	return student.getCredits();
    }
    
    public boolean isFullTime() {
	return student.isFullTime();
    }
    
    public void setState(String state) {
	student.setState(state);
    }
    
    public boolean isInState() {
	return student.isInState();
    }
    
    public void addGrade(Grade grade) {
	student.addGrade(grade);
    }

    public double getGpa() {
	logger.log("begin getGpa " + System.currentTimeMillis());
	double gpa = student.getGpa();
	logger.log("end getGpa " + System.currentTimeMillis());
	return gpa;
    }
    
    public void setGradingStrategy(GradingStrategy strategy) {
	student.setGradingStrategy(strategy);
    }
    
    public void addCharge(Charge charge) {
	student.addCharge(charge);
    }
    
    public Charge totalCharges() {
	return student.totalCharges();
    }

    public void setId(String id) {
	student.setId(id);
    }

    public String getId() {
	return student.getId();
    }
}
