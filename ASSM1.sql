create database Java5PlaySport
use Java5PlaySport
CREATE TABLE Categories (
    Id CHAR(4) PRIMARY KEY,
    Name NVARCHAR(50)
);

CREATE TABLE Products (
    Id INT IDENTITY PRIMARY KEY,
    Name NVARCHAR(100),
    Image NVARCHAR(100),
    Price FLOAT,
    CreateDate DATE,
    Available BIT,
    CategoryId CHAR(4),
    Description NVARCHAR(500),
    FOREIGN KEY (CategoryId) REFERENCES Categories(Id)
);

CREATE TABLE Accounts (
    Username VARCHAR(30) PRIMARY KEY,
    Password VARCHAR(100),
    Fullname NVARCHAR(50),
    Email VARCHAR(100),
    Photo VARCHAR(100),
    Activated BIT,
    Admin BIT
);

CREATE TABLE Orders (
    Id INT IDENTITY PRIMARY KEY,
    Username VARCHAR(30),
    CreateDate DATE,
    Address NVARCHAR(100),
    FOREIGN KEY (Username) REFERENCES Accounts(Username)
);

CREATE TABLE OrderDetails (
    Id INT IDENTITY PRIMARY KEY,
    OrderId INT,
    ProductId INT,
    Price FLOAT,
    Quantity INT,
    FOREIGN KEY (OrderId) REFERENCES Orders(Id),
    FOREIGN KEY (ProductId) REFERENCES Products(Id)
);
INSERT INTO Categories VALUES
('C001', N'Giày chạy bộ'),
('C002', N'Giày đá bóng'),
('C003', N'Giày tập gym'),
('C004', N'Áo thể thao'),
('C005', N'Quần thể thao'),
('C006', N'Áo khoác thể thao'),
('C007', N'Bộ đồ thể thao'),
('C008', N'Tất thể thao'),
('C009', N'Balo – túi thể thao'),
('C010', N'Phụ kiện thể thao');

INSERT INTO Products (Name, Image, Price, CreateDate, Available, CategoryId, Description) VALUES
(N'Nike Air Zoom Pegasus 40', 'https://res.cloudinary.com/pnam233/image/upload/product/c001_1.jpg', 2500000, '2025-01-01', 1, 'C001', N'Giày chạy bộ êm nhẹ, đàn hồi tốt, phù hợp chạy đường dài'),
(N'Adidas Ultraboost Light', 'https://res.cloudinary.com/pnam233/image/upload/product/c001_2.jpg', 3200000, '2025-01-01', 1, 'C001', N'Đế Boost hoàn trả năng lượng cao, ôm chân'),
(N'Asics Gel Nimbus 25', 'https://res.cloudinary.com/pnam233/image/upload/product/c001_3.jpg', 2900000, '2025-01-01', 1, 'C001', N'Đệm Gel giảm chấn tối ưu'),
(N'Nike Revolution 6', 'https://res.cloudinary.com/pnam233/image/upload/product/c001_4.jpg', 1800000, '2025-01-01', 1, 'C001', N'Giày chạy bộ giá tốt cho người mới'),
(N'Adidas Duramo SL', 'https://res.cloudinary.com/pnam233/image/upload/product/c001_5.jpg', 1700000, '2025-01-01', 1, 'C001', N'Nhẹ, thoáng khí'),
(N'Puma Velocity Nitro', 'https://res.cloudinary.com/pnam233/image/upload/product/c001_6.jpg', 2100000, '2025-01-01', 1, 'C001', N'Phù hợp chạy tốc độ'),
(N'Nike Downshifter 12', 'https://res.cloudinary.com/pnam233/image/upload/product/c001_7.jpg', 1600000, '2025-01-01', 1, 'C001', N'Êm ái, bền bỉ'),
(N'Asics Gel Contend', 'https://res.cloudinary.com/pnam233/image/upload/product/c001_8.jpg', 1500000, '2025-01-01', 1, 'C001', N'Ổn định, hỗ trợ tốt'),
(N'Adidas Solar Glide', 'https://res.cloudinary.com/pnam233/image/upload/product/c001_9.jpg', 2700000, '2025-01-01', 1, 'C001', N'Chạy bền chuyên nghiệp'),
(N'Nike Infinity Run', 'https://res.cloudinary.com/pnam233/image/upload/product/c001_10.jpg', 3300000, '2025-01-01', 1, 'C001', N'Giảm chấn thương khi chạy');

