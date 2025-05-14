package dev.blac.jposx.middleware;

import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLogger {
	private final Logger logger = LoggerFactory.getLogger(RequestLogger.class);

	public RequestLogger(Javalin app) {
		app.before(ctx -> {
			logger.info("→ {} {}", ctx.method(), ctx.fullUrl());
		});
	}
}
