package vn.edu.hcmut.botp.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import vn.edu.hcmut.botp.model.constant.UserRole;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@Document(collection = "tbl_user")

public class BOTPUser implements Serializable {

    @NonNull
    private String username;
    @NonNull
    private String password;

    @NonNull
    private String email;

    @NonNull
    private Set<String> roles;

}
