package tired.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public enum RoleEnum {

        ADMIN(1),
        USER(2);

        private final int value;

        RoleEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public Role(RoleEnum role) {
        this.id = role.getValue();
        this.name = role.name();
    }
}
