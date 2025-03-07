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
@Table(name="t_case_tmp_detail")
public class CaseTmpDetail {

	@Id
	@GeneratedValue
	private Integer id; // 编号
	
	@Column
	private String tmpId; // 案件Id
	@Column
	private String columName; // 字段名

	@Column
	private String colum; // 字段类型
}
