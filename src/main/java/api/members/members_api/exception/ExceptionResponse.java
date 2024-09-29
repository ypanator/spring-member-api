package api.members.members_api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ExceptionResponse {

    private String error;
    private String details;
}