INSERT INTO Products VALUES
(N'Nike Mercurial Vapor', 'https://res.cloudinary.com/pnam233/image/upload/product/c002_1.jpg', 3500000, '2025-01-01', 1, 'C002', N'Giày đá bóng tốc độ, ôm chân'),
(N'Adidas Predator', 'https://res.cloudinary.com/pnam233/image/upload/product/c002_2.jpg', 3400000, '2025-01-01', 1, 'C002', N'Kiểm soát bóng tối ưu'),
(N'Puma Future Z', 'https://res.cloudinary.com/pnam233/image/upload/product/c002_3.jpg', 3100000, '2025-01-01', 1, 'C002', N'Linh hoạt, thoải mái'),
(N'Nike Tiempo Legend', 'https://res.cloudinary.com/pnam233/image/upload/product/c002_4.jpg', 3300000, '2025-01-01', 1, 'C002', N'Da thật cao cấp'),
(N'Adidas X Speedportal', 'https://res.cloudinary.com/pnam233/image/upload/product/c002_5.jpg', 3600000, '2025-01-01', 1, 'C002', N'Tăng tốc vượt trội'),
(N'Mizuno Morelia', 'https://res.cloudinary.com/pnam233/image/upload/product/c002_6.jpg', 4200000, '2025-01-01', 1, 'C002', N'Da kangaroo mềm'),
(N'Nike Phantom GX', 'https://res.cloudinary.com/pnam233/image/upload/product/c002_7.jpg', 3700000, '2025-01-01', 1, 'C002', N'Kiểm soát bóng chính xác'),
(N'Adidas Copa Sense', 'https://res.cloudinary.com/pnam233/image/upload/product/c002_8.jpg', 3200000, '2025-01-01', 1, 'C002', N'Thoải mái khi thi đấu'),
(N'Puma Ultra', 'https://res.cloudinary.com/pnam233/image/upload/product/c002_9.jpg', 3000000, '2025-01-01', 1, 'C002', N'Siêu nhẹ'),
(N'Nike Vapor 15', 'https://res.cloudinary.com/pnam233/image/upload/product/c002_10.jpg', 3800000, '2025-01-01', 1, 'C002', N'Tốc độ chuyên nghiệp');

INSERT INTO Products VALUES
(N'Nike Metcon 9', 'https://res.cloudinary.com/pnam233/image/upload/product/c003_1.jpg', 2800000, '2025-01-01', 1, 'C003', N'Ổn định cho tập gym'),
(N'Adidas Dropset', 'https://res.cloudinary.com/pnam233/image/upload/product/c003_2.jpg', 2600000, '2025-01-01', 1, 'C003', N'Tập tạ chắc chắn'),
(N'Reebok Nano X3', 'https://res.cloudinary.com/pnam233/image/upload/product/c003_3.jpg', 2700000, '2025-01-01', 1, 'C003', N'Đa năng CrossFit'),
(N'Under Armour Tribase', 'https://res.cloudinary.com/pnam233/image/upload/product/c003_4.jpg', 2400000, '2025-01-01', 1, 'C003', N'Bám sàn tốt'),
(N'Nike Free Metcon', 'https://res.cloudinary.com/pnam233/image/upload/product/c003_5.jpg', 2900000, '2025-01-01', 1, 'C003', N'Linh hoạt'),
(N'Adidas Powerlift', 'https://res.cloudinary.com/pnam233/image/upload/product/c003_6.jpg', 2200000, '2025-01-01', 1, 'C003', N'Chuyên tập tạ'),
(N'Puma Fuse', 'https://res.cloudinary.com/pnam233/image/upload/product/c003_7.jpg', 2100000, '2025-01-01', 1, 'C003', N'Giữ thăng bằng'),
(N'Reebok Lifter PR', 'https://res.cloudinary.com/pnam233/image/upload/product/c003_8.jpg', 2300000, '2025-01-01', 1, 'C003', N'Ổn định khi nâng nặng'),
(N'Nike SuperRep', 'https://res.cloudinary.com/pnam233/image/upload/product/c003_9.jpg', 2500000, '2025-01-01', 1, 'C003', N'Tập HIIT'),
(N'Adidas Trainer V', 'https://res.cloudinary.com/pnam233/image/upload/product/c003_10.jpg', 2000000, '2025-01-01', 1, 'C003', N'Tập luyện cơ bản');

