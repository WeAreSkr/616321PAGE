package cap.mvc.dao.mapper;

import cap.mvc.dao.mapper.custom.CustomEventMapper;
import cap.mvc.model.Event;

public interface EventMapper extends CustomEventMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated
     */
    int insert(Event record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated
     */
    int insertSelective(Event record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated
     */
    Event selectByPrimaryKey(Integer code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Event record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Event record);
}