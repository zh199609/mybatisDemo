package com.zl.entity;
/**
 * @Description:角色
 * @author i-leizh
 * @date: 2018年9月27日 下午3:01:39
 */

import com.zl.config.Enabled;

import java.time.LocalDateTime;
import java.util.Date;

public class SysRole {

    private Long id;

    private String roleName;

    private Enabled enabled;

    private Long createBy;

    private LocalDateTime createTime;

    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SysRole [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createBy=" + createBy
                + ", createTime=" + createTime + ", sysUser=" + sysUser + "]";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Enabled getEnabled() {
        return enabled;
    }

    public void setEnabled(Enabled enabled) {
        this.enabled = enabled;
    }
}
