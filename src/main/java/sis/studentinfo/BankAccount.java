package sis.studentinfo;

class BankAccount {

    private final Bank bank;
    private final String number;
    private final BankAccount.Type type;
    
    BankAccount(Bank bank, String number, BankAccount.Type type) {
	this.bank = bank;
	this.number = number;
	this.type = type;
    }

    String getAba() {
	return bank.getAba();
    }

    String getNumber() {
	return number;
    }

    BankAccount.Type getType() {
	return type;
    }
    
    enum Type {
	CHECKING("CHECKING"),
	SAVINGS("SAVINGS");

	private final String description;
	
	Type(String description) {
	    this.description = description;
	}

	@Override public String toString() {
	    return description;
	}
    }
}
