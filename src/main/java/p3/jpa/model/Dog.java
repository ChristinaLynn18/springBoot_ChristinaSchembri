package p3.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="dogs")

public class Dog {
	@ApiModelProperty(notes = "Unique id of the staff, which will be auto incremented by hibernate upon add(save)") // NOTE ilker optional line to add swagger model attribute info
	@Id
	@GeneratedValue
	private Long id;
	private String	name;
	private String	type;
	
	public Dog(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

}
