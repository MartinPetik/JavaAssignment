package sk.ness.academy.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private final String meessage;

    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public ApiException(String meessage, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.meessage = meessage;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMeessage() {
        return meessage;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
