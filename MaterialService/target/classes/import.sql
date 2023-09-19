USE db;


CREATE TABLE IF NOT EXISTS material_category(
  category_id varchar(255),
  category_name varchar(255),
   PRIMARY KEY  (category_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO material_category (category_id, category_name) VALUES ('C001', 'Thread');
INSERT INTO material_category (category_id, category_name) VALUES ('C002', 'Cloth');
INSERT INTO material_category (category_id, category_name) VALUES ('C003', 'Button');


CREATE TABLE IF NOT EXISTS unit(
  unit_id VARCHAR(255) NOT NULL,
  unit_name VARCHAR(255) NOT NULL,
  category_id VARCHAR(255) NOT NULL,
  CONSTRAINT unit_pk PRIMARY KEY (unit_id),
  CONSTRAINT unit_FK FOREIGN KEY(category_id) REFERENCES material_category(category_id)
);

INSERT INTO unit (unit_id,unit_name,category_id) VALUES ('U001','ABC','C001');
INSERT INTO unit (unit_id,unit_name,category_id) VALUES ('U002','DEF','C002');
INSERT INTO unit (unit_id,unit_name,category_id) VALUES ('U003','GHI','C003');
INSERT INTO unit (unit_id,unit_name,category_id) VALUES ('U004','RIT','C002');

 
CREATE TABLE IF NOT EXISTS material_type(
  type_id VARCHAR(255) NOT NULL,
  type_name VARCHAR(255) NOT NULL,
  category_id VARCHAR(255) NOT NULL,
  CONSTRAINT material_type_pk PRIMARY KEY (type_id),
  CONSTRAINT material_type_FK FOREIGN KEY(category_id) REFERENCES material_category(category_id)
);

INSERT INTO material_type (type_id,type_name,category_id) VALUES ('T001','PQR','C001');
INSERT INTO material_type (type_id,type_name,category_id) VALUES ('T002','STU','C002');
INSERT INTO material_type (type_id,type_name,category_id) VALUES ('T003','XYZ','C003');
INSERT INTO material_type (type_id,type_name,category_id) VALUES ('T004','ABC','C003');
 
commit;
