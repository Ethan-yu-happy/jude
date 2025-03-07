package com.jude.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

/**
 * 角色实体
 * @author jude
 *
 */
@Data
@Entity
@Table(name="t_case_info")
public class CaseInfo {

	@Id
	@GeneratedValue
	private Integer id; // 编号
	
	@Column
	private String tmpId; // 模版id
	@Column
	private String tmpDetailId; // 模版详情id

	@Column
	private String value; // 案件字段内容

	@Column
	private String caseId; // 案件唯一标识

}
