package com.github.herdeny.webmedicalmanager.mapper;

import com.github.herdeny.webmedicalmanager.pojo.Fee;
import com.github.herdeny.webmedicalmanager.pojo.PayStatus;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface FeeMapper {
    // 增加费用账单
    @Insert("insert into fee(user_code, object, price, time) values(#{userCode}, #{object}, #{price}, now())")
    void insertFee(int userCode, String object, BigDecimal price);

    // 通过序号删除费用账单
    @Delete("delete from fee where code = #{code}")
    void deleteFee(int code);

    // 修改支付状态
    @Update("update fee set status = #{status} where code = #{code}")
    void updateStatus(int code, PayStatus status);

    // 获取某用户的全部费用账单
    @Select("select * from fee where user_code = #{userCode}")
    List<Fee> getFeeUser(int userCode);

    // 获取全部费用账单
    @Select("select * from fee")
    List<Fee> getFeeAll();

    // 获取月总费用
    @Select("select sum(price) from fee where date_format(time, '%Y-%m') = #{time}")
    BigDecimal getMonthTotal(String time);
}