INSERT INTO Products (Name, Image, Price, CreateDate, Available, CategoryId, Description) VALUES
(N'Áo Nike Dri-FIT', 'https://res.cloudinary.com/pnam233/image/upload/product/c004_1.jpg', 450000, '2025-01-01', 1, 'C004', N'Thấm hút mồ hôi, nhẹ và thoáng'),
(N'Áo Adidas Aeroready', 'https://res.cloudinary.com/pnam233/image/upload/product/c004_2.jpg', 420000, '2025-01-01', 1, 'C004', N'Thoáng khí khi vận động'),
(N'Áo Puma Training', 'https://res.cloudinary.com/pnam233/image/upload/product/c004_3.jpg', 380000, '2025-01-01', 1, 'C004', N'Co giãn tốt'),
(N'Áo Under Armour HeatGear', 'https://res.cloudinary.com/pnam233/image/upload/product/c004_4.jpg', 500000, '2025-01-01', 1, 'C004', N'Giữ mát khi tập'),
(N'Áo Reebok Workout', 'https://res.cloudinary.com/pnam233/image/upload/product/c004_5.jpg', 360000, '2025-01-01', 1, 'C004', N'Phù hợp tập gym'),
(N'Áo Nike Pro', 'https://res.cloudinary.com/pnam233/image/upload/product/c004_6.jpg', 480000, '2025-01-01', 1, 'C004', N'Ôm cơ, hỗ trợ vận động'),
(N'Áo Adidas Performance', 'https://res.cloudinary.com/pnam233/image/upload/product/c004_7.jpg', 410000, '2025-01-01', 1, 'C004', N'Tập luyện cường độ cao'),
(N'Áo Puma Active', 'https://res.cloudinary.com/pnam233/image/upload/product/c004_8.jpg', 390000, '2025-01-01', 1, 'C004', N'Mềm nhẹ'),
(N'Áo Under Armour Tech', 'https://res.cloudinary.com/pnam233/image/upload/product/c004_9.jpg', 470000, '2025-01-01', 1, 'C004', N'Thoải mái cả ngày'),
(N'Áo Reebok Training Tee', 'https://res.cloudinary.com/pnam233/image/upload/product/c004_10.jpg', 350000, '2025-01-01', 1, 'C004', N'Áo thể thao cơ bản');

INSERT INTO Products VALUES
(N'Quần Nike Dri-FIT', 'https://res.cloudinary.com/pnam233/image/upload/product/c005_1.jpg', 550000, '2025-01-01', 1, 'C005', N'Co giãn, thoáng khí'),
(N'Quần Adidas Training', 'https://res.cloudinary.com/pnam233/image/upload/product/c005_2.jpg', 520000, '2025-01-01', 1, 'C005', N'Phù hợp tập luyện'),
(N'Quần Puma Sport', 'https://res.cloudinary.com/pnam233/image/upload/product/c005_3.jpg', 480000, '2025-01-01', 1, 'C005', N'Nhẹ và bền'),
(N'Quần Under Armour', 'https://res.cloudinary.com/pnam233/image/upload/product/c005_4.jpg', 600000, '2025-01-01', 1, 'C005', N'Ôm vừa vặn'),
(N'Quần Reebok Active', 'https://res.cloudinary.com/pnam233/image/upload/product/c005_5.jpg', 470000, '2025-01-01', 1, 'C005', N'Dễ vận động'),
(N'Quần Nike Training', 'https://res.cloudinary.com/pnam233/image/upload/product/c005_6.jpg', 580000, '2025-01-01', 1, 'C005', N'Tập gym hiệu quả'),
(N'Quần Adidas Essential', 'https://res.cloudinary.com/pnam233/image/upload/product/c005_7.jpg', 490000, '2025-01-01', 1, 'C005', N'Mặc hàng ngày'),
(N'Quần Puma Flex', 'https://res.cloudinary.com/pnam233/image/upload/product/c005_8.jpg', 510000, '2025-01-01', 1, 'C005', N'Co giãn đa chiều'),
(N'Quần Under Armour Rush', 'https://res.cloudinary.com/pnam233/image/upload/product/c005_9.jpg', 650000, '2025-01-01', 1, 'C005', N'Hỗ trợ cơ bắp'),
(N'Quần Reebok Speed', 'https://res.cloudinary.com/pnam233/image/upload/product/c005_10.jpg', 460000, '2025-01-01', 1, 'C005', N'Chạy bộ thoải mái');

