package com.jude.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 客户实体
 * @author jude
 *
 */
@Data
@Entity
@Table(name="t_employee")
public class Employee {//extends BaseEntity

	@Id
	@GeneratedValue
	private Integer id;
	@Column(length=200)
	private String name; // 委托员工姓名

	@Column(length=50)
	private String UserId; // 用户id

	@Column(length=50)
	private String copId; // 委托公司id
	
	@Column(length=50)
	private String number; // 联系电话
	
	@Column(length=300)
	private String address; // 联系地址
	
	@Column(length=1000)
	private String remarks; // 备注

}
