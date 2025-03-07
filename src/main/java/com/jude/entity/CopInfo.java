package com.jude.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 供应商实体
 * @author jude
 *
 */
@Entity
@Data
@Table(name="t_copInfo")
public class CopInfo {

	@Id
	@GeneratedValue
	private Integer id; // 编号
	
	@Column(length=200)
	private String name; // 委托公司名称
	
	@Column(length=50)
	private String contact; // 负责人姓名
	
	@Column(length=50)
	private String number; // 负责人联系电话
	
	@Column(length=300)
	private String address; // 联系地址
	
	@Column(length=1000)
	private String remarks; // 备注
}
