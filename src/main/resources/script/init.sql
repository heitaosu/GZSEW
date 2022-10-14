DROP DATABASE sew;
CREATE DATABASE `sew` CHARACTER SET utf8 COLLATE utf8_general_ci;

# 创建加油记录表
create table fuel_record
(
    id            int auto_increment
        primary key,
    work_order    bigint       null comment '工单号',
    fuel_end      bigint       null comment '加油结束时间',
    fuel_start    bigint       null comment '加油开始时间',
    sequence_code varchar(128) null comment '序列号',
    model_type    varchar(64)  null comment '型号',
    install_type  varchar(32)  null comment '安装方式',
    fuel_set_val  double       null comment '注油量设定值',
    fuel_real_val double       null comment '注油量实际值',
    tag_real_val  double       null comment '上传到铭牌的注油量',
    oper_id       int          null comment '操作员用户id',
    create_time   bigint       null comment '创建时间',
    oil_type      varchar(255) null
)
    comment '加油记录表';

create index indexName_create_time
    on fuel_record (create_time);


create table user
(
    id            int auto_increment
        primary key,
    username      varchar(80)   null,
    password      varchar(80)   null,
    real_name     varchar(80)   null comment '用户真实姓名',
    user_level    int default 1 null comment '用户等级 0:管理员 1:普通用户',
    register_date mediumtext    null comment '注册时间',
    state         int default 1 null comment '状态 0:无效(已删除)  1:有效(未删除)'
);


create table warn_record
(
    id          int auto_increment
        primary key,
    warn_type   bigint       null comment '告警类型',
    warn_msg    varchar(255) null comment '告警内容',
    create_time bigint       null comment '创建时间'
)
    comment '告警记录表';

delete from sew.user where 1=1;
delete  from sew.fuel_record where 1=1;

# 添加管理员账号
insert into sew.user (id, username, password, real_name, user_level, register_date, state)
values  (1, 'sewadmin001', 'sew1qaz2wsx', 'sewadmin001', 0, '1652089474839', 1),
        (2, 'suchao', '123456', 'sc', 0, '1652089474839', 1),
        (3, 'suye', '123456', 'sy', 1, '355555', 0),
        (4, 'zhangshan', '123456', '张山', 1, '1658320587617', 1);

######
#redis 订阅

SUBSCRIBE alarm.event.channel;
SUBSCRIBE btn.event.channel;

#redis 发布 实时注油量
PUBLISH alarm.event.channel val_62_12

