# jposx/core

The central backend service of **JposX** — a full-stack point-of-sale system inspired by real-world restaurant infrastructure.

This module uses [Javalin](https://javalin.io/) to expose **HTTP APIs** and **WebSocket endpoints** that power order intake, kitchen routing, and persistent storage via **SQLite**.

---

## 📡 API & Socket Overview

### HTTP Endpoints
- `POST /order` – Create a new order
- `GET /orders/:id` – Fetch order by ID

> 📚 Full API documentation coming soon.
