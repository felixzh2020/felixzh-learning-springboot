package com.felixzh.engine.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String taskId;

    private String createBy;

    private long createTime;

    private String updateBy;

    private long updateTime;

}
