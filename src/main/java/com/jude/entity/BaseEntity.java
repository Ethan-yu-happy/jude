package com.jude.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * 客户实体
 * @author jude
 *
 */
@Entity
@Data
public class BaseEntity {

	@Id
	//@GeneratedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Date createTime;

	@Column(length=50)
	private Date updateTime;

	@Column(length=50)
	private String updateUser;

	@Column(length=50)
	private String isDelete;


}