INSERT INTO Products VALUES
(N'Áo khoác Nike Windrunner', 'https://res.cloudinary.com/pnam233/image/upload/product/c006_1.jpg', 1200000, '2025-01-01', 1, 'C006', N'Chống gió nhẹ'),
(N'Áo khoác Adidas Track', 'https://res.cloudinary.com/pnam233/image/upload/product/c006_2.jpg', 1150000, '2025-01-01', 1, 'C006', N'Phong cách thể thao'),
(N'Áo khoác Puma Active', 'https://res.cloudinary.com/pnam233/image/upload/product/c006_3.jpg', 1050000, '2025-01-01', 1, 'C006', N'Giữ ấm nhẹ'),
(N'Áo khoác Under Armour', 'https://res.cloudinary.com/pnam233/image/upload/product/c006_4.jpg', 1300000, '2025-01-01', 1, 'C006', N'Chống nước'),
(N'Áo khoác Reebok Sport', 'https://res.cloudinary.com/pnam233/image/upload/product/c006_5.jpg', 980000, '2025-01-01', 1, 'C006', N'Tập ngoài trời'),
(N'Áo khoác Nike Therma', 'https://res.cloudinary.com/pnam233/image/upload/product/c006_6.jpg', 1400000, '2025-01-01', 1, 'C006', N'Giữ nhiệt tốt'),
(N'Áo khoác Adidas ZNE', 'https://res.cloudinary.com/pnam233/image/upload/product/c006_7.jpg', 1500000, '2025-01-01', 1, 'C006', N'Cao cấp'),
(N'Áo khoác Puma Warm', 'https://res.cloudinary.com/pnam233/image/upload/product/c006_8.jpg', 1100000, '2025-01-01', 1, 'C006', N'Mùa lạnh'),
(N'Áo khoác Under Armour Storm', 'https://res.cloudinary.com/pnam233/image/upload/product/c006_9.jpg', 1600000, '2025-01-01', 1, 'C006', N'Chống thấm'),
(N'Áo khoác Reebok Training', 'https://res.cloudinary.com/pnam233/image/upload/product/c006_10.jpg', 1000000, '2025-01-01', 1, 'C006', N'Nhẹ và tiện dụng');

INSERT INTO Products VALUES
(N'Bộ Nike Training', 'https://res.cloudinary.com/pnam233/image/upload/product/c007_1.jpg', 950000, '2025-01-01', 1, 'C007', N'Áo + quần đồng bộ'),
(N'Bộ Adidas Sport', 'https://res.cloudinary.com/pnam233/image/upload/product/c007_2.jpg', 920000, '2025-01-01', 1, 'C007', N'Tập luyện hàng ngày'),
(N'Bộ Puma Active', 'https://res.cloudinary.com/pnam233/image/upload/product/c007_3.jpg', 880000, '2025-01-01', 1, 'C007', N'Nhẹ và thoáng'),
(N'Bộ Under Armour', 'https://res.cloudinary.com/pnam233/image/upload/product/c007_4.jpg', 1050000, '2025-01-01', 1, 'C007', N'Tập gym chuyên nghiệp'),
(N'Bộ Reebok Fit', 'https://res.cloudinary.com/pnam233/image/upload/product/c007_5.jpg', 870000, '2025-01-01', 1, 'C007', N'Phong cách năng động'),
(N'Bộ Nike Pro', 'https://res.cloudinary.com/pnam233/image/upload/product/c007_6.jpg', 1100000, '2025-01-01', 1, 'C007', N'Ôm dáng'),
(N'Bộ Adidas Aeroready', 'https://res.cloudinary.com/pnam233/image/upload/product/c007_7.jpg', 980000, '2025-01-01', 1, 'C007', N'Thấm hút mồ hôi'),
(N'Bộ Puma Flex', 'https://res.cloudinary.com/pnam233/image/upload/product/c007_8.jpg', 900000, '2025-01-01', 1, 'C007', N'Tập đa năng'),
(N'Bộ Under Armour Rush', 'https://res.cloudinary.com/pnam233/image/upload/product/c007_9.jpg', 1150000, '2025-01-01', 1, 'C007', N'Hỗ trợ cơ bắp'),
(N'Bộ Reebok Active', 'https://res.cloudinary.com/pnam233/image/upload/product/c007_10.jpg', 860000, '2025-01-01', 1, 'C007', N'Mặc thể thao hàng ngày');

