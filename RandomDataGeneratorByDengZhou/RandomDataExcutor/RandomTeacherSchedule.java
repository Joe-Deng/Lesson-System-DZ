import com.org.config.MybatisPlusApplication;
import com.org.mapper.LessonMapper;
import com.org.mapper.TeacherMapper;
import com.org.mapper.TeacherScheduleMapper;
import com.org.pojo.Lesson;
import com.org.pojo.Teacher;
import com.org.pojo.TeacherSchedule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class RandomTeacherSchedule {
    @Resource
    private TeacherScheduleMapper teacherScheduleMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private LessonMapper lessonMapper;

    @Test
    void test(){
        //注意！！只能执行一次！当执行前一定要将TeacherSchedule表清空
        //将101~123学院的选课各自添加
        for(int collegeNum=101; collegeNum<124; collegeNum++){
            Map<String,Object> map = new HashMap<>();
            map.put("college_id",collegeNum);
            //选出当前学院的所有老师
            List<Teacher> teachers = teacherMapper.selectByMap(map);
            //选出当前学院的所有课程
            List<Lesson> lessons = lessonMapper.selectByMap(map);
            //将课程翻三倍，让每节课最多三个老师教
            List<Lesson> allLessons = new ArrayList<>();
            allLessons.addAll(lessons);
            allLessons.addAll(lessons);
            allLessons.addAll(lessons);

            System.out.println("lesson已翻倍");
            for(int teacherIndex = 0;teacherIndex< teachers.size();teacherIndex++){
                //当无课可选的时候，则结束循环
                if(allLessons.size()==0){
                    break;
                }
                Teacher teacher = teachers.get(teacherIndex);
                //从中随机挑选3节课并从原列表删除
                List<Lesson> selectedLessons = new ArrayList<>();
                for(int i=0;i<3;i++){
                    if(allLessons.size()==0){
                        break;
                    }
                    int randomLessonIndex = new Random().nextInt(allLessons.size());
                    Lesson lesson = allLessons.get(randomLessonIndex);
                    Boolean isSame = false;
                    //如果课程不重复再添加至已选课程
                    for(int j=0; j<selectedLessons.size(); j++){
                        Lesson lesson1 = selectedLessons.get(j);
                        //如果id相同，则是重复
                        if(lesson1.getID().equals(lesson.getID())){
                            isSame = true;
                            break;
                        }
                    }
                    //如果重复，则跳过该课程，那么该老师少选1门课，只有2门课
                    if(isSame){
                        continue;
                    }
                    //不重复则添加到选课列表
                    selectedLessons.add(lesson);
                    System.out.println("删课前："+selectedLessons.size());
                    allLessons.remove(randomLessonIndex);   //删除已选择的课程
                }
                //老师已经挑选好任意3节课了
                System.out.println("老师已经挑选好任意3节课了"+selectedLessons);

                //先生成随机9个老师日程安排
                List<Integer> schedules = randomSchedule(9,25);
                //所选课程分三次安排至各日程
                for(int i=0; i<selectedLessons.size(); i++){
                    Lesson selectedLesson = selectedLessons.get(i);
                    for(int j=0;j<3;j++){
                        if(schedules.size()>0){
                            //随机数取第一位，用完就就删除
                            int schedule = schedules.get(0);
                            //生成对象(ID为课程ID+老师ID+数字1~3)
                            TeacherSchedule teacherSchedule = new TeacherSchedule(
                                    selectedLesson.getID()+teacher.getID()+j,
                                    teacher.getID(),
                                    selectedLesson.getID(),
                                    schedule
                            );
                            //******这里执行数据库插入操作
                            System.out.println(teacherSchedule);
                            teacherScheduleMapper.insert(teacherSchedule);
                            //生成了对象就要删除该随机日程
                            schedules.remove(0);
                        }
                    }
                }
                //所有课程安排完成
            }
            //该学院所有老师课程安排完成
        }
    }


    List<Integer> randomSchedule(int size, int range){
        Set r = new LinkedHashSet<Integer>(size);
        Random random = new Random();

        while (r.size() < size ) {
            int i = random.nextInt(range)+1;
            r.add(i);
        }
        List<Integer> res = new ArrayList<>();
        Object[] arrs = r.toArray();
        for(Object a: arrs){
            res.add(Integer.valueOf(a.toString()));
        }
        return res;
    }
}


