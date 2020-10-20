import com.itheima.dao.IUserDao;
import com.itheima.entity.QueryVo;
import com.itheima.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession SqlSession;
    private IUserDao userDao;

    @Before
    public void before() throws IOException {
        //加载配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSession构造器
        builder = new SqlSessionFactoryBuilder();
        //创建sqlSession工厂
        factory = builder.build(in);
        //创建session对象
        SqlSession = factory.openSession();
        userDao = SqlSession.getMapper(IUserDao.class);
    }
    @After
    public void after() throws IOException {
        SqlSession.commit();
        SqlSession.close();
        in.close();
    }
    @Test
    public void findByIdTest() throws IOException {

        User byId = userDao.findById(46);
        System.out.println(byId);

    }
    @Test
    public void saveTest() throws IOException {
        User user = new User();
        user.setId(59);
        user.setUsername("钻石老鼠");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("太平天下无敌");
        System.out.println("保存之前。。。" + user);
        userDao.save2(user);
        System.out.println("保存之后。。。" + user);

    }
    @Test
    public void updateTest(){
        User user = new User();
        user.setUsername("修罗");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("中国好声音");
        user.setId(54);
        userDao.update(user);
    }
    @Test
    public void deleteTest(){
        userDao.delete(53);
    }
    @Test
    public void selectCondition() throws ParseException {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("传智播客");
        queryVo.setUser(user);
        queryVo.setStart(parseDate("2018-03-03"));
        queryVo.setEnd(parseDate("2018-03-05"));
        List<User> list = userDao.findByCondition(queryVo);
        System.out.println(list);
    }
    private Date parseDate(String text){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(text);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void LikeTest(){
        List<User> list = userDao.findByUsername("%客");
        System.out.println(list);
    }
    @Test
    public void ResultMapTest(){
        List<User> list = userDao.findAll();
        System.out.print("list = " + list);
    }

}
