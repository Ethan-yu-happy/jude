package com.jude.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 客户实体
 *
 * @author jude
 */
@Data
@Entity
@Table(name = "t_msg_tem")
public class LetMsgTem {//extends BaseEntity
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length=200)
    private String msgTemNum;
    @Column(length=200)
    private String msgTemName;
    @Column(length=200)
    private String msgTitle;
    @Column(length=200)
    private String msfText;
    @Column(length=200)
    private String signature;
    @Column(length=200)
    private String appTime;
    @Column(length=200)
    private String approveStatus;
    @Column(length=200)
    private String approveInfo;

}
