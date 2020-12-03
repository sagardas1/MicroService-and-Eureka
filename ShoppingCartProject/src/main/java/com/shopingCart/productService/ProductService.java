package com.shopingCart.productService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.shopingCart.baseResponce.BaseResponce;
import com.shopingCart.productDao.ProductDao;
import com.shopingCart.productDao.ProductPriceDetailsDao;
import com.shopingCart.productDao.ProductTransactionsDao;
import com.shopingCart.productVo.BasketInfo;
import com.shopingCart.productVo.ItemVo;
import com.shopingCart.productVo.Payment;
import com.shopingCart.productVo.ProductPriceDetails;
import com.shopingCart.productVo.ProductTransactions;
import com.shopingCart.productVo.ProductVo;
import com.shopingCart.purchasseMessagingService.MessageConstant;
import com.shopingCart.purchasseMessagingService.PurchaseMessageingService;
import com.shopingCart.responceConstants.ResponceConstants;
import com.shopingCart.userDao.UserBasketDao;
import com.shopingCart.userDao.UserDoa;
import com.shopingCart.userVo.UserBasket;
@Scope(value="prototype")
@Service
public class ProductService {

	
	@Autowired
	public ProductDao productDao;
	@Autowired
	public UserDoa userDoa;
	@Autowired
	public UserBasketDao userBasketDao;
	@Autowired
	public ProductPriceDetailsDao productPriceDetailsDao;
	@Autowired
	public ProductTransactionsDao productTransactionsDao;
	@Autowired
	public PurchaseMessageingService purchaseMessageingService;

	@Autowired
	private EntityManager entityManager;

