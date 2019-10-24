package com.xp.springboot01.mapper;

import com.xp.springboot01.domian.BackLog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BackLogMapper_bak {


    /*****
     * 新增待办信息
     * @param backLog
     */
    @Insert(" insert into back_log(log_name,is_complete,complete_date,log_type) " +
            " values(#{logName},#{isComplete},#{completeDate},#{logType} )")
    void insertBackLog(BackLog backLog);

    /***
     * 按创建时间查询全部待办信息
     * @return
     */
    @Select("select id , log_name logname,is_complete isComplete,complete_date completeDate,log_type logType " +
            " from back_log where is_complete = 0  order by create_date desc ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "logName", column = "logname"),
            @Result(property = "isComplete", column = "isComplete"),
            @Result(property = "completeDate", column = "completeDate"),
            @Result(property = "logType", column = "logType")
    })
    List<BackLog> findAllBackLog();

    /**8
     *  删除待办信息
     * @param id
     */
    @Delete("delete from back_log where id = #{id} ")
    void deleteBackLogById(Long id);

    /***
     * 更新待办信息
     * @param backLog
     */
    @Update({"update back_log  set log_name = '${logName}',complete_date = #{completeDate} where id = #{id} "})
    void updateBackLog(BackLog backLog);
}
