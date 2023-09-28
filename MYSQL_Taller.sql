/* Cliente */
CREATE TABLE cliente (
	id_cliente INT AUTO_INCREMENT PRIMARY KEY,
	nombre_razon_social VARCHAR(50),
	tipo_documento VARCHAR(10),
	numero_documento VARCHAR(11),
	telefono_cliente VARCHAR(20),
	correo_cliente VARCHAR(50),
	direccion_cliente VARCHAR(50)
);

INSERT INTO cliente (nombre_razon_social, tipo_documento, numero_documento, telefono_cliente, correo_cliente, direccion_cliente)
VALUES
('Juan Pérez', 'DNI', '12345678', '987654321', 'juan@example.com', 'Calle 123, Ciudad A'),
('María González', 'RUC', '87654321', '912345678', 'maria@example.com', 'Av. Principal 456, Ciudad B'),
('Carlos Rodríguez', 'DNI', '98765432', '998877665', 'carlos@example.com', 'Plaza Central 789, Ciudad C'),
('Ana Sánchez', 'DNI', '56789012', '956784123', 'ana@example.com', 'Callejón 23, Ciudad A'),
('Luis Martínez', 'RUC', '45678901', '923456789', 'luis@example.com', 'Calle Grande 56, Ciudad B'),
('Laura Ramírez', 'DNI', '34567890', '987612345', 'laura@example.com', 'Avenida Sur 78, Ciudad C'),
('Pedro Vargas', 'RUC', '23456789', '944556677', 'pedro@example.com', 'Esquina Norte 12, Ciudad A'),
('Sofía Fernández', 'DNI', '45678901', '933311122', 'sofia@example.com', 'Plaza Este 45, Ciudad B'),
('Andrés López', 'DNI', '56789012', '944422211', 'andres@example.com', 'Calle Principal 67, Ciudad C'),
('Elena Gómez', 'RUC', '67890123', '955566677', 'elena@example.com', 'Avenida Oeste 89, Ciudad A'),
('Javier Torres', 'DNI', '78901234', '911122233', 'javier@example.com', 'Paseo 34, Ciudad B'),
('Isabel Castro', 'DNI', '89012345', '922211122', 'isabel@example.com', 'Plaza Norte 56, Ciudad C'),
('Miguel Ortega', 'RUC', '90123456', '944455566', 'miguel@example.com', 'Calle Este 78, Ciudad A'),
('Paula Vega', 'DNI', '12345678', '933322211', 'paula@example.com', 'Avenida 45, Ciudad B'),
('Ricardo Silva', 'DNI', '23456789', '911112222', 'ricardo@example.com', 'Esquina 67, Ciudad C');

/* Historial Cliente */
CREATE TABLE historial_Cliente (
	id_historial_cliente INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT REFERENCES Cliente(id_cliente),
	fecha_historial_cliente DATE,
	descripcion TEXT
);

INSERT INTO Historial_Cliente (id_cliente, fecha_historial_cliente, descripcion)
VALUES
    (3, '2021-07-15', 'Asistencia en taller de mecánica.'),
    (8, '2022-03-28', 'Reparación de motor.'),
    (5, '2022-11-10', 'Cambio de aceite y filtro.'),
    (2, '2021-09-05', 'Diagnóstico de problemas eléctricos.'),
    (7, '2022-08-20', 'Alineación y balanceo de ruedas.'),
    (1, '2023-01-12', 'Sustitución de frenos.'),
    (9, '2023-05-03', 'Inspección previa a un viaje.'),
    (4, '2021-12-18', 'Revisión de transmisión.'),
    (6, '2022-06-25', 'Servicio de mantenimiento programado.'),
    (10, '2023-08-09', 'Solución a ruido en suspensión.'),
    (3, '2021-05-30', 'Reparación de sistema de escape.'),
    (8, '2022-07-08', 'Cambio de neumáticos.'),
    (5, '2023-04-02', 'Ajuste de sistema de climatización.'),
    (2, '2022-09-17', 'Limpieza y pulido exterior.'),
    (7, '2023-03-21', 'Reemplazo de faros y luces.');

