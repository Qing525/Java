import com.ljq.date.UserA;
import com.ljq.date.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisApplicationTests {

    @Resource
    private UserRepo userRepo;

    @Test
    public void xx1(){
        UserA userA = userRepo.findById(2L).get();
        userA.setName("500");
        userRepo.save(userA);
    }
}
