#### General

* Build: mvn clean package
* Run: ./target/techgarden-tasks-1-SNAPSHOT.jar

#### Task 1

* [Package: com.techgarden.tasks.tree.model](https://github.com/mmaszkie/techgarden/tree/master/src/main/java/com/techgarden/tasks/tree/model)
* [Tests](https://github.com/mmaszkie/techgarden/blob/master/src/test/java/com/techgarden/tasks/tree/model/TreesTest.java)

#### Task 2

* [PayU client class](https://github.com/mmaszkie/techgarden/blob/master/src/main/java/com/techgarden/tasks/payu/gateway/PayUClient.java)
* [Main tests](https://github.com/mmaszkie/techgarden/blob/master/src/test/java/com/techgarden/tasks/payu/gateway/PayUClientTest.java)

#### Task 3

* [Geolocation controller class](https://github.com/mmaszkie/techgarden/blob/master/src/main/java/com/techgarden/tasks/geolocation/service/GeolocationController.java)
* Packages:
    * [com.techgarden.tasks.geolocation.service.entities.rest (REST)](https://github.com/mmaszkie/techgarden/blob/master/src/main/java/com/techgarden/tasks/geolocation/service/entities/rest)
    * [com.techgarden.tasks.geolocation.service.entities.model (database)](https://github.com/mmaszkie/techgarden/blob/master/src/main/java/com/techgarden/tasks/geolocation/service/entities/model)
* Tests:
    * [base tests](https://github.com/mmaszkie/techgarden/blob/master/src/test/java/com/techgarden/tasks/geolocation/service/GeolocationControllerTest.java)
    * [performance tests](https://github.com/mmaszkie/techgarden/blob/master/src/test/java/com/techgarden/tasks/geolocation/service/GeolocationControllerPerformanceTest.java)
* Example CURLs:
    ```
    curl -H "Content-Type: application/json" -X POST -d '{"name":"New York", "position": {"longitude":-74.005941, "latitude":40.712784}}' http://localhost:8080/geolocation/addData
    curl -H "Content-Type: application/json" -X POST -d '{"name":"Los Angeles", "position": {"longitude":-118.243685, "latitude":34.052234}}' http://localhost:8080/geolocation/addData
    curl -H "Content-Type: application/json" -X GET -d '{"distance":5000, "position": {"longitude":-74.005941, "latitude":40.712784}}' http://localhost:8080/geolocation/getNearbyData
    ```

