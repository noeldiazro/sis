package sis.performance;

class Performance {
    private int[] tests;
    
    Performance(int numberOfTests) {
	tests = new int[numberOfTests];
    }

    int get(int index) {
	return tests[index];
    }

    void set(int index, int score) {
	tests[index] = score;
    }

    void setScores(int... scores) {
	tests = scores;
    }
    
    double average() {
	double total = 0;
	for (int score: tests) {
	    total += score;
	}
	return total / tests.length;
    }
}
