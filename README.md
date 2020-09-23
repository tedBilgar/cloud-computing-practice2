mvn clean package

Build: sudo docker build --build-arg JAR_FILE=target/*.jar -t tedbilgar/dockertest .


Start: sudo docker run -p 8099:8099 tedbilgar/dockertest
