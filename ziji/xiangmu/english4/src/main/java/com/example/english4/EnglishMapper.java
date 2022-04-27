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
    @Select("SELECT*FROM  english.${biao} ")
    List<english> findAll(@Param("biao") String biao);

    @Select("SELECT table_name FROM information_schema.tables WHERE TABLE_SCHEMA = 'english'  ")
    List<String> findAll2();

    @Select("SELECT table_name FROM information_schema.tables WHERE TABLE_SCHEMA = 'englishc'  ")
    List<String> findAll2c();

    @Insert("insert into english.${biao} values(null,#{name},#{fanyi})")
    public void se(@Param("biao") String biao,@Param("name") String name, @Param("fanyi") String fanyi);
//查询数量值
    @Select("SELECT*FROM english.${biao} ORDER BY id DESC LIMIT 1")
    Integer findAll3(@Param("biao") String biao);

    @Select("SELECT*FROM english.${biao} WHERE id=${id}")
    List<english> findAll4(@Param("id") int id,@Param("biao") String biao);
//    String sql = "SELECT*FROM "+a+" WHERE id='"+id+"'";
       @Insert("INSERT INTO englishc.${biao} (name,fanyi) VALUES (#{name},#{fanyi})")
       void insertc(@Param("biao") String biao,@Param("name") String name, @Param("fanyi") String fanyi);

}
