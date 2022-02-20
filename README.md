# NewsAPI
Project using a RESTful web service with Java to get information about News and Dependency Management with Maven hands-on

# API -News
https://newsapi.org/

# API -Geo
https://geo.ipify.org/docs

# Requirements
You'll need to go create an account to get an API key (https://newsapi.org/account)
You'll need to go create an account to get an API key (https://geo.ipify.org/login)

# Dependencies

	<dependencies>
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.13.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13.2</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient -->
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
			<version>4.5.13</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/log4j/log4j -->
		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>2.17.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations -->
		<!-- https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api -->
		<dependency>
			<groupId>javax.annotation</groupId>
			<artifactId>javax.annotation-api</artifactId>
			<version>1.3.2</version>
		</dependency>
# Add Library
To add this library to your pom file 
		<dependency>
			<groupId>gr.unipi</groupId>
			<artifactId>NewsAPI</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
