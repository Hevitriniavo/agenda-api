CREATE TABLE STUDENT_LEVELS (
    id SERIAL PRIMARY KEY,
    level_name VARCHAR(50) NOT NULL,
    description TEXT
);

CREATE TABLE USERS (
    id SERIAL PRIMARY KEY,
    lastname VARCHAR(299),
    firstname VARCHAR(299),
    image TEXT,
    password VARCHAR(299),
    email VARCHAR(299),
    birthdate DATE,
    gender VARCHAR(50) CHECK (gender IN ('MALE', 'FEMALE', 'OTHER')),
    role VARCHAR(50) CHECK (role IN ('ADMIN', 'PROFESSOR', 'STUDENT')),
    level_id INT REFERENCES STUDENT_LEVELS(id)
);

CREATE TABLE CLASSROOMS (
    id SERIAL PRIMARY KEY,
    room_number VARCHAR(50),
    capacity INT,
    description TEXT
);

CREATE TABLE COURSES (
    id SERIAL PRIMARY KEY,
    course_name VARCHAR(255),
    professor_id INT,
    description TEXT,
    FOREIGN KEY (professor_id) REFERENCES USERS(id)
);

CREATE TABLE COURSE_SCHEDULE (
    id SERIAL PRIMARY KEY,
    course_id INT,
    start_time TIME,
    end_time TIME,
    day_of_week VARCHAR(20),
    month VARCHAR(20),
    year INT,
    classroom_id INT,
    FOREIGN KEY (course_id) REFERENCES COURSES(id),
    FOREIGN KEY (classroom_id) REFERENCES CLASSROOMS(id)
);