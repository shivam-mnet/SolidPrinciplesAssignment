package net.media.training.designpattern.abstractfactory;

public abstract class PhoneFactory {

    abstract public Case getCase();

    abstract public MotherBoard getMotherBoard();

    abstract public Screen getScreen();

    abstract public Processor getProcessor();

    protected Battery getBattery() {
        return new Battery();
    }
}
