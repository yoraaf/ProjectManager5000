/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Raaf van Nieuwkerk & Joshua Roles
 * Acknowledgements:
 * Used the Swing UI designer in netbeans to generate code for the foundation of GUI
 */

public class MainForm extends javax.swing.JFrame {
    //Creates new form NewJFrame
    //variables for the GUI:
    private javax.swing.JButton createProjectButton;
    private javax.swing.JButton createTeamButton;
    private javax.swing.JButton deleteProjectButton;
    private javax.swing.JButton deleteTeamButton;
    private javax.swing.JButton manageProjectButton;
    private javax.swing.JComboBox<String> projectList;
    private javax.swing.JLabel projectListLabel;
    private javax.swing.JComboBox<String> teamList;
    private javax.swing.JLabel teamListLabel;
    //The below map is used to easily link the name used in the JComboBox, to a project
    private final Map<String, Project> projects = new HashMap<String, Project>();
    private final ArrayList<String> projectNames = new ArrayList<>();
    public static MainForm mainObj;
    public MainForm() {
        super("Admin panel");
        mainObj = this;
        initComponents();
        setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        createProjectButton = new javax.swing.JButton();
        deleteProjectButton = new javax.swing.JButton();
        projectList = new javax.swing.JComboBox<>();
        createTeamButton = new javax.swing.JButton();
        deleteTeamButton = new javax.swing.JButton();
        teamList = new javax.swing.JComboBox<>();
        manageProjectButton = new javax.swing.JButton();
        projectListLabel = new javax.swing.JLabel();
        teamListLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createProjectButton.setText("Create Project");
        createProjectButton.addActionListener(evt -> createProjectButtonActionPerformed(evt));

        deleteProjectButton.setText("Delete Project");
        deleteProjectButton.addActionListener(evt -> deleteProjectButtonActionPerformed(evt));

        updateProjectList();

        createTeamButton.setText("Create Team");
        createTeamButton.addActionListener(evt -> createTeamButtonActionPerformed(evt));

        deleteTeamButton.setText("Delete Team");
        deleteTeamButton.addActionListener(evt -> deleteTeamButtonActionPerformed(evt));

        updateTeamList();

        manageProjectButton.setText("Manage Project");
        manageProjectButton.addActionListener(evt -> manageProjectButtonActionPerformed(evt));

        projectListLabel.setText("Project List");

        teamListLabel.setText("Team List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(teamList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(projectList, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(createProjectButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                                                        .addComponent(createTeamButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(deleteTeamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(deleteProjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(manageProjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(projectListLabel)
                                                        .addComponent(teamListLabel))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(projectListLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(projectList, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(manageProjectButton))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(createProjectButton)
                                        .addComponent(deleteProjectButton))
                                .addGap(33, 33, 33)
                                .addComponent(teamListLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teamList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteTeamButton)
                                        .addComponent(createTeamButton))
                                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>
    public void updateTeamList(){
        teamList.setModel(new javax.swing.DefaultComboBoxModel<>(Team.Companion.getNames().toArray(new String[0])));
    }
    public void updateProjectList(){
        projectList.setModel(new javax.swing.DefaultComboBoxModel<>(Project.Companion.getNames().toArray(new String[0])));
    }
    private void createTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {
        TeamForm team = new TeamForm();
    }

    private void deleteTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(teamList.getSelectedItem() == null){return;}
        String teamName = teamList.getSelectedItem().toString();
        ArrayList<Team> list = Team.Companion.getMasterList();
        for(Team team : list){
            if (teamName.equals(team.getName())){
                list.remove(team);
                break;
            }
        }
        Team.Companion.setMasterList(list);
        updateTeamList();
    }

    private void deleteProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(projectList.getSelectedItem() == null){return;}
        String projectName = projectList.getSelectedItem().toString();
        ArrayList<Project> list = Project.Companion.getMasterList();
        for(Project project : list){
            if (projectName.equals(project.getName())){
                list.remove(project);
                break;
            }
        }
        Project.Companion.setMasterList(list);
        updateProjectList();
    }

    private void createProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String name = JOptionPane.showInputDialog("Enter project name.");
        if(name == null){return;} //return if cancel is pressed
        if(Project.Companion.getNames().contains(name)){
            JOptionPane.showMessageDialog(null, "Project name taken, please enter another one.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Project newProject = new Project(name);
        System.out.println(newProject.getTasks());

        System.out.println("Project name: "+newProject.getName());
        updateProjectList();
        projectList.setSelectedItem(name);
    }

    private void manageProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(projectList.getSelectedItem() == null){return;}
        String projName = projectList.getSelectedItem().toString();
        ArrayList<Project> list = Project.Companion.getMasterList();
        for(Project proj : list){
            if (projName.equals(proj.getName())){
                ProjectForm project = new ProjectForm(proj);
                break;
            }
        }
    }

}
