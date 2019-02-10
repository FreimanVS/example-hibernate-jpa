CREATE TABLE IF NOT EXISTS user(
      id INT NOT NULL AUTO_INCREMENT,
      name VARCHAR(128) NOT NULL,
      password VARCHAR(128) NOT NULL,
      PRIMARY KEY (id),
      UNIQUE (name)
  );