package dev.blac.jposx.controller;

import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderController {
	private Logger logger = LoggerFactory.getLogger(OrderController.class);

	public OrderController(Javalin app) {
		app.post("/order", ctx -> {
			logger.info("Order recieved");
		});

		app.get("/order/{id}", ctx -> {

			logger.info("Order get with id " + ctx.pathParam("id"));
		});

		logger.info("OrderController endpoints registered");
	}

}