/* Vehiculo */
CREATE TABLE Vehiculo (
    	id_vehiculo INT AUTO_INCREMENT PRIMARY KEY,
	placa VARCHAR(10),
	kilometraje INT,
	modelo VARCHAR(30),
	marca VARCHAR(30),
	color VARCHAR(20),
	n_serie INT,
	n_servicios INT,
	fecha_fabricacion DATE,
	n_chasis VARCHAR(20)
);

INSERT INTO Vehiculo (placa, kilometraje, modelo, marca, color, n_serie, n_servicios, fecha_fabricacion, n_chasis)
VALUES
    ('ABC123', 5000, 'Sedán', 'Toyota', 'Rojo', 123456, 2, '2020-01-15', 'CHASIS123'),
    ('DEF456', 80000, 'Camioneta', 'Ford', 'Azul', 789012, 4, '2018-07-20', 'CHASIS456'),
    ('GHI789', 12000, 'Hatchback', 'Volkswagen', 'Blanco', 345678, 1, '2022-03-10', 'CHASIS789'),
    ('JKL012', 30000, 'SUV', 'Honda', 'Gris', 901234, 3, '2019-11-05', 'CHASIS012'),
    ('MNO345', 150000, 'Pickup', 'Chevrolet', 'Negro', 567890, 6, '2017-05-25', 'CHASIS345'),
    ('PQR678', 4000, 'Coupé', 'BMW', 'Plateado', 123450, 2, '2023-02-18', 'CHASIS678'),
    ('STU901', 28000, 'Sedán', 'Nissan', 'Verde', 678901, 3, '2021-09-30', 'CHASIS901'),
    ('VWX234', 65000, 'Camioneta', 'Ford', 'Rojo', 234567, 5, '2018-06-12', 'CHASIS234'),
    ('YZA567', 8000, 'Hatchback', 'Renault', 'Azul', 890123, 2, '2022-07-05', 'CHASIS567'),
    ('BCD890', 95000, 'SUV', 'Toyota', 'Blanco', 345678, 4, '2017-10-22', 'CHASIS890'),
    ('EFG123', 25000, 'Coupé', 'Audi', 'Negro', 901234, 3, '2020-04-17', 'CHASIS123'),
    ('HIJ456', 5000, 'Pickup', 'Chevrolet', 'Plateado', 567890, 1, '2023-03-08', 'CHASIS456'),
    ('KLM789', 68000, 'Sedán', 'Hyundai', 'Gris', 234567, 4, '2019-08-29', 'CHASIS789'),
    ('NOP012', 18000, 'Camioneta', 'Mitsubishi', 'Negro', 678901, 2, '2021-11-14', 'CHASIS012'),
    ('PQR345', 99000, 'Hatchback', 'Volkswagen', 'Rojo', 890123, 5, '2017-06-07', 'CHASIS345'),
    ('STU678', 7000, 'SUV', 'Kia', 'Azul', 123450, 3, '2022-09-23', 'CHASIS678'),
    ('VWX901', 33000, 'Coupé', 'BMW', 'Blanco', 567890, 2, '2018-04-09', 'CHASIS901'),
    ('YZA234', 52000, 'Pickup', 'Ford', 'Negro', 234567, 4, '2020-12-30', 'CHASIS234'),
    ('BCD567', 12000, 'Sedán', 'Honda', 'Gris', 345678, 2, '2021-03-18', 'CHASIS567'),
    ('EFG890', 78000, 'Camioneta', 'Toyota', 'Verde', 901234, 3, '2019-05-01', 'CHASIS890');

/* Cliente_Vehiculo */
CREATE TABLE cliente_Vehiculo (
	id_cliente_vehiculo INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT REFERENCES Cliente(id_cliente),
	id_vehiculo INT REFERENCES Vehiculo(id_vehiculo)
);

INSERT INTO cliente_Vehiculo (id_cliente, id_vehiculo)
VALUES
    (5, 1),
    (8, 2),
    (12, 3),
    (3, 4),
    (7, 5),
    (15, 6),
    (9, 7),
    (1, 8),
    (10, 9),
    (14, 10),
    (6, 11),
    (2, 12),
    (11, 13),
    (4, 14),
    (13, 15),
    (5, 16),
    (8, 17),
    (12, 18),
    (3, 19),
    (7, 20);

