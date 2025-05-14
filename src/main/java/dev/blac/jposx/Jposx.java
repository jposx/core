package dev.blac.jposx;

import io.javalin.Javalin;
import io.github.cdimascio.dotenv.Dotenv;
import dev.blac.jposx.controller.OrderEndpoints;
import dev.blac.jposx.config.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jposx {
	static Dotenv dotenv = Dotenv.load();
	static int port = Integer.parseInt(dotenv.get("PORT"));
	static Logger logger = LoggerFactory.getLogger(Jposx.class);

	public static void main(String[] args) {
		logger.info("Starting JPOS ...");
		Javalin app = Javalin.create(config -> {
			config.staticFiles.add(staticFiles -> {
				staticFiles.hostedPath = "/";
				staticFiles.directory = "public";
				staticFiles.location = io.javalin.http.staticfiles.Location.CLASSPATH;

			});
		}).start(port);
		Database.initTable();
		// Register endpoint groups
		OrderEndpoints.register(app);
	}

}
