package jdbc.tx;

import com.mycompany.springbasic1120.jdbc.tx.dao.BookDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tx1 {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = 
                new ClassPathXmlApplicationContext("jdbc-config.xml");
        BookDao bookDao = ctx.getBean("bookDaoImpl", BookDao.class);
        System.out.println(bookDao);
    }
}
