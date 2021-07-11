package com.dz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dz.entity.Instruct;
import com.dz.entity.InstructInfo;
import com.dz.mapper.InstructMapper;
import com.dz.service.InstructService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 授课 服务实现类
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@Service
public class InstructServiceImpl extends ServiceImpl<InstructMapper, Instruct> implements InstructService {


    public List<Instruct> getInstructsByCollegeId(String collegeId){
        Wrapper<Instruct> wrapper = new EntityWrapper<>();
        Wrapper<Instruct> classes = wrapper.where("class_id in("+
                "select id from class where college_id=" + collegeId+")");
        List<Instruct> instructs = selectList(classes);
        return instructs;
    }
}
