package com.sin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("department")
public class Department extends BasePojo implements Serializable {

    private long departmentId;
    private String dName;
    private String dManager;
    private long dPopulation;

    /**
     * 一个部门属于多个角色
     */
    @TableField(exist = false)
    private List<Role> roleList;

}