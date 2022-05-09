package com.sin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role")
public class Role extends BasePojo {

    private long rolId;
    private String rName;

    /**
     * 对角色  ，权限关系，多对多关系
     */
    @TableField(exist = false)
    private List<Permission> permissionList;


    @TableField(exist = false)
    private List<Department> departments;

}