INSERT INTO Products VALUES
(N'Tất Nike Cushioned', 'https://res.cloudinary.com/pnam233/image/upload/product/c008_1.jpg', 120000, '2025-01-01', 1, 'C008', N'Êm chân'),
(N'Tất Adidas Performance', 'https://res.cloudinary.com/pnam233/image/upload/product/c008_2.jpg', 110000, '2025-01-01', 1, 'C008', N'Thoáng khí'),
(N'Tất Puma Sport', 'https://res.cloudinary.com/pnam233/image/upload/product/c008_3.jpg', 100000, '2025-01-01', 1, 'C008', N'Co giãn tốt'),
(N'Tất Under Armour', 'https://res.cloudinary.com/pnam233/image/upload/product/c008_4.jpg', 130000, '2025-01-01', 1, 'C008', N'Chống trượt'),
(N'Tất Reebok Training', 'https://res.cloudinary.com/pnam233/image/upload/product/c008_5.jpg', 90000, '2025-01-01', 1, 'C008', N'Tập gym'),
(N'Tất Nike Elite', 'https://res.cloudinary.com/pnam233/image/upload/product/c008_6.jpg', 150000, '2025-01-01', 1, 'C008', N'Cao cấp'),
(N'Tất Adidas Cushioned', 'https://res.cloudinary.com/pnam233/image/upload/product/c008_7.jpg', 115000, '2025-01-01', 1, 'C008', N'Êm ái'),
(N'Tất Puma Flex', 'https://res.cloudinary.com/pnam233/image/upload/product/c008_8.jpg', 105000, '2025-01-01', 1, 'C008', N'Linh hoạt'),
(N'Tất Under Armour HeatGear', 'https://res.cloudinary.com/pnam233/image/upload/product/c008_9.jpg', 140000, '2025-01-01', 1, 'C008', N'Thoáng mát'),
(N'Tất Reebok Sport', 'https://res.cloudinary.com/pnam233/image/upload/product/c008_10.jpg', 95000, '2025-01-01', 1, 'C008', N'Bền bỉ');

