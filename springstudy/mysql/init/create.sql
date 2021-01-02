-- sql문은 해당 위치에 공유합니다.

CREATE TABLE `user` (
                        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                        `account` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
                        `email` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
                        `phone_number` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
                        `created_at` datetime NOT NULL,
                        `created_by` varchar(45) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
                        `updated_at` datetime DEFAULT NULL,
                        `updated_by` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;