package Models;

import java.util.Date;

public class MemberModel {
    public int MemberID;
    public String FName;
    public String LName;
    public String Address;
    public String PhoneNumber;
    public String Email;
    public Date MembershipStartDt;
    public String MembershipStatus;

    public MemberModel(int memberID, String fName, String lName, String address, String phoneNumber, String email,
            Date membershipStartDt, String membershipStatus) {
        this.MemberID = memberID;
        this.FName = fName;
        this.LName = lName;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
        this.MembershipStartDt = membershipStartDt;
        this.MembershipStatus = membershipStatus;
    }

    public MemberModel() { }
}
