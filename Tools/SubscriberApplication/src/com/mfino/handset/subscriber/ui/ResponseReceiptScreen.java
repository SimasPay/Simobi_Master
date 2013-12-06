package com.mfino.handset.subscriber.ui;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;

import com.mfino.handset.subscriber.datacontainers.UserDataContainer;

/**
 * @author sasidhar
 *
 */
public class ResponseReceiptScreen extends AbstractMfinoConfig implements CommandListener {

    private Displayable parent;
    private Display display;
    private Form topUpReceiptForm;
    private StringItem stringItem;

    public ResponseReceiptScreen(UserDataContainer mFinoConfigData, Displayable parent, String receiptMessage) {
        super(mFinoConfigData);
        this.parent = parent;
        display = Display.getDisplay(mFinoConfigData.getMobileBankingMidlet());
        stringItem = new StringItem("", "");
        stringItem.setText(receiptMessage);
        topUpReceiptForm = new Form("Receipt");
        topUpReceiptForm.append(stringItem);
        topUpReceiptForm.addCommand(mFinoConfigData.exitCommand);
        topUpReceiptForm.addCommand(mFinoConfigData.menuCommand);
        topUpReceiptForm.setCommandListener(this);
        display.setCurrent(topUpReceiptForm);
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == super.mFinoConfigData.backCommand) {
            display.setCurrent(parent);
        } else if (command == super.mFinoConfigData.menuCommand) {
//            System.out.println("TopUpReceiptScreen****menuCommand");
            display.setCurrent(mFinoConfigData.getMobileBankingMenuDisplay());
        } else if (command == super.mFinoConfigData.exitCommand) {
            mFinoConfigData.setAESKey(null);
            mFinoConfigData.setSourcePin(null);
            mFinoConfigData.setSourceMdn(null);
            mFinoConfigData.getMobileBankingMidlet().startApp();
        }
    }
}
