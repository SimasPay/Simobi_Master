package com.mfino.handset.subscriber.ui.youraccount.cashout;

import com.mfino.handset.subscriber.constants.Constants;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

import com.mfino.handset.subscriber.ui.AbstractMfinoConfig;
import com.mfino.handset.subscriber.datacontainers.UserDataContainer;

/**
 * @author sasidhar
 */
public class MYMCashoutFromPocket1 extends AbstractMfinoConfig implements CommandListener {

    private Displayable parent;
    private Display display;
    private Form fromPocketForm;
    private ChoiceGroup choiceGroup;
    private static final String E_MONEY = Constants.CONSTANT_EMONEY;
    private static final String BANK = Constants.CONSTANT_BANK;
    private static final String[] yourAccountMenu = {E_MONEY, BANK};

    public MYMCashoutFromPocket1(UserDataContainer mFinoConfigData, Displayable parent) {
        super(mFinoConfigData);
        this.parent = parent;
        display = Display.getDisplay(mFinoConfigData.getMobileBankingMidlet());

        fromPocketForm = new Form("Select account type");
        choiceGroup = new ChoiceGroup("Select one", Choice.EXCLUSIVE, yourAccountMenu, null);
        fromPocketForm.append(choiceGroup);
        fromPocketForm.addCommand(mFinoConfigData.backCommand);
        fromPocketForm.addCommand(mFinoConfigData.nextCommand);
        fromPocketForm.setCommandListener(this);
        display.setCurrent(fromPocketForm);
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == super.mFinoConfigData.backCommand) {
            display.setCurrent(parent);
        } else if (command == super.mFinoConfigData.nextCommand) {
            String name = choiceGroup.getString(choiceGroup.getSelectedIndex());
            if(E_MONEY.equals(name))
                mFinoConfigData.setSourcePocketCode(Constants.POCKET_CODE_EMONEY);
            else if(BANK.equals(name))
                mFinoConfigData.setSourcePocketCode(Constants.POCKET_CODE_BANK);
            new MYMAgentCodeForm2(mFinoConfigData, parent);
        } else if (command == super.mFinoConfigData.exitCommand) {
            mFinoConfigData.getMobileBankingMidlet().destroyApp(true);
            mFinoConfigData.getMobileBankingMidlet().notifyDestroyed();
        }
    }
}
