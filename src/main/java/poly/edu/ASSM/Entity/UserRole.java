package poly.edu.ASSM.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "User_Role")
@Getter
@Setter
public class UserRole {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private UserRoleId id;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name="Username", referencedColumnName="Username")
    private Accounts account;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name="RoleId", referencedColumnName="Id")
    private Roles role;
}
