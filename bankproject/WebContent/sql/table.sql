
//register table
DROP TABLE CUSTOMER;

DROP SEQUENCE CUSTOMER_ID_SEQ;
DROP SEQUENCE ACCNO_SEQ;
DROP SEQUENCE PIN_SEQ;


CREATE TABLE CUSTOMER(
CUSTOMER_ID NUMBER(5),
FIRST_NAME VARCHAR2(30) NOT NULL,
LAST_NAME VARCHAR2(20) NOT NULL,
USERNAME VARCHAR2(10) NOT NULL,
PASSWORD VARCHAR2(8) NOT NULL,
AGE NUMBER(3) NOT NULL,
DOB DATE NOT NULL,
SEX VARCHAR2(7)NOT NULL,

ADDRESS VARCHAR2(200) NOT NULL,
CITY VARCHAR2(15) NOT NULL;
STATE VARCHAR2(15) NOT NULL;
PINCODE NUMBER(7) NOT NULL;
PHONE_NO VARCHAR2(12) NOT NULL,
ALTERNATE_PHONE_NO VARCHAR2(12) DEFAULT 0,
EMAIL_ID VARCHAR2(30) NOT NULL,

FAV_TEACHER VARCHAR2(30) NOT NULL,
FAV_PET VARCHAR2(15) NOT NULL,
FIRST_SCHOOL VARCHAR2(35) NOT NULL,

ACCNO VARCHAR2(14),
AMOUNT NUMBER(10) DEFAULT 0,
PIN NUMBER(4) NOT NULL,
CREATED_DATE DATE
);

CREATE SEQUENCE CUSTOMER_ID_SEQ 
START WITH 1
INCREMENT BY 1;

ALTER TABLE CUSTOMER ADD
(
CONSTRAINT UQ_USERNAME
UNIQUE (USERNAME)
);

ALTER TABLE CUSTOMER ADD
(
CONSTRAINT UQ_PASSWORD
UNIQUE (PASSWORD)
);


ALTER TABLE CUSTOMER ADD
(
CONSTRAINT CHK_AGE
CHECK (AGE >10 AND AGE<=100)
);

ALTER TABLE CUSTOMER ADD
(
CONSTRAINT UQ_PHONE_NO
UNIQUE (PHONE_NO)
);

ALTER TABLE CUSTOMER ADD
(
CONSTRAINT UQ_EMAIL_ID
UNIQUE (EMAIL_ID)
);

ALTER TABLE CUSTOMER ADD
(
CONSTRAINT UQ_ALTERNATE_PHONE_NO
UNIQUE (ALTERNATE_PHONE_NO)
);

CREATE SEQUENCE ACCNO_SEQ
START WITH 64018123450
INCREMENT BY 7;



CREATE SEQUENCE PIN_SEQ
START WITH 6789
INCREMENT BY 21;


//create ministatementofsbm table
