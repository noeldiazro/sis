package studentinfo;

class Course {
    private String department;
    private String number;
    
    Course(String department, String number) {
	this.department = department;
	this.number = number;
    }

    String getDepartment() {
	return department;
    }

    String getNumber() {
	return number;
    }
}
