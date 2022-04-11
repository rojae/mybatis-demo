package kr.imcf.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class DatabaseTest {
    private static final Logger logger = LogManager.getLogger(DatabaseTest.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void connectionTest(){
        try(Connection con = sqlSessionFactory.openSession().getConnection()){
            logger.debug("Catalog : " +  con.getCatalog());
            logger.debug("Database connection ok");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}