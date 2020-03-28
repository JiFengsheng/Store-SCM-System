import com.jfs.dao.StaffMapper;
import com.jfs.domain.Staff;
import com.jfs.service.IStaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StaffMapperTest {

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private IStaffService staffService;

    @Test
    public void test01(){

        Staff staff = staffMapper.selectById("202003230101");
        System.out.println(staff);


    }
    @Test
    public void test02(){
        Staff staff = staffMapper.selectByPrimaryKey("202003230101");
        System.out.println(staff);
    }

    @Test
    public void test03(){
        List<Staff> staff = staffMapper.selectByDepartmentId(1);
        System.out.println(staff);

    }

    @Test
    public void test04(){
        Staff staff = new Staff();
        staff.setStaffId("202003230101");
        List<Staff> list = staffMapper.selectByExample(staff);
        for(Staff s:list){
            System.out.println(s);
        }
    }

    @Test
    public void test05(){

        int i = staffService.updatePic("202003280202",
                "017aa5e2-6ab2-4699-ae3d-e9f614f6df36.jpg");
        System.out.println(i);


    }




}
