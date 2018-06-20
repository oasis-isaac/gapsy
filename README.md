# gapsy

1. Clone repository https://github.com/oasis-isaac/gapsy.git
2. Edit src/main/resources/application.properties.example, setting connection parameters like host, DB, user and password
3. Rename src/main/resources/application.properties.example to src/main/resources/application.properties
4. Run in terminal: gradle bootRun (need to have gradel installed in your computer)
5. If you dont have gradle installed and configured, you can import project to your IDE and run GapsyTestApplication.java
6. Service will be running on port 8080 by default with next operations availables:
	a) POST localhost:8080/gapsy-api/products
	b) GET localhost:8080/gapsy-api/products/{id}
	c) GET localhost:8080/gapsy-api/products
	d) PUT localhost:8080/gapsy-api/products/{id}
	e) DELETE localhost:8080/gapsy-api/products/{id}
