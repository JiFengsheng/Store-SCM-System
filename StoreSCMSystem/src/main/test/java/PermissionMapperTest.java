import com.jfs.dao.PermissionMapper;
import com.jfs.domain.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PermissionMapperTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void testFindPermissionByUsername(){

        List<Permission> aaa = permissionMapper.selectAll();
        for(Permission permission:aaa){
            System.out.println(permission);
        }
    }

    @Test
    public void test01(){

        List<Permission> permissions = permissionMapper.selectByUserId(3, false);
        for(Permission permission:permissions){
            System.out.println(permission);
        }

    }

    @Test
    public void test02(){

        List<Permission> list = permissionMapper.selectByIdAndType(1, true, "staff");
        for(Permission permission:list){
            System.out.println(permission);
        }
    }

}
