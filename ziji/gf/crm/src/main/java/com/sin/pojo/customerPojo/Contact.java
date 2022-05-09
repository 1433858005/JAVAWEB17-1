package com.sin.pojo.customerPojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sin.pojo.BasePojo;
import com.sin.pojo.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("contact")
public class Contact extends BasePojo {

    private long contactId;
    private String way;
    private String content;

    @TableField(exist = false)
    private List<Employee> employeeList;

    @TableField(exist = false)
    private List<Customer> customerList;
}
