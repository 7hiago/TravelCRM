INSERT INTO touroperators_table (touroperator_id, touroperator_name, touroperator_phoneNumber, touroperator_email)
VALUES ('TO-joinUp','joinUp', '00001', 'joinUp@gmail.com');
INSERT INTO touroperators_table (touroperator_id, touroperator_name, touroperator_phoneNumber, touroperator_email)
VALUES ('TO-anex', 'anex',   '00002', 'anex@gmail.com');
INSERT INTO touroperators_table (touroperator_id, touroperator_name, touroperator_phoneNumber, touroperator_email)
VALUES ('TO-tui', 'tui',    '00003', 'tui@gmail.com');

INSERT INTO tours_table (tour_id, tour_country, tour_hotel, tour_departureDate, tour_returnDate, tour_proposal, touroperator_id)
VALUES ('T-Dominican', 'Dominican Republic', 'Lopesan Costa Bavaro Resort, Spa & Casino', '2022-01-25', '2022-02-10', '12345', 'TO-joinUp');
INSERT INTO tours_table (tour_id, tour_country, tour_hotel, tour_departureDate, tour_returnDate, tour_proposal, touroperator_id)
VALUES ('T-Egypt', 'Egypt', 'Nubia Aqua Beach Resort', '2022-01-26', '2022-02-11', '12346', 'TO-anex');
INSERT INTO tours_table (tour_id, tour_country, tour_hotel, tour_departureDate, tour_returnDate, tour_proposal, touroperator_id)
VALUES ('T-Turkey', 'Turkey', 'Grand Seker Hotel', '2022-01-27', '2022-02-12', '12347', 'TO-tui');

INSERT INTO accounting_table (accounting_id, accounting_tour_price, accounting_tour_paid, accounting_commissionPercent, accounting_touroperator_price, accounting_touroperator_paid, accounting_profit)
VALUES ('A-20000', 20000, 20000, 10, 18000, 18000, 2000);
INSERT INTO accounting_table (accounting_id, accounting_tour_price, accounting_tour_paid, accounting_commissionPercent, accounting_touroperator_price, accounting_touroperator_paid, accounting_profit)
VALUES ('A-25000', 25000, 25000, 10, 22500, 18000, 2500);
INSERT INTO accounting_table (accounting_id, accounting_tour_price, accounting_tour_paid, accounting_commissionPercent, accounting_touroperator_price, accounting_touroperator_paid, accounting_profit)
VALUES ('A-30000', 30000, 30000, 10, 27000, 18000, 3000);

INSERT INTO customers_table (customer_id, customer_firstName, customer_lastName, customer_phoneNumber, customer_email)
VALUES ('C-Kate', 'Kate',  'PESTEROVA', '2935783276', 'cust1@gmail.com');
INSERT INTO customers_table (customer_id, customer_firstName, customer_lastName, customer_phoneNumber, customer_email)
VALUES ('C-Oleg', 'Oleg',  'PETRENKO',  '6935783476', 'cust2@gmail.com');
INSERT INTO customers_table (customer_id, customer_firstName, customer_lastName, customer_phoneNumber, customer_email)
VALUES ('C-Artem', 'Artem', 'POHORELOV', '5935283276', 'cust3@gmail.com');

INSERT INTO managers_table (manager_id, manager_firstName, manager_lastName, manager_salary, manager_hireDate, manager_phoneNumber, manager_email, manager_login, manager_password, manager_role, manager_status)
VALUES ('M-Admin', 'Admin', 'Admin',  10000, '2020-01-01', '1', 'admin@mail.com', 'admin', '$2a$12$ahdyR3T.5gbGXz2yaKToJeegbQ0kEIG8qRXwXqvPKM.rrf577I4jG', 'ROLE_ADMIN', 'ACTIVE');
INSERT INTO managers_table (manager_id, manager_firstName, manager_lastName, manager_salary, manager_hireDate, manager_phoneNumber, manager_email, manager_login, manager_password, manager_role, manager_status)
VALUES ('M-Marina', 'Marina', 'GAIBALOVA',  10000, '2020-01-14', '4935783276', 'mngr1@gmail.com', 'mngr1', '$2a$12$QNWXqu/pD0dD1zzlkgnt.em3cqu.7bIN9VvRQ5BVdjwWKwntwEzJO', 'ROLE_MANAGER', 'ACTIVE');
INSERT INTO managers_table (manager_id, manager_firstName, manager_lastName, manager_salary, manager_hireDate, manager_phoneNumber, manager_email, manager_login, manager_password, manager_role, manager_status)
VALUES ('M-Oksana', 'Oksana', 'ZHYTNETSKA', 10000, '2020-03-05', '3935783476', 'mngr2@gmail.com', 'mngr2', '$2a$12$pWfX/ntAGOWnYaKxjfbEm.LUvvHq0yBwb8gz1W9ivy6co.QOr1gia', 'ROLE_MANAGER', 'ACTIVE');
INSERT INTO managers_table (manager_id, manager_firstName, manager_lastName, manager_salary, manager_hireDate, manager_phoneNumber, manager_email, manager_login, manager_password, manager_role, manager_status)
VALUES ('M-Vera', 'Vera',   'KUCKOVSKA',  10000, '2020-06-23', '135283276',  'mngr3@gmail.com', 'mngr3', '$2a$12$32O9K.c9a9rEgYCk4cgdqubLiqC/DtCvmxQbJ9NQla8Vn0ZY7BW/2', 'ROLE_MANAGER', 'BANNED');

INSERT INTO orders_table (tour_id, customer_id, manager_id, accounting_id, date, status)
VALUES ('T-Dominican','C-Kate','M-Marina','A-20000','2022-01-01', 'reserved');
INSERT INTO orders_table (tour_id, customer_id, manager_id, accounting_id, date, status)
VALUES ('T-Egypt','C-Oleg','M-Oksana','A-25000','2022-02-02', 'reserved');
INSERT INTO orders_table (tour_id, customer_id, manager_id, accounting_id, date, status)
VALUES ('T-Turkey','C-Artem','M-Vera','A-30000','2022-03-03', 'reserved');
