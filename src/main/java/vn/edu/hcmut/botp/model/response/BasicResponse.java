package vn.edu.hcmut.botp.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicResponse {
    private Boolean status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public BasicResponse(Boolean status) {
        this.status = status;
    }
}
