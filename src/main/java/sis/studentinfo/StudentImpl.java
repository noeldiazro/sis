package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements Student {
    
    private Name name;
    private String id;
    private int credits = 0;
    private String stateOfResidence = "";
    private List<Grade> grades = new ArrayList<Grade>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    private ChargeBook charges = new ChargeBook();
    private static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    
    public StudentImpl(String name) {
	this.name = NameImpl.create(name);
    }

    public String getName() {
	return name.getFullName();
    }

    public String getFirstName() {
	return name.getFirstName();
    }

    public String getLastName() {
	return name.getLastName();
    }

    public String getMiddleName() {
	return name.getMiddleName();
    }

    public boolean isFullTime() {
	return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public int getCredits() {
	return credits;
    }

    public void addCredits(int credits) {
	this.credits += credits;
    }

    public boolean isInState() {
	return stateOfResidence.equals(IN_STATE);
    }

    public void setState(String state) {
	this.stateOfResidence = state;
    }

    public double getGpa() {
	if (grades.isEmpty()) {
	    return 0;
	}
	double total = 0.0;
	for (Grade grade: grades) {
	    total += gradingStrategy.getGradePointsFor(grade);
	}
	return total / grades.size();
    }

    public void addGrade(Grade grade) {
	grades.add(grade);
    }

    public void setGradingStrategy(GradingStrategy strategy) {
	gradingStrategy = strategy;
    }

    public void addCharge(Charge charge) {
	charges.add(charge);
    }

    public Charge totalCharges() {
	return charges.getTotal();
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getId() {
	return id;
    }

    @Override public boolean equals(Object obj) {
	if (obj == null)
	    return false;
	if (!(obj instanceof Student))
	    return false;
	
	Student that = (Student)obj;
	return this.getId() == that.getId();
    }

    @Override public int hashCode() {
	return this.getId().hashCode();
    }

    private int flags = 0x0;
    	
    boolean isOnCampus() {
	return isFlag(Flag.ON_CAMPUS);
    }

    void setOnCampus() {
	setFlag(Flag.ON_CAMPUS);
    }

    void unsetOnCampus() {
	unsetFlag(Flag.ON_CAMPUS);
    }

    boolean isTaxExempt() {
	return isFlag(Flag.TAX_EXEMPT);
    }

    void setTaxExempt() {
	setFlag(Flag.TAX_EXEMPT);
    }

    void unsetTaxExempt() {
	unsetFlag(Flag.TAX_EXEMPT);
    }

    boolean isMinor() {
	return isFlag(Flag.MINOR);
    }

    void setMinor() {
	setFlag(Flag.MINOR);
    }

    void unsetMinor() {
	unsetFlag(Flag.MINOR);
    }

    boolean isTroublemaker() {
	return isFlag(Flag.TROUBLEMAKER);
    }

    void setTroublemaker() {
	setFlag(Flag.TROUBLEMAKER);
    }

    void unsetTroublemaker() {
	unsetFlag(Flag.TROUBLEMAKER);
    }
    
    private boolean isFlag(Flag flag) {
	int mask = flag.getMask();
	return (flags & mask) == mask;
    }

    private void setFlag(Flag flag) {
	flags = flags | flag.getMask();
    }

    private void unsetFlag(Flag flag) {
	flags = flags & (~flag.getMask());
    }
	
    private enum Flag {
	ON_CAMPUS(1),
	TAX_EXEMPT(2),
	MINOR(4),
	TROUBLEMAKER(8);
	
	private int mask;
	
	Flag(int mask) {
	    this.mask = mask;
	}

	int getMask() {
	    return mask;
	}
    }
}
