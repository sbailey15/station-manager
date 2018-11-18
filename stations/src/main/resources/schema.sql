drop table if exists stations;
create table stations
(
   stationId VARCHAR(50) NOT NULL,
   name VARCHAR(50) NOT NULL,
   hdEnabled BOOL NOT NULL
);