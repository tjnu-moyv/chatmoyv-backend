# 需求

* 基础的用户登录和注册
* 好友关系
    * 添加，删除好友
    * 好友对朋友圈的可见性
* 用户之间的信息交流(文字，语音，照片和视频)
    * 一对一信息聊天
    * 群聊
* 朋友圈
    * 发布内容(包括文字，图片，视频)
    * 点赞数量和人，评论内容
    * 是否可见(可见的分组)
* 收藏

# 项目结构:

```
src:
+---main
|   +---java
|   |   \---com
|   |       \---example
|   |           +---config             - 配置相关的
|   |           +---controller         - 控制器层
|   |           +---domain             - 实体类
|   |           +---error              - 有关错误的总类
|   |           |   \---exception      - 项目中出现的异常(抛出时使用)
|   |           +---interceptor        - 拦截器
|   |           +---mapper             - 数据库访问层
|   |           +---request            - 请求层(可选 项目中需要的)
|   |           +---service            - 服务层
|   |           |   \---impl           - 服务层实现
|   |           \---utils              - 工具包
|   \---resources                      - 项目用到的资源
|       +---mapper                     - mybatis-plus生成mapper层实现类用到
|       \---sql                        - 数据库相关
\---test                               - 测试文件夹
    \---java
        \---com
            \---example
```

## 用户表(User)：

* 用户ID(ID):唯一标识用户的ID(主键 bigint,从10000自动增长)
* 用户名(Username):用户在系统中显示的名称(不可重复,最低6位，只有数字和字母)
* 密码(Password):用户的登录密码(至少6位数字和字母(在ASCII为[33-122]之中))
* 昵称(Nickname)：用户在系统中显示的昵称(默认为username)
* 性别(Gender)：用户的性别(非必填)
* 邮箱(Email)：用户的邮箱地址(非必填)
* 手机号码(Phone)：用户的手机号码(非必填)
* 生日(Birthday)：用户的出生日期(非必填)(时间戳)
* 地址(Address)：用户的住址(非必填)
* 教育背景(Education)：用户的教育背景信息(非必填)
* 职业(Occupation)：用户的职业信息(非必填)
* 兴趣爱好(Interests)：用户的兴趣爱好(非必填)
* 个人简介(Bio)：用户的个人简介介绍(非必填)
* 最后登录时间(LastLoginTime)：用户最后一次登录的日期和时间
* 密码的修改日期(PasswordChangeDate)：用户最后一次修改密码的日期
* 创建时间(create_time)：注册时的时间
* 用户状态
* 用户角色
* 逻辑删除(is_deleted):默认为0，删除为1
* 更新时间(update_time):(时间戳)

## 好友关系表(Friendship)：

* 关系ID(ID)：唯一标识好友关系的ID
* 用户ID1(UserID1)：好友关系的一方用户ID
* 用户ID2(UserID2)：好友关系的另一方用户ID
* 关系状态(Status)：表示是否是好友关系，可以是已成为好友2、待确认1、已拒绝0等
* 逻辑删除(is_deleted):默认为0，删除为1
* 创建时间(create_time)：注册时的时间
* 更新时间(update_time):(时间戳)

## 聊天消息表(Message)：

* 消息ID(ID)：唯一标识消息的ID
* 发送者ID(SenderID)：消息的发送者用户ID
* 接收者ID(ReceiverID)：消息的接收者用户ID
* 消息类型(MessageType):消息类型 (0文本1图片2语音3视频)
* 消息内容(Content)：消息的文本内容()
* 发送时间(createstamp)：消息的发送时间
* 是否已读(IsRead)：表示消息是否已被接收者阅读
* 逻辑删除(is_deleted):默认为0，删除为1
* 创建时间(create_time)：注册时的时间
* 更新时间(update_time):(时间戳)

## 朋友圈表(Moment)：

* 动态ID(ID)：唯一标识朋友圈动态的ID
* 用户ID(UserID)：发布动态的用户ID
* 动态内容(Content)：动态的文本内容
* 点赞数(LikeCount)：动态收到的点赞数量
* 评论数(CommentCount)：动态收到的评论数量
* 图片列表(ImageList)：动态中包含的图片列表
* 逻辑删除(is_deleted):默认为0，删除为1
* 创建时间(create_time)：注册时的时间
* 更新时间(update_time):(时间戳)

## 点赞表

* ID
* 朋友圈id
* 点赞者id
* 逻辑删除(is_deleted):默认为0，删除为1
* 创建时间(create_time)：注册时的时间
* 更新时间(update_time):(时间戳)

## 评论表

* ID
* 朋友圈id
* 点赞者id
* 评论内容
* 逻辑删除(is_deleted):默认为0，删除为1
* 创建时间(create_time)：注册时的时间
* 更新时间(update_time):(时间戳)

## 收藏表

* ID
* 收藏者ID
* 收藏内容