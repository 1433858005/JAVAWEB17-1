package com.sin.pojo.businessPojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sin.pojo.BasePojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//package com.sin.pojo.businessPojo;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("ord_bus_cus")
public class OrdBusCus extends BasePojo {

    private long ordId;
    private long busId;
    private long cusId;
}
