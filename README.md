## Dependencies 
1. JDK - 1.8
2. PostgreSQL - 8.4 +
3. Maven - 3.6.0 +
4. Lombok plugin (for IDEA https://plugins.jetbrains.com/plugin/6317-lombok-plugin)

## Install and setup

### Clone application

```git clone git@github.com:OlegGasul/moment-team.git```

or just download zip file https://github.com/OlegGasul/moment-team/archive/master.zip

### Setup PostgreSQL
[MacOS]

```brew install postgres```

```pg_ctl -D /usr/local/var/postgres start```

```createdb momentteam```

```psql momentteam```

```CREATE ROLE momentdemo WITH LOGIN PASSWORD '12345';```

```\q```

### Running

1. Set database connection parameters in ```application.properties```

2. Execute in command line

```mvn clean install```

```mvn spring-boot:run```

## Using

### Create product
```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"name": "Product 1", "number": "1", "price": 100, "sales": []}' \
  http://localhost:8080/product
```

### Get all products
```curl http://localhost:8080/product```

### Get product by id
```curl http://localhost:8080/product/1```

### Update product
```
curl --header "Content-Type: application/json" \
  --request PUT \
  --data '{"id": 1, "name": "Product 1", "number": "1", "price": 100, "sales": []}' \
  http://localhost:8080/product/1
```

### Create product with sales
```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"name": "Product 2", "number": "2", "price": 100, "sales": [{"price": 100, "quantity": 1, "discount": 20, "saleDate": "2019-03-01T10:00:00"}, {"price": 100, "quantity": 10, "discount": 30, "saleDate": "2019-03-05T10:00:00"} ]}' \
  http://localhost:8080/product
```
