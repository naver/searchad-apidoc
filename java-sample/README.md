# Naver SearchAD API - Java Sample


## Getting started

### Pre-requirements

- JDK 8 : http://www.oracle.com/technetwork/java/javase/downloads/index.html
- Git client : https://git-scm.com/downloads
- Maven (optional) : https://maven.apache.org/download.cgi
- Lombok : https://projectlombok.org/download.html

### Issue the API License and the secret key

1. Sign up for NAVER SEARCH ADVERTISER's Center (http://searchad.naver.com)
2. Go to (http://manage.searchad.naver.com)
3. Go to Tools > API Manager
4. Create API license


### Git clone

```bash
$ git clone https://github.com/naver/searchad-apidoc.git
$ cd searchad-apidoc/java-sample/
```


### Modify [src/main/resources/sample.properties](src/main/resources/sample.properties).
- `API_KEY`
- `SECRET_KEY`
- `CUSTOMER_ID`


### Build

#### with installed maven
```bash
$ mvn clean package
```

#### with embeded maven
```bash
$ ./mvnw clean package
```


### Execute sample codes.
- [src/main/java/com/naver/searchad/api/sample/AdManagementSample.java](src/main/java/com/naver/searchad/api/sample/AdManagementSample.java)
- [src/main/java/com/naver/searchad/api/sample/EstimateSample.java](src/main/java/com/naver/searchad/api/sample/EstimateSample.java)
- [src/main/java/com/naver/searchad/api/sample/MasterReportSample.java](src/main/java/com/naver/searchad/api/sample/MasterReportSample.java)
- [src/main/java/com/naver/searchad/api/sample/StatReportSample.java](src/main/java/com/naver/searchad/api/sample/StatReportSample.java)

#### *nix
```bash
$ cd target
$ java -cp com.naver.searchad.api-java-sample.jar:lib/* com.naver.searchad.api.sample.AdManagementSample
```

#### windows
```bat
> cd target
> java -cp com.naver.searchad.api-java-sample.jar;lib/* com.naver.searchad.api.sample.AdManagementSample
```
