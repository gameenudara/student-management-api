CREATE TABLE `teacher` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `experience` longtext,
                           `address` varchar(255) DEFAULT NULL,
                           `date` date DEFAULT NULL,
                           `education` longtext,
                           `email` varchar(255) DEFAULT NULL,
                           `gender` enum('FEMALE','MALE') DEFAULT NULL,
                           `image_url` varchar(255) DEFAULT NULL,
                           `mobile` int DEFAULT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           `nic` varchar(255) DEFAULT NULL,
                           `subject` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `class` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `teacher_id` bigint DEFAULT NULL,
                         `fee` double DEFAULT NULL,
                         `g_name` varchar(255) DEFAULT NULL,
                         `grade` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `FK28f8ba9n0feejnamfay479ae1` (`teacher_id`),
                         CONSTRAINT `FK28f8ba9n0feejnamfay479ae1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `parent` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `address` varchar(255) DEFAULT NULL,
                          `guardian_type` enum('FATHER','GUARDIAN','MOTHER') DEFAULT NULL,
                          `mobile` int DEFAULT NULL,
                          `monthly_avg_income` double DEFAULT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          `nic` varchar(255) DEFAULT NULL,
                          `occupation` varchar(255) DEFAULT NULL,
                          `religion` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `student` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `grade_id` bigint DEFAULT NULL,
                           `address` varchar(255) DEFAULT NULL,
                           `admission_date` date DEFAULT NULL,
                           `birth_date` date DEFAULT NULL,
                           `gender` enum('FEMALE','MALE') DEFAULT NULL,
                           `image_url` varchar(255) DEFAULT NULL,
                           `mobile` int DEFAULT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           `reg_number` varchar(255) DEFAULT NULL,
                           `religion` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FKsah4wuaglr3u0vkmy6s7jhk3l` (`grade_id`),
                           CONSTRAINT `FKsah4wuaglr3u0vkmy6s7jhk3l` FOREIGN KEY (`grade_id`) REFERENCES `class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `attendance` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `student_id` bigint DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FKnq6vm31it076obtjf2qp5coim` (`student_id`),
                              CONSTRAINT `FKnq6vm31it076obtjf2qp5coim` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `student_parent` (
                                  `student_id` bigint NOT NULL,
                                  `parent_id` bigint NOT NULL,
                                  KEY `FK1uqsk99lie7damnsh9osouodd` (`parent_id`),
                                  KEY `FK3nulmrwg4cubngtp7nq5lud86` (`student_id`),
                                  CONSTRAINT `FK1uqsk99lie7damnsh9osouodd` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`id`),
                                  CONSTRAINT `FK3nulmrwg4cubngtp7nq5lud86` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
