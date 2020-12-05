/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author joshu
 */
public class EditTaskForm extends javax.swing.JFrame {

    /**
     * Creates new form EditTaskForm
     */
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

    private String newName; //set
    private ArrayList<String> subsequentTaskArrayList = new ArrayList<>(); //set
    private Team newTeam; //set
    private int newTaskLength; //set
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
        //subsequentTaskArrayList = selectedTask.getSubsequentTasks();
        updateTaskInfo();
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

        currentSubsequentTaskList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        projectTaskList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        teamList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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




    public void updateTaskInfo(){ //updates the information of the currently selected task
        allTasks.clear();
        for(String projectTaskName : selectedProject.getTaskNames()){
            allTasks.add(projectTaskName);
        }
        allTasks.remove(selectedTask.getName());
        allTasks.removeAll(subsequentTaskArrayList);
        /*for(var i=0;i<allTasks.size();i++){
            for(String subTaskName : selectedTask.getSubsequentTasks()){
                if(allTasks.get(i).equals(subTaskName)){
                   allTasks.remove(i);
                }
            }
        }*/
        //allTasks.removeAll(selectedTask.getSubsequentTasks());
        if(!selectedProject.getTaskNames().isEmpty()) {
            //if(allTasks.isEmpty()){
                //System.out.println("alltasks is empty");
                //projectTaskList.removeAllItems();
            //}else {
                projectTaskList.setModel(new javax.swing.DefaultComboBoxModel(allTasks.toArray(new String[0])));
            //}
        }
        if(!selectedTask.getSubsequentTasks().isEmpty()){
            System.out.println("subsequentTaskArrayList"+subsequentTaskArrayList);
            //if(subsequentTaskArrayList.isEmpty()){
              //  System.out.println("subsequentTaskArrayList empty");
              //  currentSubsequentTaskList.removeAllItems();
            //} else {
                currentSubsequentTaskList.setModel(new javax.swing.DefaultComboBoxModel(subsequentTaskArrayList.toArray(new String[0])));
            //}
        }


        newTaskLength = selectedTask.getTimeFrame();

        newName = selectedTask.getName();
        /*for(Team team : Team.Companion.getMasterList()){
            if(teamList.getSelectedItem().toString().equals(team.getName())){
                newTeam = team;
            }
        }*/

        //projectCompletionLabel.setText("Tasks for " + selectedProject.getName() + " completed: " + tasksCompleted + " out of " + tasksTotal + " (" + df.format(completionRate) + "%)");

    }
    private void removeSubsequentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Object selectedItem = currentSubsequentTaskList.getSelectedItem();
        if(selectedItem == null){return;}
        subsequentTaskArrayList.remove(selectedItem.toString());
        updateTaskInfo();
        System.out.println(subsequentTaskArrayList);
    }

    private void addAsSubsequentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Object selectedItem = projectTaskList.getSelectedItem();
        if(selectedItem == null){return;}
        subsequentTaskArrayList.add(selectedItem.toString());
        updateTaskInfo();
        System.out.println(subsequentTaskArrayList);
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
        selectedTask.setTimeFrame(Integer.parseInt(newLengthField.getText()));
        selectedTask.setSubsequentTasks(subsequentTaskArrayList);

        selectedProject.updateMasterList();
        callerForm.updateTaskInfo();
        this.dispose();
    }

}
