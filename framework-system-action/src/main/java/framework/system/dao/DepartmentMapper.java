package framework.system.dao;

import java.util.List;

import framework.system.model.Department;

public interface DepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_department
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_department
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    int insert(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_department
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    int insertSelective(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_department
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    Department selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_department
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_department
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    int updateByPrimaryKey(Department record);

	List<Department> queryDepartmentList(Department department);

	List<Department> queryDepartmentTree(String dept_code);

	Department getDepartmentByCode(String parent_code);

	List<Department> queryDepartmentListByParent(String parent_code);

	List<Department> queryDepartmentListByParentList(
			List<Department> departmentList);
}