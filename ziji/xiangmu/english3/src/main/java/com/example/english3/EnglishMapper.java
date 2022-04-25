package com.example.english3;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnglishMapper {
    @Select("select * from english0001")
    List<english> findAll();
    @Select("SHOW TABLES")
    List<String> findAll2();
    @Insert("insert into english.#{biao} values(null,#{name},#{fanyi})")
    public void se(@Param("biao") String biao,@Param("name") String name, @Param("fanyi") String fanyi);

}
