package poly.edu.ASSM.Entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class UserRoleId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
    private Integer roleId;
}
