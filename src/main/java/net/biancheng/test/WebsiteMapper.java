package net.biancheng.test;

import net.biancheng.po.Website;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WebsiteMapper {
    @Select("select * from website")
    List<Website> selectAllWebsite1();

    @Insert("insert into website (name,url,age,country, createtime) values(#{name},#{url},#{age},#{country}, #{createtime})")
    void addWebsite1(Website website);
}
