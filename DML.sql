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