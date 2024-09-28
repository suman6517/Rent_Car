package oops.rent.car;

public class Customer
{
    private String cusId;
    private String name;

    public Customer(String cusId, String name)
    {
        this.cusId = cusId;
        this.name = name;
    }

    public String getCusId() {
        return cusId;
    }

//    public void setCusId(int cusId) {
//        this.cusId = cusId;
//    }

    public String getName() {
        return name;
    }


}
