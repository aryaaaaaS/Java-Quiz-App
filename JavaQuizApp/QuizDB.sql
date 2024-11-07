CREATE DATABASE quizdb;
USE quizdb;
CREATE TABLE questions (
    question_id INT AUTO_INCREMENT PRIMARY KEY,
    question_text VARCHAR(255) NOT NULL,
    option1 VARCHAR(100) NOT NULL,
    option2 VARCHAR(100) NOT NULL,
    option3 VARCHAR(100) NOT NULL,
    option4 VARCHAR(100) NOT NULL,
    answer VARCHAR(100) NOT NULL
);
INSERT INTO questions (question_text, option1, option2, option3, option4, answer) VALUES
("What is the default value of an int variable in Java?", "0", "null", "undefined", "1", "0"),
("Which keyword is used to inherit a class in Java?", "extends", "implements", "inherits", "instanceof", "extends"),
("Which method is used to start a thread execution in Java?", "run()", "start()", "execute()", "init()", "start()"),
("Which of the following is not a Java feature?", "Object-oriented", "Use of pointers", "Portable", "Dynamic", "Use of pointers"),
("Which access modifier allows a member to be accessed within the same package?", "public", "private", "protected", "default", "default"),
("In Java, which of the following is not a primitive data type?", "int", "float", "String", "char", "String"),
("Which method is used to get the length of a String in Java?", "size()", "length()", "getSize()", "getLength()", "length()"),
("What is the superclass of all classes in Java?", "Object", "Class", "Superclass", "Base", "Object"),
("Which package is imported by default in every Java program?", "java.util", "java.lang", "java.io", "java.awt", "java.lang"),
("Which of the following is used to create an object in Java?", "new", "create", "newObject", "construct", "new");
SELECT * FROM questions;


