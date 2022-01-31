CREATE TABLE IF NOT EXISTS TOUROPERATORS_TABLE
(
    touroperator_id          VARCHAR(50)        NOT NULL,
    touroperator_name        VARCHAR(50)        NOT NULL,
    touroperator_phoneNumber VARCHAR(50) UNIQUE NOT NULL,
    touroperator_email       VARCHAR(50) UNIQUE NOT NULL,
    CONSTRAINT touroperator_table_pk PRIMARY KEY (touroperator_id)
);

CREATE TABLE IF NOT EXISTS TOURS_TABLE
(
    tour_id            VARCHAR(50)        NOT NULL,
    tour_country       VARCHAR(50)        NOT NULL,
    tour_hotel         VARCHAR(50)        NOT NULL,
    tour_departureDate DATE               NOT NULL,
    tour_returnDate    DATE               NOT NULL,
    tour_proposal      VARCHAR(15) UNIQUE NOT NULL,
    touroperator_id    VARCHAR(50)        NOT NULL,
    CONSTRAINT tour_table_pk PRIMARY KEY (tour_id),
    FOREIGN KEY (touroperator_id) REFERENCES TOUROPERATORS_TABLE (touroperator_id)
);

CREATE TABLE IF NOT EXISTS ACCOUNTING_TABLE
(
    accounting_id                 VARCHAR(50)   NOT NULL,
    accounting_tour_price         FLOAT         NOT NULL,
    accounting_tour_paid          FLOAT         NOT NULL,
    accounting_commissionPercent  NUMERIC(5, 2) NOT NULL,
    accounting_touroperator_price FLOAT         NOT NULL,
    accounting_touroperator_paid  FLOAT         NOT NULL,
    accounting_profit             FLOAT         NOT NULL,
    CONSTRAINT accounting_table_pk PRIMARY KEY (accounting_id)
);

CREATE TABLE IF NOT EXISTS CUSTOMERS_TABLE
(
    customer_id          VARCHAR(50)        NOT NULL,
    customer_firstName   VARCHAR(50)        NOT NULL,
    customer_lastName    VARCHAR(50)        NOT NULL,
    customer_phoneNumber VARCHAR(15) UNIQUE NOT NULL,
    customer_email       VARCHAR(50) UNIQUE,
    CONSTRAINT customer_table_pk PRIMARY KEY (customer_id)
);

CREATE TABLE IF NOT EXISTS MANAGERS_TABLE
(
    manager_id          VARCHAR(50)        NOT NULL,
    manager_firstName   VARCHAR(50)        NOT NULL,
    manager_lastName    VARCHAR(50)        NOT NULL,
    manager_salary      FLOAT              NOT NULL,
    manager_hireDate    DATE               NOT NULL,
    manager_phoneNumber VARCHAR(15) UNIQUE NOT NULL,
    manager_email       VARCHAR(50) UNIQUE NOT NULL,
    manager_login       VARCHAR(50) UNIQUE NOT NULL,
    manager_password    VARCHAR(255)       NOT NULL,
    manager_role        VARCHAR(20)        NOT NULL,
    manager_status      VARCHAR(20)        NOT NULL,
    CONSTRAINT manager_table_pk PRIMARY KEY (manager_id)
);

CREATE TABLE IF NOT EXISTS ORDERS_TABLE
(
    order_id      SERIAL      NOT NULL,
    tour_id       VARCHAR(50) NOT NULL,
    customer_id   VARCHAR(50) NOT NULL,
    manager_id    VARCHAR(50) NOT NULL,
    accounting_id VARCHAR(50) NOT NULL,
    date          DATE        NOT NULL,
    status        VARCHAR(25) NOT NULL,
    CONSTRAINT order_table_pk PRIMARY KEY (order_id),
    FOREIGN KEY (tour_id) REFERENCES TOURS_TABLE (tour_id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS_TABLE (customer_id),
    FOREIGN KEY (manager_id) REFERENCES MANAGERS_TABLE (manager_id),
    FOREIGN KEY (accounting_id) REFERENCES ACCOUNTING_TABLE (accounting_id)
);