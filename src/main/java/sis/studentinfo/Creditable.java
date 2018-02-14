package sis.studentinfo;

interface Creditable {
    boolean isFullTime();
    int getCredits();
    void addCredits(int credits);
}
