CREATE DATABASE case_study;

USE case_study;

-- Create table "vehicle_type"
CREATE TABLE vehicle_type (
    id INT PRIMARY KEY,
    type_name VARCHAR(255)
);
-- Create table "vehicle" and establish a relationship with "vehicle_type"
CREATE TABLE vehicle (
    id INT PRIMARY KEY,
    vehicle_name VARCHAR(255),
    vehicle_type_id INT,
    transmission VARCHAR(255),
    description LONGTEXT,
    rental_price DECIMAL(10, 2),
    status int,
    FOREIGN KEY (vehicle_type_id) REFERENCES vehicle_type(id)
);
-- Create table "role"
CREATE TABLE role (
    id INT PRIMARY KEY,
    role_name VARCHAR(255)
);
-- Create table "account" and establish relationships with "customer" and "employee"
CREATE TABLE account (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    role_id INT,
    status int,
    FOREIGN KEY (role_id) REFERENCES role(id)
);
-- Create table "customer"
CREATE TABLE customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_card VARCHAR(255),
    driver_license VARCHAR(255),
    verification VARCHAR(255),
    gender VARCHAR(255),
    birthdate DATE,
    image_path VARCHAR(255),
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES account(id)
);
-- Create table "employee"
CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(255),
    salary DECIMAL(10, 2),
    address VARCHAR(255),
    id_card VARCHAR(255),
    gender VARCHAR(255),
    birthdate DATE,
    image_path VARCHAR(255),
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES account(id)
);
-- Create table "tai sán the chap"
CREATE TABLE collateral_assets (
    id INT PRIMARY KEY,
    asset_name VARCHAR(255)
);
-- Create table "chi phi phat sinh"
CREATE TABLE incidental_expenses (
    id INT PRIMARY KEY,
    expense_name VARCHAR(255),
    price DECIMAL(10, 2),
    description TEXT
);
-- Create table "bill" (formerly "invoice") and establish relationships with "incidental_expenses" and "collateral_assets"
CREATE TABLE bill (
    id INT PRIMARY KEY,
    actual_receive_date DATE,
    actual_return_date DATE,
    total_amount DECIMAL(10, 2),
    incidental_expense_id INT,
    collateral_asset_id INT,
    FOREIGN KEY (incidental_expense_id) REFERENCES incidental_expenses(id),
    FOREIGN KEY (collateral_asset_id) REFERENCES collateral_assets(id)
);
-- Create table "rent_type"
CREATE TABLE rent_type (
    id INT PRIMARY KEY,
    type_name VARCHAR(255)
);
-- Create table "rent" and establish relationships with related tables
CREATE TABLE rent (
    id INT PRIMARY KEY,
    receive_date DATE,  -- Renamed from "pickup_date"
    return_date DATE,
    rental_price DECIMAL(10, 2),
    vehicle_id INT,
    customer_id INT,
    employee_id INT,
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);
-- Create table "contract"
CREATE TABLE contract (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rent_id INT,
    rent_type_id INT,
    total_amount DECIMAL(10, 2),
    rental_fee DECIMAL(10, 2),
    insurance_fee DECIMAL(10, 2),
    collateral_asset_id INT,
    receive_address VARCHAR(255),  -- Renamed from "delivery_address"
    contract_creation_date DATE,
    FOREIGN KEY (rent_type_id) REFERENCES rent_type(id),
    FOREIGN KEY (collateral_asset_id) REFERENCES collateral_assets(id),
    FOREIGN KEY (rent_id) REFERENCES rent(id)
);
-- Create table "image" as a multi-valued attribute of the "vehicle" table
CREATE TABLE image (
    id INT PRIMARY KEY,
    vehicle_id INT,
    image_path VARCHAR(255),
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);


