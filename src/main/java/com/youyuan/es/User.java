package com.youyuan.es;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名称：User <br>
 * 类描述： user索引下文档类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/8/9 13:14<br>
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1772559057730174300L;

    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private Integer age;
}
