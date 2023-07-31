-- #################### Question ####################
INSERT INTO question (
    id,
    title,
    description,
    category,
    answer_1,
    answer_2,
    answer_3,
    answer_4,
    right_answer
) VALUES (
    1,
    'What is a correct syntax to output "Hello World" in Java?',
    'Choose only one option.',
    'java',
    'echo("Hello World");',
    'System.out.println("Hello World");',
    'println("Hello World")',
    'print("Hello World")',
    'System.out.println("Hello World");'
);

INSERT INTO question (
    id,
    title,
    description,
    category,
    answer_1,
    answer_2,
    answer_3,
    answer_4,
    right_answer
) VALUES (
    2,
    'Java is short for "JavaScript".',
    'Choose only one option.',
    'java',
    'True',
    'False',
    'Null',
    'Yes',
    'False'
);

INSERT INTO question (
    id,
    title,
    description,
    category,
    answer_1,
    answer_2,
    answer_3,
    answer_4,
    right_answer
) VALUES (
    3,
    'How do you insert COMMENTS in Java code?',
    'Choose only one option.',
    'java',
    '//',
    '#',
    '/**/',
    '/*',
    '//'
);

INSERT INTO question (
    id,
    title,
    description,
    category,
    answer_1,
    answer_2,
    answer_3,
    answer_4,
    right_answer
) VALUES (
    4,
    'Which data type is used to create a variable that should store text?',
    'Choose only one option.',
    'java',
    'string',
    'char',
    'String',
    'Txt',
    'String'
);

INSERT INTO question (
    id,
    title,
    description,
    category,
    answer_1,
    answer_2,
    answer_3,
    answer_4,
    right_answer
) VALUES (
    5,
    'How do you create a variable with the numeric value 5?',
    'Choose only one option.',
    'java',
    'numeric number = 5',
    'Numeric number = 5;',
    'int n = 5;',
    'float f = 5;',
    'int n = 5;'
);

-- #################### Quiz ####################
INSERT INTO quiz (
    id,
    title,
    category
) VALUES (
    1,
    'Java basics',
    'java'
);

-- #################### Quiz Questions ####################
INSERT INTO quiz_questions (
    questions_id,
    quiz_id
) VALUES (
    1,
    1
);

INSERT INTO quiz_questions (
    questions_id,
    quiz_id
) VALUES (
    2,
    1
);

INSERT INTO quiz_questions (
    questions_id,
    quiz_id
) VALUES (
    3,
    1
);

INSERT INTO quiz_questions (
    questions_id,
    quiz_id
) VALUES (
    4,
    1
);

INSERT INTO quiz_questions (
    questions_id,
    quiz_id
) VALUES (
    5,
    1
);