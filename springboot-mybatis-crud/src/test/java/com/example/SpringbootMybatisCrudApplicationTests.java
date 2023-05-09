package com.example;

import com.example.Mapper.EmpMapper;
import com.example.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

	@Autowired
	private EmpMapper empMapper;
	/**
	 * 删除部门员工
	 */
	@Test
	void TestEmpDelete() {
		empMapper.delete(6);
	}

	/**
	 * 新增部门人员
	 */
	@Test
	void TestEmpInsert () {
		Emp emp = new Emp();
		emp.setUsername("tom");
		emp.setName("汤姆");
		emp.setGender((short) 1);
		emp.setImage("11.png");
		emp.setDeptId(2);
		emp.setEntryDate(LocalDate.of(2023, 12,22));
		emp.setCreateTime(LocalDateTime.now());
		emp.setUpdateTime(LocalDateTime.now());

		empMapper.insert(emp);
		System.out.println(emp.getId());
	}
	/**
	 * 更新员工信息
	 */
	@Test
	void TestEmpUpdate () {
		Emp emp = new Emp();
		emp.setUsername("wang");
		emp.setName("王者荣耀");
		emp.setUpdateTime(LocalDateTime.now());
		emp.setId(8);

		empMapper.update(emp);
	}
	/**
	 *  根据条件查询
	 *  姓名模糊匹配张  性别男 入职时间在2010到2020年之间
	 */
	@Test
	public void TestEmpList () {
		List<Emp> list = empMapper.list(null, (short) 1, null, null);
		System.out.println(list);
	}

	@Test
	public  void TestDeleteByIds() {
		empMapper.deleteByIds(Arrays.asList(1,2));
	}
}
