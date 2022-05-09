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
@TableName("employee")
public class Employee extends BasePojo implements Serializable {

    private long employeeId;
    private String empName;
    private String ePwd;
    private String salt;
    private long age;
    private String sex;
    private String phone;
    private String address;

    /**
     * 盐，加盐，安全，真实盐=用户名+盐
     */
    public String getCredentialsSalt(){
        return this.empName+this.salt;
    }

    /**
     * 一个用户具有多个角色
     */
    @TableField(exist = false)
    private List<Role> roleList;


}
