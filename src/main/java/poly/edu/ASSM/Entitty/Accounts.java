package poly.edu.ASSM.Entitty;

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
@Getter
@Setter

@Entity
@Table(name = "Accounts")
public class Accounts {
	    @Id
	    @Column(length = 50)
	    private String username; // PK (không auto)

	    @Column(nullable = false)
	    private String password;

	    private String fullname;
	    private String email;
	    private String photo;

	    private Boolean activated = true;
	    private Boolean admin = false;
}
