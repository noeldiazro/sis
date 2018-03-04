package sis.studentinfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

class FileCourseCatalogDB implements CourseCatalogDB {
    private String filename;
    
    FileCourseCatalogDB(String filename) {
	this.filename = filename;
    }

    public void store(CourseCatalog catalog) throws CourseCatalogDBException {
	try (Storer storer = new Storer()) {
	    storer.store(catalog.getSessions());
	}
	catch (IOException e) {
	    throw new CourseCatalogDBException(e);
	}
    }

    private class Storer implements AutoCloseable {
	private DataOutputStream output;
	
	private void store(List<Session> sessions) throws IOException {
	    output = new DataOutputStream(new FileOutputStream(filename));
	    output.writeInt(sessions.size());
	    writeSessions(sessions);
	}

	private void writeSessions(List<Session> sessions) throws IOException {
	    for (Session session: sessions)
		writeSession(session);
	}

	private void writeSession(Session session) throws IOException {
	    output.writeUTF(session.getDepartment());
	    output.writeUTF(session.getNumber());
	    output.writeLong(session.getStartDate().getTime());
	}

	@Override public void close() throws IOException {
	    output.close();
	}
    }

    public void load(CourseCatalog catalog) throws CourseCatalogDBException {
	try (Loader loader = new Loader()) {
	    loader.load(catalog);
	}
	catch (IOException e) {
	    throw new CourseCatalogDBException(e);
	}
    }

    private class Loader implements AutoCloseable {
	private DataInputStream input;
	
	private void load(CourseCatalog catalog) throws IOException {
	    if (!isDbExisting()) return;

	    input = new DataInputStream(new FileInputStream(filename));
	    int numberOfStoredSessions = readNumberOfStoredSessions();
	    for (int i=0; i < numberOfStoredSessions; i++) {
		catalog.add(readSession());
	    }
	}

	private boolean isDbExisting() {
	    return new File(filename).exists();
	}

	private int readNumberOfStoredSessions() throws IOException {
	    return input.readInt();
	}

	private Session readSession() throws IOException {
	    String department = input.readUTF();
	    String number = input.readUTF();
	    Date startDate = new Date(input.readLong());
	    return RegularSession.create(new Course(department, number), startDate);
	}
	    
	@Override public void close() throws IOException {
	    if (input != null)
		input.close();
	}
    }
}
