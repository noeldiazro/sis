package sis.ui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import sis.studentinfo.Student;
import sis.studentinfo.StudentImpl;

public class StudentUI {

    static final String MENU = "(A)dd or (Q)uit?";
    static final String ADD_OPTION = "A";
    static final String QUIT_OPTION = "Q";
    static final String NAME_PROMPT = "Name: ";
    
    private BufferedReader in;
    private PrintStream out;

    private Student student;
    
    public StudentUI() {
	this(System.in, System.out);
    }

    public StudentUI(InputStream in, PrintStream out) {
	this.in = new BufferedReader(new InputStreamReader(in));
	this.out = out;
    }
    
    public void run() throws IOException {
	out.println(MENU);
	if (in.readLine().equals(ADD_OPTION)) {
	    out.print(NAME_PROMPT);
	    student = new StudentImpl(in.readLine());
	    out.println(MENU);
	}
    }

    Student getStudent() {
	return student;
    }
}
