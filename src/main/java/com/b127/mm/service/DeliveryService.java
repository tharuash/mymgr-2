package com.b127.mm.service;

import java.util.List;

import com.b127.mm.dto.DeliveryDto;
import com.b127.mm.entity.Delivery;

public interface DeliveryService {
	
	DeliveryDto addDelivery(Delivery delivery, Long orderId);
	
	List<DeliveryDto> getDeliveries(Long sellerId);
	
	DeliveryDto getDelivery(Long deliveryId);
}	
