package com.sin.pojo;


import com.sin.pojo.BasePojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consult extends BasePojo {
    private static final long serialVersionUID = 1L;
    private long consultId;
    private String cConsultContent;
    private String cName;
    private String cSex;
    private String cPhone;



}