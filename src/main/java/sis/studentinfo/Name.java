package sis.studentinfo;

import java.io.Serializable;

interface Name extends Serializable {
    static final int MAXIMUM_NUMBER_OF_PARTS = 3;
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getFullName();
}
