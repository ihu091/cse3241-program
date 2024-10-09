package Models;

import java.sql.Date;

public class InventoryModel {
    public int RentalID;
    public int ItemID;
    public int MemberID;
    public int DeliveryID;
    public Date StartDt;
    public Date EndDt;
    public double Fee;

    public InventoryModel(int rentalID, int itemID, int memberID, int deliveryID, Date startDt, Date endDt,
            double fee) {
        this.RentalID = rentalID;
        this.ItemID = itemID;
        this.MemberID = memberID;
        this.DeliveryID = deliveryID;
        this.StartDt = startDt;
        this.EndDt = endDt;
        this.Fee = fee;
    }
}
