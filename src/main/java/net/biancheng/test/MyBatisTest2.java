package net.biancheng.test;

import net.biancheng.po.Website;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// 注解
public class MyBatisTest2 {
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

        WebsiteMapper websiteMapper = ss.getMapper(WebsiteMapper.class);
        websiteMapper.addWebsite(website);

        // Mapper接口发送 SQL
        // 查询所有网站
        List<Website> listWeb = websiteMapper.selectAllWebsite();
        for (Website site : listWeb) {
            System.out.println(site);
        }
        // 提交事务
        ss.commit();
        // 关闭 SqlSession
        ss.close();
    }

}