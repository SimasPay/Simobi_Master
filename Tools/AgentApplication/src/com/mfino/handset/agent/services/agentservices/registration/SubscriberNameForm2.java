/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfino.handset.agent.services.agentservices.registration;

import com.mfino.handset.agent.constants.Constants;
import com.mfino.handset.agent.util.StringUtil;
import com.mfino.handset.agent.widgets.CustomDialogs;
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
public class SubscriberNameForm2 extends CustomizedForm implements ActionListener {

    AgentDataContainer mfinoConfigData;
    CustomTextField tfFirstName;
    CustomTextField tfLastName;

    public SubscriberNameForm2(AgentDataContainer mcd) {
        this.getStyle().setBgColor(Constants.COLOUR_GRAY);
        this.mfinoConfigData = mcd;
        CustomLabel lblFirstname = new CustomLabel("Firstname");
        CustomLabel lblLastName = new CustomLabel("Lastname");
        this.previousForm = mfinoConfigData.getPreviousForm();
        tfFirstName = new CustomTextField();
        tfFirstName.setMaxSize(Constants.FIELD_LENGTH_FIRSTNAME);
        tfLastName = new CustomTextField(Constants.FIELD_LENGTH_LASTNAME);
        tfLastName.setMaxSize(Constants.FIELD_LENGTH_LASTNAME);

        Command cmd1 = new Command("Back", 2);
        Command cmd2 = new Command("OK", 1);
        this.addCommand(cmd2);
        this.addCommand(cmd1);
        this.addCommandListener(this);

        BoxLayout layout = new BoxLayout(BoxLayout.Y_AXIS);
        this.setLayout(layout);

        this.addComponent(lblFirstname);
        this.addComponent(tfFirstName);

        this.addComponent(lblLastName);
        this.addComponent(tfLastName);

        this.setTitle("Deatils");
        this.getTitleStyle().setBgColor(Constants.COLOUR_GRAY);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getCommand().getId() == 1) {
            if (StringUtil.isBlank(tfFirstName.getText()) || StringUtil.isBlank(tfLastName.getText())) {
                Dialog d = CustomDialogs.createInvalidValueEnteredDialog(this);
                d.show();
                return;
            }
            mfinoConfigData.setFirstName(tfFirstName.getText());
            mfinoConfigData.setLastName(tfLastName.getText());
            mfinoConfigData.setPreviousForm(this);
            DOBAppIDForm3 form = new DOBAppIDForm3(mfinoConfigData);
            form.show();
        } else if (ae.getCommand().getId() == 2) {
            if (this.previousForm == null) {
                this.previousForm = new SubscriberMDNForm1(mfinoConfigData);
            }
            this.previousForm.show();
        }
    }
}
