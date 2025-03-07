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
@Table(name="t_pic")
public class Pic {

	@Id
	@GeneratedValue
	private Integer id; // 编号
	
	@Column
	private String picData; // 角色名称
	


	
	
	
}
