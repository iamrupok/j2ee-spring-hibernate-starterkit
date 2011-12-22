ALTER TABLE DBVENDOR.COUNTRY
 DROP PRIMARY KEY CASCADE;
DROP TABLE DBVENDOR.COUNTRY CASCADE CONSTRAINTS;

CREATE TABLE DBVENDOR.COUNTRY
(
  ID             NUMBER                         NOT NULL,
  NAME           VARCHAR2(4000 BYTE)            NOT NULL,
  ISO_CODE       VARCHAR2(4000 BYTE)            NOT NULL,
  DISPLAY_ORDER  NUMBER                         DEFAULT 0                     NOT NULL
)
TABLESPACE DBVENDOR
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE UNIQUE INDEX DBVENDOR.COUNTRY_PK ON DBVENDOR.COUNTRY
(ID)
LOGGING
TABLESPACE SYSTEM
PCTFREE    10
INITRANS   2
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
NOPARALLEL;


ALTER TABLE DBVENDOR.COUNTRY ADD (
  CONSTRAINT COUNTRY_PK
 PRIMARY KEY
 (ID)
    USING INDEX 
    TABLESPACE SYSTEM
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                FREELISTS        1
                FREELIST GROUPS  1
               ));

			   
			   
		SET DEFINE OFF;
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (1, 'UNITED STATES', 'US', 0);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (2, 'AFGHANISTAN', 'AF', 1);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (3, 'ALAND ISLANDS', 'AX', 2);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (4, 'ALBANIA', 'AL', 3);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (5, 'ALGERIA', 'DZ', 4);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (6, 'AMERICAN SAMOA', 'AS', 5);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (7, 'ANDORRA', 'AD', 6);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (8, 'ANGOLA', 'AO', 7);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (9, 'ANGUILLA', 'AI', 8);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (10, 'ANTARCTICA', 'AQ', 9);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (11, 'ANTIGUA AND BARBUDA', 'AG', 10);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (12, 'ARGENTINA', 'AR', 11);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (13, 'ARMENIA', 'AM', 12);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (14, 'ARUBA', 'AW', 13);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (15, 'AUSTRALIA', 'AU', 14);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (16, 'AUSTRIA', 'AT', 15);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (17, 'AZERBAIJAN', 'AZ', 16);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (18, 'BAHAMAS', 'BS', 17);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (19, 'BAHRAIN', 'BH', 18);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (20, 'BANGLADESH', 'BD', 19);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (21, 'BARBADOS', 'BB', 20);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (22, 'BELARUS', 'BY', 21);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (23, 'BELGIUM', 'BE', 22);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (24, 'BELIZE', 'BZ', 23);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (25, 'BENIN', 'BJ', 24);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (26, 'BERMUDA', 'BM', 25);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (27, 'BHUTAN', 'BT', 26);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (28, 'BOLIVIA\, PLURINATIONAL STATE OF', 'BO', 27);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (29, 'BOSNIA AND HERZEGOVINA', 'BA', 28);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (30, 'BOTSWANA', 'BW', 29);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (31, 'BOUVET ISLAND', 'BV', 30);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (32, 'BRAZIL', 'BR', 31);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (33, 'BRITISH INDIAN OCEAN TERRITORY', 'IO', 32);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (34, 'BRUNEI DARUSSALAM', 'BN', 33);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (35, 'BULGARIA', 'BG', 34);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (36, 'BURKINA FASO', 'BF', 35);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (37, 'BURUNDI', 'BI', 36);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (38, 'CAMBODIA', 'KH', 37);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (39, 'CAMEROON', 'CM', 38);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (40, 'CANADA', 'CA', 39);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (41, 'CAPE VERDE', 'CV', 40);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (42, 'CAYMAN ISLANDS', 'KY', 41);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (43, 'CENTRAL AFRICAN REPUBLIC', 'CF', 42);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (44, 'CHAD', 'TD', 43);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (45, 'CHILE', 'CL', 44);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (46, 'CHINA', 'CN', 45);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (47, 'CHRISTMAS ISLAND', 'CX', 46);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (48, 'COCOS (KEELING) ISLANDS', 'CC', 47);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (49, 'COLOMBIA', 'CO', 48);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (50, 'COMOROS', 'KM', 49);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (51, 'CONGO', 'CG', 50);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (52, 'CONGO, THE DEMOCRATIC REPUBLIC OF THE', 'CD', 51);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (53, 'COOK ISLANDS', 'CK', 52);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (54, 'COSTA RICA', 'CR', 53);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (55, 'CÔTE D''''IVOIRE', 'CI', 54);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (56, 'CROATIA', 'HR', 55);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (57, 'CUBA', 'CU', 56);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (58, 'CYPRUS', 'CY', 57);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (59, 'CZECH REPUBLIC', 'CZ', 58);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (60, 'DENMARK', 'DK', 59);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (61, 'DJIBOUTI', 'DJ', 60);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (62, 'DOMINICA', 'DM', 61);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (63, 'DOMINICAN REPUBLIC', 'DO', 62);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (64, 'ECUADOR', 'EC', 63);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (65, 'EGYPT', 'EG', 64);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (66, 'EL SALVADOR', 'SV', 65);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (67, 'EQUATORIAL GUINEA', 'GQ', 66);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (68, 'ERITREA', 'ER', 67);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (69, 'ESTONIA', 'EE', 68);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (70, 'ETHIOPIA', 'ET', 69);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (71, 'FALKLAND ISLANDS (MALVINAS)', 'FK', 70);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (72, 'FAROE ISLANDS', 'FO', 71);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (73, 'FIJI', 'FJ', 72);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (74, 'FINLAND', 'FI', 73);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (75, 'FRANCE', 'FR', 74);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (76, 'FRENCH GUIANA', 'GF', 75);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (77, 'FRENCH POLYNESIA', 'PF', 76);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (78, 'FRENCH SOUTHERN TERRITORIES', 'TF', 77);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (79, 'GABON', 'GA', 78);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (80, 'GAMBIA', 'GM', 79);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (81, 'GEORGIA', 'GE', 80);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (82, 'GERMANY', 'DE', 81);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (83, 'GHANA', 'GH', 82);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (84, 'GIBRALTAR', 'GI', 83);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (85, 'GREECE', 'GR', 84);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (86, 'GREENLAND', 'GL', 85);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (87, 'GRENADA', 'GD', 86);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (88, 'GUADELOUPE', 'GP', 87);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (89, 'GUAM', 'GU', 88);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (90, 'GUATEMALA', 'GT', 89);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (91, 'GUERNSEY', 'GG', 90);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (92, 'GUINEA', 'GN', 91);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (93, 'GUINEA-BISSAU', 'GW', 92);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (94, 'GUYANA', 'GY', 93);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (95, 'HAITI', 'HT', 94);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (96, 'HEARD ISLAND AND MCDONALD ISLANDS', 'HM', 95);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (97, 'HOLY SEE (VATICAN CITY STATE)', 'VA', 96);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (98, 'HONDURAS', 'HN', 97);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (99, 'HONG KONG', 'HK', 98);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (100, 'HUNGARY', 'HU', 99);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (101, 'ICELAND', 'IS', 100);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (102, 'INDIA', 'IN', 101);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (103, 'INDONESIA', 'ID', 102);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (104, 'IRAN, ISLAMIC REPUBLIC OF', 'IR', 103);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (105, 'IRAQ', 'IQ', 104);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (106, 'IRELAND', 'IE', 105);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (107, 'ISLE OF MAN', 'IM', 106);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (108, 'ISRAEL', 'IL', 107);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (109, 'ITALY', 'IT', 108);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (110, 'JAMAICA', 'JM', 109);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (111, 'JAPAN', 'JP', 110);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (112, 'JERSEY', 'JE', 111);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (113, 'JORDAN', 'JO', 112);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (114, 'KAZAKHSTAN', 'KZ', 113);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (115, 'KENYA', 'KE', 114);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (116, 'KIRIBATI', 'KI', 115);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (117, 'KOREA, DEMOCRATIC PEOPLE''''S REPUBLIC OF', 'KP', 116);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (118, 'KOREA, REPUBLIC OF', 'KR', 117);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (119, 'KUWAIT', 'KW', 118);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (120, 'KYRGYZSTAN', 'KG', 119);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (121, 'LAO PEOPLE''''S DEMOCRATIC REPUBLIC', 'LA', 120);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (122, 'LATVIA', 'LV', 121);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (123, 'LEBANON', 'LB', 122);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (124, 'LESOTHO', 'LS', 123);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (125, 'LIBERIA', 'LR', 124);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (126, 'LIBYAN ARAB JAMAHIRIYA', 'LY', 125);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (127, 'LIECHTENSTEIN', 'LI', 126);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (128, 'LITHUANIA', 'LT', 127);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (129, 'LUXEMBOURG', 'LU', 128);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (130, 'MACAO', 'MO', 129);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (131, 'MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF', 'MK', 130);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (132, 'MADAGASCAR', 'MG', 131);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (133, 'MALAWI', 'MW', 132);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (134, 'MALAYSIA', 'MY', 133);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (135, 'MALDIVES', 'MV', 134);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (136, 'MALI', 'ML', 135);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (137, 'MALTA', 'MT', 136);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (138, 'MARSHALL ISLANDS', 'MH', 137);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (139, 'MARTINIQUE', 'MQ', 138);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (140, 'MAURITANIA', 'MR', 139);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (141, 'MAURITIUS', 'MU', 140);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (142, 'MAYOTTE', 'YT', 141);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (143, 'MEXICO', 'MX', 142);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (144, 'MICRONESIA, FEDERATED STATES OF', 'FM', 143);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (145, 'MOLDOVA, REPUBLIC OF', 'MD', 144);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (146, 'MONACO', 'MC', 145);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (147, 'MONGOLIA', 'MN', 146);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (148, 'MONTENEGRO', 'ME', 147);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (149, 'MONTSERRAT', 'MS', 148);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (150, 'MOROCCO', 'MA', 149);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (151, 'MOZAMBIQUE', 'MZ', 150);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (152, 'MYANMAR', 'MM', 151);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (153, 'NAMIBIA', 'NA', 152);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (154, 'NAURU', 'NR', 153);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (155, 'NEPAL', 'NP', 154);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (156, 'NETHERLANDS', 'NL', 155);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (157, 'NETHERLANDS ANTILLES', 'AN', 156);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (158, 'NEW CALEDONIA', 'NC', 157);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (159, 'NEW ZEALAND', 'NZ', 158);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (160, 'NICARAGUA', 'NI', 159);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (161, 'NIGER', 'NE', 160);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (162, 'NIGERIA', 'NG', 161);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (163, 'NIUE', 'NU', 162);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (164, 'NORFOLK ISLAND', 'NF', 163);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (165, 'NORTHERN MARIANA ISLANDS', 'MP', 164);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (166, 'NORWAY', 'NO', 165);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (167, 'OMAN', 'OM', 166);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (168, 'PAKISTAN', 'PK', 167);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (169, 'PALAU', 'PW', 168);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (170, 'PALESTINIAN TERRITORY, OCCUPIED', 'PS', 169);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (171, 'PANAMA', 'PA', 170);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (172, 'PAPUA NEW GUINEA', 'PG', 171);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (173, 'PARAGUAY', 'PY', 172);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (174, 'PERU', 'PE', 173);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (175, 'PHILIPPINES', 'PH', 174);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (176, 'PITCAIRN', 'PN', 175);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (177, 'POLAND', 'PL', 176);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (178, 'PORTUGAL', 'PT', 177);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (179, 'PUERTO RICO', 'PR', 178);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (180, 'QATAR', 'QA', 179);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (181, 'RÉUNION', 'RE', 180);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (182, 'ROMANIA', 'RO', 181);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (183, 'RUSSIAN FEDERATION', 'RU', 182);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (184, 'RWANDA', 'RW', 183);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (185, 'SAINT BARTHÉLEMY', 'BL', 184);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (186, 'SAINT HELENA', 'SH', 185);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (187, 'SAINT KITTS AND NEVIS', 'KN', 186);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (188, 'SAINT LUCIA', 'LC', 187);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (189, 'SAINT MARTIN', 'MF', 188);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (190, 'SAINT PIERRE AND MIQUELON', 'PM', 189);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (191, 'SAINT VINCENT AND THE GRENADINES', 'VC', 190);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (192, 'SAMOA', 'WS', 191);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (193, 'SAN MARINO', 'SM', 192);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (194, 'SAO TOME AND PRINCIPE', 'ST', 193);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (195, 'SAUDI ARABIA', 'SA', 194);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (196, 'SENEGAL', 'SN', 195);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (197, 'SERBIA', 'RS', 196);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (198, 'SEYCHELLES', 'SC', 197);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (199, 'SIERRA LEONE', 'SL', 198);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (200, 'SINGAPORE', 'SG', 199);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (201, 'SLOVAKIA', 'SK', 200);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (202, 'SLOVENIA', 'SI', 201);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (203, 'SOLOMON ISLANDS', 'SB', 202);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (204, 'SOMALIA', 'SO', 203);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (205, 'SOUTH AFRICA', 'ZA', 204);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (206, 'SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS', 'GS', 205);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (207, 'SPAIN', 'ES', 206);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (208, 'SRI LANKA', 'LK', 207);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (209, 'SUDAN', 'SD', 208);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (210, 'SURINAME', 'SR', 209);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (211, 'SVALBARD AND JAN MAYEN', 'SJ', 210);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (212, 'SWAZILAND', 'SZ', 211);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (213, 'SWEDEN', 'SE', 212);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (214, 'SWITZERLAND', 'CH', 213);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (215, 'SYRIAN ARAB REPUBLIC', 'SY', 214);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (216, 'TAIWAN, PROVINCE OF CHINA', 'TW', 215);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (217, 'TAJIKISTAN', 'TJ', 216);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (218, 'TANZANIA, UNITED REPUBLIC OF', 'TZ', 217);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (219, 'THAILAND', 'TH', 218);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (220, 'TIMOR-LESTE', 'TL', 219);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (221, 'TOGO', 'TG', 220);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (222, 'TOKELAU', 'TK', 221);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (223, 'TONGA', 'TO', 222);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (224, 'TRINIDAD AND TOBAGO', 'TT', 223);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (225, 'TUNISIA', 'TN', 224);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (226, 'TURKEY', 'TR', 225);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (227, 'TURKMENISTAN', 'TM', 226);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (228, 'TURKS AND CAICOS ISLANDS', 'TC', 227);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (229, 'TUVALU', 'TV', 228);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (230, 'UGANDA', 'UG', 229);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (231, 'UKRAINE', 'UA', 230);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (232, 'UNITED ARAB EMIRATES', 'AE', 231);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (233, 'UNITED KINGDOM', 'GB', 232);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (234, 'UNITED STATES MINOR OUTLYING ISLANDS', 'UM', 233);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (235, 'URUGUAY', 'UY', 234);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (236, 'UZBEKISTAN', 'UZ', 235);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (237, 'VANUATU', 'VU', 236);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (238, 'VENEZUELA, BOLIVARIAN REPUBLIC OF', 'VE', 237);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (239, 'VIET NAM', 'VN', 238);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (240, 'VIRGIN ISLANDS, BRITISH', 'VG', 239);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (241, 'VIRGIN ISLANDS, U.S.', 'VI', 240);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (242, 'WALLIS AND FUTUNA', 'WF', 241);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (243, 'WESTERN SAHARA', 'EH', 242);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (244, 'YEMEN', 'YE', 243);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (245, 'ZAMBIA', 'ZM', 244);
Insert into COUNTRY
   (ID, NAME, ISO_CODE, DISPLAY_ORDER)
 Values
   (246, 'ZIMBABWE', 'ZW ', 245);
COMMIT;
	   