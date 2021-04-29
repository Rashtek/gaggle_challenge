# Gaggle Interview Challenge
This is a super simple web 'API' written in Java Spring Boot.
Its only job is to serve a single JSON string with the fields "message" and "timestamp".
The timestamp field is formatted according to ISO-8601, in particular [Java's ISO_OFFSET_DATE_TIME DateTimeFormatter](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/format/DateTimeFormatter.html#ISO_OFFSET_DATE_TIME).

## Dependencies
- Java 8+ (11 set in pom.xml)
- Docker (Optional)

## Testing and Building
Run `./mvnw package` (on Linux) or `.\mvnw.cmd` (on Windows) to run unit tests and produce a .jar file in the `target/` directory.

Alternatively, run `./build.sh` (on Linux) to create a Docker image with port 8080 exposed. During the image build process, unit tests are run, and the build will fail if a unit test fails. The tag used for the image is `gaggle`.

## Running
### Jar File
Simply run `java -jar ./target/<name_of_jar>.jar`

### Docker
Run `docker run -p 8080:8080 -it --rm gaggle`

As there is nothing interesting in the container, running with `--rm` automatically removes the container when it closes, so you don't have to remember to later.

While the project is running, open `http://localhost:8080` in your browser or via a tool such as curl to retrieve the JSON.