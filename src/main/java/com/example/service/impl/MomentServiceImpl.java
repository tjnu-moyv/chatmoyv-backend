package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.Moment;
import com.example.service.MomentService;
import com.example.mapper.MomentMapper;
import org.springframework.stereotype.Service;

/**
* @author 17986
* @description 针对表【moment】的数据库操作Service实现
* @createDate 2023-08-04 17:06:40
*/
@Service
public class MomentServiceImpl extends ServiceImpl<MomentMapper, Moment>
    implements MomentService{

}




