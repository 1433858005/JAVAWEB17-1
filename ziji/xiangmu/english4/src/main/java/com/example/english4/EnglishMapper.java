package com.example.english4;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnglishMapper {
    @Select("SELECT*FROM  ${biao} ")
    List<english> findAll(@Param("biao") String biao);
    @Select("SHOW TABLES")
    List<String> findAll2();

    @Insert("insert into ${biao} values(null,#{name},#{fanyi})")
    public void se(@Param("biao") String biao,@Param("name") String name, @Param("fanyi") String fanyi);
//查询数量值
    @Select("SELECT*FROM english0001 ORDER BY id DESC LIMIT 1")
    Integer findAll3();

    @Select("SELECT*FROM english0001 WHERE id=${id}")
    List<english> findAll4(@Param("id") int id);
//    String sql = "SELECT*FROM "+a+" WHERE id='"+id+"'";

}
