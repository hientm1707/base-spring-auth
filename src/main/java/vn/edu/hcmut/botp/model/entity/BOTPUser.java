package vn.edu.hcmut.botp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@Document(collection = "tbl_user")
public class BOTPUser {

    @NonNull
    private String username;
    @NonNull
    private String password;
}
