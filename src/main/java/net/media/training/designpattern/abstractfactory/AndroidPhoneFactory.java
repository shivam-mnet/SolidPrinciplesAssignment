package net.media.training.designpattern.abstractfactory;

public class AndroidPhoneFactory extends PhoneFactory {

    @Override
    public Case getCase() {
        return new AndroidCase();
    }

    @Override
    public MotherBoard getMotherBoard() {
        return new AndroidMotherBoard();
    }

    @Override
    public Screen getScreen() {
        return new AndroidScreen();
    }

    @Override
    public Processor getProcessor() {
        return new AndroidProcessor();
    }
}
