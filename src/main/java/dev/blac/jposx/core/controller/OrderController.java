package dev.blac.jposx.core.controller;

import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderController {
	private Logger logger = LoggerFactory.getLogger(OrderController.class);

	public OrderController(Javalin app) {
		app.post("/order", ctx -> {
		});

		app.get("/order/{id}", ctx -> {
		});

		logger.info("OrderController endpoints registered");
	}

}
