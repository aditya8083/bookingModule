CREATE TYPE BookingStatus AS ENUM ('PENDING','SUCCESSFUL','DEFERRED','CANCELLED');

CREATE TABLE booking_master(id Varchar(255) Primary Key,
amount float8, booking_email Varchar(255),booking_source Varchar(255),booking_status Varchar(255),booking_type Varchar(255),payment_id Varchar(255),payment_status Varchar(255),booking_phone_number Varchar(255),super_pnr Varchar(255),user_id Varchar(255));


CREATE TABLE booking_user_details(id Varchar(255) Primary Key,
user_age Varchar(255),user_name Varchar(255),
booking_id Varchar(255));
