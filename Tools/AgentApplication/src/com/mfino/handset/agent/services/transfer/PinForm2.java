/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfino.handset.agent.services.transfer;

import com.mfino.handset.agent.services.listeners.IResponseListener;
import com.mfino.handset.agent.services.TransactionResultForm;
import com.mfino.handset.agent.constants.Constants;
import com.mfino.handset.agent.util.StringUtil;
import com.mfino.handset.agent.widgets.CustomDialogs;
import com.mfino.handset.agent.http.HttpExecutorThread;
import com.mfino.handset.agent.datacontainers.ResponseDataContainer;
import com.mfino.handset.agent.datacontainers.AgentDataContainer;
import com.mfino.handset.agent.widgets.CustomLabel;
import com.mfino.handset.agent.widgets.CustomTextField;
import com.mfino.handset.agent.widgets.CustomizedForm;
import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BoxLayout;

/**
 *
 * @author karthik
 */
public class PinForm2 extends CustomizedForm implements ActionListener, IResponseListener {

    AgentDataContainer userAppData;
    CustomTextField tfSourcePin;

    public PinForm2(AgentDataContainer mcd) {
        this.getStyle().setBgColor(Constants.COLOUR_GRAY);
        this.userAppData = mcd;

        this.previousForm = userAppData.getPreviousForm();

        CustomLabel lblSourcePin = new CustomLabel("Pin");

        tfSourcePin = new CustomTextField(CustomTextField.PASSWORD);

        Command cmd1 = new Command("Back", 2);
        Command cmd2 = new Command("OK", 1);
        this.addCommand(cmd2);
        this.addCommand(cmd1);
        this.addCommandListener(this);

        BoxLayout layout = new BoxLayout(BoxLayout.Y_AXIS);
        this.setLayout(layout);

        this.addComponent(lblSourcePin);
        this.addComponent(tfSourcePin);

        this.setTitle("Deatils");
        this.getTitleStyle().setBgColor(Constants.COLOUR_GRAY);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getCommand().getId() == 1) {

            if (StringUtil.isBlank(tfSourcePin.getText())) {
                Dialog d = CustomDialogs.createInvalidValueEnteredDialog(this);
                d.show();
                return;
            }
            userAppData.setPreviousForm(this);
            userAppData.setSourcePin(tfSourcePin.getText());

            HttpExecutorThread thread = new HttpExecutorThread(userAppData, this);
            thread.start();
            return;

        } else if (ae.getCommand().getId() == 2) {
            if (this.previousForm == null) {
                this.previousForm = new TransferServices1(userAppData);
            }
            this.previousForm.show();
        }
    }

    public void responseReceived(ResponseDataContainer rd) {

        if (rd == null) {
            Dialog d = CustomDialogs.createInvalidResponseDailog(previousForm);
            d.show();
            return;
        }

        if (!rd.getMsgCode().equals(Constants.NOTIFICATIONCODE_INQUIRY_SUCCESS)) {
            TransactionResultForm form = new TransactionResultForm(userAppData, rd);
            form.show();
            return;
        }
        userAppData.setTransactioncharges(rd.getTransactionCharges());
        userAppData.setTransferId(rd.getTransferId());
        userAppData.setDebitAmount(rd.getDebitAmount());
        userAppData.setCreditAmount(rd.getCreditAmount());
        userAppData.setParentTxnId(rd.getParentTxnId());
        TransferConfirmationForm3 form = new TransferConfirmationForm3(userAppData);
        form.show();
    }
}
