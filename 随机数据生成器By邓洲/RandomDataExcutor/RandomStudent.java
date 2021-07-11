import com.org.config.MybatisPlusApplication;
import com.org.mapper.ClassMapper;
import com.org.mapper.StudentMapper;
import com.org.pojo.Class;
import com.org.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class RandomStudent {
    @Resource
    private ClassMapper classMapper;
    @Resource
    private StudentMapper studentMapper;

    @Test
    void test(){
        List<Class> classes = classMapper.selectList(null);
        for(Class cls : classes){
            //每个班级随机生成20~40名学生
            int randomStudentNum = new Random().nextInt(21)+20;
            for(int i=0; i<randomStudentNum; i++){
                //生成三位顺序数(100~）studentID
                int studentID = 100+i;
                RandomTeacher randomTeacher = new RandomTeacher();
                int sex = randomTeacher.randSex();
                String name = randomTeacher.randSingleFamilyName()+randomTeacher.randName(sex);
                Student student = new Student(
                        cls.getID()+studentID,
                        name,
                        cls.getCollegeId(),
                        cls.getID(),
                        sex,
                        cls.getGrade(),
                        null,
                        null
                );
//                System.out.println(student);
                studentMapper.insert(student);
            }
        }
    }
}
