package com.b127.mm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.dto.DeliveryDto;
import com.b127.mm.entity.Delivery;
import com.b127.mm.entity.Order;
import com.b127.mm.entity.User;
import com.b127.mm.repository.DeliveryRepository;
import com.b127.mm.repository.OrderRepository;
import com.b127.mm.repository.UserRepository;
import com.b127.mm.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private DeliveryRepository deliveryRepository;

	@Override
	public DeliveryDto addDelivery(Delivery delivery, Long orderId) {
		Order currentOrder = orderRepository.findById(orderId).get();
		delivery.setOrder(currentOrder);
		Delivery savedDelivery = deliveryRepository.save(delivery);
		return new DeliveryDto(savedDelivery.getId(), savedDelivery.getOrder().getId(), savedDelivery.getDeliveryCost(),
				savedDelivery.getCurrencyType(), savedDelivery.getDestinationAddress(), savedDelivery.getDeliveryType(),
				savedDelivery.getIsDeliveryComplete());
	}

	@Override
	public List<DeliveryDto> getDeliveries(Long sellerId) {
		User seller = userRepository.findById(sellerId).get();
		List<Order> sellerOrders = orderRepository.findBySeller(seller);
		List<Delivery> sellerDeliveries = deliveryRepository.findByOrderIn(sellerOrders);
		List<DeliveryDto> deliveryDtos = new ArrayList<DeliveryDto>();
		for (Delivery d : sellerDeliveries) {
			deliveryDtos.add(new DeliveryDto(d.getId(), d.getOrder().getId(), d.getDeliveryCost(), d.getCurrencyType(),
					d.getDestinationAddress(), d.getDeliveryType(), d.getIsDeliveryComplete()));
		}
		return deliveryDtos;
	}

	@Override
	public DeliveryDto getDelivery(Long deliveryId) {
		Delivery d = deliveryRepository.findById(deliveryId).get();
		return new DeliveryDto(d.getId(), d.getOrder().getId(), d.getDeliveryCost(), d.getCurrencyType(),
					d.getDestinationAddress(), d.getDeliveryType(), d.getIsDeliveryComplete());
	}

}
