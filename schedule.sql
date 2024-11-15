CREATE TABLE User (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(50) NOT NULL,
                      email VARCHAR(100) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Schedule (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          user_id BIGINT NOT NULL,
                          user_name VARCHAR(20) NOT NULL ,
                          title VARCHAR(20),
                          contents VARCHAR(100),
                          created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);
