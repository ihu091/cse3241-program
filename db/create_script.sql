CREATE TABLE MEMBERS (
    MemberID INT NOT NULL,
    FName VARCHAR(100) NOT NULL,
    LName VARCHAR(100) NOT NULL,
    Address VARCHAR(200),
    PhoneNumber VARCHAR(20),
    Email VARCHAR(255),
    MembershipStartDt DATE NOT NULL,
    MemberStatus VARCHAR(20) NOT NULL,
    PRIMARY KEY (MemberID)
);

CREATE TABLE RENTALS (
    RentalID INT NOT NULL,
    ItemID INT NOT NULL,
    MemberID INT NOT NULL,
    DeliveryID INT NOT NULL,
    StartDt DATE NOT NULL,
    EndDt DATE NOT NULL,
    Fee DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY(RentalID)
);

CREATE TABLE INVENTORY (
    ItemID INT NOT NULL,
    Name VARCHAR(100) NOT NULL,
    Size VARCHAR(10) NOT NULL,
    Color VARCHAR(10),
    WarehouseID INT,
    ManufacturerID INT,
    PRIMARY KEY (ItemID)
);

CREATE TABLE WAREHOUSE (
    WarehouseID INT NOT NULL,
    Address VARCHAR(200),
    City VARCHAR(60),
    MaxCapacity VARCHAR(20),
    PRIMARY KEY (WarehouseID)
);

CREATE TABLE MANUFACTURER (
    ManufacturerID INT,
    Name VARCHAR(100),
    Address VARCHAR(200),
    City VARCHAR(60),
    PRIMARY KEY (ManufacturerID)
);

CREATE TABLE PAYMENTS (
    PaymentID INT,
    MemberID INT,
    RentalID INT,
    DateTime DATETIME,
    Amount DECIMAL(10, 2),
    Method VARCHAR(20),
    Status VARCHAR(10),
    PRIMARY KEY (PaymentID)
);

CREATE TABLE DRONES (
    DroneID INT,
    Model VARCHAR(20),
    Status VARCHAR(10),
    BatteryLife DECIMAL(3, 2),
    Capacity VARCHAR(20),
    PRIMARY KEY (DroneID)
);

CREATE TABLE DRONE_MAINTENANCE (
    MaintenanceID INT,
    DroneID INT,
    Date DATE,
    Type VARCHAR(20),
    Cost DECIMAL(10, 2),
    PRIMARY KEY (MaintenanceID)
);

CREATE TABLE SHIPMENTS (
    DeliveryID INT,
    EstDeliveryDt DATE,
    Status VARCHAR(10),
    Address VARCHAR(200),
    DroneID INT,
    Type VARCHAR(20),
    PRIMARY KEY (DeliveryID)
);

CREATE TABLE RENTAL_REVIEWS (
    ReviewID INT,
    MemberID INT,
    RentalID INT,
    Date DATE,
    Rating INT,
    Comments VARCHAR(500),
    PRIMARY KEY (ReviewID)
);

CREATE TABLE EQUIPMENT_REVIEWS (
    ReviewID INT,
    MemberID INT,
    EquipmentID INT,
    Date DATE,
    Rating INT,
    Comments VARCHAR(500),
    PRIMARY KEY (ReviewID)
);