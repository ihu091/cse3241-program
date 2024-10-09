package Models;

public class InventoryModel {
    public int ItemID;
    public String Name;
    public String Size;
    public String Color;
    public int WarehouseID;
    public int ManufacturerID;

    public InventoryModel(int itemID, String name, String size, String color, int warehouseID, int manufacturerID) {
        this.ItemID = itemID;
        this.Name = name;
        this.Size = size;
        this.Color = color;
        this.WarehouseID = warehouseID;
        this.ManufacturerID = manufacturerID;
    }

    public InventoryModel() { }
}
