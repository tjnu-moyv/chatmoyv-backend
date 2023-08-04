package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.UserRelations;
import com.example.service.UserRelationsService;
import com.example.mapper.UserRelationsMapper;
import org.springframework.stereotype.Service;

/**
* @author 17986
* @description 针对表【user_relations】的数据库操作Service实现
* @createDate 2023-08-04 17:06:40
*/
@Service
public class UserRelationsServiceImpl extends ServiceImpl<UserRelationsMapper, UserRelations>
    implements UserRelationsService{

}




