INSERT INTO user (USER_NAME_ID, USER_NAME)
VALUES ('U001', '김면곤'), ('U002', '김예민'), ('U003', '조효소'), ('U004', '한니수');

INSERT INTO question (QUESTION, QUESTION_ID)
VALUES ('1. 교수는 수업 전 강의 목표를 명확히 제시하였습니까?', 'Q001'),
('2. 강의의 내용은 체계적이고 성의있게 구성되었는가?', 'Q002'),
('3. 교수는 강의 내용에 대해 전문적 지식이 있었는가?', 'Q003'),
('4. 강의 진행 속도는 적절하였는가?', 'Q004');

INSERT INTO answer (ANSWER, ANSWER_ID, QUESTION_ID)
VALUES ('(1)전혀 아니다.', 'A001','Q001'),
('(2)아니다.', 'A002', 'Q002'),
('(3)그렇다.', 'A003', 'Q003'),
('(4)매우그렇다.', 'A004', 'Q004')
;

INSERT INTO statistics (STATISTICS_ID,QUESTION_ID, ANSWER_ID, USER_NAME_ID)
VALUES ('S001','Q001', 'A004', 'U001'),
('S002','Q002', 'A001', 'U001'),
('S003','Q003', 'A004', 'U001'),
('S004','Q004', 'A002', 'U001'),
('S005','Q001', 'A002', 'U002'),
('S006','Q002', 'A002', 'U002'),
('S007','Q003', 'A001', 'U002'),
('S008','Q004', 'A002', 'U002'),
('S009','Q001', 'A002', 'U003'),
('S010','Q002', 'A001', 'U003'),
('S011','Q003', 'A003', 'U003'),
('S012','Q004', 'A003', 'U003'),
('S013','Q001', 'A001', 'U004'),
('S014','Q002', 'A004', 'U004'),
('S015','Q003', 'A004', 'U004'),
('S016','Q004', 'A004', 'U004')
;