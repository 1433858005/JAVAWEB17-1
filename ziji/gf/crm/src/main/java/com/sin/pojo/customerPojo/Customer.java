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
@TableName("customer")
public class Customer extends BasePojo {

    private long customerId;
    private String customerName;
    private String sex;
    private String phone;
    private String company;
    private String address;
    private long isOrders;

    @TableField(exist = false)
    private List<Employee> employeeList;

}
