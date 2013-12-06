/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfino.handset.agent.services.buy.purchase;

import com.mfino.handset.agent.services.listeners.IResponseListener;
import com.mfino.handset.agent.services.TransactionResultForm;
import com.mfino.handset.agent.constants.Constants;
import com.mfino.handset.agent.datacontainers.ResponseDataContainer;
import com.mfino.handset.agent.datacontainers.AgentDataContainer;
import com.mfino.handset.agent.http.HttpExecutorThread;
import com.mfino.handset.agent.widgets.CustomDialogs;
import com.mfino.handset.agent.widgets.CustomizedForm;
import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.plaf.Border;
import com.sun.lwuit.table.TableLayout;

/**
 *
 * @author karthik
 */
public class PurchaseConfirmationForm3 extends CustomizedForm implements ActionListener, IResponseListener {

    private AgentDataContainer userAppData;
//    private Dialog waitingDialog;

    public PurchaseConfirmationForm3(AgentDataContainer mfinoConfigData) {
        this.userAppData = mfinoConfigData;
        this.getStyle().setBgColor(Constants.COLOUR_GRAY);
        this.previousForm = mfinoConfigData.getPreviousForm();

        TableLayout tl = new TableLayout(5, 1);
        this.setLayout(tl);

        Command cmd1 = new Command("Confirm", 1);
        Command cmd2 = new Command("Cancel", 2);

        this.addCommand(cmd1);
        this.addCommand(cmd2);
        this.addCommandListener(this);

        String confirm = "Do you want to purchase\n";
        confirm = confirm + "from Code :" + userAppData.getPartnerCode() + "\n";
        confirm = confirm + "Amount :" + userAppData.getAmount();

        TextArea ta = new TextArea();
        ta.setEditable(false);
        ta.getStyle().setBorder(Border.createEmpty());
        ta.getStyle().setBgColor(Constants.COLOUR_GRAY);
        ta.setFocusable(false);
        ta.getSelectedStyle().setBgColor(Constants.COLOUR_GRAY);
        ta.setText(confirm);

        this.setTitle("Confirmation");
        this.getTitleStyle().setBgColor(Constants.COLOUR_GRAY);

        this.addComponent(ta);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getCommand().getId() == 1) {
//            userAppData.setPreviousForm(this);
            userAppData.setTransactionName(Constants.TRANSACTION_PURCHASE);
            userAppData.setConfirmed(Constants.CONSTANT_VALUE_TRUE);

            HttpExecutorThread executor = new HttpExecutorThread(userAppData, this);
            executor.start();

            return;
        } else if (ae.getCommand().getId() == 2) {
            this.userAppData.getHomePage().show();
        }
    }

    public void responseReceived(ResponseDataContainer rd) {
        if (rd == null) {
            Dialog d = CustomDialogs.createInvalidResponseDailog(previousForm);
            d.show();
            return;
        }
        userAppData.setResultFormTitle("Confirmation");
        TransactionResultForm form = new TransactionResultForm(userAppData, rd);
        form.show();
    }
}
