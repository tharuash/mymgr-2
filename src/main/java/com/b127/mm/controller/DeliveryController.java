package com.b127.mm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b127.mm.dto.DeliveryDto;
import com.b127.mm.entity.Delivery;
import com.b127.mm.service.DeliveryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/deliveries/{sellerId}")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;
	
	@GetMapping
	public List<DeliveryDto> getDeliveries(@PathVariable Long sellerId){
		return deliveryService.getDeliveries(sellerId);
	}
	
	@PostMapping("/{orderId}")
	public DeliveryDto addDelivery(@RequestBody Delivery delivery, @PathVariable Long sellerId, @PathVariable Long orderId) {
		return deliveryService.addDelivery(delivery, orderId);
	}
	
	@PutMapping("/{orderId}")
	public DeliveryDto updateDelivery(@RequestBody Delivery delivery, @PathVariable Long sellerId, @PathVariable Long orderId) {
		return deliveryService.addDelivery(delivery, orderId);
	}
	
	@GetMapping("/{deliveryId}")
	public DeliveryDto getDelivery(@PathVariable Long deliveryId) {
		return deliveryService.getDelivery(deliveryId);
	}
	
	
	

}
