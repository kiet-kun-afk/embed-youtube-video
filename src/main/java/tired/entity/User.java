package tired.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`user`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "role")
	private Role role;

	@Column(name = "isActive")
	private Boolean isActive;

	@Transient
	private String captcha;

	@Transient
	private String hiddenCaptcha;

	@Transient
	private String realCaptcha;
}
