public class Crew implements ICrew {
  
  private String name;
  private boolean isAlive = true;

  public Crew(String name) {
    this.name = name;
    this.isAlive = true;
  }
  
  @Override
  public void doWork() {
    System.out.println("Crew " + this.name + " is doing work.");
  }
  
  @Override
  public String getName() {
    return this.name;
  }

  public void setAlive(boolean isAlive) {
    this.isAlive = isAlive;
  }

  public boolean isAlive() {
    return this.isAlive;
  }

  public boolean callMeeting() {
    if(!this.isAlive) {
        System.out.println(this.name + " is dead and cannot call a meeting.");
        System.exit(0);
        return false;
    } else {
        System.out.print(this.name + " found a corpse ");
        System.out.print("and calls a meeting. ");
        System.out.println("Let's find the impostor!");
        return true;
    }
}

@Override
  public void kick() {
    System.out.println(this.name + " has been kicked out of spacecraft!");
  }
  
}
