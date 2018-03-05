package sis.studentinfo;

class Bank {
    private final String aba;
    
    Bank(String aba) {
	this.aba = aba;
    }

    String getAba() {
	return aba;
    }
}
