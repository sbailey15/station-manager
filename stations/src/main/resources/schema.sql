create table stations
(
   id integer not null,
   station_id varchar(255) not null,
   station_name varchar(255) not null,
   hd_enabled bool not null,
   primary key(id)
);