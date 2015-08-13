--
-- File generated with SQLiteStudio v3.0.6 on Wed Aug 12 20:32:23 2015
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
--BEGIN TRANSACTION;

-- Table: relation_attribute_value
CREATE TABLE relation_attribute_value (id INTEGER PRIMARY KEY AUTOINCREMENT, relation_id REFERENCES event (id), relationship_attribute_id REFERENCES relationship_attribute (id), value TEXT, type TEXT);

-- Table: relationship
CREATE TABLE relationship (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, source REFERENCES class (id), target REFERENCES class (id));

-- Table: event
CREATE TABLE event (id INTEGER PRIMARY KEY AUTOINCREMENT, collection_id REFERENCES collection (id), ordering INTEGER);

-- Table: class
CREATE TABLE class (id INTEGER PRIMARY KEY AUTOINCREMENT, datamodel_id REFERENCES datamodel (id), name TEXT NOT NULL);

-- Table: relation
CREATE TABLE relation (id INTEGER PRIMARY KEY AUTOINCREMENT, relationship_id REFERENCES relationship (id), source_object_id REFERENCES object (id), target_object_id REFERENCES object (id), start_source_object_version_id REFERENCES event (id), end_source_object_version_id REFERENCES event (id), start_target_object_version_id REFERENCES event (id), end_target_object_version_id REFERENCES event (id), event_id REFERENCES event (id));

-- Table: event_attribute_name
CREATE TABLE event_attribute_name (id INTEGER PRIMARY KEY AUTOINCREMENT, collection_id REFERENCES collection (id), name TEXT);

-- Table: relationship_attribute
CREATE TABLE relationship_attribute (id INTEGER PRIMARY KEY AUTOINCREMENT, relationship_id REFERENCES relationship (id), source_attribute REFERENCES attribute_name (id), target_attribute REFERENCES attribute_name (id));

-- Table: object_version
CREATE TABLE object_version (id INTEGER PRIMARY KEY AUTOINCREMENT, object_id REFERENCES object (id), event_id REFERENCES event (id));

-- Table: object
CREATE TABLE object (id INTEGER PRIMARY KEY AUTOINCREMENT, class_id REFERENCES class (id));

-- Table: event_attribute_value
CREATE TABLE event_attribute_value (id INTEGER PRIMARY KEY AUTOINCREMENT, event_id REFERENCES event (id), event_attribute_name_id REFERENCES event_attribute_name (id), value TEXT, type TEXT);

-- Table: collection
CREATE TABLE collection (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);

-- Table: datamodel
CREATE TABLE datamodel (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);

-- Table: attribute_value
CREATE TABLE attribute_value (id INTEGER PRIMARY KEY AUTOINCREMENT, object_version_id REFERENCES event (id), attribute_name_id REFERENCES attribute_name (id), value TEXT, type TEXT);

-- Table: attribute_name
CREATE TABLE attribute_name (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, class_id REFERENCES class (id));

-- Table: pcase
CREATE TABLE pcase (id INTEGER PRIMARY KEY AUTOINCREMENT, log_id REFERENCES log (id));

-- Table: log
CREATE TABLE log (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, process_id REFERENCES process (id), collection_id REFERENCES collection (id));

-- Table: activity
CREATE TABLE activity (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, process_id REFERENCES process (id));

-- Table: process
CREATE TABLE process (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);

-- Table: event_to_case
CREATE TABLE event_to_case (case_id REFERENCES log (id) NOT NULL, event_id REFERENCES event (id) NOT NULL, ordering INTEGER, PRIMARY KEY (case_id, event_id));

--COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
