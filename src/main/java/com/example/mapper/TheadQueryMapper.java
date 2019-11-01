package com.example.mapper;

import com.example.vo.Medical;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @author: yangjie
 * @date: Created in 2019/11/1 9:28
 */
@Repository
public interface TheadQueryMapper {

    @Select("SELECT\n" +
            "\tsuit.suite_id,\n" +
            "\tsuit.update_time,\n" +
            "\tsuit.create_time \n" +
            "FROM\n" +
            "\tt_medical_order_suit suit\n" +
            "\tLEFT JOIN t_trans_medical_order der ON suit.medical_order_id = der.medical_order_id \n" +
            "WHERE\n" +
            "\t suit.create_time < '2019-11-10 10:10:10'\n" +
            "AND suit.create_time > '2019-10-10 10:10:10' \t\n" +
            "order by suit.update_time desc")
    List<Medical> normalQuery();

    @Select("SELECT " +
            "suit.suite_id," +
            "suit.update_time," +
            "suit.create_time " +
            " FROM" +
            " t_medical_order_suit suit" +
            " LEFT JOIN t_trans_medical_order der ON suit.medical_order_id = der.medical_order_id " +
            " WHERE" +
            " suit.create_time >= #{start} " +
            " AND suit.create_time < #{end} order by suit.update_time desc")
    List<Medical> stepQuery(String start, String end);

}
