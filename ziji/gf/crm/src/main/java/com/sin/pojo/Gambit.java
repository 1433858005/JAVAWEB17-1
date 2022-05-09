package com.sin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("gambit")
public class Gambit extends BasePojo implements Serializable {
    @TableId(type = IdType.AUTO)
    private long gambitId;
    private String gHeadline;
    private String gAuditor;
    private String gAudiTime;
    private String gFounder;
    private String gCheckState;
}
