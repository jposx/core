CREATE TABLE IF NOT EXISTS Orders (
		order_id INTEGER UNIQUE,
		order_body TEXT,
		status TEXT,
		created_at TEXT,
		PRIMARY KEY(order_id)
);


