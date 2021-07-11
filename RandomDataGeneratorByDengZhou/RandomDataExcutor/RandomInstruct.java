import com.org.config.MybatisPlusApplication;
import com.org.mapper.*;
import com.org.pojo.Class;
import com.org.pojo.Instruct;
import com.org.pojo.Teacher;
import com.org.pojo.TeacherSchedule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class RandomInstruct {
    @Resource
    private TeacherScheduleMapper teacherScheduleMapper;
    @Resource
    private ClassMapper classMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private InstructMapper instructMapper;

    @Test
    void test(){
        //Lesson以学院为单位，Teacher也以学院为单位，那么查班级，根据班级所属学院随机添加老师和课程
        //将101~123学院的选课各自添加
        for(int collegeNum=101; collegeNum<124; collegeNum++) {
            Map<String, Object> map = new HashMap<>();
            map.put("college_id", collegeNum);
            List<Class> classes = classMapper.selectByMap(map);
            //选出该学院的的所有老师日程，不好选，因为没保存CollegeID，所以得借助老师查询
            List<TeacherSchedule> teacherSchedules = new ArrayList<>();
            List<Teacher> teachers = teacherMapper.selectByMap(map);
            for(Teacher teacher : teachers){
                Map<String, Object> map1 = new HashMap<>();
                map1.put("teacher_id",teacher.getID());
                List<TeacherSchedule> teacherSchedules1 = teacherScheduleMapper.selectByMap(map1);
                teacherSchedules.addAll(teacherSchedules1);
            }
//            添加一个内存Instruct列表表示已选择的Instruct,可以用于验证班级和日程同时重复
            List<String> instrunct_ids = new ArrayList<>();

            //针对课程过多，班级过少的情况，需要平均每个班的25个日程不能超过12个，超过则结束选课。
            int maxInstruct = classes.size() * 12;
            //每个循环班级选一次课，保证所有班级都能平均选到课
            while (teacherSchedules.size()>0 && instrunct_ids.size()<maxInstruct){
                for(int classIndex=0; classIndex<classes.size();classIndex++){
                    if(teacherSchedules.size()==0){
                        //如果中途课选完了，就结束
                        break;
                    }
                    //遍历每一个班级，选择一次课(ID与班级ID+日程Schedule）
                    //随机挑选课程
                    int randomTeacherScheduleIndex = new Random().nextInt(teacherSchedules.size());
                    TeacherSchedule teacherSchedule = teacherSchedules.get(randomTeacherScheduleIndex);
                    Class aClass = classes.get(classIndex);
                    //一位整数加0边两位
                    int normalSchedule = teacherSchedule.getSchedule();
                    String schedule = normalSchedule+"";
                    if(normalSchedule<10){
                        schedule = "0"+schedule;
                    }
                    String id = aClass.getID()+schedule;
                    //验证是否重复
                    if(instrunct_ids.contains(id)){
                        //重复则跳过该次循环，该班少选一门课
                        System.out.println("重复，跳过："+id);
                        continue;
                    }
                    Instruct instruct = new Instruct(
                            id,
                            aClass.getID(),
                            teacherSchedule.getLessonId(),
                            teacherSchedule.getTeacherId(),
                            teacherSchedule.getSchedule()
                    );
                    //*********执行数据库插入操作
                    System.out.println(instruct);
                    instructMapper.insert(instruct);
                    //添加至验重数组
                    instrunct_ids.add(instruct.getID());
                    //完成后删除该TeacherSchedule;
                    teacherSchedules.remove(randomTeacherScheduleIndex);
                }
            }
        }

    }

}
