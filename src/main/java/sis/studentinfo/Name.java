package sis.studentinfo;

interface Name {
    static final int MAXIMUM_NUMBER_OF_PARTS = 3;
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getFullName();
}
