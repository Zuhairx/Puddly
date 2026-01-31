
-- create database
CREATE DATABASE pudding_database;
USE pudding_database;

-- create table
CREATE TABLE `Menu` (
  `Kode` varchar(10) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Harga` int(11) NOT NULL,
  `Stok` int(11) NOT NULL
);

-- insert data
INSERT INTO `Menu` (`Kode`, `Nama`, `Harga`, `Stok`) VALUES
('PD-936', 'Pudding Cokelat', 10000, 100),
('PD-937', 'Pudding Vanilla', 12000, 80),
('PD-938', 'Pudding Strawberry', 11000, 90),
('PD-939', 'Pudding Mango', 13000, 70),
('PD-940', 'Pudding Banana', 10500, 95),
('PD-941', 'Pudding Chocolate Chip', 14000, 60),
('PD-942', 'Pudding Coconut', 12500, 85),
('PD-943', 'Pudding Lemon', 11500, 75),
('PD-944', 'Pudding Blueberry', 13500, 65),
('PD-945', 'Pudding Caramel', 15000, 50),
('PD-946', 'Pudding Apple', 15500, 55),
('PD-947', 'Pudding Pineapple', 16000, 60),
('PD-948', 'Pudding Orange', 16500, 65),
('PD-949', 'Pudding Grape', 17000, 70),
('PD-950', 'Pudding Peach', 17500, 75),
('PD-951', 'Pudding Kiwi', 18000, 80),
('PD-952', 'Pudding Raspberry', 18500, 85),
('PD-953', 'Pudding Blackberry', 19000, 90),
('PD-954', 'Pudding Cherry', 19500, 95),
('PD-955', 'Pudding Passionfruit', 20000, 100),
('PD-956', 'Pudding Lychee', 10500, 50),
('PD-957', 'Pudding Durian', 11000, 55),
('PD-958', 'Pudding Jackfruit', 11500, 60),
('PD-959', 'Pudding Papaya', 12000, 65),
('PD-960', 'Pudding Guava', 12500, 70),
('PD-961', 'Pudding Watermelon', 13000, 75),
('PD-962', 'Pudding Honeydew', 13500, 80),
('PD-963', 'Pudding Cantaloupe', 14000, 85),
('PD-964', 'Pudding Avocado', 14500, 90),
('PD-965', 'Pudding Taro', 15000, 95),
('PD-966', 'Pudding Matcha', 15500, 100),
('PD-967', 'Pudding Red Bean', 16000, 50),
('PD-968', 'Pudding Green Tea', 16500, 55),
('PD-969', 'Pudding Black Sesame', 17000, 60),
('PD-970', 'Pudding Almond', 17500, 65),
('PD-971', 'Pudding Pistachio', 18000, 70),
('PD-972', 'Pudding Hazelnut', 18500, 75),
('PD-973', 'Pudding Walnut', 19000, 80),
('PD-974', 'Pudding Pecan', 19500, 85),
('PD-975', 'Pudding Macadamia', 20000, 90),
('PD-976', 'Pudding Oreo', 10500, 95),
('PD-977', 'Pudding KitKat', 11000, 100),
('PD-978', 'Pudding Snickers', 11500, 50),
('PD-979', 'Pudding Reeses', 12000, 55),
('PD-980', 'Pudding M&M', 12500, 60),
('PD-981', 'Pudding Twix', 13000, 65),
('PD-982', 'Pudding Ferrero Rocher', 13500, 70),
('PD-983', 'Pudding Kinder Bueno', 14000, 75),
('PD-984', 'Pudding Toblerone', 14500, 80),
('PD-985', 'Pudding Lindt', 15000, 85);

