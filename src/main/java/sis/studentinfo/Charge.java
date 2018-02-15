package sis.studentinfo;

class Charge {
    private int cents;
    
    Charge(int cents) {
	this.cents = cents;
    }

    Charge sum(Charge that) {
	return new Charge(this.cents + that.cents);
    }

    @Override public boolean equals(Object obj) {
	Charge that = (Charge)obj;
	return this.cents == that.cents;
    }
}
