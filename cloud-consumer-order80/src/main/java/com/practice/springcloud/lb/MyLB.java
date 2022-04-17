package com.practice.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ribbon手写轮询算法
 * */
@Component
public class MyLB implements  LoadBalancer{


    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;

        do {
            current = this.atomicInteger.getAndIncrement();
            // 超过最大值,为0,重新计数 2147483647 = Integer.MAX_VALUE
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            // 自旋锁
        }while (this.atomicInteger.compareAndSet(current,next));
        System.out.println("****第几次访问，次数next: "+next);
        return next;
    }

    /*
    * 负载均衡算法:rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标,每次服务重启动后rest接口计数从1开始.
    * */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();


        return serviceInstances.get(index);
    }
}
