package com.leyou.search.client;

import com.leyou.item.api.ItemServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "item-service")
public interface ItemServiceClient extends ItemServiceApi {

}
