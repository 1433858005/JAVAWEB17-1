package com.sin.pojo.businessPojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sin.pojo.BasePojo;
import com.sin.pojo.customerPojo.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("orders")
public class Orders extends BasePojo {
    private long ordersId;
    private double totalPrice;
    @TableField(exist = false)
    private List<Business> businessList;
    @TableField(exist = false)
    private List<Customer> customerList;
}
