package com.juanantonio.comisariav2.controller;

import com.juanantonio.comisariav2.model.DAO.SuspectDAO;
import com.juanantonio.comisariav2.model.Email;
import com.juanantonio.comisariav2.model.LicensePlate;
import com.juanantonio.comisariav2.model.PhoneNumber;
import com.juanantonio.comisariav2.model.Residencie;
import com.juanantonio.comisariav2.model.Suspect;
import com.juanantonio.comisariav2.view.GUIAddSuspect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Juan Antonio
 */
public class CtrlGUIAddSuspect implements ActionListener {

    GUIAddSuspect gui = null;
    SuspectDAO suspectDao = null;
    DefaultListModel<String> modelResidencies = new DefaultListModel<>();
    DefaultListModel<String> modelEmails = new DefaultListModel<>();
    DefaultListModel<String> modelLicensePlates = new DefaultListModel<>();
    DefaultListModel<String> modelPhoneNumbers = new DefaultListModel<>();

    public CtrlGUIAddSuspect(GUIAddSuspect gui) {
        this.gui = gui;
        suspectDao = new SuspectDAO();
        gui.addEmailButton.addActionListener(this);
        gui.addLicensePlateButton.addActionListener(this);
        gui.addPhoneNumberButton.addActionListener(this);
        gui.addResidencieButton.addActionListener(this);
        gui.deleteEmailButton.addActionListener(this);
        gui.deleteLicensePlateButton.addActionListener(this);
        gui.deletePhoneNumberButton.addActionListener(this);
        gui.deleteResidencieButton.addActionListener(this);
        gui.saveSuspectButton.addActionListener(this);

        gui.residenciesList.setModel(modelResidencies);
        gui.emailsList.setModel(modelEmails);
        gui.phoneNumbersList.setModel(modelPhoneNumbers);
        gui.licensePlatesList.setModel(modelLicensePlates);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.addResidencieButton) {
            if (!gui.residenciesTextArea.getText().equals("")) {
                modelResidencies.addElement(gui.residenciesTextArea.getText());
                gui.residenciesTextArea.setText(null);
            }
        }

        if (e.getSource() == gui.addPhoneNumberButton) {
            if (!gui.phoneNumberTextArea.getText().equals("")) {
                modelPhoneNumbers.addElement(gui.phoneNumberTextArea.getText());
                gui.phoneNumberTextArea.setText(null);
            }
        }

        if (e.getSource() == gui.addEmailButton) {
            if (!gui.emailTextField.getText().equals("")) {
                modelEmails.addElement(gui.emailTextField.getText());
                gui.emailTextField.setText(null);
            }
        }

        if (e.getSource() == gui.addLicensePlateButton) {
            if (!gui.licensePlateTextField.getText().equals("")) {
                modelLicensePlates.addElement(gui.licensePlateTextField.getText());
                gui.licensePlateTextField.setText(null);
            }
        }

        if (e.getSource() == gui.deleteResidencieButton) {
            if (gui.residenciesList.getSelectedIndex() != -1) {
                modelResidencies.removeElementAt(gui.residenciesList.getSelectedIndex());
            }
        }

        if (e.getSource() == gui.deleteEmailButton) {
            if (gui.emailsList.getSelectedIndex() != -1) {
                modelEmails.removeElementAt(gui.emailsList.getSelectedIndex());
            }
        }

        if (e.getSource() == gui.deletePhoneNumberButton) {
            if (gui.phoneNumbersList.getSelectedIndex() != -1) {
                modelPhoneNumbers.removeElementAt(gui.phoneNumbersList.getSelectedIndex());
            }
        }

        if (e.getSource() == gui.deleteLicensePlateButton) {
            if (gui.licensePlatesList.getSelectedIndex() != -1) {
                modelLicensePlates.removeElementAt(gui.licensePlatesList.getSelectedIndex());
            }
        }

        if (e.getSource() == gui.saveSuspectButton) {
            saveSuspect();
        }

    }

    private void saveSuspect() {
        Suspect s = new Suspect(gui.nameTextField.getText(), gui.surname1TextField.getText(),
                gui.surname2TextField.getText(), gui.dniTextField.getText(),
                gui.recordsTextArea.getText(), gui.factsTextArea.getText());
        if (gui.phoneNumbersList.getModel().getSize() > 0) {
            List<PhoneNumber> p = new ArrayList<>();
            for (int i = 0; i < gui.phoneNumbersList.getModel().getSize(); i++) {
                p.add(new PhoneNumber(gui.phoneNumbersList.getModel().getElementAt(i), s));
            }
            s.setPhoneNumbers(p);
        }
        if (gui.emailsList.getModel().getSize() > 0) {
            List<Email> e = new ArrayList<>();
            for (int i = 0; i < gui.emailsList.getModel().getSize(); i++) {
                e.add(new Email(gui.emailsList.getModel().getElementAt(i), s));
            }
            s.setEmails(e);
        }
        if (gui.licensePlatesList.getModel().getSize() > 0) {
            List<LicensePlate> l = new ArrayList<>();
            for (int i = 0; i < gui.licensePlatesList.getModel().getSize(); i++) {
                l.add(new LicensePlate(gui.licensePlatesList.getModel().getElementAt(i), s));
            }
            s.setLicensePlates(l);
        }
        if (gui.residenciesList.getModel().getSize() > 0) {
            List<Residencie> r = new ArrayList<>();
            for (int i = 0; i < gui.residenciesList.getModel().getSize(); i++) {
                r.add(new Residencie(gui.residenciesList.getModel().getElementAt(i), s));
            }
            s.setResidencies(r);
        }
        suspectDao.insert(s);
    }
}
