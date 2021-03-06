package framework.system.dao;


import java.util.List;

import framework.system.model.Log;

public interface LogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_log
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_log
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    int insert(Log record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_log
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    int insertSelective(Log record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_log
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    Log selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_log
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    int updateByPrimaryKeySelective(Log record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_log
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    int updateByPrimaryKey(Log record);

	List<Log> queryLogList(Log log);

	void deleteLogForTask();

}