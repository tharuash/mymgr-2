package com.b127.mm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.dto.ManualOrderDto;
import com.b127.mm.dto.ManualOrderProductDto;
import com.b127.mm.dto.OrderDto;
import com.b127.mm.entity.Order;
import com.b127.mm.entity.OrderedProducts;
import com.b127.mm.entity.Product;
import com.b127.mm.entity.Stock;
import com.b127.mm.entity.User;
import com.b127.mm.repository.OrderRepository;
import com.b127.mm.repository.OrderedProductsRepository;
import com.b127.mm.repository.ProductRepository;
import com.b127.mm.repository.StockRepository;
import com.b127.mm.repository.UserRepository;
import com.b127.mm.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderedProductsRepository orderedProductsRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<ManualOrderDto> getSellerOrders(Long sellerId) {
		User currentSeller = userRepository.findById(sellerId).get();
		List<Order> sellerOrders = orderRepository.findBySeller(currentSeller);
		List<ManualOrderDto> manualorderDtos = new ArrayList<ManualOrderDto>();
		for (Order o : sellerOrders) {
			manualorderDtos.add(new ManualOrderDto(o.getId(), o.getOrderExpirationDate(), o.getOrderStartDate(),
					o.getOrderStartTime(), o.getTotalPrice(), o.getCurrencyType(), o.getOrderStatus(),
					o.getOrderLocation(), o.getSellerConfirmation(), o.getBuyerConfirmation(), null,
					o.getOrderProducts().size()));

		}
		return manualorderDtos;
	}

	@Override
	public ManualOrderDto addManualOrder(ManualOrderDto manualOrderDto, Long sellerId) {
		User currentSeller = userRepository.findById(sellerId).get();
		List<Long> orderProductIds = new ArrayList<>();
		for (ManualOrderProductDto m : manualOrderDto.getOrderedProducts()) {
			orderProductIds.add(m.getProductId());
		}
		List<Product> orderProducts = productRepository.findByIdIn(orderProductIds);
		Order currentOrder = new Order(manualOrderDto.getId(), currentSeller, null, 0.0,
				manualOrderDto.getOrderExpirationDate(), manualOrderDto.getOrderStartDate(),
				manualOrderDto.getOrderStartTime(), manualOrderDto.getTotalPrice(), manualOrderDto.getCurrencyType(),
				manualOrderDto.getOrderStatus(), manualOrderDto.getOrderLocation(),
				manualOrderDto.getSellerConfirmation(), manualOrderDto.getBuyerConfirmation());

		Order savedOrder = orderRepository.save(currentOrder);

		for (ManualOrderProductDto m : manualOrderDto.getOrderedProducts()) {
			OrderedProducts o = new OrderedProducts();
			o.setId(m.getId());
			o.setOrder(savedOrder);
			Product p = orderProducts.stream().filter(pro -> m.getProductId().equals(pro.getId())).findAny().orElse(null);
			 System.out.println(p.getName());
			
			o.setProduct(p);
			o.setRequiredQuantity(m.getRequiredQuantity());
			o.setSubTotal(m.getSubTotal());

			orderedProductsRepository.save(o);
			
			Stock s = stockRepository.findByProduct(p);
			double availableQuantity = s.getAvailableQuantity();
			availableQuantity = availableQuantity - m.getRequiredQuantity();
			s.setAvailableQuantity(availableQuantity);
			stockRepository.save(s);
			
			
		}

		ManualOrderDto mo = new ManualOrderDto();
		mo.setId(savedOrder.getId());
		return mo;

	}

	@Override
	public ManualOrderDto getSellerOrder(Long orderId) {
		Order o = orderRepository.findById(orderId).get();
		List<ManualOrderProductDto> manualOrderProductDtos = new ArrayList<>();

		for (OrderedProducts op : o.getOrderProducts()) {
			manualOrderProductDtos.add(new ManualOrderProductDto(op.getId(), op.getProduct().getName(),
					new Double(op.getRequiredQuantity()).longValue(), op.getSubTotal(), op.getProduct().getId()));
		}
		return new ManualOrderDto(o.getId(), o.getOrderExpirationDate(), o.getOrderStartDate(), o.getOrderStartTime(),
				o.getTotalPrice(), o.getCurrencyType(), o.getOrderStatus(), o.getOrderLocation(),
				o.getSellerConfirmation(), o.getBuyerConfirmation(), manualOrderProductDtos,
				o.getOrderProducts().size());

	}

}
