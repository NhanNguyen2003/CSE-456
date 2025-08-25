INSERT INTO equipment_type (equipment_type_id, type_name, description) VALUES
(1, 'Laptop', 'Portable computers used for teaching/research'),
(2, 'Projector', 'Devices used for classroom presentations'),
(3, 'Printer', 'Printers for administrative/student use'),
(4, 'Microscope', 'Lab equipment for biology/medical courses');

INSERT INTO equipment (equipment_id, equipment_type_id, equipment_name, purchase_price, quantity_available, purchase_date) VALUES
('EQ00000001', 1, 'Dell Latitude 5420', 1500.00, 20, NOW()),
('EQ00000002', 1, 'HP ProBook 450 G8', 1350.00, 15, NOW()),
('EQ00000003', 2, 'Epson EB-X06 Projector', 2200.00, 5, NOW()),
('EQ00000004', 2, 'BenQ MW550 Projector', 2500.00, 3, NOW()),
('EQ00000005', 3, 'Canon LBP2900 Printer', 1200.00, 10, NOW()),
('EQ00000006', 4, 'Olympus CX23 Microscope', 5000.00, 7, NOW());

INSERT INTO user (user_id, username, password, role) VALUES
(1, 'admin', 'admin', 1),
(2, 'staff01', 'staff', 2),
(3, 'customer', 'customer', 3);
