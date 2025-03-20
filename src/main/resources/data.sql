INSERT INTO students (student_name, email, phone_number)
VALUES ('Sok Dara', 'sokdara@example.com', '010123456'),
       ('Chantha Kim', 'chanthakim@example.com', '012987654'),
       ('Rithy Meas', 'rithymeas@example.com', '015456789'),
       ('Borey Soth', 'boreysoth@example.com', '016654321'),
       ('Srey Neang', 'sreyneang@example.com', '070112233'),
       ('Piseth Khun', 'pisethkhun@example.com', '077998877'),
       ('Dara Chhim', 'darachhim@example.com', '085334455'),
       ('Sokha Yem', 'sokhayem@example.com', '087667788'),
       ('Vireak Phan', 'vireakphan@example.com', '092556677'),
       ('Nita Heng', 'nitaheng@example.com', '097889900');


INSERT INTO instructors (instructor_name, email)
VALUES ('Sok Chea', 'sokchea@example.com'),
       ('Chan Vannak', 'chanvannak@example.com'),
       ('Rith Sopheak', 'rithsopheak@example.com'),
       ('Borey Dara', 'boreydara@example.com'),
       ('Srey Lin', 'sreylin@example.com'),
       ('Piseth Phan', 'pisethphan@example.com'),
       ('Dara Chhun', 'darachhun@example.com'),
       ('Sokha Heng', 'sokhaheng@example.com'),
       ('Vireak Kim', 'vireakkim@example.com'),
       ('Nita Meas', 'nitameas@example.com');

INSERT INTO courses (course_name, description, instructor_id)
VALUES ('Web Development', 'Learn to build modern websites', 2),
       ('Data Science', 'Introduction to data analysis and ML', 2),
       ('Cybersecurity', 'Fundamentals of network security', 3),
       ('Cloud Computing', 'Deploy and manage cloud applications', 4),
       ('Mobile App Development', 'Create apps for Android and iOS', 5),
       ('Artificial Intelligence', 'Basics of AI and deep learning', 6),
       ('Blockchain Technology', 'Introduction to decentralized apps', 7),
       ('Database Management', 'SQL and NoSQL database systems', 8),
       ('UI/UX Design', 'User interface and experience principles', 9),
       ('Software Testing', 'Techniques for testing and debugging', 10);

INSERT INTO student_course (student_id, course_id)
VALUES (2, 13), -- Chantha Kim -> Cybersecurity
       (3, 14), -- Rithy Meas -> Cloud Computing
       (4, 15), -- Borey Soth -> Mobile App Development
       (5, 16), -- Srey Neang -> Artificial Intelligence
       (6, 17), -- Piseth Khun -> Blockchain Technology
       (7, 18), -- Dara Chhim -> Database Management
       (8, 19), -- Sokha Yem -> UI/UX Design
       (9, 20), -- Vireak Phan -> Software Testing
       (10, 21); -- Nita Heng -> Spring Boot
