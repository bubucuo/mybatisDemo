package net.biancheng.test;

import net.biancheng.po.Website;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebsiteMapper {
    @Select("select * from website")
    List<Website> selectAllWebsite();

    @Insert("insert into website (name,url,age,country) values(#{name},#{url},#{age},#{country})")
    void addWebsite(Website website);
}
