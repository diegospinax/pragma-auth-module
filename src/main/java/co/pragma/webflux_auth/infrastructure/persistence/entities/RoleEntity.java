package co.pragma.webflux_auth.infrastructure.persistence.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("roles")
@Data
public class RoleEntity {
    @Id
    private Long id;
    private String name;
    private String description;
}
