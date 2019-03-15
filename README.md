## Dependencies 
1. JDK - 1.8
2. PostgreSQL - 8.4 +
3. Maven - 3.6.0 +
4. Lombok plugin (for IDEA https://plugins.jetbrains.com/plugin/6317-lombok-plugin)

## Install and setup

### Clone application

```git clone git@github.com:OlegGasul/moment-team.git```

or just download zip file

### Setup PostgreSQL
[MacOS]

```brew install postgres```

```pg_ctl -D /usr/local/var/postgres start```

```createdb momentteam```

```psql momentteam```

```CREATE ROLE momentdemo WITH LOGIN PASSWORD '12345';```

```\q```

### Running

```mvn clean install```

```mvn spring-boot:run```