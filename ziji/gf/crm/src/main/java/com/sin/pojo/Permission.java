package com.sin.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("permission")
public class Permission extends BasePojo implements Serializable {

    private long permissionId;
    @NonNull
    private String permName;
    @NonNull
    private String permission;
    @NonNull
    private String url;
}
