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

-- Create table "rent" and establish relationships with related tables
CREATE TABLE rent (
    id INT PRIMARY KEY,
    receive_date DATE,  -- Renamed from "pickup_date"
    return_date DATE,
    rental_price DECIMAL(10, 2),
    vehicle_id INT,
    customer_id INT,
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
-- Create table "contract"
CREATE TABLE contract (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rent_id INT,
    total_amount DECIMAL(10, 2),
    rental_fee DECIMAL(10, 2),
    insurance_fee DECIMAL(10, 2),
    collateral_asset_id INT,
    receive_address VARCHAR(255),  -- Renamed from "delivery_address"
    contract_creation_date DATE,
    FOREIGN KEY (collateral_asset_id) REFERENCES collateral_assets(id),
    FOREIGN KEY (rent_id) REFERENCES rent(id),
     employee_id INT,
     FOREIGN KEY (employee_id) REFERENCES employee(id)
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

INSERT INTO vehicle(id,vehicle_name,vehicle_type_id, transmission,fuel, description,rental_price,status) VALUES
(1,'TOYOTA VELOZ CROSS 2022',5,'Số tự động','Xăng','Xe toyota veloz cross xe moi 2022', 100,1),
(2,'TOYOTA CAMRY 2018',2,'Số tự động','Xăng','Toyota Camry số tự động đăng ký năm 2018',150,1),
(3,'MITSUBISHI XPANDER 2019',5,'Số tự động','Xăng','Mitshubishi Xpander đăng kí cuối 2019',90,1),
(4,'MORRIS GARAGES MG5 LUXURY 2022',2,'Số Tự động','Xăng','MORRIS GARAGES MG5 LUXURY 2022', 160,1),
(5,'MITSUBISHI XPANDER 2022',5,'Số Tự động','Xăng','MITSUBISHI XPANDER 2022', 120,1),
(6,'MITSUBISHI XPANDER 2019',5,'Số sàn','Xăng','Xe nhà, sạch sẽ, đời mới, có bảo hiểm đầy đủ.',80,1),
(7,'PEUGEOT 5008 2018',5, 'Số Tự động','Xăng','Peugeot 5008 số tự động đăng kí 2019',95,1),
(8, 'VINFAST LUX SA 2.0 2022',5,'Số Tự động','Xăng','VINFAST LUX SA 2.0 2022',180,1),
(9, 'MITSUBISHI XPANDER 2020',5,'Số Tự động','Xăng','MITSUBISHI XPANDER 2020',90,1),
(10, 'TOYOTA FORTUNER 2012',5,'Số Tự động','Xăng','Xe gia đình, cần cho nguoi thuê cẩn thận, kỹ lưỡng',200,1),
(11, 'MINI COOPER',1,'Số Tự động','Xăng','Mẫu xe Mini Cooper luôn nổi tiếng với thiết kế thú vị',200,0),
(12, 'MAZDA MAZDA 2',1,'Số Tự động','Xăng','Mazda2 có thiết kế hấp dẫn và khả năng vận hành tốt',200,0),
(13, 'KIA K5 2022',2,'Số Tự động','Xăng','KIA K5 Trùm phân khúc sedan hạng D',200,0),
(14, 'KIA MORNING 2017',1,'Số sàn','Xăng',' không gian nội thất linh hoạt và tiết kiệm nhiên liệu.',200,0),
(15, 'TOYOTA YARIS',1,'Số Tự động','Xăng','Một chiếc xe nhỏ nhẹ và tiết kiệm nhiên liệu từ Toyota.',200,0),
(16, 'FORD WILDTRAK WILDTRAK',7,'Số Tự động','Xăng','mang đến cho bạn trải nghiệm lái xe thoải mái',200,0),
(17, 'HYUNDAI ACCENT 1.4AT',1,'Số Tự động','Xăng','một lựa chọn giá trị với nhiều tính năng tiện ích.',200,0),
(18, 'PORSCHE MACAN 2016',1,'Số Tự động','Xăng','PORSCHE MACAN 2016',200,0),
(19, 'KIA RIO 2014',1,'Số Tự động','Xăng',' Kia Rio cung cấp sự thoải mái và tiện nghi trong một gói giá trị.',200,0),
(20, 'PEUGEOT 2008',1,'Số Tự động','Xăng','PEUGEOT THƯƠNG HIỆU XE CHÂU ÂU',200,0),
(21, 'HYUNDAI ACCENT 2021',3,'Số Tự động','Xăng','Hyundai Accent 2021',200,0),
(22, 'MAZDA MAZDA 3 2019',3,'Số Tự động','Xăng','Mazda Mazda 3',200,0),
(23, 'SUZUKI SWIFT 2015 ',3,'Số Tự động','Xăng','Suzuki Swift 2015 Số tự động màu Trắng',200,0),
(24, 'VOLVO XC60 T6AWD',3,'Số Tự động','Xăng','Volvo XC60 T6AWD Model 2021',200,0),
(25, 'MERCEDES GLC300 4MATIC',3,'Số Tự động','Xăng','Mercedes_GLC300_4MATIC Model_2020',200,0),
(26, 'HONDA JAZZ RS 1.5',3,'Số Tự động','Xăng','2019 Honda Jazz RS 1.5',200,0),
(27, 'KIA CARNIVAL SIGNATURE',4,'Số Tự động','Dầu','Kia Carnival Signature',200,0),
(28, 'KIA CARNIVAL',4,'Số Tự động','Dầu','Kia Carnival 2.2 Signature',200,0),
(29, 'KIA CARNIVAL',4,'Số Tự động','Dầu','Kia Carnival Signature 2.2D cao cấp',200,0),
(30, 'KIA LUXURY DATH ',4,'Số Tự động','Dầu','2019 KIA Sedona LUXURY DATH D 2.2',200,0);

INSERT INTO image (id,vehicle_id, image_path) VALUES
(1, 1, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_veloz_cross_2022/p/g/2023/02/14/15/gZBVOUPBWhNE8dsL0C_3SA.jpg'),
(2, 1, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_veloz_cross_2022/p/g/2023/02/14/15/4iz300-Bam8UfjxmkzenNw.jpg'),
(3, 1, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_veloz_cross_2022/p/g/2023/02/14/15/7EUb9ysYW9NNtLFYaUxbEg.jpg'),
(4, 1, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_veloz_cross_2022/p/g/2023/02/14/15/9DMZld-QqBJAduyTZ8nYrg.jpg'),
(5, 2, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_camry_2018/p/g/2023/03/14/11/F72O5TBCzqnMteEIOqQaYg.jpg'),
(6, 2, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_camry_2018/p/g/2023/03/14/11/5PKfAT82yPPJQ8UPq_OuOA.jpg'),
(7, 2, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_camry_2018/p/g/2023/03/14/11/G5Q5a1VVCoGrjAc9ntH_9A.jpg'),
(8, 2, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_camry_2018/p/g/2023/03/14/11/QysPqO12SJzXFP3_zFc8hA.jpg'),
(9, 3, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2019/p/g/2023/02/14/11/xnb3uNgn3T5VoP0dCsk6eQ.jpg'),
(10, 3, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2019/p/g/2023/02/14/11/dGOYIqp2IcPrPUYXY_Lqeg.jpg'),
(11, 3, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2019/p/g/2023/02/03/16/RBkZHUjC97pbIA1RVmJr7g.jpg'),
(12, 3, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2019/p/g/2023/02/03/17/j2ePdyRWLYpYVW-chi55tw.jpg'),
(14, 4, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/morris_garages_mg5_luxury_2022/p/g/2023/03/14/12/04GJRAKmsKWpojfqm3wesw.jpg'),
(15, 4, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/morris_garages_mg5_luxury_2022/p/g/2023/03/14/13/c9mI7ylwgFk8uCpLfzziDg.jpg'),
(16, 4, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/morris_garages_mg5_luxury_2022/p/g/2023/03/14/12/O2K0B2AzL8idHl3LbspO0g.jpg'),
(17, 4, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/morris_garages_mg5_luxury_2022/p/g/2023/03/14/13/by3jtF-tchYqP3pRhRxumA.jpg'),
(18, 5, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2022/p/g/2023/03/18/10/BLzXoM69m5Ul6KrbjvlM6w.jpg'),
(19, 5, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2022/p/g/2023/03/18/10/m6cOIn63ySXXrcXqD48K1g.jpg'),
(20, 5, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2022/p/g/2023/03/18/10/U9CGZAGMMA900X9D2GS3kA.jpg'),
(21, 5, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2022/p/g/2023/03/18/10/9aF7Ibj0RDReqwB_LO7ZvQ.jpg'),
(22, 6, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2019/p/g/2023/06/20/15/HudPrDACLnE2C2zIzSeMLg.jpg'),
(23, 6, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2019/p/g/2023/06/20/15/P0IVUZ7xrFNr27hkXrDY-g.jpg'),
(24, 6, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2019/p/g/2023/06/20/15/KKILaX5iX0uZ2BPtTA2TfA.jpg'),
(25, 6, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2019/p/g/2023/06/20/15/REp243mohNv6aCnp4rUXtA.jpg'),
(26, 7, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/peugeot_5008_2018/p/g/2023/06/28/12/VjtSHIhrL57mezmLE3XVwA.jpg'),
(27, 7, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/peugeot_5008_2018/p/g/2023/06/28/12/m8nOZnpiXzyxBsVlVEM3Jg.jpg'),
(28, 7, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/peugeot_5008_2018/p/g/2023/06/28/12/_QO2MvlW0_-DWpDB-Riq4g.jpg'),
(29, 7, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/peugeot_5008_2018/p/g/2023/06/28/12/m8nOZnpiXzyxBsVlVEM3Jg.jpg'),
(30, 8, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/vinfast_lux_sa_2.0_2022/p/g/2023/04/11/11/YTAbvv0wBrLQbA-f3wbqxQ.jpg'),
(31, 8, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/vinfast_lux_sa_2.0_2022/p/g/2023/04/11/11/HttF02gqQGgBI8QJJT941Q.jpg'),
(32, 8, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/vinfast_lux_sa_2.0_2022/p/g/2023/04/11/11/408HQ_S7Qvq7OrYtTV582w.jpg'),
(33, 8, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/vinfast_lux_sa_2.0_2022/p/g/2023/04/11/11/eOzJynJLlVLSxFnl5Y5tLw.jpg'),
(34, 9, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2020/p/g/2023/02/26/00/ZK6_YscjrB2vCnKrE_A30Q.jpg'),
(35, 9, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2020/p/g/2023/02/26/00/P2Yd2PysBKTErUjGGdp23A.jpg'),
(36, 9, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2020/p/g/2023/02/26/00/GQZ4fHzN5CN7aPnru_oWCw.jpg'),
(37, 9, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/mitsubishi_xpander_2020/p/g/2022/09/15/13/P7Ew5WEe4EOlQfqXDD50tg.jpg'),
(38, 10, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_fortuner_2012/p/g/2023/06/12/09/aRJyqfZUuly9gsnx01PNBw.jpg'),
(39, 10, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_fortuner_2012/p/g/2023/06/12/09/HYRsdC9J6KHMZGu3DJMCnQ.jpg'),
(40, 10, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_fortuner_2012/p/g/2023/06/12/09/kYFypX787tOUIXtEYdMNtA.jpg'),
(41, 10, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/toyota_fortuner_2012/p/g/2023/06/12/09/kYFypX787tOUIXtEYdMNtA.jpg'),
(42, 11, 'https://cdn.chotot.com/aNsnEXDOlS0hU74FCw3wz6Ri8JuXmSDkEdQZsG7e7NM/preset:view/plain/b286c6b5bbe15f6e34e5f12b34995397-2832760383643298242.jpg'),
(43, 11, 'https://cdn.chotot.com/NNejxwP8s2EhE2hBmtITFKfjY5LE4wlGxDcNjvvXvvI/preset:view/plain/ec3aa714509e529194f0d2d773aad24b-2832760383665796246.jpg'),
(44, 11, 'https://cdn.chotot.com/4p8MANomwFvHoM3YW2uRXHvPfjzUpzXvV3cLcvTI_bk/preset:view/plain/431cac7ae216070bc21b07c3db291a83-2832760383688616438.jpg'),
(45, 11, 'https://cdn.chotot.com/HvLzr8B2bbeixzNLGdIjENbkWSVtv6x2suVVCRVk6aU/preset:view/plain/66708cbefe9078da61637b9264ebaef2-2832760383792124606.jpg'),
(46, 12, 'https://static.carmudi.vn/carmudi_v3/storage/13033/64dca04b4853d_e97df508de030c5d5512523.jpg'),
(47, 12, 'https://static.carmudi.vn/carmudi_v3/storage/13013/64dca04370160_3c6e9b58b053620d3b42522.jpg'),
(48, 12, 'https://static.carmudi.vn/carmudi_v3/storage/13014/64dca0447123b_6d710334283ffa61a32e529.jpg'),
(49, 12, 'https://static.carmudi.vn/carmudi_v3/storage/13012/64dca04368221_3d825bcb70c0a29efbd1533.jpg'),
(50, 13, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/kia_k5_2022/p/g/2023/01/21/11/VeKTHV2oBC9RPBMti1QP_w.jpg'),
(51, 13, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/kia_k5_2022/p/g/2022/11/25/18/Q4ssB-nacS0T28R5R8r4bw.jpg'),
(52, 13, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/kia_k5_2022/p/g/2022/11/25/18/t7455LBpxjKsTVFJLWDg_g.jpg'),
(53, 13, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/kia_k5_2022/p/g/2022/11/25/18/itZo0TMU235B0MzLfBrxLQ.jpg'),
(54, 14, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/kia_morning_2017/p/g/2023/02/14/11/8WcRQtQB6Eqd60lcj4PDZQ.jpg'),
(55, 14, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/kia_morning_2017/p/g/2023/02/14/11/dvar1MQFm4YB5TVOmcdvsA.jpg'),
(56, 14, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/kia_morning_2017/p/g/2023/02/14/11/OXG--84e--B3_65C6HzcXQ.jpg'),
(57, 14, 'https://n1-pstg.mioto.vn/cho_thue_xe_o_to_tu_lai_thue_xe_du_lich_hochiminh/kia_morning_2017/p/g/2023/02/14/11/4XmGxJAPqMeMddRZR-R78Q.jpg'),
(58, 15, 'https://static.carmudi.vn/carmudi_v3/storage/14699/64e41cffd601f_7db7acd010df4318eaa4ca87ead735a9.jpeg'),
(59, 15, 'https://static.carmudi.vn/carmudi_v3/storage/14700/64e41d0197e6c_4e4d6f6f44cd92259cbe8d67551e4e23.jpeg'),
(60, 15, 'https://static.carmudi.vn/carmudi_v3/storage/14701/conversions/64e41d0307672_9ae1319d13684fdc00ec303bde42f583-350_212.jpg'),
(61, 15, 'https://static.carmudi.vn/carmudi_v3/storage/14711/conversions/64e41d125e375_4768edf843657e463a48ab602c05a462-350_212.jpg'),
(62, 16, 'https://static.carmudi.vn/carmudi_v3/storage/14687/64e41b062c55c_f300eeaa2f4713e004378c55d099ddca.jpeg'),
(63, 16, 'https://static.carmudi.vn/carmudi_v3/storage/14688/conversions/64e41b0835e03_388ce5f40b52c3c83e10f8ca9f6db5bd-350_212.jpg'),
(64, 16, 'https://static.carmudi.vn/carmudi_v3/storage/14690/conversions/64e41b0c05dba_a5ab2b3af352ab8abb5a54c5a4920a97-350_212.jpg'),
(65, 16, 'https://static.carmudi.vn/carmudi_v3/storage/14689/64e41b0a23ccd_dfcb513a53866aa7e74e3ea48597a4ff.jpeg'),
(66, 17, 'https://static.carmudi.vn/carmudi_v3/storage/14384/64e0d38c584c3_6332fc8980be52e00baf.jpg'),
(67, 17, 'https://static.carmudi.vn/carmudi_v3/storage/14385/64e0d38c69494_3d7ca9c7d5f007ae5ee1.jpg'),
(68, 17, 'https://static.carmudi.vn/carmudi_v3/storage/14386/64e0d38e025ef_cfad4c163021e27fbb30.jpg'),
(69, 17, 'https://static.carmudi.vn/carmudi_v3/storage/14387/64e0d38e0dd7a_f5109ba1e79635c86c87.jpg'),
(70, 18, 'https://static.carmudi.vn/carmudi_v3/storage/10954/64d5e1f2aa229_9214871dfa4e2810715f90.jpg'),
(71, 18, 'https://static.carmudi.vn/carmudi_v3/storage/10945/64d5e1ea598a6_3b736d78102bc2759b3a88.jpg'),
(72, 18, 'https://static.carmudi.vn/carmudi_v3/storage/10958/64d5e1f62e5c7_bae8d2e3afb07dee24a194.jpg'),
(73, 18, 'https://static.carmudi.vn/carmudi_v3/storage/10949/64d5e1eddc45d_93b1b8b5c5e617b84ef797.jpg'),
(74, 19, 'https://static.carmudi.vn/carmudi_v3/storage/13533/64dd9f3279630_e890054d0845da1b835463.jpg'),
(75, 19, 'https://static.carmudi.vn/carmudi_v3/storage/13525/64dd9f2f489cf_19cf62e96fe1bdbfe4f068.jpg'),
(76, 19, 'https://static.carmudi.vn/carmudi_v3/storage/13536/64dd9f34c5b7e_fcd71315191dcb43920c.jpg'),
(77, 19, 'https://static.carmudi.vn/carmudi_v3/storage/13529/64dd9f30e0549_8357ff71f2792027796864.jpg'),
(78, 20, 'https://static.carmudi.vn/carmudi_v3/storage/4393/64a54fdd65459_4116a98d7ea3aefdf7b2283.jpg'),
(79, 20, 'https://static.carmudi.vn/carmudi_v3/storage/4395/64a54fdec847f_b37ec2fc15d2c58c9cc3281.jpg'),
(80, 20, 'https://static.carmudi.vn/carmudi_v3/storage/4391/64a54fdc12b50_5fb78fed5bc38b9dd2d2278.jpg'),
(81, 20, 'https://static.carmudi.vn/carmudi_v3/storage/4396/64a54fe0303ee_ccaae90e3e20ee7eb731284.jpg'),
(121, 21, 'https://static.carmudi.vn/carmudi_v3/storage/12851/64dc94d63951e_3f6207b19dba4fe416ab365.jpg'),
(82, 21, 'https://static.carmudi.vn/carmudi_v3/storage/12850/64dc94d63921a_2f8b135889535b0d0242369.jpg'),
(83, 21, 'https://static.carmudi.vn/carmudi_v3/storage/12852/64dc94d6ce6d1_4bf5adc837c3e59dbcd2385.jpg'),
(84, 21, 'https://static.carmudi.vn/carmudi_v3/storage/12858/64dc94d90ef3f_1213f92e6325b17be834384.jpg'),
(85, 22, 'https://static.carmudi.vn/carmudi_v3/storage/13817/64dde45150b35_73a7b9d5d3cc019258dd.jpg'),
(86, 22, 'https://static.carmudi.vn/carmudi_v3/storage/13815/64dde4508424b_4f33d13cbb25697b3034.jpg'),
(87, 22, 'https://static.carmudi.vn/carmudi_v3/storage/13816/64dde4508a949_fb6703616978bb26e269.jpg'),
(88, 22, 'https://static.carmudi.vn/carmudi_v3/storage/13819/64dde4523b49e_34291c54764da413fd5c.jpg'),
(89, 23, 'https://static.carmudi.vn/carmudi_v3/storage/12832/64dc93db8523b_2cc0ff2f5a24887ad135345.jpg'),
(90, 23, 'https://static.carmudi.vn/carmudi_v3/storage/12838/64dc93ddcabf0_327af1ad54a686f8dfb7346.jpg'),
(91, 23, 'https://static.carmudi.vn/carmudi_v3/storage/12833/64dc93db89fe9_0cfbcb2c6e27bc79e536347.jpg'),
(92, 23, 'https://static.carmudi.vn/carmudi_v3/storage/12846/64dc93e0818bb_dcef7230d73b05655c2a351.jpg'),
(93, 24, 'https://static.carmudi.vn/carmudi_v3/storage/7830/64ba015b5b83e_15d2659327f7f4a9ade652.jpg'),
(94, 24, 'https://static.carmudi.vn/carmudi_v3/storage/7835/64ba015f99efd_531d45120776d4288d6766.jpg'),
(95, 24, 'https://static.carmudi.vn/carmudi_v3/storage/7834/64ba015e5fbd4_98c89156d332006c592358.jpg'),
(96, 24, 'https://static.carmudi.vn/carmudi_v3/storage/7838/64ba016140a3f_ad1f8d5acf3e1c60452f56.jpg'),
(97, 25, 'https://static.carmudi.vn/carmudi_v3/storage/7783/64b9fcfa196f4_ea9c25b8cbe518bb41f42.jpg'),
(98, 25, 'https://static.carmudi.vn/carmudi_v3/storage/7775/64b9fce63741d_8e07f71d1940ca1e93513.jpg'),
(99, 25, 'https://static.carmudi.vn/carmudi_v3/storage/7782/64b9fcf9b6811_e65ea74449199a47c3086.jpg'),
(100, 25, 'https://static.carmudi.vn/carmudi_v3/storage/7776/64b9fce905c16_28a76cbd82e051be08f11.jpg'),
(101, 26, 'https://static.carmudi.vn/carmudi_v3/storage/14/4d8006e31e7cc6229f6d68.jpg'),
(102, 26, 'https://static.carmudi.vn/carmudi_v3/storage/14/f373c717df8807d65e9967.jpg'),
(103, 26, 'https://static.carmudi.vn/carmudi_v3/storage/14/ac07016c19f3c1ad98e264.jpg'),
(104, 26, 'https://static.carmudi.vn/carmudi_v3/storage/14/a444f70aef9537cb6e8458.jpg'),
(105, 27, 'https://static.carmudi.vn/carmudi_v3/storage/14003/64de3a2b83e50_1ef0e0dbc3c2119c48d3.jpg'),
(106, 27, 'https://static.carmudi.vn/carmudi_v3/storage/14002/64de3a2b37801_20e5bac499dd4b8312cc.jpg'),
(107, 27, 'https://static.carmudi.vn/carmudi_v3/storage/14001/64de3a2a0244c_e5559a6cb9756b2b3264.jpg'),
(108, 27, 'https://static.carmudi.vn/carmudi_v3/storage/14000/64de3a29f378b_714c1475376ce532bc7d.jpg'),
(109, 28, 'https://static.carmudi.vn/carmudi_v3/storage/10978/64d5e6e7b7e88_87c1a510f5a126ff7fb0120.jpg'),
(110, 28, 'https://static.carmudi.vn/carmudi_v3/storage/10987/64d5e6eed1fdd_a69c5c4d0cfcdfa286ed116.jpg'),
(111, 28, 'https://static.carmudi.vn/carmudi_v3/storage/10974/64d5e6e45007a_3c3dfcedac5c7f02264d121.jpg'),
(112, 28, 'https://static.carmudi.vn/carmudi_v3/storage/10972/64d5e6e284abc_2bfc062d569c85c2dc8d117.jpg'),
(113, 29, 'https://static.carmudi.vn/carmudi_v3/storage/13232/64dce10176979_c193eca44eb59cebc5a4.jpg'),
(114, 29, 'https://static.carmudi.vn/carmudi_v3/storage/13233/64dce1029aca0_4f706c47ce561c084547.jpg'),
(115, 29, 'https://static.carmudi.vn/carmudi_v3/storage/13231/64dce101663f5_fb09bfc81dd9cf8796c8.jpg'),
(116, 29, 'https://static.carmudi.vn/carmudi_v3/storage/13234/64dce1029f40c_4610163eb42f66713f3e.jpg'),
(117, 30, 'https://static.carmudi.vn/carmudi_v3/storage/9977/64ccfe611407b_d67db585e505365b6f14.jpg'),
(118, 30, 'https://static.carmudi.vn/carmudi_v3/storage/9978/64ccfe6232770_65f1440e148ec7d09e9f.jpg'),
(119, 30, 'https://static.carmudi.vn/carmudi_v3/storage/9979/64ccfe62370ad_2a5b004450c4839adad5.jpg'),
(120, 30, 'https://static.carmudi.vn/carmudi_v3/storage/9976/64ccfe610f676_4095156445e496bacff5.jpg');