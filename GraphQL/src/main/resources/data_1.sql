-- Address seeds
INSERT INTO address (id, street, city)
VALUES
  (1, '123 Main Street', 'Springfield'),
  (2, '456 Elm Street', 'Shelbyville');

-- Student seeds
INSERT INTO student (id, first_name, last_name, email, address_id)
VALUES
  (1, 'John', 'Doe', 'john.doe@example.com', 1),
  (2, 'Jane', 'Smith', 'jane.smith@example.com', 2);

-- Subject seeds
INSERT INTO subject (id, subject_name, marks_obtained, student_id)
VALUES
  (1, 'Math', 90, 1),
  (2, 'Science', 85, 1),
  (3, 'History', 88, 2),
  (4, 'Literature', 92, 2);

select * from address;

select * from student;