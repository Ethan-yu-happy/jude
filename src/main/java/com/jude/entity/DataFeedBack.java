package com.jude.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 客户实体
 *
 * @author jude
 */
@Data
@Entity
@Table(name = "data_feed_back")
public class DataFeedBack  {//extends BaseEntity

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
    @Column(length = 200)
    private String tel; //发送手机号
    @Column(length = 200)
    private String userAcc; // 操作账号
    @Column(length = 200)
    private String overdueName; //逾期人姓名
    @Column(length = 200)
    private String sendTel; //发送手机号
    @Column(length = 200)
    private String letNum; //函件编号
    @Column(length = 200)
    private String letPic; //函件图片
    @Column(length = 200)
    private String letType; //函件类型
    @Column(length = 200)
    private String batchNum; //函件批次号
    @Column(length = 200)
    private String letSendTime; //函件发送时间
    @Column(length = 200)
    private String sendType; //发送类型
    @Column(length = 200)
    private Date firstQueryTime; //首次查看时间
    @Column(length = 200)
    private Date lastQueryTime; //最近查看时间

}
