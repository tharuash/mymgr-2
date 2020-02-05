package com.b127.mm.service;

import java.util.List;

import com.b127.mm.dto.ManualOrderDto;
import com.b127.mm.dto.OrderDto;

public interface OrderService {
	
	// List<OrderDto> getSellerOrders(Long sellerId);
	
	List<ManualOrderDto> getSellerOrders(Long sellerId);
	
	ManualOrderDto addManualOrder(ManualOrderDto manualOrderDto, Long sellerId);
	
	ManualOrderDto getSellerOrder(Long orderId);
}
