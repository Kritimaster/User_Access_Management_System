-- Create a sequence for generating auto-increment values for users, software, and requests tables
CREATE SEQUENCE users_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE software_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE requests_seq START WITH 1 INCREMENT BY 1;

-- Create users table
CREATE TABLE users (
    id NUMBER PRIMARY KEY,  -- Using NUMBER instead of SERIAL
    username VARCHAR2(100) UNIQUE,
    password CLOB,  -- Use CLOB for large text fields
    role VARCHAR2(20)
);

-- Create software table
CREATE TABLE software (
    id NUMBER PRIMARY KEY,  -- Using NUMBER instead of SERIAL
    name VARCHAR2(100),
    description CLOB,  -- Use CLOB for large text fields
    access_levels VARCHAR2(255)  -- Can hold values like 'Read, Write, Admin'
);

-- Create requests table
CREATE TABLE requests (
    id NUMBER PRIMARY KEY,  -- Using NUMBER instead of SERIAL
    user_id NUMBER,  -- Foreign key referencing the users table
    software_id NUMBER,  -- Foreign key referencing the software table
    access_type VARCHAR2(20),
    reason CLOB,  -- Use CLOB for large text fields
    status VARCHAR2(20),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_software FOREIGN KEY (software_id) REFERENCES software(id)
);

-- Create triggers to auto-increment the ID fields using the sequences
CREATE OR REPLACE TRIGGER users_trigger
  BEFORE INSERT ON users
  FOR EACH ROW
  BEGIN
    SELECT users_seq.NEXTVAL INTO :NEW.id FROM dual;
  END;

CREATE OR REPLACE TRIGGER software_trigger
  BEFORE INSERT ON software
  FOR EACH ROW
  BEGIN
    SELECT software_seq.NEXTVAL INTO :NEW.id FROM dual;
  END;

CREATE OR REPLACE TRIGGER requests_trigger
  BEFORE INSERT ON requests
  FOR EACH ROW
  BEGIN
    SELECT requests_seq.NEXTVAL INTO :NEW.id FROM dual;
  END;
