CREATE LOGIN sqlTest WITH PASSWORD = 'MatKhauMoiCuaBan123!';
USE murach;
CREATE USER sqlTest FOR LOGIN sqlTest;
ALTER ROLE db_owner ADD MEMBER sqlTest;