/*
 * This sql script will be executed automatically when the application is upgraded or patched. 
 * It is called from installScript.pl, which is located in the same (config) folder.
 * Add ALTER TABLE commands (if required) or use it for modification, insertion or deletion of records.
 * Note: ALTER TABLE commands are not required for adding new columns when hibernate.hbm2ddl.auto property is set
 * 		 to "update" in persistence.xml.  You can reliably use the "update" value (default) to update your schema
 *		 when upgrading your application, provided:
 *
 *				1. You only modify the schema of your own application.
 *				2. You don't setup any database triggers.
 *				3. You don't update column definitions or drop any columns in your schema (hibernate will not do this for you).
 *
*/
commit;