CREATE TABLE `user` (
  `user_id` INT PRIMARY KEY,
  `user_name` VARCHAR(50) NOT NULL UNIQUE,
  `password_hash` VARCHAR(255) NOT NULL,
  `salt` VARCHAR(64) NOT NULL,
  `email` VARCHAR(255) NOT NULL UNIQUE,
  `phone` VARCHAR(20) UNIQUE,
  `sex` ENUM('male', 'female') NOT NULL,
  `vip_level` TINYINT UNSIGNED DEFAULT 0 NOT NULL,
  `vip_expiry_date` DATETIME DEFAULT NULL,
  `free_vip_uses` INT DEFAULT 0 NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` ENUM('active', 'suspended', 'deleted') DEFAULT 'active' NOT NULL
);

CREATE TABLE `vip_levels`(
  `vip_level` TINYINT PRIMARY KEY,
  `name` VARCHAR(50) NOT NULL,
  `benefits` TEXT,
  `price` DECIMAL(10,2)
);
