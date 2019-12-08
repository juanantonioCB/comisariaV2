/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanantonio.comisariav2.controller;

import com.juanantonio.comisariav2.model.DAO.SuspectDAO;
import com.juanantonio.comisariav2.model.Email;
import com.juanantonio.comisariav2.model.LicensePlate;
import com.juanantonio.comisariav2.model.PhoneNumber;
import com.juanantonio.comisariav2.model.Residencie;
import com.juanantonio.comisariav2.model.Suspect;
import com.juanantonio.comisariav2.view.GUIEditSuspect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

/**
 *
 * @author Juan Antonio
 */
public class CtrlGUIEditSuspect implements ActionListener {

    GUIEditSuspect gui;
    Long id;
    SuspectDAO suspectDao;

    DefaultListModel modelEmails = new DefaultListModel<>();
    DefaultListModel modelLicensePlates = new DefaultListModel<>();
    DefaultListModel modelResidencies = new DefaultListModel<>();
    DefaultListModel modelPhoneNumbers = new DefaultListModel<>();
    DefaultListModel companionsModel = new DefaultListModel();
    DefaultListModel companionsAddModel = new DefaultListModel();

    public CtrlGUIEditSuspect(GUIEditSuspect gui, Long id) {
        this.gui = gui;
        this.id = id;
        gui.addEmailButton.addActionListener(this);
        gui.addLicensePlateButton.addActionListener(this);
        gui.addPhoneNumberButton.addActionListener(this);
        gui.addResidencieButton.addActionListener(this);
        gui.deleteEmailButton.addActionListener(this);
        gui.deleteLicensePlateButton.addActionListener(this);
        gui.deletePhoneNumberButton.addActionListener(this);
        gui.deleteResidencieButton.addActionListener(this);
        gui.saveSuspectButton.addActionListener(this);
        gui.addCompanionButton.addActionListener(this);
        gui.reloadCompanionsButton.addActionListener(this);
        gui.removeCompanionsButton.addActionListener(this);
        gui.emailsList.setModel(modelEmails);
        gui.licensePlatesList.setModel(modelLicensePlates);
        gui.phoneNumbersList.setModel(modelPhoneNumbers);
        gui.residenciesList.setModel(modelResidencies);
        gui.companionsList.setModel(companionsModel);
        gui.companionsAddList.setModel(companionsAddModel);
        suspectDao = new SuspectDAO();
        loadSuspect(id);
    }

    private void loadSuspect(Long id) {
        Suspect s = suspectDao.getOneSuspect(id);
        gui.nameTextField.setText(s.getName());
        gui.surname1TextField.setText(s.getSurname1());
        gui.surname2TextField.setText(s.getSurname2());
        gui.dniTextField.setText(s.getDni());
        gui.factsTextArea.setText(s.getFacts());
        gui.recordsTextArea.setText(s.getRecords());
        for (Email email : s.getEmails()) {
            modelEmails.addElement(email);
        }
        for (LicensePlate licensePlate : s.getLicensePlates()) {
            modelLicensePlates.addElement(licensePlate);
        }
        for (PhoneNumber phoneNumber : s.getPhoneNumbers()) {
            modelPhoneNumbers.addElement(phoneNumber);
        }
        for (Residencie residencies : s.getResidencies()) {
            modelResidencies.addElement(residencies);
        }
        for (Suspect companions : s.getCompanions()) {
            companionsAddModel.addElement(companions);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.reloadCompanionsButton) {
            //loadCompanions();            
        }
        if (e.getSource() == gui.removeCompanionsButton) {
            if (gui.companionsAddList.getSelectedIndex() != -1) {
                companionsModel.addElement(companionsAddModel.getElementAt(gui.companionsAddList.getSelectedIndex()));
                companionsAddModel.removeElementAt(gui.companionsAddList.getSelectedIndex());
            }
        }
        if (e.getSource() == gui.addCompanionButton) {
            if (gui.companionsList.getSelectedIndex() != -1) {
                companionsAddModel.addElement(companionsModel.getElementAt(gui.companionsList.getSelectedIndex()));
                companionsModel.removeElementAt(gui.companionsList.getSelectedIndex());
            }

        }
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

        }
    }

}
