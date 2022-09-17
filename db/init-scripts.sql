CREATE TABLE ErgoPrice (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	timestamps TEXT NOT NULL,
	symbol TEXT NOT NULL,
	price DOUBLE NOT NULL
);

CREATE TABLE WhatToMine (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    timestamps TEXT NOT NULL,
	networkHashrate DOUBLE NOT NULL,
	blockReward DOUBLE NOT NULL,
	blockTime DOUBLE NOT NULL
);

CREATE TABLE Miner (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    timestamps TEXT NOT NULL,
	farmRevenue DOUBLE NOT NULL,
	farmCost DOUBLE NOT NULL,
	farmDiff DOUBLE NOT NULL
);