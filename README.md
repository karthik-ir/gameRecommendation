# gameRecommendation

Run `mvn clean package` to build the jar file.

Then you can run the project either

1. On your machine using `mvn spring-boot:run`

2. Build docker image with `docker build --build-arg JAR_FILE=./target/gameRecommendation-1.0.0.jar .`

then run the docker image `docker run -p 8080:8080 {IMAGE_ID}` 
