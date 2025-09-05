# StudentMiniApp

# Setup Instructions

1. **MySQL Database Setup**:
- CREATE DATABASE student;
- USE student;

- CREATE TABLE student_details (
- index INT,
- name VARCHAR(50),
- year VARCHAR(10),
- GPA DECIMAL(3,1)
- Table `student_details` has a column named `index` as the primary key.

);

   
2. **Java Setup**:
- Java 8 
- configure database connection
- compile
- run

3. **Assumptions / Notes**:
   - MySQL server is running locally.
   - Database credentials are set in `DBConnection.java`.
 