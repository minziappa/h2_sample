CREATE TABLE IF NOT EXISTS admin (
  admin_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  admin_id VARCHAR(100) NOT NULL,
  admin_name VARCHAR(200) NULL,
  admin_email VARCHAR(300) NULL,
  admin_auth VARCHAR(100) NULL,
  admin_status CHAR(2) NULL,
  admin_delete CHAR(1) NULL,
  user_id VARCHAR(100) NULL,
  mr_no INT NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (admin_no)
) ENGINE=innoDB DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS admin_mt (
  am_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  am_title VARCHAR(100) NULL,
  am_weight INT NULL,
  am_explain VARCHAR(300) NULL,
  am_status CHAR(2) NULL,
  am_delete CHAR(1) NULL,
  mt_no INT NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (am_no)
) ENGINE=innoDB DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX mt_no_idx1 ON admin_mt (mt_no);

CREATE TABLE IF NOT EXISTS notification (
  noti_no INT UNSIGNED NOT NULL,
  noti_title VARCHAR(100) NULL,
  noti_contents VARCHAR(200) NULL,
  noti_kind VARCHAR(30) NULL,
  noti_start TIMESTAMP NULL,
  noti_end TIMESTAMP NULL,
  noti_status CHAR(2) NULL,
  noti_delete CHAR(1) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (noti_no)
) ENGINE=innoDB DEFAULT CHARACTER SET = utf8;


CREATE TABLE abilists_sequence
(
	seq_name VARCHAR(30) NOT NULL,
	id BIGINT UNSIGNED NOT NULL DEFAULT '0',
	seq_explain VARCHAR(100) NULL,
	PRIMARY KEY (seq_name)
) ENGINE=innoDB DEFAULT CHARSET=utf8;
CREATE INDEX seq_name_idx1 ON abilists_sequence(seq_name);

INSERT INTO abilists_sequence (seq_name, id, seq_explain) VALUES("userTemp", 0, "for registering user in temp");
INSERT INTO abilists_sequence (seq_name, id, seq_explain) VALUES("notification", 0, "for the notification");



