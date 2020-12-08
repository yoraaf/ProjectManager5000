/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Raaf van Nieuwkerk & Joshua Roles
 * Acknowledgements:
 * Used the Swing UI designer in netbeans to generate code for the foundation of GUI
 */

public class EditTaskForm extends javax.swing.JFrame {
    //Creates new form EditTaskForm
    private javax.swing.JComboBox<String> currentSubsequentTaskList;
    private javax.swing.JComboBox<String> projectTaskList;
    private javax.swing.JLabel subsequentTaskLabel;
    private javax.swing.JLabel tasksLabel;
    private javax.swing.JTextField newLengthField;
    private javax.swing.JLabel newLengthLabel;
    private javax.swing.JTextField newNameField;
    private javax.swing.JLabel newNameLabel;
    private javax.swing.JLabel newTeamLabel;
    private javax.swing.JButton removeSubsequentButton;
    private javax.swing.JButton addAsSubsequentButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JComboBox<String> teamList;

    private String newName;
    private ArrayList<String> subsequentTaskArrayList = new ArrayList<>();
    private Team newTeam;
    ArrayList<String> allTasks = new ArrayList<>();

    private Task selectedTask;
    private Project selectedProject;
    private ProjectForm callerForm;

    public EditTaskForm(Project selectedProject, Task selectedTask, ProjectForm callerForm) {
        super("Editing task: "+selectedTask.getName());
        this.selectedProject = selectedProject;
        this.selectedTask = selectedTask;
        this.callerForm = callerForm;
        initComponents();
        setVisible(true);
        newNameField.setText(selectedTask.getName());
        newLengthField.setText(Integer.toString(selectedTask.getTimeFrame()));
        for(String subTaskName : selectedTask.getSubsequentTasks()){
            subsequentTaskArrayList.add(subTaskName);
        }
        newTeam = selectedTask.getAssignedTeam();

        System.out.println("subtasks "+subsequentTaskArrayList);
        teamList.setModel(new javax.swing.DefaultComboBoxModel(Team.Companion.getNames().toArray(new String[0])));
        teamList.setSelectedItem(newTeam);
        updateComboBoxes();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        newTeamLabel = new javax.swing.JLabel();
        newLengthLabel = new javax.swing.JLabel();
        newNameLabel = new javax.swing.JLabel();
        newNameField = new javax.swing.JTextField();
        newLengthField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        currentSubsequentTaskList = new javax.swing.JComboBox<>();
        subsequentTaskLabel = new javax.swing.JLabel();
        removeSubsequentButton = new javax.swing.JButton();
        addAsSubsequentButton = new javax.swing.JButton();
        tasksLabel = new javax.swing.JLabel();
        projectTaskList = new javax.swing.JComboBox<>();
        teamList = new javax.swing.JComboBox<>();


        newTeamLabel.setText("Team");

        newLengthLabel.setText("Task Length");

        newNameLabel.setText("Task Name");

        newNameField.setText("jTextField2");

        newLengthField.setText("jTextField4");

        submitButton.setText("Submit Changes");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        subsequentTaskLabel.setText("Subsequent Tasks");

        removeSubsequentButton.setText("Remove as subsequent task");
        removeSubsequentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSubsequentButtonActionPerformed(evt);
            }
        });

        addAsSubsequentButton.setText("Add as Subsequent Task");
        addAsSubsequentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAsSubsequentButtonActionPerformed(evt);
            }
        });

        tasksLabel.setText("Tasks");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(newTeamLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(newLengthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(newNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(subsequentTaskLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                                        .addComponent(tasksLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(addAsSubsequentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(removeSubsequentButton, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                                        .addComponent(currentSubsequentTaskList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(newNameField)
                                                        .addComponent(newLengthField)
                                                        .addComponent(projectTaskList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(teamList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newNameLabel)
                                        .addComponent(newNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newTeamLabel)
                                        .addComponent(teamList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newLengthLabel)
                                        .addComponent(newLengthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(subsequentTaskLabel)
                                        .addComponent(currentSubsequentTaskList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeSubsequentButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(projectTaskList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tasksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addAsSubsequentButton)
                                .addGap(18, 18, 18)
                                .addComponent(submitButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    public void updateComboBoxes(){ //updates the information of the currently selected task
        allTasks.clear();
        for(String projectTaskName : selectedProject.getTaskNames()){
            allTasks.add(projectTaskName); //reassign tasklist
        }
        allTasks.remove(selectedTask.getName());
        allTasks.removeAll(subsequentTaskArrayList);

        if(!selectedProject.getTaskNames().isEmpty()) {
                projectTaskList.setModel(new javax.swing.DefaultComboBoxModel(allTasks.toArray(new String[0])));
        } //Assigns tasks to all task combo box

        System.out.println("subsequentTaskArrayList"+subsequentTaskArrayList);
        currentSubsequentTaskList.setModel(new javax.swing.DefaultComboBoxModel(subsequentTaskArrayList.toArray(new String[0])));
        //Assigns tasks to subsequent task combo box
    }
    private void removeSubsequentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Object selectedItem = currentSubsequentTaskList.getSelectedItem();
        if(selectedItem == null){return;}
        subsequentTaskArrayList.remove(selectedItem.toString());
        updateComboBoxes();
        System.out.println(subsequentTaskArrayList);
    }

    private void addAsSubsequentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Object selectedItem = projectTaskList.getSelectedItem();
        if(selectedItem == null){return;}
        subsequentTaskArrayList.add(selectedItem.toString());
        updateComboBoxes();
        System.out.println(subsequentTaskArrayList);
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int duration;
        try {
            duration = Integer.parseInt(newLengthField.getText());
            if(duration<0){
                throw new NumberFormatException();
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a positive integer", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Team selectedTeam = null;
        newName = newNameField.getText();
        String oldName = selectedTask.getName();
        for(Team team:Team.Companion.getMasterList()){
            if(team.getName().equals(teamList.getSelectedItem().toString())){
                selectedTeam = team;
                break;
            }
        }
        for(Task task : selectedProject.getTasks()){
            for(var i=0;i< task.getSubsequentTasks().size();i++){
                if(task.getSubsequentTasks().get(i).equals(oldName)){
                    task.getSubsequentTasks().set(i,newName);
                }
            }
        }
        selectedTask.setName(newName);
        selectedTask.setAssignedTeam(selectedTeam);
        selectedTask.setTimeFrame(duration);
        selectedTask.setSubsequentTasks(subsequentTaskArrayList);

        selectedProject.updateMasterList();
        callerForm.updateTaskInfo();
        callerForm.taskList.setSelectedIndex(0);
        callerForm.taskList.setSelectedItem(selectedTask);
        this.dispose();
    }

}
