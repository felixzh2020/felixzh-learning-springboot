drop database if exists  QuartzEngine;
create database QuartzEngine;

drop table if exists QuartzEngine.TASK_INFO;
CREATE TABLE QuartzEngine.TASK_INFO(
 `task_id` varchar(64) NOT NULL COMMENT '任务ID',
 `task_name` varchar(128) DEFAULT null COMMENT '任务名称',
 `cluster_name` varchar(255) NOT null COMMENT '集群名称',
 `task_type` varchar(50) NOT null COMMENT '任务类型：备份OR恢复',
 `schedule_type` varchar(50) NOT null COMMENT '调度类型：手动OR周期',
 `period_time` varchar(10) DEFAULT null COMMENT '单位：秒',
 `schedule_status` char(1) default '0' COMMENT '调度状态：0正常，1挂起',
 `create_by` varchar(64) default '' COMMENT '创建者',
 `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
 `update_by` varchar(64) default '' COMMENT '更新者',
 `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
 PRIMARY key (`task_id`),
 UNIQUE KEY `unique_taskname_clustername` (`task_id`, `cluster_name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务信息表';

drop table if exists QuartzEngine.TASK_RECORD;
CREATE TABLE QuartzEngine.TASK_RECORD(
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
 `task_id` varchar(64) NOT NULL COMMENT '任务ID',
 `task_status` varchar(50) DEFAULT null COMMENT '任务状态',
 `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
 `begin_time` bigint(20) DEFAULT NULL COMMENT '开始时间',
 `schedule_time` bigint(20) DEFAULT NULL COMMENT '调度时间',
 `end_time` bigint(20) DEFAULT NULL COMMENT '结束时间',
 `progres` int(11) DEFAULT NULL COMMENT '任务进度',
 `detail_log` text COMMENT '任务日志',
 PRIMARY key (`id`),
 KEY `fk_taskId` (`task_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务调度日志表';