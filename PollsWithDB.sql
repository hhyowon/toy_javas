
CREATE TABLE ANSWER
(
  ANSWER    VARCHAR(50) NOT NULL,
  ANSWER_ID VARCHAR(50) NOT NULL,
  PRIMARY KEY (ANSWER_ID)
) COMMENT '답변';

CREATE TABLE QUESTION
(
  Q_01      VARCHAR(50) NOT NULL,
  Q_02      VARCHAR(50) NOT NULL,
  Q_03      VARCHAR(50) NOT NULL,
  Q_04      VARCHAR(50) NOT NULL,
  Q_ID      VARCHAR(50) NOT NULL,
  ANSWER_ID VARCHAR(50) NOT NULL,
  USER_ID   VARCHAR(50) NOT NULL,
  PRIMARY KEY (Q_ID)
) COMMENT '문항';

CREATE TABLE STATISTICS
(
  USER_ID   VARCHAR(50) NOT NULL,
  Q_ID      VARCHAR(50) NOT NULL,
  ANSWER_ID VARCHAR(50) NOT NULL
) COMMENT '통계';

CREATE TABLE USER
(
  USER    VARCHAR(50) NOT NULL,
  USER_ID VARCHAR(50) NOT NULL,
  PRIMARY KEY (USER_ID)
) COMMENT '설문자';

ALTER TABLE STATISTICS
  ADD CONSTRAINT FK_USER_TO_STATISTICS
    FOREIGN KEY (USER_ID)
    REFERENCES USER (USER_ID);

ALTER TABLE STATISTICS
  ADD CONSTRAINT FK_QUESTION_TO_STATISTICS
    FOREIGN KEY (Q_ID)
    REFERENCES QUESTION (Q_ID);

ALTER TABLE STATISTICS
  ADD CONSTRAINT FK_ANSWER_TO_STATISTICS
    FOREIGN KEY (ANSWER_ID)
    REFERENCES ANSWER (ANSWER_ID);

ALTER TABLE QUESTION
  ADD CONSTRAINT FK_ANSWER_TO_QUESTION
    FOREIGN KEY (ANSWER_ID)
    REFERENCES ANSWER (ANSWER_ID);

ALTER TABLE QUESTION
  ADD CONSTRAINT FK_USER_TO_QUESTION
    FOREIGN KEY (USER_ID)
    REFERENCES USER (USER_ID);
