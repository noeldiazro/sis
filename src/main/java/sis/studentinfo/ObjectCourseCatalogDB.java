package sis.studentinfo;

import java.io.*;
import java.util.List;

class ObjectCourseCatalogDB implements CourseCatalogDB {
    private String filename;
    
    ObjectCourseCatalogDB(String filename) {
	this.filename = filename;
    }

    public void store(CourseCatalog catalog) throws CourseCatalogDBException {
	try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))) {
	    output.writeObject(catalog.getSessions());
	}
	catch (IOException e) {
	    throw new CourseCatalogDBException(e);
	}
    }
    
    public void load(CourseCatalog catalog) throws CourseCatalogDBException {
	try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename))) {
	    List<Session> sessions = (List<Session>)input.readObject();
	    for (Session s: sessions)
		catalog.add(s);
	}
	catch (IOException e) {
	    throw new CourseCatalogDBException(e);
	}
	catch (ClassNotFoundException e) {
	    throw new CourseCatalogDBException(e);
	}
    }
}
