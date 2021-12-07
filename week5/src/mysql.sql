-- 第一题
CREATE TABLE cqupt_student
(
    student VARCHAR(10),
    name    VARCHAR(20),
    sex     VARCHAR(2),
    age     INTEGER,
    Fee     DECIMAL(10, 2),
    address VARCHAR(50),
    memo    VARCHAR(300)
);

-- 第二题
CREATE TABLE CourseAa
(
    Aa1 VARCHAR(20),
    Aa2 INTEGER,
    Aa3 DECIMAL(10)
);

-- 第三题
CREATE TABLE ChooseBb
(
    Bb1 VARCHAR(30),
    Bb2 INTEGER,
    Bb3 DECIMAL(6)
);

-- 第四题
ALTER TABLE ChooseBb
    ADD Bb4 VARCHAR(20) Not NULL DEFAULT '系统测试值';

-- 第五题
ALTER TABLE ChooseBb
    ADD Bb5 VARCHAR(10) PRIMARY KEY;

-- 第六题
Create View View_Choosebb(View_bb1, View_bb2, view_bb3)
AS
SELECT Bb1, Bb4, Bb5
FROM ChooseBb;

-- 第七题
Drop View View_Choosebb;

-- 第八题
Create Index Index_bb2 ON ChooseBb (Bb2 ASC) ;
Create Index Index_bb4 ON ChooseBb (Bb4 DESC) ;

-- 第九题
Drop Index Index_bb2 on ChooseBb;

-- 第十题
Create Table test
(
    Name    VARCHAR(20),
    Age     INTEGER,
    Score   NUMERIC(10, 2),
    address VARCHAR(60)
);

-- 第十一题
INSERT INTO test (Name, Age, Score, address)
VALUES ('赵一', 20, 580.00, '重邮宿舍12-3-5');
INSERT INTO test (Name, Age, Score, address)
VALUES ('钱二', 19, 540.00, '南福苑5-2-9');
INSERT INTO test (Name, Age, Score, address)
VALUES ('苏三', 21, 555.50, '学生新区21-5-15');
INSERT INTO test (Name, Age, Score, address)
VALUES ('李四', 22, 505.00, '重邮宿舍8-6-22');
INSERT INTO test (Name, Age, Score, address)
VALUES ('周五', 20, 495.50, '学生新区23-4-8');
INSERT INTO test (Name, Age, Score, address)
VALUES ('吴六', 19, 435.00, '南福苑2-5-12');

-- 第十二题
Create Table test_temp
(
    Name    VARCHAR(20),
    Age     INTEGER,
    Score   NUMERIC(10, 2),
    address VARCHAR(60)
);

-- 第十三题
INSERT INTO test (Name, Age, Score, address)
VALUES ('郑七', 21, 490.50, '重邮宿舍11-2-1');
INSERT INTO test (Name, Age, Score, address)
VALUES ('张八', 20, 560.00, '南福苑3-3-3');
INSERT INTO test (Name, Age, Score, address)
VALUES ('王九', 20, 495.50, '学生新区19-7-1');

-- 第十四题
INSERT INTO test
SELECT *
FROM test_temp;

-- 第十五题
UPDATE test
SET score=score + 5
WHERE age <= 20;

-- 第十六题
UPDATE test
set age=age - 1
WHERE address LIKE '南福苑%';

-- 第十七题
DELETE
FROM test
WHERE age >= 21
  AND score >= 500;

-- 第十八题
DELETE
FROM test
WHERE score <= 550
  and address like '重邮宿舍%';

-- 第十九题
CREATE TABLE Student
(
    SNO     VARCHAR(20),
    Name    VARCHAR(10),
    Age     INTEGER,
    College VARCHAR(30)
);
-- 第二十题
CREATE TABLE Course
(
    CourseID       VARCHAR(15),
    CourseName     VARCHAR(30),
    CourseBeforeID VARCHAR(15)
);

-- 第二十一题
CREATE TABLE Choose
(
    SNO      VARCHAR(20),
    CourseID VARCHAR(30),
    Score    DECIMAL(5, 2)
);

-- 第二十二题
INSERT INTO student
VALUES ('S0001', '张三', 20, '计算机学院');
INSERT INTO Student
VALUES ('S0002', '李四', 19, '通信学院');
INSERT INTO Student
VALUES ('S0002', '王五', 21, '计算机学院');

-- 第二十三题
INSERT INTO Course
VALUES ('C1', '计算机导论', NULL);
INSERT INTO Course
VALUES ('C2', 'C语言', 'C1');
INSERT INTO Course
VALUES ('C3', '数据结构', 'C2');

-- 第二十四题
INSERT INTO Choose
VALUES ('S0001', 'C1', 95);
INSERT INTO Choose
VALUES ('S0001', 'C2', 80);
INSERT INTO Choose
VALUES ('S0001', 'C3', 84);
INSERT INTO Choose
VALUES ('S0002', 'C1', 80);
INSERT INTO Choose
VALUES ('S0002', 'C2', 85);
INSERT INTO Choose
VALUES ('S0003', 'C1', 78);
INSERT INTO Choose
VALUES ('S0003', 'C3', 70);

-- 第二十五题
SELECT sno, name
FROM student
WHERE College = '计算机学院';

-- 第二十六题
SELECT *
FROM student
WHERE age BETWEEN 20 and 23;

-- 第二十七题
SELECT count(*)
FROM student;

-- 第二十八题
SELECT max(score), min(score), sum(score), avg(score)
FROM Choose
WHERE CourseID = 'C1';

-- 第二十九题
SELECT CourseID, CourseName
FROM Course
WHERE CourseBeforeID is NULL;

-- 第三十题
SELECT student.SNO, Name, courseName, Score
FROM student,
     Choose,
     Course
WHERE student.SNO = Choose.SNO
  and Course.CourseID = Choose.CourseID;

-- 第三十一题
SELECT *
FROM student S1
WHERE EXISTS(
              SELECT *
              FROM student S2
              WHERE S1.College = S2.College
                and S2.Name = '张三');

-- 第三十二题
SELECT SNO, score
FROM Choose
WHERE CourseID = 'C1'
  and score < (
    SELECT score
    FROM Choose
    WHERE CourseID = 'C1'
      and SNO = (
        SELECT SNO
        FROM student
        WHERE Name = '张三'));

-- 第三十三题
SELECT SNO
FROM Choose
WHERE CourseID = 'C1'
UNION
SELECT SNO
FROM Choose
WHERE CourseID = 'C3';

-- 第三十四题
SELECT DISTINCT SNO
FROM Choose
WHERE CourseID = 'C1'
UNION
SELECT DISTINCT SNO
FROM Choose
WHERE CourseID = 'C3';
