package dev.blac.jposx;

import io.javalin.Javalin;
import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.blac.jposx.controller.OrderController;

public class Jposx {
	private static Jposx jposx;
	static Dotenv dotenv = Dotenv.load();
	static int port = Integer.parseInt(dotenv.get("JAVALIN_PORT"));
	static Logger logger = LoggerFactory.getLogger(Jposx.class);

	public Jposx() {
		logger.info("Starting JposX ...");
		logger.info(
				"\n       _                __   __\n" +
						"      | |               \\ \\ / /\n" +
						"      | |_ __   ___  ___ \\ V / \n" +
						"  _   | | '_ \\ / _ \\/ __| > <  \n" +
						" | |__| | |_) | (_) \\__ \\/ . \\ \n" +
						"  \\____/| .__/ \\___/|___/_/ \\_\\\n" +
						"        | |                    \n" +
						"        |_|                    \n");
		Javalin app = Javalin.create(config -> {
			config.showJavalinBanner = false;
		}).start(port);
		new OrderController(app);
	}

	public static void main(String[] args) {
		jposx = new Jposx();
	}
}
