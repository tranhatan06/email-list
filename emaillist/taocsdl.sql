-- 1. Tạo database (bỏ qua nếu đã có)
IF DB_ID('murach') IS NULL
BEGIN
    CREATE DATABASE murach;
END
GO

USE murach;
GO

-- 2. Tạo bảng User (tên trùng từ khoá SQL Server nên phải đóng ngoặc vuông)
IF OBJECT_ID('dbo.[User]', 'U') IS NOT NULL
    DROP TABLE dbo.[User];
GO

CREATE TABLE dbo.[User] (
    UserID    INT IDENTITY(1,1) PRIMARY KEY,
    Email     VARCHAR(100) NOT NULL UNIQUE,
    FirstName VARCHAR(50)  NOT NULL,
    LastName  VARCHAR(50)  NOT NULL
);
GO

-- 3. Chèn dữ liệu mẫu (đúng như trong ảnh SELECT * FROM User)
INSERT INTO dbo.[User] (Email, FirstName, LastName) VALUES
    ('jsmith@gmail.com',      'John',   'Smith'),
    ('andi@murach.com',       'Andrea', 'Steelman'),
    ('joelmurach@yahoo.com',  'Joel',   'Murach');
GO

-- Kiểm tra
SELECT * FROM dbo.[User];
GO