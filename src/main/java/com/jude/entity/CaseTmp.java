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
@Table(name="t_case_tmp")
public class CaseTmp {

	@Id
	@GeneratedValue
	private Integer id; // 编号
	
	@Column
	private String tmpTitle; // 案件姓名
	@Column
	private String columInfos; // 字段详情
}
