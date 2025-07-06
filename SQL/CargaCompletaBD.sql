--Sucursal
insert into sucursal (id,ciudad,direccion,nombre) values
(1,'Valparaíso','Valparaíso','Ferremas Valparaíso'),
(2,'Viña del Mar','Viña del Mar','Ferremas Viña del Mar'),
(3,'Santiago','Santiago Centro','Ferremas Santiago'),
(4,'Internet','Internet','Ferremas Internet');

-- Categorías
INSERT INTO categoria (id, nombre) VALUES (1, 'Herramientas manuales');
INSERT INTO categoria (id, nombre) VALUES (2, 'Materiales básicos');
INSERT INTO categoria (id, nombre) VALUES (3, 'Equipos de seguridad');
INSERT INTO categoria (id, nombre) VALUES (4, 'Tornillos y anclajes');
INSERT INTO categoria (id, nombre) VALUES (5, 'Fijaciones y adhesivos');
INSERT INTO categoria (id, nombre) VALUES (6, 'Equipos de medición');

-- Subcategorías
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (1, 'Martillos', 1);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (2, 'Destornilladores', 1);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (3, 'Llaves', 1);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (4, 'Herramientas Eléctricas', 1);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (5, 'Taladros', 1);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (6, 'Sierras', 1);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (7, 'Lijadoras', 1);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (8, 'Materiales de Construcción', 1);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (9, 'Cemento', 2);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (10, 'Arena', 2);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (11, 'Ladrillos', 2);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (12, 'Acabados', 2);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (13, 'Pinturas', 2);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (14, 'Barnices', 2);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (15, 'Cerámicos', 2);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (16, 'Cascos', 3);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (17, 'Guantes', 3);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (18, 'Lentes de Seguridad', 3);
INSERT INTO subcategoria (id, nombre, categoria_id) VALUES (19, 'Accesorios Varios', 3);

