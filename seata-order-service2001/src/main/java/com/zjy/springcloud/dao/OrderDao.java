package com.zjy.springcloud.dao;

import com.zjy.springcloud.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author zhujunyang
 * created on 2021/9/10 18:30
 * @Version 1.0
 */
@Mapper
public interface OrderDao {


     @Insert("insert into t_order(id, user_id, product_id, count, money, status) values(null, #{order.user_id},#{order.product_id}, #{order.count}, #{order.money},0)")
     void create (Order order);

      @Update("update t_order set status = 1 where user_id=#{user_id} and status = #{status}")
     void update(@Param("userId") Long userId, @Param("status") Integer status);
}
