package com.xin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xin
 * @create 2020-11-26 17:50:51
 */
@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {  //Dept 实体类 ，orm,列表关系映射
    private long deptNo;
    private String dName;

    //这个数据存储在哪个数据库~微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(String db_source) {
        this.db_source = db_source;
    }

    /*
    * 链式写法
    * Dept dept=new Dept();
    * dept.setDeptNo(21).setDName('放入').setDbSource('001')
    * */
}