-- Productos
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (1, 'FER-000001', 'Martillos Modelo 1', 'Martillos profesional ideal para trabajo pesado', 'Stanley', 65, 1, 1,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (2, 'FER-000002', 'Martillos Modelo 2', 'Martillos profesional ideal para trabajo pesado', 'Sodimac', 89, 1, 1,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (3, 'FER-000003', 'Destornilladores Modelo 1', 'Destornilladores profesional ideal para trabajo pesado', '3M', 55, 1, 2,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (4, 'FER-000004', 'Destornilladores Modelo 2', 'Destornilladores profesional ideal para trabajo pesado', 'Stanley', 24, 1, 2,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (5, 'FER-000005', 'Llaves Modelo 1', 'Llaves profesional ideal para trabajo pesado', 'Black & Decker', 32, 1, 3,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (6, 'FER-000006', 'Llaves Modelo 2', 'Llaves profesional ideal para trabajo pesado', 'Makita', 56, 1, 3,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (7, 'FER-000007', 'Herramientas Eléctricas Modelo 1', 'Herramientas Eléctricas profesional ideal para trabajo pesado', 'Makita', 18, 1, 4,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (8, 'FER-000008', 'Herramientas Eléctricas Modelo 2', 'Herramientas Eléctricas profesional ideal para trabajo pesado', 'Black & Decker', 89, 1, 4,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (9, 'FER-000009', 'Taladros Modelo 1', 'Taladros profesional ideal para trabajo pesado', 'Bosch', 95, 1, 5,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (10, 'FER-000010', 'Taladros Modelo 2', 'Taladros profesional ideal para trabajo pesado', 'Black & Decker', 88, 1, 5,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (11, 'FER-000011', 'Sierras Modelo 1', 'Sierras profesional ideal para trabajo pesado', 'Stanley', 91, 1, 6,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (12, 'FER-000012', 'Sierras Modelo 2', 'Sierras profesional ideal para trabajo pesado', 'Black & Decker', 37, 1, 6,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (13, 'FER-000013', 'Lijadoras Modelo 1', 'Lijadoras profesional ideal para trabajo pesado', 'Sodimac', 83, 1, 7,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (14, 'FER-000014', 'Lijadoras Modelo 2', 'Lijadoras profesional ideal para trabajo pesado', 'Makita', 86, 1, 7,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (15, 'FER-000015', 'Materiales de Construcción Modelo 1', 'Materiales de Construcción profesional ideal para trabajo pesado', 'Bosch', 35, 1, 8,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (16, 'FER-000016', 'Materiales de Construcción Modelo 2', 'Materiales de Construcción profesional ideal para trabajo pesado', 'Makita', 60, 1, 8,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (17, 'FER-000017', 'Cemento Modelo 1', 'Cemento profesional ideal para trabajo pesado', 'Sodimac', 40, 2, 9,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (18, 'FER-000018', 'Cemento Modelo 2', 'Cemento profesional ideal para trabajo pesado', 'Bosch', 46, 2, 9,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (19, 'FER-000019', 'Arena Modelo 1', 'Arena profesional ideal para trabajo pesado', 'Black & Decker', 75, 2, 10,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (20, 'FER-000020', 'Arena Modelo 2', 'Arena profesional ideal para trabajo pesado', 'Sodimac', 65, 2, 10,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (21, 'FER-000021', 'Ladrillos Modelo 1', 'Ladrillos profesional ideal para trabajo pesado', 'DeWalt', 19, 2, 11,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (22, 'FER-000022', 'Ladrillos Modelo 2', 'Ladrillos profesional ideal para trabajo pesado', 'DeWalt', 82, 2, 11,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (23, 'FER-000023', 'Acabados Modelo 1', 'Acabados profesional ideal para trabajo pesado', 'Bosch', 74, 2, 12,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (24, 'FER-000024', 'Acabados Modelo 2', 'Acabados profesional ideal para trabajo pesado', 'Stanley', 24, 2, 12,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (25, 'FER-000025', 'Pinturas Modelo 1', 'Pinturas profesional ideal para trabajo pesado', 'Black & Decker', 31, 2, 13,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (26, 'FER-000026', 'Pinturas Modelo 2', 'Pinturas profesional ideal para trabajo pesado', 'Bosch', 55, 2, 13,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (27, 'FER-000027', 'Barnices Modelo 1', 'Barnices profesional ideal para trabajo pesado', 'Bosch', 79, 2, 14,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (28, 'FER-000028', 'Barnices Modelo 2', 'Barnices profesional ideal para trabajo pesado', 'DeWalt', 74, 2, 14,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (29, 'FER-000029', 'Cerámicos Modelo 1', 'Cerámicos profesional ideal para trabajo pesado', 'Sodimac', 86, 2, 15,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (30, 'FER-000030', 'Cerámicos Modelo 2', 'Cerámicos profesional ideal para trabajo pesado', 'Sodimac', 79, 2, 15,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (31, 'FER-000031', 'Cascos Modelo 1', 'Cascos profesional ideal para trabajo pesado', 'Makita', 64, 3, 16,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (32, 'FER-000032', 'Cascos Modelo 2', 'Cascos profesional ideal para trabajo pesado', '3M', 42, 3, 16,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (33, 'FER-000033', 'Guantes Modelo 1', 'Guantes profesional ideal para trabajo pesado', 'Sodimac', 60, 3, 17,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (34, 'FER-000034', 'Guantes Modelo 2', 'Guantes profesional ideal para trabajo pesado', 'Bosch', 53, 3, 17,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (35, 'FER-000035', 'Lentes de Seguridad Modelo 1', 'Lentes de Seguridad profesional ideal para trabajo pesado', 'Black & Decker', 52, 3, 18,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (36, 'FER-000036', 'Lentes de Seguridad Modelo 2', 'Lentes de Seguridad profesional ideal para trabajo pesado', 'Bosch', 55, 3, 18,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (37, 'FER-000037', 'Accesorios Varios Modelo 1', 'Accesorios Varios profesional ideal para trabajo pesado', 'Sodimac', 25, 3, 19,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id, subcategoria_id,fecha_ingreso) VALUES (38, 'FER-000038', 'Accesorios Varios Modelo 2', 'Accesorios Varios profesional ideal para trabajo pesado', 'Black & Decker', 19, 3, 19,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id,fecha_ingreso) VALUES (39, 'FER-000039', 'Tornillos Estándar', 'Tornillos resistente y confiable para múltiples usos', 'Stanley', 35, 4,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id,fecha_ingreso) VALUES (40, 'FER-000040', 'Anclajes Estándar', 'Anclajes resistente y confiable para múltiples usos', 'DeWalt', 71, 4,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id,fecha_ingreso) VALUES (41, 'FER-000041', 'Silicona Estándar', 'Silicona resistente y confiable para múltiples usos', 'DeWalt', 54, 5,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id,fecha_ingreso) VALUES (42, 'FER-000042', 'Pegamento Estándar', 'Pegamento resistente y confiable para múltiples usos', '3M', 90, 5,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id,fecha_ingreso) VALUES (43, 'FER-000043', 'Cinta Métrica Estándar', 'Cinta Métrica resistente y confiable para múltiples usos', 'Stanley', 58, 6,'2025-05-01');
INSERT INTO producto (id, cod_producto, nombre, descripcion, marca, stock, categoria_id,fecha_ingreso) VALUES (44, 'FER-000044', 'Nivel Láser Estándar', 'Nivel Láser resistente y confiable para múltiples usos', 'Makita', 65, 6,'2025-05-01');

INSERT INTO precio (producto_id, valor, fecha, activo) VALUES
(1, 4200, '2025-05-01', false), (1, 4500, '2025-06-01', true),
(2, 1300, '2025-05-01', false), (2, 1500, '2025-06-01', true),
(3, 2300, '2025-05-01', false), (3, 2500, '2025-06-01', true),
(4, 28000, '2025-05-01', false), (4, 30000, '2025-06-01', true),
(5, 4700, '2025-05-01', false), (5, 5000, '2025-06-01', true),
(6, 1800, '2025-05-01', false), (6, 2000, '2025-06-01', true),
(7, 2200, '2025-05-01', false), (7, 2500, '2025-06-01', true),
(8, 9000, '2025-05-01', false), (8, 9500, '2025-06-01', true),
(9, 13000, '2025-05-01', false), (9, 13500, '2025-06-01', true),
(10, 2800, '2025-05-01', false), (10, 3000, '2025-06-01', true),
(11, 1800, '2025-05-01', false), (11, 2000, '2025-06-01', true),
(12, 3700, '2025-05-01', false), (12, 4000, '2025-06-01', true),
(13, 9500, '2025-05-01', false), (13, 10000, '2025-06-01', true),
(14, 7400, '2025-05-01', false), (14, 7700, '2025-06-01', true),
(15, 1200, '2025-05-01', false), (15, 1400, '2025-06-01', true),
(16, 6500, '2025-05-01', false), (16, 7000, '2025-06-01', true),
(17, 1600, '2025-05-01', false), (17, 1800, '2025-06-01', true),
(18, 4200, '2025-05-01', false), (18, 4500, '2025-06-01', true),
(19, 5800, '2025-05-01', false), (19, 6000, '2025-06-01', true),
(20, 7700, '2025-05-01', false), (20, 8000, '2025-06-01', true),
(21, 19500, '2025-05-01', false), (21, 20000, '2025-06-01', true),
(22, 11400, '2025-05-01', false), (22, 12000, '2025-06-01', true),
(23, 13500, '2025-05-01', false), (23, 14000, '2025-06-01', true),
(24, 24500, '2025-05-01', false), (24, 25000, '2025-06-01', true),
(25, 3900, '2025-05-01', false), (25, 4200, '2025-06-01', true),
(26, 6700, '2025-05-01', false), (26, 7000, '2025-06-01', true),
(27, 16500, '2025-05-01', false), (27, 17000, '2025-06-01', true),
(28, 5900, '2025-05-01', false), (28, 6200, '2025-06-01', true),
(29, 4100, '2025-05-01', false), (29, 4400, '2025-06-01', true),
(30, 2800, '2025-05-01', false), (30, 3000, '2025-06-01', true),
(31, 1900, '2025-05-01', false), (31, 2200, '2025-06-01', true),
(32, 8700, '2025-05-01', false), (32, 9000, '2025-06-01', true),
(33, 3500, '2025-05-01', false), (33, 3800, '2025-06-01', true),
(34, 7500, '2025-05-01', false), (34, 8000, '2025-06-01', true),
(35, 13400, '2025-05-01', false), (35, 14000, '2025-06-01', true),
(36, 1700, '2025-05-01', false), (36, 2000, '2025-06-01', true),
(37, 5400, '2025-05-01', false), (37, 5700, '2025-06-01', true),
(38, 3700, '2025-05-01', false), (38, 4000, '2025-06-01', true),
(39, 6100, '2025-05-01', false), (39, 6400, '2025-06-01', true),
(40, 12400, '2025-05-01', false), (40, 13000, '2025-06-01', true),
(41, 24500, '2025-05-01', false), (41, 25000, '2025-06-01', true),
(42, 6700, '2025-05-01', false), (42, 7000, '2025-06-01', true),
(43, 2200, '2025-05-01', false), (43, 2500, '2025-06-01', true),
(44, 4800, '2025-05-01', false), (44, 5000, '2025-06-01', true);
