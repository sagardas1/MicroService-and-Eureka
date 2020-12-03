package com.shopingCart.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class AsynExecutorService {
	@Async
	public void m1() throws InterruptedException {
		System.out.println("m1()");
		Thread.sleep(1000000000l);

	}
	
	
	@Async
	public void m2() {
		System.out.println("m2()");
		

	}
}
