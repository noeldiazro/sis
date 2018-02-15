package sis.studentinfo;

public interface Student extends Creditable,
				 Statable,
				 Gradable,
				 Chargable {

    static final String IN_STATE = "CO";
    
    String getName();
    String getFirstName();
    String getLastName();
    String getMiddleName();
}

