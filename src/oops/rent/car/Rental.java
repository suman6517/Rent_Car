package oops.rent.car;

public class Rental
{
    private Car car;
    private Customer customer;
    private int rentDays;

    public Rental(Car car, Customer customer, int rentDays)
    {
        this.car = car;
        this.customer = customer;
        this.rentDays = rentDays;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getRentDays() {
        return rentDays;
    }
}
