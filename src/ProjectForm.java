/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Raaf van Nieuwkerk & Joshua Roles
 * Acknowledgements:
 * Used the Swing UI designer in netbeans to generate code for the foundation of GUI
 */

public class ProjectForm extends javax.swing.JFrame {

    /**
     * Creates new form ProjectForm
     */
    private Project selectedProject;
    private double tasksCompleted = 0;
    private double tasksTotal = 0;
    public ProjectForm(Project selectedProject) {
        super("Properties of "+ selectedProject.getName());
        this.selectedProject = selectedProject;
        if(selectedProject.getTasks()!= null && selectedProject.getTasks().size()>0) {
            for (Task t : selectedProject.getTasks()) {
                tasksTotal++; //increase for every task in the project
                if (t.getProgress()) {
                    tasksCompleted++; //increase for each completed task
                }
            }
        }
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

        taskList = new javax.swing.JComboBox<>();
        projectCompletionLabel = new javax.swing.JLabel();
        selectTaskLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        criticalPathScalaButton = new javax.swing.JButton();
        criticalPathKotlinButton = new javax.swing.JButton();
        assignedTeamLabel = new javax.swing.JLabel();
        taskLengthLabel = new javax.swing.JLabel();
        toggleCompleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        subsequentTaskField = new javax.swing.JTextArea();
        completedLabel = new javax.swing.JLabel();
        deleteTask = new javax.swing.JButton();
        subsiquentTasksLabel = new javax.swing.JLabel();
        createTaskButton = new javax.swing.JButton();
        taskEditButton = new javax.swing.JButton();


        updateTaskList();
        taskList.addActionListener(evt -> taskListActionPerformed(evt));

        projectCompletionLabel.setText("Tasks for "+selectedProject.getName()+" completed: No tasks yet");

        selectTaskLabel.setText("Select Task");

        subsequentTaskField.setEditable(false);

        criticalPathScalaButton.setText("View Scala Critical Path");
        criticalPathScalaButton.addActionListener(evt -> criticalPathScalaButtonActionPerformed(evt));

        criticalPathKotlinButton.setText("View Kotlin Critical Path");
        criticalPathKotlinButton.addActionListener(evt -> criticalPathKotlinButtonActionPerformed(evt));

        assignedTeamLabel.setText("Assigned team");

        taskLengthLabel.setText("Task length");

        toggleCompleteButton.setText("Toggle Complete");
        toggleCompleteButton.addActionListener(evt -> toggleCompleteButtonActionPerformed(evt));

        subsequentTaskField.setColumns(20);
        subsequentTaskField.setRows(5);
        jScrollPane1.setViewportView(subsequentTaskField);

        completedLabel.setText("Task completion");

        deleteTask.setText("Delete selected Task");
        deleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTaskActionPerformed(evt);
            }
        });

        subsiquentTasksLabel.setText("Subsequent Tasks");

        createTaskButton.setText("Create New Task");
        createTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTaskButtonActionPerformed(evt);
            }
        });

        taskEditButton.setText("Edit Task");
        taskEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskEditButtonActionPerformed(evt);
            }
        });

        updateTaskInfo();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(projectCompletionLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(selectTaskLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(criticalPathScalaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(criticalPathKotlinButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(taskList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(assignedTeamLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                                        .addComponent(subsiquentTasksLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(deleteTask, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                                        .addComponent(createTaskButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(toggleCompleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(taskLengthLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(completedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(1, 1, 1))
                                                        .addComponent(taskEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(projectCompletionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(criticalPathScalaButton)
                                        .addComponent(criticalPathKotlinButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectTaskLabel)
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(taskList, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(taskEditButton))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(taskLengthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(assignedTeamLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(completedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(subsiquentTasksLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(toggleCompleteButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(deleteTask)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(createTaskButton)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>
    public void updateTaskList(){ //updates the JComboBox
        if(selectedProject.getTaskNames() != null) {
            taskList.setModel(new javax.swing.DefaultComboBoxModel(selectedProject.getTasks().toArray(new Task[0])));
        }

    }

    public void setSelectedTask(Task t){
        taskList.setSelectedItem(t);
    }

    public void updateTaskInfo(){ //updates the information of the currently selected task
        Task selectedTask = (Task)taskList.getSelectedItem();
        if(selectedTask != null) {
            assignedTeamLabel.setText("Team: " + selectedTask.getAssignedTeam().getName());
            taskLengthLabel.setText("Duration: " + Integer.toString(selectedTask.getTimeFrame()));
            completedLabel.setText("Completed: " + selectedTask.getProgress());
            subsequentTaskField.setText("");
            if (selectedTask.getSubsequentTasks() != null) {
                System.out.println(selectedTask.getSubsequentTasks());
                for (var i = 0; i < selectedTask.getSubsequentTasks().size(); i++) {
                    subsequentTaskField.append(selectedTask.getSubsequentTasks().get(i) + "\n");
                }
            }
            tasksTotal = 0;
            tasksCompleted = 0;
            if (selectedProject.getTasks() != null && selectedProject.getTasks().size() > 0) {
                for (Task t : selectedProject.getTasks()) {
                    tasksTotal++; //increase for every task in the project
                    if (t.getProgress()) {
                        tasksCompleted++; //increase for each completed task
                    }
                }
            }
            DecimalFormat df = new DecimalFormat("0.00");
            df.setRoundingMode(RoundingMode.HALF_DOWN);
            double completionRate = (tasksTotal > 0) ? tasksCompleted * 100 / tasksTotal : 0;
            System.out.println("completion: " + completionRate);
            projectCompletionLabel.setText("Tasks for " + selectedProject.getName() + " completed: " + tasksCompleted + " out of " + tasksTotal + " (" + df.format(completionRate) + "%)");
        } else{
            assignedTeamLabel.setText("Team: ");
            taskLengthLabel.setText("Duration: ");
            completedLabel.setText("Completed: ");
            subsequentTaskField.setText("");
            projectCompletionLabel.setText("Tasks for " + selectedProject.getName() + " completed: No tasks found");
        }
        selectedProject.updateMasterList();
    }
    private void taskListActionPerformed(java.awt.event.ActionEvent evt) {
        // Whenever a different task is selected, update the information
        updateTaskInfo();
    }

    private void criticalPathScalaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CriticalPathScala path = new CriticalPathScala();
        var pathArrayList = new ArrayList<>(path.start(selectedProject));
        System.out.println("test");

        JTable table = new JTable();
        ArrayList<CriticalNode> tablelist = new ArrayList<>();
        //tablelist = pathArrayList;
        DefaultTableModel model = new DefaultTableModel();
        JScrollPane scroll;
        String headers[] = {"Name", "Duration", "Earliest Start", "Earliest Finish", "Latest Start"   , "Latest Finish", "Float"};

        model.setColumnIdentifiers(headers);
        table.setModel(model);
        scroll = new JScrollPane(table);

        for (int i = 0; i < (pathArrayList.size()); i++) {
            model.addRow(new Object[] {
                    pathArrayList.get(i).get("name"),
                    pathArrayList.get(i).get("duration"),
                    pathArrayList.get(i).get("earliestStart"),
                    pathArrayList.get(i).get("earliestFinish"),
                    pathArrayList.get(i).get("latestStart"),
                    pathArrayList.get(i).get("latestFinish"),
                    pathArrayList.get(i).get("totalFloat")
            });
        }

        JFrame criticalPathDisplay = new JFrame("Scala critical path for "+selectedProject.getName());
        criticalPathDisplay.add(scroll);
        criticalPathDisplay.setSize(600,300);
        criticalPathDisplay.setLocationRelativeTo(this);
        criticalPathDisplay.setVisible(true);
    }

    private void criticalPathKotlinButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CalculateCriticalPath path = new CalculateCriticalPath(selectedProject);

        JTable table = new JTable();
        ArrayList<CriticalNode> tablelist = new ArrayList<>();
        tablelist = path.getCriticalPath();
        DefaultTableModel model = new DefaultTableModel();
        JScrollPane scroll;
        String headers[] = {"Name", "Duration", "Earliest Start", "Earliest Finish", "Latest Start"   , "Latest Finish", "Float"};

        model.setColumnIdentifiers(headers);
        table.setModel(model);
        scroll = new JScrollPane(table);

        for (int i = 0; i < (tablelist.size()); i++) {
            model.addRow(new Object[] {
                    tablelist.get(i).getName(),
                    tablelist.get(i).getDuration(),
                    tablelist.get(i).getEarliestStart(),
                    tablelist.get(i).getEarliestFinish(),
                    tablelist.get(i).getLatestStart(),
                    tablelist.get(i).getLatestFinish(),
                    tablelist.get(i).getTotalFloat()
            });
        }

        JFrame criticalPathDisplay = new JFrame("Kotlin critical path for "+selectedProject.getName());
        criticalPathDisplay.add(scroll);
        criticalPathDisplay.setSize(600,300);
        criticalPathDisplay.setLocationRelativeTo(this);
        //criticalPathDisplay.setLocation(this.getX()+this.getWidth()/2+ criticalPathDisplay.getWidth()/2, this.getY());
        //criticalPathDisplay.setLocation(this.getX()+this.getWidth()/2+ criticalPathDisplay.getWidth()/2, this.getY());
        criticalPathDisplay.setVisible(true);

    }

    private void createTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CreateTaskForm form = new CreateTaskForm(selectedProject, this);
    }
    private void deleteReferenceToTask(String tName){
        for(Task task : selectedProject.getTasks()){
            for(var i=0;i< task.getSubsequentTasks().size();i++){
                if(task.getSubsequentTasks().get(i).equals(tName)){
                    task.getSubsequentTasks().remove(i);
                }
            }
        }
    }
    private void deleteTaskActionPerformed(java.awt.event.ActionEvent evt) {
        if(taskList.getSelectedItem() == null){return;}
        ArrayList<String> subTasks = findSubsequentTasks((Task)taskList.getSelectedItem());
        System.out.println("sub tasks" +subTasks);
        if(subTasks.size()>0) {
            int n = JOptionPane.showConfirmDialog(null, "There are subsequent tasks, do you want to delete these?", "There are subsequent tasks", JOptionPane.YES_NO_OPTION);
            System.out.println("n "+n);
            if (n == JOptionPane.YES_OPTION) {
                deleteReferenceToTask(((Task) taskList.getSelectedItem()).getName());
                for(String taskName:subTasks){
                    deleteReferenceToTask(taskName);
                    ArrayList<Task> projectTasks = selectedProject.getTasks();
                    for(int i = 0;i<projectTasks.size();i++){
                        if(projectTasks.get(i).getName().equals(taskName)){
                            selectedProject.removeTask(projectTasks.get(i));
                        }
                    }
                }
            } else if(n==-1){return;}
        }
        System.out.println("SUB TASKS FOUND!!" +findSubsequentTasks((Task)taskList.getSelectedItem()));
        selectedProject.removeTask((Task)taskList.getSelectedItem());
        updateTaskList();
        updateTaskInfo();
    }

    private ArrayList<String> findSubsequentTasks(Task t){
        ArrayList<String> returnList = new ArrayList<>();
        ArrayList<String> subsequentTaskNames = t.getSubsequentTasks();
        for(String taskName : subsequentTaskNames){
            if(!returnList.contains(taskName)){
                returnList.add(taskName); //add all subsequent tasks of the currently selected task
            }
        }
        for(int i=0;i<returnList.size();i++){ //loop through list of subsequent task names
            for(Task task : selectedProject.getTasks()){  //loop through the project tasks
                if(task.getName().equals(returnList.get(i))){ //find task object that fits with the task name
                    ArrayList<String> moreTasks = findSubsequentTasks(task); //call this method again using the newly found tasks
                    if(moreTasks !=null) {
                        for(String moreTaskName : moreTasks) {
                            if(!returnList.contains(moreTaskName)) { //check if item was already in the list
                                returnList.add(moreTaskName); //add tasks from this method to the list
                            }
                        }
                    }
                }
            }
        }
        return returnList;
    }

    private void taskEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        EditTaskForm form = new EditTaskForm(selectedProject, (Task)taskList.getSelectedItem(), this);
        System.out.println("Button EditForm");
    }


    private void toggleCompleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Toggles if a task is complete, and then updates the information fields
        Task selectedTask = ((Task)taskList.getSelectedItem());
        if(selectedTask == null){return;}
        selectedTask.setProgress(!selectedTask.getProgress());
        updateTaskInfo();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JLabel assignedTeamLabel;
    private javax.swing.JLabel completedLabel;
    private javax.swing.JButton createTaskButton;
    private javax.swing.JButton criticalPathKotlinButton;
    private javax.swing.JButton criticalPathScalaButton;
    private javax.swing.JButton deleteTask;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel selectTaskLabel;
    private javax.swing.JLabel projectCompletionLabel;
    private javax.swing.JTextArea subsequentTaskField;
    private javax.swing.JLabel subsiquentTasksLabel;
    private javax.swing.JLabel taskLengthLabel;
    public javax.swing.JComboBox<String> taskList;
    private javax.swing.JButton toggleCompleteButton;
    private javax.swing.JButton taskEditButton;
    // End of variables declaration
}
