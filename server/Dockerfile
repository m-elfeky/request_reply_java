FROM openjdk:22
WORKDIR /app
COPY .mvn/ ./.mvn
COPY mvnw pom.xml ./
COPY src ./src
RUN ./mvnw clean install
CMD ["./mvnw", "spring-boot:run"]