/* Personal */
CREATE TABLE Personal (
	id_personal INT AUTO_INCREMENT PRIMARY KEY,
	nombre_personal VARCHAR(30),
	apellido_personal VARCHAR(40),
	ocupacion VARCHAR(35),
	salario FLOAT,
	telefono_personal VARCHAR(20),
	correo_personal VARCHAR(50)
);

INSERT INTO Personal (nombre_personal, apellido_personal, ocupacion, salario, telefono_personal, correo_personal)
VALUES
    ('Juan', 'Pérez', 'Mecánico', 40000.00, '555-1234', 'juan.perez@example.com'),
    ('Carlos', 'González', 'Mecánico', 38000.00, '555-5678', 'carlos.gonzalez@example.com'),
    ('Luis', 'Martínez', 'Mecánico', 42000.00, '555-9876', 'luis.martinez@example.com'),
    ('Javier', 'Díaz', 'Ingeniero Automotriz', 55000.00, '555-4321', 'javier.diaz@example.com'),
    ('Ana', 'Hernández', 'Diseñadora de Autopartes', 48000.00, '555-8765', 'ana.hernandez@example.com'),
    ('Roberto', 'Ramírez', 'Mecánico', 39000.00, '555-2345', 'roberto.ramirez@example.com'),
    ('Diego', 'García', 'Asistente de Taller', 32000.00, '555-6789', 'diego.garcia@example.com'),
    ('Carmen', 'Pérez', 'Contador para Taller', 45000.00, '555-7654', 'carmen.perez@example.com'),
    ('Daniel', 'López', 'Mecánico', 41000.00, '555-3456', 'daniel.lopez@example.com'),
    ('Miguel', 'González', 'Supervisor de Taller', 55000.00, '555-8901', 'miguel.gonzalez@example.com'),
    ('Sofía', 'Torres', 'Diseñadora de Automóviles', 48000.00, '555-4567', 'sofia.torres@example.com'),
    ('María', 'López', 'Recepcionista de Taller', 35000.00, '555-0123', 'maria.lopez@example.com'),
    ('Lorena', 'Vargas', 'Mecánico', 40000.00, '555-6789', 'lorena.vargas@example.com'),
    ('Andrés', 'Fernández', 'Asistente de Taller', 33000.00, '555-2345', 'andres.fernandez@example.com'),
    ('Ricardo', 'Ramírez', 'Mecánico', 42000.00, '555-7890', 'ricardo.ramirez@example.com');

/* Servicio */
CREATE TABLE Servicio (
	id_servicio INT AUTO_INCREMENT PRIMARY KEY,
	id_personal INT REFERENCES Personal(id_personal),
	id_vehiculo VARCHAR(10) REFERENCES Vehiculo(id_vehiculo),
	fecha_servicio Date,
	precio_servicio FLOAT,
	descripcion_servicio TEXT
	servicio_pagado Boolean
);

INSERT INTO Servicio (id_personal, id_vehiculo, fecha_servicio, precio_servicio, descripcion_servicio)
VALUES
    (6, 1, '2021-04-10', 150.00, 'Cambio de aceite y filtro'),
    (3, 2, '2021-06-25', 300.00, 'Revisión de frenos y cambio de pastillas'),
    (9, 3, '2022-01-15', 200.00, 'Alineación y balanceo'),
    (12, 4, '2022-03-08', 500.00, 'Cambio de correa de distribución'),
    (2, 5, '2022-05-20', 1200.00, 'Reparación de motor'),
    (8, 6, '2022-06-10', 50.00, 'Cambio de filtro de aire'),
    (14, 7, '2022-08-02', 80.00, 'Cambio de bujías'),
    (4, 8, '2022-09-18', 300.00, 'Revisión general y mantenimiento'),
    (11, 9, '2022-10-30', 1500.00, 'Reparación de transmisión'),
    (7, 10, '2022-12-05', 70.00, 'Cambio de aceite de transmisión'),
    (1, 11, '2023-01-22', 100.00, 'Inspección de sistema eléctrico'),
    (5, 12, '2023-02-14', 400.00, 'Reemplazo de amortiguadores'),
    (10, 13, '2023-04-09', 180.00, 'Cambio de batería'),
    (13, 14, '2023-06-30', 600.00, 'Reparación de sistema de dirección'),
    (15, 15, '2023-07-22', 40.00, 'Ajuste de freno de mano'),
    (6, 16, '2023-09-05', 250.00, 'Cambio de líquido de frenos'),
    (3, 17, '2023-10-17', 120.00, 'Reemplazo de termostato'),
    (12, 18, '2023-12-08', 70.00, 'Recarga de refrigerante'),
    (2, 19, '2023-12-30', 200.00, 'Cambio de bombillas y faros'),
    (7, 20, '2023-08-13', 1800.00, 'Reparación de sistema de suspensión');

