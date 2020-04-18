FROM java:8u111-jdk
ADD target/orderservice-0.0.1-SNAPSHOT.jar order-service.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "order-service.jar" ]