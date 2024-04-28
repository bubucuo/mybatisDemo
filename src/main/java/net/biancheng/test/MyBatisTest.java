package net.biancheng.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.biancheng.po.Website;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        // 读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
        // 通过SqlSessionFactory创建SqlSession
        SqlSession ss = ssf.openSession();
        // SqlSession执行文件中定义的SQL，并返回映射结果
        // 添加网站
        Website website = new Website();
        website.setName("编程帮");
        website.setUrl("https://www.cainiaoplus.com/");
        website.setAge(21);
        website.setCountry("CN");
        ss.insert("net.biancheng.mapper.WebsiteMapper.addWebsite", website);

        // Mapper接口发送 SQL
        // 查询所有网站
        List<Website> listWeb = ss.selectList("net.biancheng.mapper.WebsiteMapper.selectAllWebsite", website );
        for (Website site : listWeb) {
            System.out.println(site);
        }
        // 提交事务
        ss.commit();
        // 关闭 SqlSession
        ss.close();
    }

}