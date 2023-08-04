package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.Favorite;
import com.example.service.FavoriteService;
import com.example.mapper.FavoriteMapper;
import org.springframework.stereotype.Service;

/**
* @author 17986
* @description 针对表【favorite】的数据库操作Service实现
* @createDate 2023-08-04 17:06:40
*/
@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite>
    implements FavoriteService{

}




