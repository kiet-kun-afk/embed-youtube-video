package tired.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "video")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "href", unique = true)
	private String href;

	@Column(name = "poster")
	private String poster;

	@Column(name = "views")
	private Integer views;

	@Column(name = "shares")
	private Integer shares;

	@Column(name = "description")
	private String description;

	@Column(name = "isActive")
	private Boolean isActive;
}
