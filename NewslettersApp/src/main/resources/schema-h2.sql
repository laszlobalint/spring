CREATE TABLE IF NOT EXISTS subscriptions (
    id VARCHAR(36) PRIMARY KEY,
    fullname VARCHAR(64) NOT NULL,
    email VARCHAR(64) NOT NULL,
    UNIQUE KEY UK_email (email)
);

CREATE TABLE IF NOT EXISTS newsletters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    publishingdate DATE
);