	public BaseResponce<Void> insertProduct(ProductVo productVo) {
		Query query = entityManager.createNativeQuery("Select * from userdetails where username=? and userlastname=?");
		query.setParameter(1, "fhsbf").setParameter(2, "fhsdbh");
		query.getResultList();

		
		
		
		
	
		
		
		
		
		BaseResponce<Void> baseResponce = new BaseResponce<Void>();
		ProductVo pro = productDao.getproductFromdb(productVo.getProductName());
		if (pro != null) {
			productVo.setQuantity(productVo.getQuantity() + pro.getQuantity());
			int update = productDao.updateProductsQuantity(productVo.getProductName(), productVo.getQuantity());
			if (update > 0) {
				baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
				baseResponce.setStatusMessage(ResponceConstants.UPDATE);
			}
			

		} else {
			productDao.save(productVo);
			baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
			baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE);
		}
		return baseResponce;
	}

	
	
	public List<ProductVo> viewAllProduct() {
		List<ProductVo> list = null;
		list = productDao.viewAllProduct();
		return list;
	}

	public BaseResponce<Void> addToCart(UserBasket userBasket) {
		BaseResponce<Void> baseResponce = null;

		UserBasket userProduct = userBasketDao.getUserProduct(userBasket.getProductName(), userBasket.getEmail());
		baseResponce = new BaseResponce<Void>();

		if (userProduct != null) {
			userBasket.setQuantity(userBasket.getQuantity() + userProduct.getQuantity());
			int update = userBasketDao.updateUserBasket(userBasket.getProductName(), userBasket.getQuantity(),
					userBasket.getEmail());
			if (update > 0) {
				baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
				baseResponce.setStatusMessage(ResponceConstants.UPDATE);
			} else {
				baseResponce.setStatusCode(ResponceConstants.FAILED);
				baseResponce.setStatusMessage(ResponceConstants.FAIL_MESSAGE);
			}
		} else {
			userBasketDao.save(userBasket);
			baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
			baseResponce.setStatusMessage(ResponceConstants.UPDATE);
		}

		return baseResponce;
	}

	public BasketInfo viewCart(String email) {
		double totalAmountToBePaid = 0;
		ItemVo itemVo = null;
		List<ItemVo> itemVoList = new ArrayList<ItemVo>();
		List<UserBasket> userbasketList = userBasketDao.getUserBasketList(email);
		List<String> productName = new ArrayList<String>();

		for (UserBasket basket : userbasketList) {
			productName.add(basket.getProductName());
		}
		List<ProductPriceDetails> productPriceDetailsList = new ArrayList<>();

		for (String name : productName) {
			ProductPriceDetails productPriceDetails = productPriceDetailsDao.getProductPrice(name);
			productPriceDetailsList.add(productPriceDetails);

		}
		for (int i = 0; i < userbasketList.size(); i++) {
			for (int j = 0; j < productPriceDetailsList.size(); j++) {
				if (userbasketList.get(i).getProductName().equals(productPriceDetailsList.get(j).getProductName())) {
					itemVo = new ItemVo();
					itemVo.setProductName(userbasketList.get(i).getProductName());
					itemVo.setQuantity(userbasketList.get(i).getQuantity());
					itemVo.setPrice(userbasketList.get(i).getQuantity() * productPriceDetailsList.get(j).getPrice());
					totalAmountToBePaid += itemVo.getPrice();
					itemVoList.add(itemVo);

				}
			}
		}
		Payment payment = new Payment();
		payment.setAmountToBePaid(totalAmountToBePaid);
		payment.setPaymentStatus(ResponceConstants.NOT_PAID);
		payment.setFinalAmount(totalAmountToBePaid);
		payment.setAmountPaid(0);
		BasketInfo basketInfo = new BasketInfo();
		basketInfo.setItemList(itemVoList);
		basketInfo.setTotalPrice(totalAmountToBePaid);

		basketInfo.setPayment(payment);
		basketInfo.setEmail(email);

		return basketInfo;
	}

	public BasketInfo payment(BasketInfo basketInfo) {
		long quantity = 0;
		ProductTransactions productTransactions = new ProductTransactions();
		List<ItemVo> itemList = new ArrayList<>();
		itemList = basketInfo.getItemList();
		if (basketInfo.getPayment().getAmountToBePaid() == basketInfo.getPayment().getAmountPaid()) {
			for (ItemVo item : itemList) {
				userBasketDao.removeItems(item.getProductName(), basketInfo.getEmail());
				ProductVo product = productDao.getproductFromdb(item.getProductName());
				quantity = product.getQuantity() - item.getQuantity();

				productDao.updateRecord(item.getProductName(), quantity);
				quantity = 0;
			}

			productTransactions.setEmail(basketInfo.getEmail());
			productTransactions.setAmountPaid(basketInfo.getPayment().getAmountPaid());
			productTransactions.setPaymentStatus(basketInfo.getPayment().getPaymentStatus());
			productTransactions.setFinalAmount(basketInfo.getPayment().getFinalAmount());
			productTransactions.setPaymentStatus(ResponceConstants.PAID);
			productTransactionsDao.save(productTransactions);
			basketInfo.setStatusCode(ResponceConstants.SUCCESS_CREATED);
			basketInfo.setStatusMessage(ResponceConstants.PAYMENT_SUCCESSFULL);
		}
		if (basketInfo.getStatusCode() == ResponceConstants.SUCCESS_CREATED) {
			purchaseMessageingService.sendMessage(MessageConstant.PURCHASE_MESSAGE_SUBJECT, basketInfo.getEmail(),
					MessageConstant.PURCHASE_MESSAGE_TEXT);
			purchaseMessageingService.sendMessage(MessageConstant.PURCHASE_MESSAGE_SUBJECT, basketInfo.getEmail(),
					MessageConstant.LINK_FOR_WHATSAPP_UPDATE);

		}

		// whatsappIntegration pending.

		return basketInfo;
	}

	public ProductPriceDetails viewProduct(String name) {
		return productPriceDetailsDao.getProductPrice(name);

	}

	public ProductPriceDetails deleteProduct(String name) {
		return productPriceDetailsDao.deleteProduct(name);

	}

	public BaseResponce<Void> removeProductFromCart(UserBasket userBasket) {
		userBasketDao.delete(userBasket);
		return null;
	}

	public List<ProductPriceDetails> vieworderdetails(String email) {
		return null;
	}

	public List<ProductPriceDetails> productListWithRespectToQuantity() {
		return null;
	}

}
