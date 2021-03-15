package com.qfant.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: chenghui
 * @Date: 2021/3/15 10:56
 */
@Component
public class MyLB implements  LoadBalancer{
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index=getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }

    public final  int getAndIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current<Integer.MAX_VALUE?current+1:0;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("************"+next);
        return next;
    }
}
