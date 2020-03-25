import com.jfs.dao.RoleMapper;
import com.jfs.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void test01(){

        Role role = roleMapper.selectByPrimaryKey(1);
        System.out.println(role);


    }

    @Test
    public void test02(){

        Role role = roleMapper.selectById(1);
        System.out.println(role);

    }


}
