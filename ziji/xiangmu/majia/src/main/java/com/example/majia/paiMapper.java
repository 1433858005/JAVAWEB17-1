package com.example.majia;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface paiMapper {

    @org.springframework.beans.factory.annotation.Autowired(required = true)
    //查询牌库
    @Select("SELECT ${lie} FROM  mj.paiku")
    List<String> findyi(@Param("lie") String lie);

    @Select("SELECT pai FROM  mj.paiku")
    List<String> findpai();
    @Select("SELECT ss FROM  mj.paiku")
    List<Integer> findss();
    @Insert(" INSERT INTO mj.paiku(${pai})VALUES(#{paizhi})")
    void tianjiapai(@Param("pai") String pai,@Param("paizhi") String paizhi);
    //删除数据表所有数据
    @Select(" TRUNCATE TABLE  mj.paiku")
    void shanchu();
//发牌计数器
    @Update("UPDATE mj.paiku SET ss=#{ss} WHERE id=1")
//    UPDATE c1 SET NAME='body', fanyi='男孩' WHERE id=1
    void qishuqi(@Param("ss") int ss);

    @Update("UPDATE mj.paiku SET ${kk}=#{ss} WHERE id=#{paizhi}")
    void xipai(@Param("ss") String ss,@Param("paizhi") int paizhi,@Param("kk") String kk);



}
