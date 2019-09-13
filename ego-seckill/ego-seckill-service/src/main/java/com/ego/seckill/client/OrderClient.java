package com.ego.seckill.client;

import com.ego.order.api.OrderApi;
import com.ego.seckill.config.OrderConfig;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "order-service",configuration = OrderConfig.class)
public interface OrderClient extends OrderApi {
}
