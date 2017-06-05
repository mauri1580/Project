DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS employee_x_authority;

CREATE TABLE employee (
  id                      BIGINT          AUTO_INCREMENT PRIMARY KEY,
  email 					        VARCHAR(100)    NOT NULL UNIQUE,
  password 				        VARCHAR(60)     NOT NULL,
  first_name 				      VARCHAR(50)     NOT NULL,
  last_name 				      VARCHAR(50)     NOT NULL,
  create_timestamp        DATETIME        NOT NULL DEFAULT current_timestamp,
  update_timestamp        DATETIME        NOT NULL DEFAULT current_timestamp,
  create_employee_id      BIGINT          NOT NULL,
  update_employee_id      BIGINT          NOT NULL
);

CREATE TABLE authority (
  id              BIGINT        AUTO_INCREMENT PRIMARY KEY,
  name            VARCHAR(50)   NOT NULL,
  description     VARCHAR(255)  NULL
);

CREATE TABLE employee_x_authority (
  id  BIGINT AUTO_INCREMENT PRIMARY KEY,
  employee_id  BIGINT NOT NULL,
  authority_id BIGINT NOT NULL,
  CONSTRAINT employee_x_authority_fkey_employee_id FOREIGN KEY (employee_id) REFERENCES employee (id),
  CONSTRAINT employee_x_authority_fkey_authority_id FOREIGN KEY (authority_id) REFERENCES authority (id)
);

INSERT INTO employee(id, email, password, first_name, last_name, create_employee_id, update_employee_id) VALUES
  (0, 'admin@bb.com', '$2a$12$/JQU0SWuJWuctYNc4bFN6u7w8Y2f1jNlSped/TJeMU7YHB894/KIK', 'Admin', 'Nimda', 0,0),
  (1, 'drawer@bb.com', '$2a$12$/JQU0SWuJWuctYNc4bFN6u7w8Y2f1jNlSped/TJeMU7YHB894/KIK', 'Drawer', 'Reward', 0,0),
  (2, 'tester@bb.com', '$2a$12$/JQU0SWuJWuctYNc4bFN6u7w8Y2f1jNlSped/TJeMU7YHB894/KIK', 'Tester', 'Retest', 0,0),
  (3, 'requester@bb.com', '$2a$12$/JQU0SWuJWuctYNc4bFN6u7w8Y2f1jNlSped/TJeMU7YHB894/KIK', 'Requester', 'Retseuqer', 0,0);

INSERT INTO authority(id, name, description) VALUES
  (0, 'ADMIN', 'Administrates and has access to all'),
  (1, 'DRAWER', 'Adds new donors and takes blood'),
  (2, 'TESTER', 'Tests blood donations'),
  (3, 'REQUESTER', 'Makes requests for blood units');

INSERT INTO employee_x_authority(employee_id, authority_id) VALUES
  (0,0),
  (1,1),
  (2,2),
  (3,3);
