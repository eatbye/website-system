package ujn.school.cn.dao.config;

import ujn.school.cn.model.config.Config;

public interface ConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_site_config
     *
     * @mbg.generated Wed Feb 08 22:45:50 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_site_config
     *
     * @mbg.generated Wed Feb 08 22:45:50 CST 2017
     */
    int insert(Config record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_site_config
     *
     * @mbg.generated Wed Feb 08 22:45:50 CST 2017
     */
    int insertSelective(Config record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_site_config
     *
     * @mbg.generated Wed Feb 08 22:45:50 CST 2017
     */
    Config selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_site_config
     *
     * @mbg.generated Wed Feb 08 22:45:50 CST 2017
     */
    int updateByPrimaryKeySelective(Config record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_site_config
     *
     * @mbg.generated Wed Feb 08 22:45:50 CST 2017
     */
    int updateByPrimaryKey(Config record);

	int updateConfig(Config config);

}