CREATE TABLE m_language (
  ml_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  ml_code VARCHAR(10) NOT NULL,
  ml_name VARCHAR(50) NOT NULL,
  ml_english_name VARCHAR(50) NOT NULL,
  ml_status CHAR(2) NULL,
  ml_delete CHAR(1) NULL DEFAULT '0',
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (ml_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;
CREATE UNIQUE INDEX ml_code_idx1 ON m_language (ml_code);

CREATE TABLE m_industry (
  mi_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  mi_large_category VARCHAR(100) NOT NULL,
  mi_middle_category VARCHAR(100) NOT NULL,
  mi_code VARCHAR(20) NOT NULL,
  mi_explain VARCHAR(300) NULL,
  ml_code VARCHAR(10) NOT NULL,
  mi_status CHAR(2) NULL,
  mi_delete CHAR(1) NULL DEFAULT '0',
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (mi_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;
CREATE INDEX ml_code_idx1 ON m_industry(ml_code);

CREATE TABLE m_role (
  mr_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  mr_name VARCHAR(100) NOT NULL,
  mr_code VARCHAR(20) NULL,
  mr_explain VARCHAR(300) NULL,
  mr_responsibilities VARCHAR(300) NULL,
  mr_works VARCHAR(200) NULL,
  mr_skills VARCHAR(300) NULL,
  mr_prefers VARCHAR(200) NULL,
  ml_code VARCHAR(10) NOT NULL,
  mr_status CHAR(2) NULL,
  mr_delete CHAR(1) NULL DEFAULT '0',
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (mr_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;
CREATE UNIQUE INDEX mr_name_idx1 ON m_role (mr_name);

CREATE TABLE m_tech (
  mt_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  mt_skill VARCHAR(100) NULL,
  mt_kind VARCHAR(100) NULL,
  mt_name VARCHAR(100) NOT NULL,
  mt_version VARCHAR(30) NULL,
  mt_explain VARCHAR(300) NULL,
  mt_relation VARCHAR(200) NULL,
  mt_trend VARCHAR(100) NULL,
  ml_code VARCHAR(10) NOT NULL,
  mt_status CHAR(2) NULL,
  mt_delete CHAR(1) NULL DEFAULT '0',
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (mt_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE TABLE m_tech_detail (
  mtd_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  mt_no INT NULL,
  mt_kind VARCHAR(100) NULL,
  mtd_level INT NULL,
  mtd_level_explain VARCHAR(30) NULL,
  ml_code VARCHAR(10) NOT NULL,
  mtd_status CHAR(2) NULL,
  mtd_delete CHAR(1) NULL DEFAULT '0',
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (mtd_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;
CREATE INDEX mt_kind_idx1 ON m_tech_detail (mt_kind);




CREATE TABLE users_noti (
  un_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id VARCHAR(100) NOT NULL,
  noti_no INT NOT NULL,
  un_status CHAR(2) NULL,
  un_delete CHAR(1) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (un_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE TABLE users (
  user_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id VARCHAR(100) NOT NULL,
  user_pwd VARCHAR(200) NOT NULL,
  user_auth VARCHAR(100) NULL,
  user_name VARCHAR(100) NULL,
  user_img_name VARCHAR(100) NULL,
  user_img MEDIUMBLOB NULL,
  user_sex VARCHAR(10) NULL,
  user_email VARCHAR(50) NULL,
  user_ages INT DEFAULT 0,
  user_profile VARCHAR(300) NULL,
  user_status CHAR(2) NULL,
  user_delete CHAR(1) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (user_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE UNIQUE INDEX user_id_idx1 ON users (user_id);
CREATE INDEX user_name_idx2 ON users (user_name);

CREATE TABLE user_tech (
  ut_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  ut_skill VARCHAR(100) NULL,
  ut_kind VARCHAR(100) NULL,
  ut_level VARCHAR(2) NULL,
  ut_detail VARCHAR(200) NULL,
  ut_status CHAR(2) NULL,
  ut_delete CHAR(1) NULL,
  mt_no INT NULL,
  user_id VARCHAR(100) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (ut_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;
CREATE INDEX mt_no_idx1 ON user_tech (mt_no);

CREATE TABLE user_projects_tech (
  upt_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  upt_kind VARCHAR(100) NULL,
  upt_level VARCHAR(100) NULL,
  upt_detail VARCHAR(200) NULL,
  upt_status CHAR(2) NULL,
  upt_delete CHAR(1) NULL,
  mt_no INT NULL,
  up_no INT NULL,
  user_id VARCHAR(100) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (upt_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE INDEX mt_no_idx1 ON user_projects_tech (mt_no);
CREATE INDEX up_no_idx2 ON user_projects_tech (up_no);

CREATE TABLE user_projects (
  up_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  up_name VARCHAR(100) NOT NULL,
  up_industrial VARCHAR(100) NULL,
  up_explain VARCHAR(300) NULL,
  up_members VARCHAR(7) NULL,
  up_role VARCHAR(150) NULL,
  up_status CHAR(2) NULL,
  up_delete CHAR(1) NULL,
  user_id VARCHAR(100) NULL,
  mr_name VARCHAR(100) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (up_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE INDEX up_name_idx1 ON user_projects (up_name);
CREATE INDEX user_id_idx2 ON user_projects (user_id);

CREATE TABLE user_task (
  utk_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
  utk_work_day TIMESTAMP NULL,
  utk_work_hour VARCHAR(2) NULL,
  utk_work_progress VARCHAR(2) NULL,
  utk_task VARCHAR(300) NULL,
  utk_status CHAR(2) NULL,
  utk_delete CHAR(1) NULL,
  up_no INT UNSIGNED DEFAULT 0 NULL,
  mt_no INT DEFAULT 0 NULL,
  user_id VARCHAR(100) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (utk_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE INDEX user_id_idx1 ON user_task (user_id);
CREATE INDEX utk_work_day_idx2 ON user_task (utk_work_day);

CREATE TABLE user_temp
(
	user_temp_num BIGINT UNSIGNED NOT NULL,
	user_temp_email VARCHAR(200) NOT NULL,
	user_temp_token VARCHAR(300) NOT NULL,
	user_temp_status CHAR(1) NOT NULL,
	insert_date TIMESTAMP NOT NULL,
	update_date TIMESTAMP NOT NULL,
	PRIMARY KEY (user_temp_num)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE INDEX user_temp_num_idx1 ON user_temp(user_temp_num);

