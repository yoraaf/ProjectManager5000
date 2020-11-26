/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.util.Arrays;

/**
 * @author Raaf van Nieuwkerk & Joshua Roles
 * Acknowledgements:
 * Used the Swing UI designer in netbeans to generate code for the foundation of GUI
 */

public class TeamForm extends javax.swing.JFrame {

    /**
     * Creates new form TeamForm
     */
    public TeamForm() {
        super("Team Manager");
        try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        setVisible(true);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {


        jTextArea1 = new javax.swing.JTextArea();
        staffList = new javax.swing.JComboBox<>();
        addAsMemberButton = new javax.swing.JButton();
        addAsLeaderButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        teamNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addStaffButton = new javax.swing.JButton();
        selectStaffLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        teamList = new javax.swing.JTextArea();
        clearButton = new javax.swing.JButton();



        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staffList.setModel(new javax.swing.DefaultComboBoxModel<>(Staff.Companion.getNames().toArray(new String[0])));

        addAsMemberButton.setText("Add as Member");
        addAsMemberButton.addActionListener(evt -> addAsMemberButtonActionPerformed(evt));

        addAsLeaderButton.setText("Add as Team Leader");
        addAsLeaderButton.addActionListener(evt -> addAsLeaderButtonActionPerformed(evt));

        finishButton.setText("Finalise Team");
        finishButton.addActionListener(evt -> finishButtonActionPerformed(evt));

        jLabel1.setText("Enter Team Name");

        addStaffButton.setText("Add Staff Member");
        addStaffButton.addActionListener(evt -> addStaffButtonActionPerformed(evt));

        selectStaffLabel.setText("Select Staff Member");

        teamList.setEditable(false);
        teamList.setColumns(20);
        teamList.setRows(5);
        jScrollPane4.setViewportView(teamList);

        clearButton.setText("Clear Team");
        clearButton.addActionListener(evt -> clearButtonActionPerformed(evt));

        teamNameField.setText("TeamName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(staffList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(selectStaffLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(addAsLeaderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(addAsMemberButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(teamNameField)
                                                                .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(addStaffButton, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                                                .addComponent(finishButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(selectStaffLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(staffList, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addAsLeaderButton)
                                        .addComponent(addAsMemberButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(teamNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addStaffButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(finishButton))
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for(Team team : Team.Companion.getMasterList()){
            if (team.getName().equals(teamNameField.getText())){
                JOptionPane.showMessageDialog(null, "Team already exists.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        if(!teamList.getText().contains("(L)")){
            JOptionPane.showMessageDialog(null, "A team must have a leader.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String teamString = teamList.getText();
        String[] teamArray = teamString.split("\n");

        //myTeam.addAll();
        String leader = "";
        for( String member : teamArray){
            if (member.contains("(L)")){
                member = member.substring(0,member.indexOf("(")-1);
                leader = member;
                System.out.println("leader: "+leader);
            }
        }
        Team myTeam = new Team(teamNameField.getText(),leader, Arrays.asList(teamArray));
        System.out.println(Team.Companion.getMasterList().toString());
        String names = "Names: ";
        for(Team team : Team.Companion.getMasterList()){
            names+=team.getName()+" ";
        }
        MainForm.mainObj.updateTeamList();
        System.out.println(names);
        this.dispose();
    }

    private void addAsLeaderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String selectedStaff = staffList.getSelectedItem().toString();
        if(teamList.getText().contains(selectedStaff)){return;}
        String oldText = teamList.getText();
        teamList.setText(oldText+selectedStaff+" (L)\n");
        ((JButton)evt.getSource()).setEnabled(false); //disable button after selecting a leader

    }

    private void addAsMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String teamString = teamList.getText();
        String[] teamArray = teamString.split("\n");
        for(int i = 0; i<teamArray.length; i++){
            String member = teamArray[i];
            if (member.contains("(L)")){
                member = member.substring(0,member.indexOf("(")-1);
                teamArray[i]=member;
            }
        }
        String selectedStaff = staffList.getSelectedItem().toString();
        if(Arrays.asList(teamArray).contains(selectedStaff)){return;}
        String oldText = teamList.getText();
        teamList.setText(oldText+staffList.getSelectedItem().toString()+"\n");
    }

    private void addStaffButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String newStaffName = JOptionPane.showInputDialog("Enter name for staff member");
        if(Staff.Companion.getNames().contains(newStaffName)){
            JOptionPane.showMessageDialog(null, "Name already exists.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if(newStaffName == null){
            return;
        }
        Staff newStaff = new Staff(newStaffName);
        staffList.addItem(newStaff.getName());
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        teamList.setText("");
        addAsLeaderButton.setEnabled(true);
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify
    private javax.swing.JButton addAsLeaderButton;
    private javax.swing.JButton addAsMemberButton;
    private javax.swing.JButton addStaffButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel selectStaffLabel;
    private javax.swing.JComboBox<String> staffList;
    private javax.swing.JTextArea teamList;
    private javax.swing.JTextField teamNameField;
    // End of variables declaration
}
