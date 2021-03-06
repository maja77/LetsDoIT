package model;

public interface User {

    void register(String email, String name, String password);
    void login(String email, String password);
    void logout();
    void addProject(Project newProject);
    void delProjekt(Project project);
    void addLabel(Label newLabel);
    void delLabel(Label label);
    void addTask(Task newTask, TaskBoardImpl backlog);
    void delTask(Task task, TaskBoardImpl taskBoardImpl);
    void setStatus(Status status);
    void setDate();
    void setPriority(Priority priority);
    void setLabel(Label label);
//    void setTaskList(Board taskList);

}
