**Dependencies**

Java 8


**Install and setup PostgreSQL**

[MacOS]

Install
brew install postgres

Start PostgreSQL server
pg_ctl -D /usr/local/var/postgres start

Create Database
createdb momentteam

Create user
psql momentteam
CREATE ROLE momentdemo WITH LOGIN PASSWORD '12345';
\q


**Running**

mvn clean install

mvn spring-boot:run