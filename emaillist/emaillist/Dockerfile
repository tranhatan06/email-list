# Stage 1: Build ứng dụng bằng Maven
FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app
# Copy pom.xml và tải các dependency
COPY pom.xml .
RUN mvn dependency:go-offline -B
# Copy mã nguồn và build
COPY src ./src
RUN mvn clean package

# Stage 2: Chạy ứng dụng trên Tomcat 9
FROM tomcat:9.0-jdk11-corretto
# Xóa các app mặc định của Tomcat để tránh xung đột
RUN rm -rf /usr/local/tomcat/webapps/*
# Copy file war từ bước build sang thư mục webapps của Tomcat, đổi tên thành ROOT.war để chạy ở trang chủ (/)
COPY --from=build /app/target/emaillist.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
