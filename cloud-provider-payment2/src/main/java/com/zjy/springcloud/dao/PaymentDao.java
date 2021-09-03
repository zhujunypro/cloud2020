package com.zjy.springcloud.dao;

import com.zjy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhujunyang
 * created on 2021/8/25 10:41
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {

    @Insert("insert into payment(id, serial) values(#{id}, #{serial})")
    public int create(Payment payment);

    @Select("select * from payment where id = #{id}")
    public Payment getPaymentById(@Param("id") Long id);
}
