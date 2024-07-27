package net.media.training.designpattern.abstractfactory;

public class IphonePhoneFactory extends PhoneFactory{

    @Override
    public Case getCase() {
        return new IphoneCase();
    }

    @Override
    public MotherBoard getMotherBoard() {
        return new IphoneMotherBoard();
    }

    @Override
    public Screen getScreen() {
        return new IphoneScreen();
    }

    @Override
    public Processor getProcessor() {
        return new IphoneProcessor();
    }
}
