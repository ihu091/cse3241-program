PRAGMA foreign_keys = off;

BEGIN TRANSACTION;

-- Table: DRONE_MAINTENANCE
CREATE TABLE
    DRONE_MAINTENANCE (
        MaintenanceID INT NOT NULL,
        DroneID INT NOT NULL REFERENCES DRONES (DroneID) ON UPDATE CASCADE,
        Date DATE NOT NULL,
        Type VARCHAR(20) NOT NULL,
        Cost DECIMAL(10, 2) NOT NULL,
        PRIMARY KEY (MaintenanceID)
    );

-- Table: DRONES
CREATE TABLE
    DRONES (
        DroneID INT,
        Model VARCHAR(20) NOT NULL,
        Status VARCHAR(10) NOT NULL,
        BatteryLife DECIMAL(3, 2) NOT NULL,
        WeightCapacity INT NOT NULL,
        VolumeCapacity INT NOT NULL,
        PRIMARY KEY (DroneID)
    );

-- Table: EQUIPMENT_REVIEWS
CREATE TABLE
    EQUIPMENT_REVIEWS (
        ReviewID INT NOT NULL,
        MemberID INT NOT NULL REFERENCES MEMBERS (MemberID) ON UPDATE CASCADE,
        EquipmentID INT REFERENCES INVENTORY (ItemID) ON UPDATE CASCADE NOT NULL,
        Date DATE NOT NULL,
        Rating INT NOT NULL,
        Comments VARCHAR(500),
        PRIMARY KEY (ReviewID)
    );

-- Table: INVENTORY
CREATE TABLE
    INVENTORY (
        ItemID INT NOT NULL,
        Name VARCHAR(100) NOT NULL,
        Type VARCHAR(20) NOT NULL,
        Size VARCHAR(10) NOT NULL,
        Weight INT NOT NULL,
        Color VARCHAR(10),
        Year INT NOT NULL,
        WarehouseID INT REFERENCES WAREHOUSE (WarehouseID) ON UPDATE CASCADE NOT NULL,
        ManufacturerID INT REFERENCES MANUFACTURER (ManufacturerID) ON UPDATE CASCADE NOT NULL,
        PRIMARY KEY (ItemID)
    );

-- Table: MANUFACTURER
CREATE TABLE
    MANUFACTURER (
        ManufacturerID INT NOT NULL,
        Name VARCHAR(100) NOT NULL,
        Address VARCHAR(200) NOT NULL,
        City VARCHAR(60) NOT NULL,
        PRIMARY KEY (ManufacturerID)
    );

-- Table: MEMBERS
CREATE TABLE
    MEMBERS (
        MemberID INT NOT NULL,
        FName VARCHAR(100) NOT NULL,
        LName VARCHAR(100) NOT NULL,
        Address VARCHAR(200) NOT NULL,
        PhoneNumber VARCHAR(20),
        Email VARCHAR(255),
        MembershipStartDt DATE NOT NULL,
        MemberStatus VARCHAR(20) NOT NULL,
        PRIMARY KEY (MemberID)
    );

-- Table: PAYMENTS
CREATE TABLE
    PAYMENTS (
        PaymentID INT NOT NULL,
        MemberID INT REFERENCES MEMBERS (MemberID) ON UPDATE CASCADE NOT NULL,
        RentalID INT REFERENCES RENTALS (RentalID) ON UPDATE CASCADE NOT NULL,
        DateTime DATETIME NOT NULL,
        Amount DECIMAL(10, 2) NOT NULL,
        Method VARCHAR(20) NOT NULL,
        Status VARCHAR(10) NOT NULL,
        PRIMARY KEY (PaymentID)
    );

-- Table: RENTAL_REVIEWS
CREATE TABLE
    RENTAL_REVIEWS (
        ReviewID INT NOT NULL,
        MemberID INT REFERENCES MEMBERS (MemberID) ON UPDATE CASCADE NOT NULL,
        RentalID INT REFERENCES RENTALS (RentalID) ON UPDATE CASCADE NOT NULL,
        Date DATE NOT NULL,
        Rating INT NOT NULL,
        Comments VARCHAR(500),
        PRIMARY KEY (ReviewID)
    );

-- Table: RENTALS
CREATE TABLE
    RENTALS (
        RentalID INT NOT NULL,
        ItemID INT NOT NULL REFERENCES INVENTORY (ItemID) ON UPDATE CASCADE,
        MemberID INT NOT NULL REFERENCES MEMBERS (MemberID) ON UPDATE CASCADE,
        StartDt DATE NOT NULL,
        EndDt DATE NOT NULL,
        Fee DECIMAL(10, 2) NOT NULL,
        PRIMARY KEY (RentalID)
    );

-- Table: SHIPMENTS
CREATE TABLE
    SHIPMENTS (
        DeliveryID INT NOT NULL,
        RentalID INT NOT NULL REFERENCES RENTALS (RentalID) ON UPDATE CASCADE,
        EstDeliveryDt DATE,
        Status VARCHAR(10) NOT NULL,
        Address VARCHAR(200) NOT NULL,
        DroneID INT REFERENCES DRONES (DroneID) ON UPDATE RESTRICT NOT NULL,
        Type VARCHAR(20) NOT NULL,
        Distance INT,
        PRIMARY KEY (DeliveryID)
    );

-- Table: WAREHOUSE
CREATE TABLE
    WAREHOUSE (
        WarehouseID INT NOT NULL,
        Address VARCHAR(200) NOT NULL,
        City VARCHAR(60) NOT NULL,
        MaxCapacity VARCHAR(20) NOT NULL,
        PRIMARY KEY (WarehouseID)
    );

COMMIT TRANSACTION;

PRAGMA foreign_keys = on;