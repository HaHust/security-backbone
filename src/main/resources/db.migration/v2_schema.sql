use `ha2s`;

ALTER TABLE `users` auto_increment = 1;
ALTER TABLE `authorities` auto_increment = 1;
ALTER TABLE `students` auto_increment = 1;

DROP TABLE if exists `user_roles`;
DROP TABLE if exists `users`;
DROP TABLE if exists `roles`;

CREATE TABLE `users` (
                         `user_id` int NOT NULL AUTO_INCREMENT,
                         `email` varchar(45) NOT NULL,
                         `password` varchar(64) NOT NULL,
                         `enabled` int NOT NULL DEFAULT(1),
                         `created_at` datetime DEFAULT NULL,
                         `updated_at` datetime DEFAULT NULL,
                         PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `roles` (
                         `role_id` int NOT NULL AUTO_INCREMENT,
                         `role_name` varchar(60) NOT NULL,
                         PRIMARY KEY (`role_id`),
                         UNIQUE KEY `uk_roles_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



CREATE TABLE `user_roles` (
                              `user_id` int NOT NULL,
                              `role_id` int NOT NULL,
                              PRIMARY KEY (`user_id`,`role_id`),
                              KEY `fk_user_roles_role_id` (`role_id`),
                              CONSTRAINT `fk_user_roles_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
                              CONSTRAINT `fk_user_roles_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into `users`(`email`,`password`) values ('hanv','12345');
insert into `roles`(`role_name`) values ('ADMIN'),('USER');
insert into `user_roles`(`user_id`,`role_id`) values (1,1),(1,2);