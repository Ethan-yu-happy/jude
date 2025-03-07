package com.jude.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 角色实体
 * @author jude
 *
 */
@Data
@Entity
@Table(name="t_case")
public class Case {

	@Id
	@GeneratedValue
	private Integer id; // 编号
	
	@Column
	private String tmpId; // 模版id

	@Column
	private String employeeId; // 员工id

}
