package com.juanantonio.comisariav2.controller;

import com.juanantonio.comisariav2.model.DAO.SuspectDAO;
import com.juanantonio.comisariav2.model.Suspect;
import com.juanantonio.comisariav2.view.GUIAddSuspect;
import com.juanantonio.comisariav2.view.GUIEditSuspect;
import com.juanantonio.comisariav2.view.GUIHome;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Antonio
 */
public class CtrlGUIHome implements ActionListener {

    private GUIHome gui = null;
    GUIAddSuspect guiAddSuspect;
    SuspectDAO suspectDao = null;

    public CtrlGUIHome(GUIHome gui) {
        this.gui = gui;
        guiAddSuspect = new GUIAddSuspect();
        gui.addSuspectButton.addActionListener(this);
        gui.deleteSuspectButton.addActionListener(this);
        gui.reloadButton.addActionListener(this);
        gui.searchButton.addActionListener(this);
        gui.searchTextField.addActionListener(this);
        gui.tableSuspects.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    Long id = (Long) gui.tableSuspects.getValueAt(gui.tableSuspects.getSelectedRow(), 0);
                    GUIEditSuspect guiEdit= new GUIEditSuspect(id);
                    guiEdit.setVisible(true);
                }
            }
        });
        suspectDao = new SuspectDAO();
        loadTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.searchTextField) {
            loadTableSearch(gui.searchTextField.getText());
        }
        if (e.getSource() == gui.addSuspectButton) {
            guiAddSuspect.setVisible(true);
        }
        if (e.getSource() == gui.deleteSuspectButton) {
            if (gui.tableSuspects.getSelectedRow() != -1) {
                Long id = (Long) gui.tableSuspects.getValueAt(gui.tableSuspects.getSelectedRow(), 0);
                suspectDao.removeSuspect(id);
                loadTable();
            }
        }
        if (e.getSource() == gui.searchButton) {
            loadTableSearch(gui.searchTextField.getText());
        }
        if (e.getSource() == gui.reloadButton) {
            loadTable();
        }
    }

    private void loadTableSearch(String s) {
        List<Suspect> suspects = suspectDao.getSearchSuspects(s);
        DefaultTableModel model = new DefaultTableModel(new Object[][]{
            {null, null, null, null},},
                new String[]{
                    "ID", "Nombre", "Apellidos", "DNI"
                });
        gui.tableSuspects.setModel(model);
        if (suspects != null) {
            for (int i = 1; i < suspects.size(); i++) {
                model.addRow(new Object[][]{{null, null, null, null}});
            }
            for (int i = 0; i < suspects.size(); i++) {
                gui.tableSuspects.setValueAt(suspects.get(i).getId(), i, 0);
                gui.tableSuspects.setValueAt(suspects.get(i).getName(), i, 1);
                gui.tableSuspects.setValueAt(suspects.get(i).getSurname1() + " " + suspects.get(i).getSurname2(), i, 2);
                gui.tableSuspects.setValueAt(suspects.get(i).getDni(), i, 3);
            }
        }
    }

    private void loadTable() {
        List<Suspect> suspects = suspectDao.getSuspects();
        DefaultTableModel model = new DefaultTableModel(new Object[][]{
            {null, null, null, null},},
                new String[]{
                    "ID", "Nombre", "Apellidos", "DNI"
                });
        gui.tableSuspects.setModel(model);
        if (suspects != null) {
            for (int i = 1; i < suspects.size(); i++) {
                model.addRow(new Object[][]{{null, null, null, null}});
            }
            for (int i = 0; i < suspects.size(); i++) {
                gui.tableSuspects.setValueAt(suspects.get(i).getId(), i, 0);
                gui.tableSuspects.setValueAt(suspects.get(i).getName(), i, 1);
                gui.tableSuspects.setValueAt(suspects.get(i).getSurname1() + " " + suspects.get(i).getSurname2(), i, 2);
                gui.tableSuspects.setValueAt(suspects.get(i).getDni(), i, 3);
            }
        }
    }
}
