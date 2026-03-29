public class NonPlayerChar extends Character{
    public NonPlayerChar(String name) {
        this.name = name;
    }

    @Override
    public void doWork(){
        System.out.println(this.name + " is idle.");
    }
}
