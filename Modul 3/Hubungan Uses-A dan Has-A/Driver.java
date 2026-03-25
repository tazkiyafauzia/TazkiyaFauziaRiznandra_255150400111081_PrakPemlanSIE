public class Driver {
    private Car car;

    public Driver() {
        System.out.println("Driver is created.");
        this.car = new Car();
    }

    public void driving() {
        System.out.println("Driver is driving.");
        Car coupe = new Car();
        System.out.println("Using a car that has " + coupe.numWheel + " wheels.");
    }
}