INSERT INTO `case_study`.`vehicle_type` (`id`, `type_name`) VALUES ('1', '4 Chỗ (Mini)');
INSERT INTO `case_study`.`vehicle_type` (`id`, `type_name`) VALUES ('2', '4 Chỗ (Sedan)');
INSERT INTO `case_study`.`vehicle_type` (`id`, `type_name`) VALUES ('3', '4 Chỗ (Hatchback)');
INSERT INTO `case_study`.`vehicle_type` (`id`, `type_name`) VALUES ('4', '5 Chỗ (Gầm cao)');
INSERT INTO `case_study`.`vehicle_type` (`id`, `type_name`) VALUES ('5', '7 Chỗ (Gầm cao)');
INSERT INTO `case_study`.`vehicle_type` (`id`, `type_name`) VALUES ('6', '7 Chỗ (Gầm Thấp)');
INSERT INTO `case_study`.`vehicle_type` (`id`, `type_name`) VALUES ('7', 'Bán tải');

INSERT INTO vehicle(id, vehicle_name, vehicle_type_id, transmission, fuel,description, rental_price, status) VALUES				
(1,'Toyota Camry',1, 'Tự động', 60, 'Xe sedan hạng trung', 100,1),				
(2,'Honda CR-V',2, 'Tự động', 80, 'Xe SUV gia đình', 150,1),				
(3,'Ford Focus', 1, 'Số sàn', 55, 'Xe sedan tiết kiệm nhiên liệu', 90,1),				
(4, 'Toyota Sienna', 2, 'Tự động', 75, 'Xe đa dụng 7 chỗ', 160,1),				
(5, 'Chevrolet Silverado',2, 'Tự động', 90, 'Xe bán tải', 120,1),				
(6, 'Volkswagen Golf',1, 'Số sàn', 50, 'Xe hatchback', 80,1),				
(7, 'Honda Civic',1, 'Tự động', 55, 'Xe sedan', 95,1),				
(8, 'Ford Explorer',2, 'Tự động', 70, 'Xe SUV lớn', 180,1),				
(9, 'Nissan Altima',1,'Số sàn', 60, 'Xe sedan tiết kiệm nhiên liệu',90,1),				
(10, 'Jeep Grand Cherokee',2,'Tự động',80,'Xe SUV chất lượng cao',200,1);				

