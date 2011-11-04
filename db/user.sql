DROP TABLE DBVENDOR.DB_SECURITY_USER CASCADE CONSTRAINTS;

CREATE TABLE DBVENDOR.DB_SECURITY_USER
(
  ID               NUMBER                       NOT NULL,
  USERNAME         VARCHAR2(200 BYTE),
  PASSWORD         VARCHAR2(255 BYTE),
  EMAIL            VARCHAR2(255 BYTE),
  FIRSTNAME        VARCHAR2(100 BYTE),
  LASTNAME         VARCHAR2(100 BYTE),
  USER_TYPE        VARCHAR2(100 BYTE)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


Insert into DB_SECURITY_USER
   (ID, USERNAME, PASSWORD, EMAIL, FIRSTNAME, 
    LASTNAME, USER_TYPE)
 Values
   (2146433532, 'admin', '9jD7DgMldUY=', 'admin@ekit.com', 'admin', 
    'admin', 'Admin');
Insert into DB_SECURITY_USER
   (ID, USERNAME, PASSWORD, EMAIL, FIRSTNAME, 
    LASTNAME, USER_TYPE)
 Values
   (2146433530, 'test', 'vCdhvdo07Bg=', 'test.@test.com', 'test', 
    'test', 'User');

COMMIT;
