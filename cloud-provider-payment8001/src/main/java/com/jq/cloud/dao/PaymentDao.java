package com.jq.cloud.dao;

import com.jq.cloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface PaymentDao {

    Payment getPaymentById(@PathVariable("id") Long id);

}
