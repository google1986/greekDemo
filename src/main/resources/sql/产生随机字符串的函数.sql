DELIMITER $$
CREATE OR  REPLACR FUNCTION rand_string(n INT) RETURNS VARCHAR(255)
    BEGIN
    DECLARE chars_str VARCHAR(100) DEFAULT 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    DECLARE return_str VARCHAR(255) DEFAULT '';
    DECLARE i INT DEFAULT 0;
    WHILE i < n DO
    SET return_str = CONCAT(return_str,SUBSTRING(chars_str,FLOOR(1+RAND()*52),1));
    SET i=i+1;
    END WHILE;
    RETURN return_str;
    END$$
DELIMITER ;