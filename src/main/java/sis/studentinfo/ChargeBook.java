package sis.studentinfo;

import java.util.List;
import java.util.ArrayList;

class ChargeBook {
    private List<Charge> charges = new ArrayList<Charge>();

    void add(Charge charge) {
	charges.add(charge);
    }

    Charge getTotal() {
	Charge total = new Charge(0);
	for (Charge charge: charges) {
	    total = total.sum(charge);
	}
	return total;
    }
}