/* Herramienta/Repuesto */
CREATE TABLE Herramienta_Repuesto (
	id_herramienta_repuesto INT AUTO_INCREMENT PRIMARY KEY,
	nombre_herramienta_repuesto VARCHAR(30),
	precio_compra FLOAT,
	precio_venta FLOAT,
	descripcion_herramienta_repuesto TEXT,
	stock_herramienta_repuesto INT
);

INSERT INTO Herramienta_Repuesto (nombre_herramienta_repuesto, precio_compra, precio_venta, descripcion_herramienta_repuesto, stock_herramienta_repuesto)
VALUES
    ('Llave inglesa', 10.00, 15.00, 'Herramienta ajustable para apretar o aflojar tuercas y tornillos.', 5),
    ('Destornillador Phillips', 5.00, 8.00, 'Herramienta para atornillar y desatornillar tornillos Phillips.', 8),
    ('Alicate de corte', 12.00, 18.00, 'Herramienta de corte para cables y alambres.', 3),
    ('Martillo de garra', 15.00, 20.00, 'Martillo con cabeza curva para remover clavos.', 7),
    ('Llave de tubo', 8.00, 12.00, 'Herramienta para apretar y aflojar tuercas y pernos.', 2),
    ('Cinta métrica', 7.00, 10.00, 'Herramienta de medición para tomar medidas con precisión.', 6),
    ('Destornillador plano', 4.00, 6.00, 'Herramienta para atornillar y desatornillar tornillos planos.', 9),
    ('Pinzas de punta', 6.00, 9.00, 'Pinzas pequeñas para sujetar objetos con precisión.', 4),
    ('Sierra manual', 18.00, 25.00, 'Herramienta de corte manual para madera y materiales blandos.', 1),
    ('Taladro inalámbrico', 60.00, 90.00, 'Herramienta eléctrica para perforar agujeros en diferentes materiales.', 0),
    ('Aceite de motor', 20.00, 30.00, 'Aceite lubricante para motores de vehículos.', 15),
    ('Filtro de aire', 8.00, 15.00, 'Filtro para purificar el aire que ingresa al motor del vehículo.', 18),
    ('Bujías', 5.00, 10.00, 'Bujías de encendido para el sistema de ignición del vehículo.', 12),
    ('Pastillas de freno', 25.00, 40.00, 'Pastillas de freno para el sistema de frenado del vehículo.', 9),
    ('Filtro de aceite', 6.00, 12.00, 'Filtro para purificar el aceite del motor del vehículo.', 14),
    ('Amortiguadores', 40.00, 70.00, 'Amortiguadores para mejorar la suspensión del vehículo.', 7),
    ('Correa de distribución', 15.00, 25.00, 'Correa para transmitir la potencia del motor a otros componentes.', 5),
    ('Sensor de oxígeno', 30.00, 50.00, 'Sensor para medir la concentración de oxígeno en los gases de escape.', 3),
    ('Filtro de combustible', 10.00, 18.00, 'Filtro para purificar el combustible que llega al motor del vehículo.', 6),
    ('Batería', 50.00, 80.00, 'Batería para el sistema eléctrico y de arranque del vehículo.', 11),
    ('Rótulas de suspensión', 18.00, 30.00, 'Rótulas para las conexiones en el sistema de suspensión del vehículo.', 4),
    ('Kit de embrague', 80.00, 120.00, 'Kit completo para el sistema de embrague del vehículo.', 2),
    ('Termostato', 10.00, 18.00, 'Termostato para regular la temperatura del motor del vehículo.', 8),
    ('Cables de bujías', 12.00, 20.00, 'Cables para conectar las bujías al sistema de ignición del vehículo.', 7),
    ('Alternador', 60.00, 100.00, 'Alternador para generar energía eléctrica en el vehículo.', 5),
    ('Motor de arranque', 50.00, 90.00, 'Motor para iniciar el arranque del vehículo.', 4),
    ('Radiador', 40.00, 70.00, 'Radiador para enfriar el líquido de refrigeración del motor del vehículo.', 6),
    ('Correa de accesorios', 15.00, 25.00, 'Correa para transmitir potencia a los accesorios del motor.', 9),
    ('Sensores de ABS', 25.00, 40.00, 'Sensores para el sistema antibloqueo de frenos del vehículo.', 3),
    ('Tubo de escape', 35.00, 60.00, 'Tubo para conducir los gases de escape fuera del vehículo.', 5),
    ('Sensor de temperatura', 12.00, 20.00, 'Sensor para medir la temperatura del motor del vehículo.', 8);

