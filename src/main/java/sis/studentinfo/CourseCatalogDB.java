package sis.studentinfo;

interface CourseCatalogDB {
    void store(CourseCatalog catalog) throws CourseCatalogDBException;
    void load(CourseCatalog catalog) throws CourseCatalogDBException;
}
