# Basic MongoDB commands

## online data

http://stat-computing.org/dataexpo/2009/
http://stat-computing.org/dataexpo/2009/supplemental-data.html


## Import data into collections

```
Use cloud MongoD for connection
https://docs.atlas.mongodb.com/

https://cloud.mongodb.com/v2/5d3d9b90ff7a253c71f2667f#clusters
Connection through command line
mongo "mongodb+srv://cluster0-popyd.mongodb.net/test" --username <username>
username: 
admin
```


## Run mongoDB client

```
mongo
show databases;
use airline;
show collections;
```

## CRUD operations

```
db.planes.insert({tailnum: 'XYZ1234'});
db.planes.find({tailnum: 'XYZ1234'});
db.planes.update({tailnum:'XYZ1234'},{$set:{'comments':'My comments'}});
db.planes.remove({tailnum: 'XYZ1234'});
```

## Drop collections

```
db.airports.drop();
db.carriers.drop();
db.planes.drop();
```

- When no collection is left, database is removed.

## Build this project:

```
mvn clean package
```

## Run the Spring Boot App:

```
java -jar target/mongodb-0.0.1-SNAPSHOT.jar

```

## Postman test URLs:

```
http://localhost:8080/airports?iata="06N"
http://localhost:8080/planes?tailnum=N055AA
http://localhost:8080/carrier?code="02Q"
http://localhost:8080/weather?location=London,uk
```

## Curl

```
curl http://localhost:8080/airports?iata=06N
curl http://localhost:8080/planes?tailnum=N055AA
curl http://localhost:8080/carrier?code="02Q"
curl http://localhost:8080/weather?location=London,uk
```

