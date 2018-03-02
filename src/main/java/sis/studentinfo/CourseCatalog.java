package sis.studentinfo;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CourseCatalog {
    private String filename;
    private List<Session> sessions = new ArrayList<Session>();
    
    CourseCatalog(String filename) {
	this.filename = filename;
    }

    List<Session> getSessions() {
	return sessions;
    }

    void add(Session session) {
	sessions.add(session);
    }

    void clear() {
	sessions = new ArrayList<Session>();
    }

    void store() throws IOException {
	DataOutputStream output = null;
	try {
	    output = new DataOutputStream(new FileOutputStream(filename));
	    output.writeInt(getNumberOfSessions());
	    for (Session session: getSessions()) {
		output.writeUTF(session.getDepartment());
		output.writeUTF(session.getNumber());
		output.writeLong(session.getStartDate().getTime());
	    }
	}
	finally {
	    output.close();
	}
    }

    private int getNumberOfSessions() {
	return getSessions().size();
    }
    
    void load() throws IOException {
	DataInputStream input = null;
	try {
	    if (new File(filename).exists()) {
		input = new DataInputStream(new FileInputStream(filename));

		int numberOfStoredSessions = input.readInt();
		for (int i=0; i < numberOfStoredSessions; i++) {
		    String department = input.readUTF();
		    String number = input.readUTF();
		    Date startDate = new Date(input.readLong());
		    add(RegularSession.create(new Course(department, number), startDate));
		}
	    }
	}
	finally {
	    if (input != null)
		input.close();
	}
    }
}
