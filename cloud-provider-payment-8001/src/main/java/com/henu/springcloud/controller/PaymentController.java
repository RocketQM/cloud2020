package com.henu.springcloud.controller;

import com.henu.springcloud.entity.CommonResult;
import com.henu.springcloud.entity.Payment;
import com.henu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    //服务发现,对于注册进eureka服务注册中心的微服务,可以通过服务发现来获得该服务的信息
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public Object discovery(){
        //getServices 获取所有微服务名称
        List<String> servicesList = discoveryClient.getServices();
        servicesList.forEach(a -> {
            log.info("**** micro service：" + a);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(a -> {
            log.info(a.getServiceId() + "\t" + a.getHost() + "\t" + a.getPort() + "\t" + a.getUri());
        });
        return this.discoveryClient;
    }
}
