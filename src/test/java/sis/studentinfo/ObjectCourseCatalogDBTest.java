package sis.studentinfo;

import junit.framework.TestCase;

public class ObjectCourseCatalogDBTest extends TestCase {
    public void testLoad_NoSessionsStored() {
	ObjectCourseCatalogDB db = new ObjectCourseCatalogDB("ObjectCourseCatalog.db");
	CourseCatalog catalog = new CourseCatalog(db);
	db.store(catalog);
	catalog.clear();
	db.load(catalog);
	assertTrue(catalog.getSessions().isEmpty());
    }

    public void testLoad_OneSessionStored() {
	ObjectCourseCatalogDB db = new ObjectCourseCatalogDB("ObjectCourseCatalog.db");
	CourseCatalog catalog = new CourseCatalog(db);
	catalog.add(RegularSession.create(new Course("ENGL", "101"), DateUtil.createDate(2018, 1, 8)));
	db.store(catalog);
	catalog.clear();
	db.load(catalog);
	assertEquals(1, catalog.getSessions().size());
    }
}
