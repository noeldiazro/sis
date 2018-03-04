package sis.studentinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CourseCatalog {
    private String filename;
    private CourseCatalogDB db;
    private List<Session> sessions = new ArrayList<Session>();
    
    CourseCatalog(String filename) {
	this(new FileCourseCatalogDB(filename));
	this.filename = filename;
    }

    CourseCatalog(CourseCatalogDB db) {
	this.db = db;
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

    void store() throws CourseCatalogDBException {
	db.store(this);
    }

    void load() throws CourseCatalogDBException {
	db.load(this);
    }
}
