package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.entity.Student;
import com.example.mybatisplus.mapper.StudentMapper;
import com.example.mybatisplus.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2016-2019, Mobius-Vision
 * FileName: StudentServiceImpl
 * Author: liuwenxu
 * Date: 2019-9-26 11:41:09
 * Description:  服务实现类
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
