package poly.edu.ASSM.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Accounts")
public class Accounts {

    @Id
    private String username;

    private String password;
    private String fullname;
    private String email;
    private String photo;

    @Column(nullable = false)
    private Boolean activated = true;

    @Column(nullable = false)
    private Boolean admin = false;

    @Column(nullable = false)
    private Boolean superAdmin = false;

}

