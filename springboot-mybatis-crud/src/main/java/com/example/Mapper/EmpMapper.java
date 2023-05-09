package com.example.Mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;


/**
 * 员工表CRUD
 */
@Mapper
public interface EmpMapper {
    /**
     * 删除员工信息
     * @param id 员工id
     */
    @Delete("delete from emp where id = #{value}")
    void delete (Integer id);

    /**
     * 新增员工信息
     * @param emp 员工信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp (username, name, gender, image, job, entry_date, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert (Emp emp);

    /**
     * 更新员工信息
     * @param emp 员工要更新的信息
     */
    @Update("update emp set username=#{username}, name=#{name}, update_time=#{updateTime} where id=#{id}")
    void update (Emp emp);

    /**
     * 模糊查询姓名带张 性别为男 入职时间 2010-01-01 ~ 2020-01-01
     * @return 员工集合
     * 注释 注解语法 采用xml文件
     */
//    @Select("select * from emp where name like concat('%', #{name}, '%')" +
//            "and gender=#{gender} and entry_date between #{begin} and #{end} order by update_time desc")
    List<Emp> list (String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量勾选删除
     * @param ids 待删除的id
     */
    void deleteByIds (List<Integer> ids);
}
