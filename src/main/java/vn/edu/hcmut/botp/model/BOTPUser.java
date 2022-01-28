package vn.edu.hcmut.botp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "tbl_user")
public class BOTPUser {

    @Id
    private Long id;
    private String username;
    private String password;
}
