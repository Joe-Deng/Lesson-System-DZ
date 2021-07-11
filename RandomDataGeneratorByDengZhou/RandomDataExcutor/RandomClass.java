
import com.org.config.MybatisPlusApplication;
import com.org.mapper.ClassMapper;
import com.org.mapper.MajorMapper;
import com.org.pojo.Class;
import com.org.pojo.Major;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;


@SpringBootTest(classes = MybatisPlusApplication.class)
public class RandomClass {
    @Resource
    private MajorMapper mapper;
    @Resource
    private ClassMapper classMapper;

    @Test
    public void test(){
        List<Major> allMajors = mapper.selectList(null);
        for(Major major : allMajors){
            System.out.println(major);
            //ID = 年级Grade + MajorId + 1位（1~3）的随机数randomClassNum
            for(int grade=2016; grade<2022; grade++){
                //每个专业包含2016~2021年级的班级
                int randomClassNum = new Random().nextInt(3)+1;
                for(int i=0; i<randomClassNum; i++){
                    //根据随机数添加班级数量
                    Class randomClass = new Class(
                            grade+major.getID()+(i+1),
                            major.getName()+ grade%100 +"级"+ (i+1) + "班",
                            major.getCollegeId(),
                            major.getID(),
                            grade
                            );
                    System.out.println(randomClass);
                    classMapper.insert(randomClass);
                }
            }
        }
    }
}
