package org.example.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;


/**
 * @author haoren
 * @date 2024/05/31 16:21
 **/
@ApiModel(value = "用户表", description = "")
@Entity
@Data
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity implements Serializable, Cloneable {
    /**
     * 租户号
     */
    @ApiModelProperty(name = "租户号", notes = "")
    private String tenantId;
    /**
     * 乐观锁
     */
    @Column(name = "REVISION")
    @org.springframework.data.annotation.Version
    @ApiModelProperty(name = "乐观锁", notes = "")
    private Integer revision;
    /**
     * 创建人
     */
    @Column(name = "CREATED_BY")
    @CreatedBy
    @ApiModelProperty(name = "创建人", notes = "")
    private String createdBy;
    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "创建时间", notes = "")
    private Instant createdTime;
    /**
     * 更新人
     */
    @Column(name = "UPDATED_BY")
    @LastModifiedBy
    @ApiModelProperty(name = "更新人", notes = "")
    private String updatedBy;
    /**
     * 更新时间
     */
    @Column(name = "UPDATED_TIME")
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "更新时间", notes = "")
    private Instant updatedTime;
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "用户ID", notes = "")
    private Long userId;
    /**
     * 用户名称;UNIQUE
     */
    @Column(name = "username")
    @ApiModelProperty(name = "用户名称", notes = "UNIQUE")
    private String username;
    /**
     * 用户密码
     */
    @Column(name = "password")
    @ApiModelProperty(name = "用户密码", notes = "")
    private String password;
}
