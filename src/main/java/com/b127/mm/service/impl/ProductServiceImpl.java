package com.b127.mm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.dto.OrderDto;
import com.b127.mm.dto.ProductDto;
import com.b127.mm.dto.ProductOrderDto;
import com.b127.mm.dto.StockDto;
import com.b127.mm.dto.UserDto;
import com.b127.mm.entity.Order;
import com.b127.mm.entity.OrderedProducts;
import com.b127.mm.entity.Product;
import com.b127.mm.entity.User;
import com.b127.mm.repository.OrderedProductsRepository;
import com.b127.mm.repository.ProductRepository;
import com.b127.mm.repository.UserRepository;
import com.b127.mm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderedProductsRepository orderedProductsRepository;

	// @Autowired
	// private FileService fileService;

	/*
	 * @Override public List<Product> getUserProducts(Long userId) { User
	 * currentSeller = userRepository.findById(userId).get(); return
	 * productRepository.findByUser(currentSeller); }
	 */

	@Override
	public List<ProductDto> getUserProducts(Long userId) {
		User currentSeller = userRepository.findById(userId).get();
		List<Product> products = productRepository.findByUser(currentSeller);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();

		for (Product p : products) {
			productDtos.add(new ProductDto(p.getId(), p.getName(), p.getType(), p.getUnitPrice(), p.getCurrencyType(),
					p.getUnitQuantity(), p.getSiUnit(), null));
		}
		return productDtos;
	}

	/*
	 * @Override public Product getOneProduct(Long productId) { return
	 * productRepository.findById(productId).get(); }
	 */

	@Override
	public ProductDto getOneProduct(Long productId) {
		Product p = productRepository.findById(productId).get();
		return new ProductDto(p.getId(), p.getName(), p.getType(), p.getUnitPrice(), p.getCurrencyType(),
				p.getUnitQuantity(), p.getSiUnit(), null);
	}

	@Override
	public Product addProduct(Product product, Long userId) {
		User currentUser = userRepository.findById(userId).get();
		product.setUser(currentUser);
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<ProductOrderDto> getProductOrders(Long productId) {
		List<Object> os = orderedProductsRepository.findProductSells(Long.valueOf(1));
		for(Object o: os ) {
			System.out.println(o);
		}
		
		Product p = productRepository.findById(productId).get();
		List<OrderedProducts> productOrders = orderedProductsRepository.findByProduct(p);
		List<ProductOrderDto> productOrderDtos = new ArrayList<>();
		for (OrderedProducts o : productOrders) {
			productOrderDtos.add(
					new ProductOrderDto(o.getId(), o.getOrder().getOrderStartDate(), o.getOrder().getOrderStartTime(),
							o.getOrder().getOrderStatus(), o.getRequiredQuantity(), o.getSubTotal()));
		}
		return productOrderDtos;

	}

	@Override
	public List<ProductDto> getUserRequiredProducts(List<Long> productIds) {
		// User currentSeller = userRepository.findById(userId).get();
		List<Product> products = productRepository.findByIdIn(productIds);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();

		for (Product p : products) {
			productDtos.add(new ProductDto(p.getId(), p.getName(), p.getType(), p.getUnitPrice(), p.getCurrencyType(),
					p.getUnitQuantity(), p.getSiUnit(), null));
		}
		return productDtos;
	}

	@Override
	public List<ProductDto> getProducts() {
		List<Product> products = productRepository.findAll();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();

		for (Product p : products) {
			StockDto stock = new StockDto(p.getStock().getId(), p.getName(), p.getStock().getStockType(), p.getStock().getMaximumQuantity(), p.getStock().getAvailableQuantity(), p.getStock().isAvailableOnSell(), p.getUnitPrice()); 
			productDtos.add(new ProductDto(p.getId(), p.getName(), p.getType(), p.getUnitPrice(), p.getCurrencyType(),
					p.getUnitQuantity(), p.getSiUnit(), null, stock));
		}
		return productDtos;
	}
	
	@Override
	public ProductDto getProduct(Long productId) {
		Product p = productRepository.findById(productId).get();
		User seller = userRepository.findById(p.getUser().getId()).get();
		StockDto stock = new StockDto(p.getStock().getId(), p.getName(), p.getStock().getStockType(), p.getStock().getMaximumQuantity(), p.getStock().getAvailableQuantity(), p.getStock().isAvailableOnSell(), p.getUnitPrice()); 
		UserDto sellerDto = new UserDto(seller.getId(), seller.getFirstname(), seller.getLastname(), seller.getEmail(), seller.getMobile(), seller.getBuisnessName());
		ProductDto pd = new ProductDto(p.getId(), p.getName(), p.getType(), p.getUnitPrice(), p.getCurrencyType(),
					p.getUnitQuantity(), p.getSiUnit(), null, stock, sellerDto);
		
		return pd;
	}

	/*
	 * @Override public Product addProductNew(String productData, MultipartFile
	 * file, Long userId) throws JsonMappingException, JsonProcessingException {
	 * Product p = new ObjectMapper().readValue(productData, Product.class);
	 * //p.setImage(fileService.saveFile(file, "products")); User currentUser =
	 * userRepository.findById(userId).get(); p.setUser(currentUser); return
	 * productRepository.save(p); }
	 */

}
