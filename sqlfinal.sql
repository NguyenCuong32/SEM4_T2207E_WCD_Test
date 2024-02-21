CREATE TABLE `employee` (
	`employeeId` varchar(20) NOT NULL,
	`employeeName` varchar(64) NOT NULL,
	`birthday` DATETIME NOT NULL,
	`phoneNumber` varchar(11) NOT NULL,
	`email` varchar(255) NOT NULL,
	PRIMARY KEY (`employeeId`)
);