/* Servicio_Repuesto */
CREATE TABLE Servicio_Repuesto (
	id_servicio_repuesto INT AUTO_INCREMENT PRIMARY KEY,
	id_servicio INT REFERENCES Servicio(id_servicio),
	id_herramienta_repuesto INT REFERENCES Herramienta_Repuesto(id_herramienta_repuesto)
);

INSERT INTO Servicio_Repuesto (id_servicio, id_herramienta_repuesto)
VALUES
    (5, 15),
    (18, 25),
    (2, 12),
    (8, 21),
    (13, 18),
    (7, 14),
    (3, 11),
    (19, 24),
    (1, 10),
    (6, 22),
    (10, 13),
    (5, 17),
    (20, 25),
    (15, 20),
    (9, 16);

/* Metodo_Pago */
CREATE TABLE Metodo_Pago (
	id_metodo INT AUTO_INCREMENT PRIMARY KEY,
	tipo_metodo VARCHAR(50)
);

INSERT INTO Metodo_Pago (tipo_metodo)
VALUES ('Tarjeta de crédito'),
       ('PayPal'),
       ('Transferencia bancaria'),
       ('Efectivo'),
       ('Cheque');

/* Comprobante_Pago */
CREATE TABLE Comprobante_Pago (
	id_comprobante INT AUTO_INCREMENT PRIMARY KEY,
	tipo_comprobante VARCHAR(50)
);

INSERT INTO Comprobante_Pago (tipo_comprobante)
VALUES ('Factura'),
       ('Recibo'),
       ('Nota de crédito'),
       ('Nota de débito'),
       ('Boleta');

/* Pago_Servicio */
CREATE TABLE Pago_Servicio (
	id_pago_servicio INT AUTO_INCREMENT PRIMARY KEY,
	id_servicio INT REFERENCES Servicio(id_servicio),
	id_comprobante INT REFERENCES Comprobante_Pago(id_comprobante),
	id_metodo INT REFERENCES Metodo_Pago(id_metodo),
);

INSERT INTO Pago_Servicio (id_servicio, id_comprobante, id_metodo, pago_total_servicio)
VALUES
    (7, 2, 3, 80.00),
    (3, 1, 4, 200.00),
    (1, 5, 2, 150.00),
    (11, 4, 5, 1500.00),
    (6, 3, 1, 250.00),
    (12, 2, 5, 70.00),
    (9, 1, 4, 200.00),
    (3, 3, 2, 120.00),
    (15, 5, 1, 40.00),
    (5, 2, 3, 1200.00),
    (9, 1, 2, 200.00),
    (4, 5, 4, 300.00),
    (2, 4, 1, 1200.00),
    (7, 3, 5, 70.00),
    (8, 2, 1, 300.00),
    (11, 1, 3, 1500.00),
    (10, 5, 4, 180.00),
    (1, 4, 5, 100.00),
    (15, 3, 1, 40.00),
    (12, 2, 2, 70.00),
    (6, 1, 3, 250.00),
    (13, 5, 4, 600.00),
    (5, 4, 5, 1200.00),
    (8, 3, 1, 300.00),
    (9, 2, 2, 200.00);