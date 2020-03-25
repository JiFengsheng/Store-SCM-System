import com.jfs.dao.UserMapper;
import com.jfs.domain.User;

import com.jfs.security.MyUserDetailService;
import com.jfs.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void testFindByUsername(){
        User aaa = userMapper.findByUsername("jfs");
        System.out.println(aaa);
    }


    @Test
    public void testUpdatePassword(){
        User user = new User();
        user.setUserId(3);
//        user.setUsername("admin");
        //哈希算法+盐值
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode("123"));
        userMapper.updateByExample(user);


    }

    @Test
    public void test01(){



    }

    @Test
    public void test02(){
        MyUserDetailService service = new MyUserDetailService();
        UserDetails userDetails = service.loadUserByUsername("jfs");
        System.out.println(userDetails);
    }

    @Test
    public void test03(){
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("123");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        int insert = userMapper.insert(user);
        System.out.println(insert);

        System.out.println(user);

    }

    @Test
    public void test04(){
        User user = userMapper.selectById(1);
        System.out.println(user);

    }



}
