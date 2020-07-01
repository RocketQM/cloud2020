package com.henu.springcloud.service;

import com.henu.springcloud.entity.Payment;

/**
* @author JinK
* @date 2020/6/19
*/
public interface PaymentService{


int deleteByPrimaryKey(Integer id);

int insert(Payment record);

int insertSelective(Payment record);

Payment selectByPrimaryKey(Integer id);

int updateByPrimaryKeySelective(Payment record);

int updateByPrimaryKey(Payment record);

}
