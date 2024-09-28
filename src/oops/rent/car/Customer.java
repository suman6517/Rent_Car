package oops.rent.car;

public class Customer
{
    private int cusId;
    private String name;
    private int phoneNo;

    public Customer(int cusId, String name, int phoneNo) {
        this.cusId = cusId;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

}
