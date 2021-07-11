import com.org.config.MybatisPlusApplication;
import com.org.mapper.CollegeMapper;
import com.org.mapper.TeacherMapper;
import com.org.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class RandomTeacherTest {
    @Resource
    private TeacherMapper teacherMapper;

    @Test
    void randomTest(){
        RandomTeacher randomTeacher = new RandomTeacher();
        int sex = randomTeacher.randSex();
        int age = randomTeacher.randAge();
        String familyName = randomTeacher.randSingleFamilyName();
        String name = randomTeacher.randName(sex);
        int college = randomTeacher.randCollege();
        String id = randomTeacher.randTeacherID(college);
        System.out.println(familyName+name+","+sex+","+age);
        System.out.println(college+","+id);
    }

    @Test
    void randomTeacherTest(){
        List<Teacher> teacherList = new ArrayList<>();
        for(int i=0;i<2900;i++){
            Teacher randomTeacher = RandomTeacher.getRandomTeacher();
            Boolean ifSame = false;
            for(Teacher teacher : teacherList){
                if(teacher.getID().equals(randomTeacher.getID())){
                    System.out.println("ID重复:"+teacher.getID());
                    ifSame=true;
                    break;
                }
            }
            if(!ifSame){
                //如果没有重复，那么就插入
                teacherList.add(randomTeacher);
                //同时数据库插一条
                teacherMapper.insert(randomTeacher);
            }
            System.out.println(randomTeacher);
        }
        //循环结束，打印插入了多少条
        System.out.println("总共生成了"+teacherList.size()+"条数据");
    }
}
