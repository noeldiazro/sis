package sis.studentinfo;

interface Gradable {
    double getGpa();
    void addGrade(Grade grade);
    void setGradingStrategy(GradingStrategy strategy);
}
