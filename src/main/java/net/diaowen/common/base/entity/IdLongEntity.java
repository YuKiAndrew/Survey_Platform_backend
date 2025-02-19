package net.diaowen.common.base.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class IdLongEntity {

	protected Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid-string")
	//@GeneratedValue(generator = "system-uuid")
    //@GenericGenerator(name = "system-uuid", strategy = "uuid")
    //@Column(length = 32)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
