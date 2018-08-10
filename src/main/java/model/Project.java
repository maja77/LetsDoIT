package model;

import java.util.ArrayList;

public class Project {

    private String mProjectName;
    private String mProjectDescription;

    private ArrayList<Task> taskList = new ArrayList<>();
    private ArrayList<UserImpl> userList = new ArrayList<>();

    public Project(String projectName) {
        mProjectName = projectName;
    }

    public String getProjectName() {
        return mProjectName;
    }

    public void setProjectName(String projectName) {
        mProjectName = projectName;
    }

    public String getProjectDescription() {
        return mProjectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        mProjectDescription = projectDescription;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public ArrayList<UserImpl> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserImpl> userList) {
        this.userList = userList;
    }
}
