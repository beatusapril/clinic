`docker build -t db .`
`docker run -p 5432:5432 db`
`./gradlew flywayMigrate -Dflyway.configFiles=myFlyway.conf`
состояние в Hibernate - transient, managed, detached or deleted
