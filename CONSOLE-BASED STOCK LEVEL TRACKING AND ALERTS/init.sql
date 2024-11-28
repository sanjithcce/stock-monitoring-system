CREATE DATABASE stock_app;
USE stock_app;
-- Create table for Suppliers
CREATE TABLE Supplier (
    supplierId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contactName VARCHAR(100),
    contactPhone VARCHAR(15),
    contactEmail VARCHAR(100),
    address VARCHAR(255),
    startShift TIMESTAMP,
    endShift TIMESTAMP,
    supplierType VARCHAR(20),
    username VARCHAR(100),
    password VARCHAR(100) DEFAULT 'SUPPLIER@123'
);

-- Create table for Customers
CREATE TABLE Customer (
    customerId VARCHAR(12) PRIMARY KEY,
    supplierId INT NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50),
    phoneNumber VARCHAR(15),
    email VARCHAR(100),
    totalAmountSpent BIGINT DEFAULT 0,
    address VARCHAR(255),
    guardianName VARCHAR(50),
    guardianPhoneNumber VARCHAR(15),
    password VARCHAR(100),
    FOREIGN KEY (supplierId) REFERENCES Supplier(supplierId)
);

-- Create table for Stock Items
CREATE TABLE StockItem (
    itemId INT AUTO_INCREMENT PRIMARY KEY,
    customerId VARCHAR(12),
    itemCode VARCHAR(50) UNIQUE NOT NULL,
    itemType VARCHAR(20),
    quantityInStock INT DEFAULT 0,
    pricePerUnit NUMERIC(10, 2) DEFAULT 0,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId)
);

-- Create table for Transactions
CREATE TABLE StockTransaction (
    transactionId VARCHAR(50) PRIMARY KEY,
    transferredQuantity INT NOT NULL,
    transactionDoneAt TIMESTAMP NOT NULL,
    fromItemId INT NOT NULL,
    toItemId INT NOT NULL,
    FOREIGN KEY (fromItemId) REFERENCES StockItem(itemId),
    FOREIGN KEY (toItemId) REFERENCES StockItem(itemId)
);
