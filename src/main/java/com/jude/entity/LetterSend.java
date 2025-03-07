package com.jude.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 客户实体
 * @author jude
 *
 */
@Data
@Entity
@Table(name="t_letter_send")
public class LetterSend {
	//extends BaseEntity
	@Id
	//@GeneratedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Date createTime;

	@Column(length=50)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateTime;

	@Column(length=50)
	private String updateUser;

	@Column(length=200)
	private String tel   ;//发送手机号
	@Column(length=200)
	private String support   ;//		运营商
	@Column(length=200)
	private String batchNum   ;//批次编号
	@Column(length=200)
	private String temNum   ;//		模板编号
	@Column(length=200)
	private String letNum   ;//函件编号
	@Column(length=200)
	private String name   ;//		逾期人姓名
	@Column(length=200)
	private String idNum   ;//逾期人身份证号
	@Column(length=200)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate   ;//		截至日期
	@Column(length=200)
	private String repayAmt   ;//还款金额/元
	@Column(length=200)
	private String mediatorTel   ;//		调解员电话
	@Column(length=200)
	private String letType   ;//		函件类型
	@Column(length=200)
	private String sendStatus   ;//发送状态
	@Column(length=200)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date repayDate   ;//		还款日期
	@Column(length=200)
	private String letPic   ;//函件图片
/*overdueName  overdueIdNum mediatorName  mediatorTel  letCreateTime
streetStatus*/
	@Column(length=200)
	private String overdueName   ;//函件图片
	@Column(length=200)
	private String overdueIdNum   ;//函件图片
	@Column(length=200)
	private String mediatorName   ;//函件图片
	@Column(length=200)
	private String streetStatus   ;//函件图片
	@Column(length=200)
	private String letCreateTime   ;//函件图片





	
	
	
}
