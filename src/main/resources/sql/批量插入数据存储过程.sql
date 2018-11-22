DELIMITER $$
CREATE PROCEDURE insert_batch_project(IN max_num INT(10))
    BEGIN
    DECLARE i INT DEFAULT 0;
    SET autocommit = 0;
    REPEAT
    SET i = i+1;
    INSERT INTO project(project_name,project_summary,project_type,reporter,STATUS,update_date,remark)VALUES(rand_string(15),rand_string(25),'自研项目',rand_string(6),1,NOW(),rand_string(4));    
    UNTIL i = max_num
    END REPEAT;
    COMMIT;    
    END$$
DELIMITER ;