CREATE DATABASE case_study;

USE case_study;

-- Create table "vehicle_type"
CREATE TABLE vehicle_type (
    vehicle_type_id INT PRIMARY KEY,
    type_name VARCHAR(255)
);
-- Create table "vehicle" and establish a relationship with "vehicle_type"
CREATE TABLE vehicle (
    vehicle_id INT PRIMARY KEY,
    vehicle_name VARCHAR(255),
    vehicle_type_id INT,
    transmission VARCHAR(255),
    description LONGTEXT,
    rental_price DECIMAL(10, 2),
    status int,
    FOREIGN KEY (vehicle_type_id) REFERENCES vehicle_type(vehicle_type_id)
);
-- Create table "role"
CREATE TABLE role (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(255)
);
-- Create table "account" and establish relationships with "customer" and "employee"
CREATE TABLE account (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    role_id INT,
    status int,
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);
-- Create table "customer"
CREATE TABLE customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    id_card VARCHAR(255),
    driver_license VARCHAR(255),
    verification VARCHAR(255),
    gender VARCHAR(255),
    birthdate DATE,
    image_path VARCHAR(255),
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);
-- Create table "employee"
CREATE TABLE employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(255),
    salary DECIMAL(10, 2),
    address VARCHAR(255),
    id_card VARCHAR(255),
    gender VARCHAR(255),
    birthdate DATE,
    image_path VARCHAR(255),
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);
-- Create table "collateral_assets"
CREATE TABLE collateral_assets (
    collateral_asset_id INT PRIMARY KEY,
    asset_name VARCHAR(255)
);
-- Create table "incidental_expenses"
CREATE TABLE incidental_expenses (
    incidental_expense_id INT PRIMARY KEY,
    expense_name VARCHAR(255),
    price DECIMAL(10, 2),
    description TEXT
);
-- Create table "bill" (formerly "invoice") and establish relationships with "incidental_expenses" and "collateral_assets"
CREATE TABLE bill (
    bill_id INT PRIMARY KEY,
    actual_receive_date DATE,
    actual_return_date DATE,
    total_amount DECIMAL(10, 2),
    incidental_expense_id INT,
    collateral_asset_id INT,
    FOREIGN KEY (incidental_expense_id) REFERENCES incidental_expenses(incidental_expense_id),
    FOREIGN KEY (collateral_asset_id) REFERENCES collateral_assets(collateral_asset_id)
);
-- Create table "rent_type"
CREATE TABLE rent_type (
    rent_type_id INT PRIMARY KEY,
    type_name VARCHAR(255)
);
-- Create table "rent" and establish relationships with related tables
CREATE TABLE rent (
    rent_id INT PRIMARY KEY,
    receive_date DATE,  -- Renamed from "pickup_date"
    return_date DATE,
    rental_price DECIMAL(10, 2),
    vehicle_id INT,
    customer_id INT,
    employee_id INT,
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);
-- Create table "contract"
CREATE TABLE contract (
    contract_id INT PRIMARY KEY AUTO_INCREMENT,
    rent_id INT,
    rent_type_id INT,
    total_amount DECIMAL(10, 2),
    rental_fee DECIMAL(10, 2),
    insurance_fee DECIMAL(10, 2),
    collateral_asset_id INT,
    receive_address VARCHAR(255),  -- Renamed from "delivery_address"
    contract_creation_date DATE,
    FOREIGN KEY (rent_type_id) REFERENCES rent_type(rent_type_id),
    FOREIGN KEY (collateral_asset_id) REFERENCES collateral_assets(collateral_asset_id),
    FOREIGN KEY (rent_id) REFERENCES rent(rent_id)
);
-- Create table "image" as a multi-valued attribute of the "vehicle" table
CREATE TABLE image (
    image_id INT PRIMARY KEY,
    vehicle_id INT,
    image_path VARCHAR(255),
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id)
);


INSERT INTO `case_study`.`vehicle_type` (`vehicle_type_id`, `type_name`) VALUES ('1', '4 Chỗ (Mini)');
INSERT INTO `case_study`.`vehicle_type` (`vehicle_type_id`, `type_name`) VALUES ('2', '4 Chỗ (Sedan)');
INSERT INTO `case_study`.`vehicle_type` (`vehicle_type_id`, `type_name`) VALUES ('3', '4 Chỗ (Hatchback)');
INSERT INTO `case_study`.`vehicle_type` (`vehicle_type_id`, `type_name`) VALUES ('4', '5 Chỗ (Gầm cao)');
INSERT INTO `case_study`.`vehicle_type` (`vehicle_type_id`, `type_name`) VALUES ('5', '7 Chỗ (Gầm cao)');
INSERT INTO `case_study`.`vehicle_type` (`vehicle_type_id`, `type_name`) VALUES ('6', '7 Chỗ (Gầm Thấp)');
INSERT INTO `case_study`.`vehicle_type` (`vehicle_type_id`, `type_name`) VALUES ('7', 'Bán tải');
