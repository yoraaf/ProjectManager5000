import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Raaf van Nieuwkerk & Joshua Roles
 * Acknowledgements:
 * Used the Swing UI designer in netbeans to generate code for the foundation of GUI
 */

public class CreateTaskForm extends javax.swing.JFrame {
    //Creates new form CreateTaskForm
    //variables for the GUI:
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

    private Project selectedProject;
    private ProjectForm callerForm;

    public CreateTaskForm(Project selectedProject, ProjectForm callerForm) {
        super("Create task for "+selectedProject.getName());
        this.selectedProject = selectedProject;
        this.callerForm = callerForm;
        initComponents();
        setVisible(true);
        this.setIconImage(Main.imageIcon.getImage());
    }

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

        selectPreviousTaskLabel.setText("Select Previous Tasks");

        addPreviousTaskButton.setText("Add as previous Task");
        addPreviousTaskButton.addActionListener(evt -> addPreviousTaskButtonActionPerformed(evt));

        confirmTaskButton.setText("Confirm Task");
        confirmTaskButton.addActionListener(evt -> confirmTaskButtonActionPerformed(evt));

        estimatedTimeField.setText("1");
        estimatedTimeField.addActionListener(evt -> estimatedTimeFieldActionPerformed(evt));

        updateTeamList();

        taskTitleLabel.setText("Task Title");

        taskTitleField.setText("Title");
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
        setLocationRelativeTo(null);
    }// </editor-fold>
    public void updateTeamList(){
        selectTeamList.setModel(new javax.swing.DefaultComboBoxModel<>(Team.Companion.getNames().toArray(new String[0])));
    }
    public void updateTaskList(){
        if(selectedProject.getTaskNames() != null) {
            previousTaskList.setModel(new javax.swing.DefaultComboBoxModel<>(selectedProject.getTaskNames().toArray(new String[0])));
        }
    }
    private ArrayList<Task> previousTasks = new ArrayList<>();
    private void addPreviousTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(previousTaskList.getSelectedItem() == null){return;}
        String selectedTask = previousTaskList.getSelectedItem().toString();
        String prevTasks = previousTasksField.getText();
        String[] prevTaskArray = prevTasks.split("\n");
        if(Arrays.asList(prevTaskArray).contains(selectedTask)){return;}

        previousTasksField.append(previousTaskList.getSelectedItem().toString()+"\n");
    }

    private void estimatedTimeFieldActionPerformed(java.awt.event.ActionEvent evt) {
        confirmTaskButton.requestFocus(); //focus on confirm button so that pressing enter twice will quickly confirm the task
    }

    private void taskTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {
        confirmTaskButton.requestFocus(); //focus on confirm button so that pressing enter twice will quickly confirm the task
    }

    private void confirmTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
        if(selectedProject.getTaskNames() != null && selectedProject.getTaskNames().contains(title)){
            JOptionPane.showMessageDialog(null, "Task already exists", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Task newTask = new Task(title, selectedTeam, duration);
        selectedProject.addTask(newTask);
        System.out.println("Tasks for this project "+selectedProject.getTasks());
        String prevTasks = previousTasksField.getText();
        String[] prevTaskArray = prevTasks.split("\n"); //turn the text area into an array
        for(String taskName : prevTaskArray){ //loop through string array
            for(Task task : selectedProject.getTasks()){ //loop through task array for this project
                if(task.getName().equals(taskName)){ //find task object associated with the title in string array
                    newTask.addPre(task); //add the found task to the newTask object as a pre task
                }
            }
        }
        selectedProject.updateMasterList(); //update the project file so the new task is associated with it
        callerForm.updateTaskList(); //update the JComboBox in ProjectForm so the new task is in there
        callerForm.setSelectedTask(newTask); //Auto select the newly made task
        callerForm.updateTaskInfo(); //update the information of the currently selected task
        this.dispose(); //close CreateTaskForm
    }


}
