package net.diaowen.common.base.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;


@MappedSuperclass
public abstract class IdEntity {//implements Serializable

	protected String id;

	@Id
	/*
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	*/

	@GeneratedValue(generator = "uuid2")
	// uuid generator
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 55)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
