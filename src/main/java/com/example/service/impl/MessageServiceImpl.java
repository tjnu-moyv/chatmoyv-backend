package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.Message;
import com.example.service.MessageService;
import com.example.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author 17986
* @description 针对表【message】的数据库操作Service实现
* @createDate 2023-08-04 17:06:40
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




