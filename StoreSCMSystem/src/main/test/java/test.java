import com.jfs.dao.UserMapper;
import com.jfs.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindByUsername(){
        User aaa = userMapper.findByUsername("jfs");
        System.out.println(aaa);
    }



    @Test
    public void test01(){

        System.out.println("test");
    }
    class v {
        int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "v{" +
                    "id=" + id +
                    '}';
        }
    }

    @Test
    public void test02(){

        List list = new ArrayList();
        v v = new v();
        v.setId(1);
        list.add(v);
        v.setId(2);
        list.add(v);
        for (Object v1:list){
            System.out.println(v1);
        }
    }

}
