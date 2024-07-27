package net.media.training.designpattern.abstractfactory;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 6:34:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneMaker {
    PhoneFactory AndroidPhoneFactory = new AndroidPhoneFactory();
    PhoneFactory IphonePhoneFactory = new IphonePhoneFactory();

    public Case buildPhone(String phoneType) {
        PhoneFactory phoneFactory;

        if (phoneType.equalsIgnoreCase("Android")) {
            phoneFactory = AndroidPhoneFactory;
        } else {
            phoneFactory = IphonePhoneFactory;
        }

        Case phone = phoneFactory.getCase();

        MotherBoard motherBoard = phoneFactory.getMotherBoard();
        motherBoard.attachBattery(phoneFactory.getBattery());
        motherBoard.attachProcessor(phoneFactory.getProcessor());

        phone.attachMotherBoard(phoneFactory.getMotherBoard());
        phone.attachScreen(phoneFactory.getScreen());

        return phone;
    }
}