INSERT INTO Products VALUES
(N'Balo Nike Training', 'https://res.cloudinary.com/pnam233/image/upload/product/c009_1.jpg', 850000, '2025-01-01', 1, 'C009', N'Đựng đồ tập'),
(N'Balo Adidas Sport', 'https://res.cloudinary.com/pnam233/image/upload/product/c009_2.jpg', 820000, '2025-01-01', 1, 'C009', N'Nhiều ngăn'),
(N'Túi Puma Duffel', 'https://res.cloudinary.com/pnam233/image/upload/product/c009_3.jpg', 780000, '2025-01-01', 1, 'C009', N'Túi thể thao lớn'),
(N'Balo Under Armour', 'https://res.cloudinary.com/pnam233/image/upload/product/c009_4.jpg', 900000, '2025-01-01', 1, 'C009', N'Chống nước'),
(N'Túi Reebok Gym', 'https://res.cloudinary.com/pnam233/image/upload/product/c009_5.jpg', 750000, '2025-01-01', 1, 'C009', N'Đựng giày'),
(N'Balo Nike Elite', 'https://res.cloudinary.com/pnam233/image/upload/product/c009_6.jpg', 950000, '2025-01-01', 1, 'C009', N'Cao cấp'),
(N'Balo Adidas Classic', 'https://res.cloudinary.com/pnam233/image/upload/product/c009_7.jpg', 800000, '2025-01-01', 1, 'C009', N'Phong cách đơn giản'),
(N'Túi Puma Active', 'https://res.cloudinary.com/pnam233/image/upload/product/c009_8.jpg', 770000, '2025-01-01', 1, 'C009', N'Dễ mang'),
(N'Balo Under Armour Hustle', 'https://res.cloudinary.com/pnam233/image/upload/product/c009_9.jpg', 980000, '2025-01-01', 1, 'C009', N'Bền chắc'),
(N'Túi Reebok Sport', 'https://res.cloudinary.com/pnam233/image/upload/product/c009_10.jpg', 720000, '2025-01-01', 1, 'C009', N'Tập luyện hàng ngày');

INSERT INTO Products VALUES
(N'Băng cổ tay Nike', 'https://res.cloudinary.com/pnam233/image/upload/product/c010_1.jpg', 120000, '2025-01-01', 1, 'C010', N'Thấm mồ hôi'),
(N'Găng tay tập gym Adidas', 'https://res.cloudinary.com/pnam233/image/upload/product/c010_2.jpg', 250000, '2025-01-01', 1, 'C010', N'Bảo vệ tay'),
(N'Dây kháng lực Puma', 'https://res.cloudinary.com/pnam233/image/upload/product/c010_3.jpg', 180000, '2025-01-01', 1, 'C010', N'Tập thể lực'),
(N'Bình nước thể thao', 'https://res.cloudinary.com/pnam233/image/upload/product/c010_4.jpg', 200000, '2025-01-01', 1, 'C010', N'Dung tích lớn'),
(N'Mũ lưỡi trai Nike', 'https://res.cloudinary.com/pnam233/image/upload/product/c010_5.jpg', 300000, '2025-01-01', 1, 'C010', N'Chống nắng'),
(N'Bó gối thể thao', 'https://res.cloudinary.com/pnam233/image/upload/product/c010_6.jpg', 220000, '2025-01-01', 1, 'C010', N'Bảo vệ khớp'),
(N'Khăn tập gym', 'https://res.cloudinary.com/pnam233/image/upload/product/c010_7.jpg', 150000, '2025-01-01', 1, 'C010', N'Mềm và thấm hút'),
(N'Dây nhảy thể lực', 'https://res.cloudinary.com/pnam233/image/upload/product/c010_8.jpg', 170000, '2025-01-01', 1, 'C010', N'Tập cardio'),
(N'Đai lưng tập gym', 'https://res.cloudinary.com/pnam233/image/upload/product/c010_9.jpg', 350000, '2025-01-01', 1, 'C010', N'Hỗ trợ lưng'),
(N'Tai nghe thể thao', 'https://res.cloudinary.com/pnam233/image/upload/product/c010_10.jpg', 650000, '2025-01-01', 1, 'C010', N'Chống mồ hôi');


INSERT INTO Accounts VALUES
('user01','123',N'Nguyễn Văn A','a@gmail.com','u1.jpg',1,0),
('user02','123',N'Trần Thị B','b@gmail.com','u2.jpg',1,0),
('user03','123',N'Lê Văn C','c@gmail.com','u3.jpg',1,0),
('user04','123',N'Phạm Thị D','d@gmail.com','u4.jpg',1,0),
('user05','123',N'Hoàng Văn E','e@gmail.com','u5.jpg',1,0),
('admin','admin',N'Admin','admin@gmail.com','admin.jpg',1,1);



INSERT INTO Orders VALUES
('user01','2025-01-10',N'Hà Nội'),
('user02','2025-01-11',N'TP HCM'),
('user03','2025-01-12',N'Đà Nẵng');

INSERT INTO OrderDetails VALUES
(1,1,2500000,1),
(1,12,3400000,1),
(2,5,1700000,2),
(3,22,2800000,1);

select * from Products
