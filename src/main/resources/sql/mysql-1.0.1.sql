use moyuchat;

drop table if exists `user`;
create table `user`
(
    id                   bigint auto_increment,
    username             varchar(256) unique not null,
    password             varchar(256)        not null,
    nickname             varchar(256)             default 'user',
    gender               tinyint             null default 0,
    email                varchar(256)        null default null,
    phone_number         varchar(64)         null default null,
    birthday             datetime            null default null,
    address              varchar(256)        null default null,
    education            varchar(256)        null default null,
    occupation           varchar(256)        null default null,
    interests            varchar(256)        null default null,
    bio                  varchar(256)        null default null,
    last_login_time      datetime            null default null,
    password_change_time datetime            null default null,
    create_time          datetime            null default CURRENT_TIMESTAMP null comment '创建时间',
    user_status          tinyint             null default 0 not null comment '用户状态 0 - 正常',
    role                 tinyint             null default 0 comment '用户角色',
    is_delete            tinyint             null default 0 not null comment '是否删除',
    update_time          datetime            null default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    primary key (id)
) auto_increment = 1000
  CHARACTER SET = UTF8MB4;

drop table if exists `user_relations`;
create table `user_relations`
(
    id          bigint auto_increment,
    user_id     bigint   not null,
    friend_id   bigint   not null,
    status      tinyint       default 0,
    create_time datetime null default CURRENT_TIMESTAMP null comment '创建时间',
    is_delete   tinyint  null default 0 not null comment '是否删除',
    update_time datetime null default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    primary key (id)
) character set = UTF8MB4;

