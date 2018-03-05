package sis.studentinfo;

import java.io.Serializable;

public interface Student extends Creditable,
				 Statable,
				 Gradable,
				 Chargable,
				 Serializable {

    static final String IN_STATE = "CO";
    
    String getName();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    void setId(String id);
    String getId();
}

