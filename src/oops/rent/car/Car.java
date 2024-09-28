package oops.rent.car;

public class Car
{
    private int carId;
    private String brand;
    private String model;
    private double basePrice;
    private boolean isAvalable;

    public Car(int carId, String brand, String model, double basePrice )
    {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePrice = basePrice;
        this.isAvalable = true;
    }

    public int getCarId() {
        return carId;
    }


    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }

    public boolean isAvalable() {
        return isAvalable;
    }

    public double calculateRent(int rentalDays)
    {
        double totalRent = basePrice *rentalDays;
        return totalRent;
    }
    public void rent()
    {
        isAvalable = false;
    }
    public void returnCar()
    {
        isAvalable = true;
    }

}
