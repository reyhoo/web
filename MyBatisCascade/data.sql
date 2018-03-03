INSERT INTO t_employee	(real_name,sex,birthday,mobile,POSITION,note) VALUES('tom',1,NOW(),'1515151515','manager','is a good man');
INSERT INTO t_employee	(real_name,sex,birthday,mobile,POSITION,note) VALUES('lucy',0,NOW(),'15151515','hr','is a good girl');
INSERT INTO t_employee	(real_name,sex,birthday,mobile,POSITION,note) VALUES('jerry',1,NOW(),'110','coder','is a bad man');

INSERT INTO t_work_card(emp_id,real_name,department,mobile,POSITION,note)
VALUES(1,'tom','caiwu','1515151515','manager','is a good man');
INSERT INTO t_work_card(emp_id,real_name,department,mobile,POSITION,note)
VALUES(2,'lucy','renshi','15151515','hr','is a good girl');
INSERT INTO t_work_card(emp_id,real_name,department,mobile,POSITION,note)
VALUES(3,'jerry','kaifa','110','coder','is a bad man');


INSERT INTO t_task(title,context,note)VALUES('task1','task1context','task1 is very easy');
INSERT INTO t_task(title,context,note)VALUES('task2','task2context','task2 is very easy');
INSERT INTO t_task(title,context,note)VALUES('task3','task3context','task3 is very easy');
INSERT INTO t_task(title,context,note)VALUES('task4','task4context','task4 is very easy');
INSERT INTO t_task(title,context,note)VALUES('task5','task5context','task5 is very easy');


INSERT INTO t_employee_task(emp_id,task_id,task_name,note)VALUES(1,5,'task5CCCCCC','1 hao ren wu 5');
INSERT INTO t_employee_task(emp_id,task_id,task_name,note)VALUES(3,3,'task5CCCCCC','3 hao ren wu 3');
INSERT INTO t_employee_task(emp_id,task_id,task_name,note)VALUES(3,2,'task5CCCCCC','3 hao ren wu 2');
INSERT INTO t_employee_task(emp_id,task_id,task_name,note)VALUES(2,4,'task5CCCCCC','2 hao ren wu 4');
INSERT INTO t_employee_task(emp_id,task_id,task_name,note)VALUES(1,1,'task5CCCCCC','1 hao ren wu 1');



INSERT INTO t_male_health_form(emp_id,heart,liver,spleen,lung,kidney,prostate,note)VALUES
(1,'G','G','G','G','G','G','T');
INSERT INTO t_male_health_form(emp_id,heart,liver,spleen,lung,kidney,prostate,note)VALUES
(3,'G','G','G','G','G','G','J');
INSERT INTO t_female_health_form(emp_id,heart,liver,spleen,lung,kidney,uterus,note)VALUES
(2,'G','G','G','G','G','G','L');


