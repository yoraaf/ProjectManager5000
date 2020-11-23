/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 *
 * @author joshu
 */
public class CreateTaskForm extends javax.swing.JFrame {

    /**
     * Creates new form CreateTaskForm
     */
    private Project selectedProject;
    public CreateTaskForm() {
        super("Create task");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        setVisible(true);
    }
    public CreateTaskForm(Project selectedProject) {
        super("Create task for "+selectedProject.getName());
        this.selectedProject = selectedProject;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        selectTeamLabel = new javax.swing.JLabel();
        estimatedLengthLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        previousTasksField = new javax.swing.JTextArea();
        previousTaskList = new javax.swing.JComboBox<>();
        selectPreviousTaskLabel = new javax.swing.JLabel();
        addPreviousTaskButton = new javax.swing.JButton();
        confirmTaskButton = new javax.swing.JButton();
        estimatedTimeField = new javax.swing.JTextField();
        selectTeamList = new javax.swing.JComboBox<>();
        taskTitleLabel = new javax.swing.JLabel();
        taskTitleField = new javax.swing.JTextField();



        selectTeamLabel.setText("Select Team");
        previousTasksField.setEditable(false);


        estimatedLengthLabel.setText("Estimated Length (hours):");

        previousTasksField.setColumns(20);
        previousTasksField.setRows(5);
        jScrollPane2.setViewportView(previousTasksField);

        updateTaskList();
        previousTaskList.addActionListener(evt -> previousTaskListActionPerformed(evt));

        selectPreviousTaskLabel.setText("Select Previous Tasks");

        addPreviousTaskButton.setText("Add as previous Task");
        addPreviousTaskButton.addActionListener(evt -> addPreviousTaskButtonActionPerformed(evt));

        confirmTaskButton.setText("Confirm Task");
        confirmTaskButton.addActionListener(evt -> confirmTaskButtonActionPerformed(evt));

        estimatedTimeField.setText("jTextField2");
        estimatedTimeField.addActionListener(evt -> estimatedTimeFieldActionPerformed(evt));

        updateTeamList();
        selectTeamList.addActionListener(evt -> selectTeamListActionPerformed(evt));

        taskTitleLabel.setText("Task Title");

        taskTitleField.setText("jTextField1");
        taskTitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskTitleFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(taskTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectTeamLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(estimatedLengthLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(confirmTaskButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(previousTaskList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectPreviousTaskLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addPreviousTaskButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                                        .addComponent(estimatedTimeField)
                                        .addComponent(selectTeamList, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(taskTitleField))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(taskTitleLabel)
                                        .addComponent(taskTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(selectTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectTeamList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(estimatedLengthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(estimatedTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(selectPreviousTaskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(previousTaskList, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(addPreviousTaskButton)
                                                .addGap(23, 23, 23)
                                                .addComponent(confirmTaskButton))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>
    public void updateTeamList(){
        selectTeamList.setModel(new javax.swing.DefaultComboBoxModel<>(Team.Companion.getNames().toArray(new String[0])));
    }
    public void updateTaskList(){
        previousTaskList.setModel(new javax.swing.DefaultComboBoxModel<>(Task.Companion.getNames().toArray(new String[0])));
    }
    private void addPreviousTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void selectTeamListActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void estimatedTimeFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void previousTaskListActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void confirmTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String title = taskTitleField.getText();
        Team selectedTeam = null;
        int duration = -1;
        for(Team team:Team.Companion.getMasterList()){
            if(team.getName().equals(selectTeamList.getSelectedItem().toString())){
                selectedTeam = team;
                break;
            }
        }
        try{
            duration = Integer.parseInt(estimatedTimeField.getText());
            if(duration<0){
                throw new NumberFormatException();
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a positive integer", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(selectedTeam == null){
            JOptionPane.showMessageDialog(null, "Please add a team", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(title.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter a title", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Task newTask = new Task(title, selectedTeam, duration);
        selectedProject.addTask(newTask);
        System.out.println("Tasks for this project "+selectedProject.getTasks());
    }

    private void taskTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateTaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateTaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateTaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateTaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTaskForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton addPreviousTaskButton;
    private javax.swing.JButton confirmTaskButton;
    private javax.swing.JLabel estimatedLengthLabel;
    private javax.swing.JTextField estimatedTimeField;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> previousTaskList;
    private javax.swing.JTextArea previousTasksField;
    private javax.swing.JLabel selectPreviousTaskLabel;
    private javax.swing.JLabel selectTeamLabel;
    private javax.swing.JComboBox<String> selectTeamList;
    private javax.swing.JTextField taskTitleField;
    private javax.swing.JLabel taskTitleLabel;
    // End of variables declaration
}
