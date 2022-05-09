package com.sin.pojo.customerPojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sin.pojo.BasePojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cus_emp")
public class CusEmp extends BasePojo {

    private long cusId;
    private long empId;

}
