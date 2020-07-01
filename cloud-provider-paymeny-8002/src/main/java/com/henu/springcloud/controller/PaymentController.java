package com.henu.springcloud.controller;

import com.henu.springcloud.entity.CommonResult;
import com.henu.springcloud.entity.Payment;
import com.henu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author JinK
 * @date 2020/6/19
 */
@RequestMapping("/payment")
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
      int id = paymentService.insert(payment);
      return new CommonResult<Integer>(200, "success, port:" + serverPort, id);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Integer id){
        Payment payment = paymentService.selectByPrimaryKey(id);
        if (payment != null){
            return new CommonResult<Payment>(200, "success, port:" + serverPort, payment);
        }else{
            return new CommonResult<Payment>(404,"error! port:" + serverPort, null);
        }
    }
}
