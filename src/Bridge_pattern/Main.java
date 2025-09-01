package Bridge_pattern;
interface Device {
    void turnOn();
    void turnOff();
}
class TV implements Device{
    @Override
    public void turnOff() {
        System.out.println("TV turnoff");
    }

    @Override
    public void turnOn() {
        System.out.println("TV turnon");
    }
}
class Radio implements Device{
    @Override
    public void turnOff() {
        System.out.println("Radio turnoff");
    }

    @Override
    public void turnOn() {
        System.out.println("Radio turnon");
    }
}

abstract  class remotecontrol{
    protected Device device;
    public remotecontrol(Device device){
        this.device=device;
    }
    abstract  void presson();
    abstract void pressoff();
}
class Basicremote extends remotecontrol{
    public Basicremote(Device device){
        super(device);
    }
    @Override
    public void presson() {
        System.out.println("Basic remote : ");
        device.turnOn();
    }

    @Override
    public void pressoff() {
        System.out.println("Basic remote : ");
        device.turnOff();
    }
}

class Advanceremote extends remotecontrol{
    public Advanceremote(Device device){
        super(device);
    }
    @Override
    public void presson() {
        System.out.println("Advance remote : ");
        device.turnOn();
    }

    @Override
    public void pressoff() {
        System.out.println("Advance remote : ");
        device.turnOff();
    }
    public void mute(){
        System.out.println("Device is muted");
    }
}

public class Main {
    public static void main(String[] args) {
        Device Tv=new TV();
        Device Radio=new Radio();
        remotecontrol remote1=new Basicremote(Tv);
        remotecontrol remote2=new Advanceremote(Radio);
        remote1.presson();
        remote1.pressoff();

        remote2.presson();
        remote2.pressoff();


    }
}

/*

What is Bridge Pattern?
The Bridge Pattern is a Structural Design Pattern that separates abstraction (what to do) from implementation (how to do).
This allows you to vary both independently without changing each other.

👉 In simple words:
Instead of binding abstraction and implementation together in one class, we “bridge” them using composition.



Mapping with Example
Abstraction:
RemoteControl → defines the high-level API (pressOn, pressOff).

Refined Abstraction:
BasicRemote, AdvancedRemote → extend abstraction, add more features (mute).

Implementor:
Device interface → defines low-level actions (turnOn, turnOff).

Concrete Implementor:
TV, Radio → actual implementations of how a device turns on/off.

Bridge (the link):
protected Device device; inside RemoteControl → this "bridges" abstraction and implementation.

Client:
public class BridgePatternExample with main() → creates the objects (BasicRemote tvRemote = new BasicRemote(new TV());) and uses them.
 */