INSERT INTO image (id, vehicle_id, image_path) VALUES										
(1, 1, 'https://cdn.chotot.com/F0rI56fGoV2991KEpNlz8nAib4q96guznHDEYGifSjo/preset:view/plain/741f12265c3862e898ad75b09ab96306-2838866668057288961.jpg'),										
(2, 1, 'https://cdn.chotot.com/PxV2lUMxJmknT5jbmHQhxg-zmNw71QydEJPalqzcbc8/preset:view/plain/ac0fa2bae162200aac2f574793f8cf22-2838866667280711090.jpg'),										
(3, 1, 'https://cdn.chotot.com/pgLSxSllJkcdJvEo7GVHcJA9bxXMODSa1PghbYODVyQ/preset:view/plain/477c304020684440513c8333c9cdae97-2838866668962106741.jpg'),										
(4, 1, 'https://cdn.chotot.com/XzAFGIpNaE-o5i84grCSMOBzcqpexH2F9UXTYBDBjmM/preset:view/plain/8477ef57a62ce5b6d6ea7f6dad801335-2838866667881301295.jpg'),										
(5, 2, 'https://cdn.chotot.com/Gmv6dLO0MYTgZWQ4_QdeVWHygWo0cS2wfLCbDAd3fZA/preset:view/plain/3e49e9ab6da3264409bf8e1391e0edc2-2775654839760811876.jpg'),										
(6, 2, 'https://cdn.chotot.com/uKmEIoXtSGE2pOi5MamjEEh8ghnMq6pMaybf6C8NOeM/preset:view/plain/3e59410ed001d3211c0783955e53eada-2775654839771575263.jpg'),										
(7, 2, 'https://cdn.chotot.com/-6fo59zzHpNA1EPLm1rFO_iKuNPqNVEdgHCfzKrjLDs/preset:view/plain/9df42c45cbc3a488094119bf102f5aaa-2775654839764008896.jpg'),										
(8, 2, 'https://cdn.chotot.com/PHXsNiwNU6lY0lpd4QQGIMuF1R4eLHCkpdqznADth5o/preset:view/plain/3e80e27a6e27f76191c54277d968207e-2775654838214060612.jpg'),										
(9, 3, 'https://cdn.chotot.com/EHBtHdv8dkdY3wsYoO30RDwEFqInsAg8v3dBMnR3HX0/preset:view/plain/3e44f6ebf035837c34fc7922e27dc0ef-2839455116496893131.jpg'),										
(10, 3, 'https://cdn.chotot.com/EwNSKhpo70gO7t5SGqIBTTDbCSVBycru65xrQ2cyAuI/preset:view/plain/635184c638d59a2713d6ca62c59a5a42-2839455117126782626.jpg'),										
(11, 3, 'https://cdn.chotot.com/EYZEtmQ8ZclGnSqdiXNT668X88bZyJGOKB2TWrbjfdQ/preset:view/plain/643b8590c5890237718757707d3c6d46-2839455117110348786.jpg'),										
(12, 3, 'https://cdn.chotot.com/usFuvjDHo1qECpkwpEhfiLZMgc1t6XWx-6gpuBJqYOs/preset:view/plain/132cdbb86fa9878ca0a22676068beca1-2839455118519245418.jpg'),										
(14, 4, 'https://cdn.chotot.com/h9dQk_3AFEX7DK9YJa4a3H93YK8cLeHP72JZzYDl4Ac/preset:view/plain/3ba57b2767cb2ea97fcd95a36f41a975-2814320277627784561.jpg'),										
(15, 4, 'https://cdn.chotot.com/FfHlA6_qH9RyHN-__NYjpuJwuNkonhrxIEP5tNCAodI/preset:view/plain/d376a85f6e5b76a8278387f3d5b2a8bd-2814320278469161133.jpg'),										
(16, 4, 'https://cdn.chotot.com/wJ-jfEDAb-W22R3MnsXuZWSMCE99rT5vm6LVy90YSFo/preset:view/plain/1da734297f06c566017850a6b8d2d4a9-2814320279250418067.jpg'),										
(17, 4, 'https://cdn.chotot.com/Px_1i8Ja0Wpg-MTHEw1PvULq0J7R5HV6-QaSnG1WhTc/preset:view/plain/3e40057a26e8cc76592fd4e9b204d48f-2814320278774279290.jpg'),										
(18, 5, 'https://cdn.chotot.com/xxiuSxS0dPAVSmHubbJfwVkfVPLs2RinJDYJCgPYFJo/preset:view/plain/416b88598486a3ffb6dc059b071468de-2836953204423615378.jpg'),										
(19, 5, 'https://cdn.chotot.com/QYzqs6CguRg2mM9tF8PBpn1Km3XH6ksr_GnT9rp7ePo/preset:view/plain/12cf488605bb483daef7cc068adf3a3d-2836953204525503888.jpg'),										
(20, 5, 'https://cdn.chotot.com/4XW8FzAIKqrjAPdd80kIqpPfNFHlBjVoDEo_Qtw8EgQ/preset:view/plain/d748e110b62c5cea2dddb260eb85040f-2836953204386028424.jpg'),										
(21, 5, 'https://cdn.chotot.com/pqXIs34e44QsNascv1zUZA0UZxmvlWAInZX3TbDb-fM/preset:view/plain/b53feccb48a370deaac1110bdf78e601-2836953204402267478.jpg'),										
(22, 6, 'https://cdn.chotot.com/tHFuUtGWPXoYmluh42d9Icl_U8S1pEzz6838_4rj7lQ/preset:view/plain/b2a0610d683a269f28d72e12f2eab08c-2835117186048276846.jpg'),										
(23, 6, 'https://cdn.chotot.com/dUFt0kqnNT67QwMF_fYJ9bDJ2Oe3eiYajLYlCk2Cd5o/preset:view/plain/bf395b929522f6965187587221b6ee22-2835117183912463130.jpg'),										
(24, 6, 'https://cdn.chotot.com/c_QH5OI7DV3MwuGatSqGk1HJn97_nLJsS_vIOrUXdIc/preset:view/plain/551e786bdaf0bf1585ddf528687df2cf-2835117186798275354.jpg'),										
(25, 6, 'https://cdn.chotot.com/1sKMxrl7iDl4xQK7lEQTfcmv_L_hMtrYzbq88VRUel4/preset:view/plain/13574e1a881f14db565b451d969f820f-2835117185511358173.jpg'),										
(26, 7, 'https://cdn.chotot.com/0FJHOhn2YBJyyL-svC6mdYDXIpuvorEDbeyrh2Wvb4U/preset:view/plain/43f302d1e16986a6d879b60bbc0bfba8-2840300706675292336.jpg'),										
(27, 7, 'https://cdn.chotot.com/WnO02Hvgow0c6y8P-dZEYC6mdNhoJh6cQ9ijMlKbw14/preset:view/plain/852ed46b008ce2b02dc4550c1f1c615d-2840300706784006673.jpg'),										
(28, 7, 'https://cdn.chotot.com/zCYxSz8Y9GXm0WXyuwwXvzRx7xeKHbEhMawGLwaX_9U/preset:view/plain/3990284cdc71f5ff10ca44c6f9d58205-2840300705964360282.jpg'),										
(29, 7, 'https://cdn.chotot.com/WnO02Hvgow0c6y8P-dZEYC6mdNhoJh6cQ9ijMlKbw14/preset:view/plain/852ed46b008ce2b02dc4550c1f1c615d-2840300706784006673.jpg'),										
(30, 8, 'https://cdn.chotot.com/41mBMqSW7tFqpX9XPalsoe9o0Y1h7hPTnGiJ8rPqjP8/preset:view/plain/1c2190d43dbfa0653b3dd22c9e195a7e-2819414393435771204.jpg'),										
(31, 8, 'https://cdn.chotot.com/Z7e6ibxzDQHaXgR1PIOXweNBhwW5trJdEit5qEb8Ug8/preset:view/plain/e6b200a75c803e8536b687e883492e74-2819414416472703445.jpg'),										
(32, 8, 'https://cdn.chotot.com/argYvlby-EdKWRLgxxTF9UUlrt9IvlvxLznKSirgQVc/preset:view/plain/3df3207f5ce49f696327375208efb74c-2819414430413869380.jpg'),										
(33, 8, 'https://cdn.chotot.com/f21nX0J67qtJqv9P-JaUQmBXvF91h4g56g9R1UELGmQ/preset:view/plain/90cc92f81be565686e44180198fcc1d9-2819414423987933508.jpg'),										
(34, 9, 'https://cdn.chotot.com/XYBUGUTtnGScfBgILCG-fp_ZG5yptp_foOd-PuRKsys/preset:view/plain/baf3a5c0ca8af51e3eb580dab052928d-2839736173471927959.jpg'),										
(35, 9, 'https://cdn.chotot.com/DN5ZRqkeN4sgctLjQOVnYQtj14uWX_4NXAJ9RWL-z64/preset:view/plain/391e505161abdaa4559d9d75d70e4486-2839736174615542636.jpg'),										
(36, 9, 'https://cdn.chotot.com/217K2REVSH-eUyQHFGnvAQezJrl2QU_uIgVi9ad1EE4/preset:view/plain/f1bdc456e3c605cb74b91e72cff6e8f9-2839736175033843451.jpg'),										
(37, 9, 'https://cdn.chotot.com/J_k0mBBj83pi4TImJq0v-ia1cOkTpjnP8xcYQSKYQZc/preset:view/plain/2b994db180a545b38a081e146c85b1ce-2839736173463156531.jpg'),										
(38, 10, 'https://cdn.chotot.com/tLE1-zOUuKBQ8Av4VkpmvdlQnMf5iaCp_KGG682mYpM/preset:view/plain/3f587c4e297a5f3a3ceea34976f88ca0-2836117715783853582.jpg'),										
(39, 10, 'https://cdn.chotot.com/W2KOTCB7_cBAB0jEGQmA5QDOpjyFWKTaXYqIRMZFiQc/preset:view/plain/204d6b28678250196ad623ad6f4959cc-2836117715994162362.jpg'),										
(40, 10, 'https://cdn.chotot.com/MruUhR4WCudTeIHn0jyAqnVDgsXeL5jLZlXq0WnuM8A/preset:view/plain/23770dae1f15e16ae31945050495a90e-2836117717319226629.jpg'),										
(41, 10, 'https://cdn.chotot.com/9lSZE2plfkzLSBJGnXBFGpt47pLinnH0g2V3r-C9Rg0/preset:view/plain/898030f5945c5fdd67952f7da7746c7d-2836117715532980319.jpg');										


ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';

