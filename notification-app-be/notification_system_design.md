# Campus Notification System Design

## Stage 1 - Database Schema

### Tables

### users

| Column | Type |
|---------|------|
| id | BIGINT (PK) |
| name | VARCHAR |
| email | VARCHAR UNIQUE |
| role | VARCHAR |
| created_at | TIMESTAMP |

---

### notifications

| Column | Type |
|---------|------|
| id | BIGINT (PK) |
| title | VARCHAR |
| message | TEXT |
| category | VARCHAR |
| priority | INT |
| created_at | TIMESTAMP |
| expires_at | TIMESTAMP |

---

### notification_recipients

| Column | Type |
|---------|------|
| id | BIGINT (PK) |
| notification_id | BIGINT (FK) |
| user_id | BIGINT (FK) |
| status | VARCHAR |
| delivered_at | TIMESTAMP |

---

## Relationships

- One notification can be delivered to many users.
- One user can receive many notifications.
- notification_recipients acts as the junction table.

---

## Indexes

- users(email)
- notifications(priority)
- notifications(created_at)
- notification_recipients(user_id)
- notification_recipients(notification_id)

These indexes improve lookup speed, notification retrieval, and delivery tracking.