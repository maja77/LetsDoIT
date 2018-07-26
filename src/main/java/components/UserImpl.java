package components;

public class UserImpl implements User {


    private String mEmail;
    private String mName;
    private String mPassword;

    public UserImpl(String email, String name, String password) {
        mEmail = email;
        mName = name;
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }


    @Override
    public void register(String email, String name, String password) {

    }

    @Override
    public void login(String email, String password) {

    }

    @Override
    public void logout() {

    }

    @Override
    public void addProject(Project newProject) {

    }

    @Override
    public void delProjekt(Project project) {

    }

    @Override
    public void addLabel(Label newLabel) {

    }

    @Override
    public void delLabel(Label label) {

    }

    @Override
    public void addTask(Task newTask, TaskBoardImpl backlog) {
        backlog.addTask(newTask);
    }

    @Override
    public void delTask(Task task, TaskBoardImpl taskBoardImpl) {
        taskBoardImpl.delTask(task);
    }

    @Override
    public void setStatus(Status status) {

    }

    @Override
    public void setDate() {

    }

    @Override
    public void setPriority(Priority priority) {

    }

    @Override
    public void setLabel(Label label) {

    }

//    @Override
//    void setTaskList(Board taskList) {
//
//    }
}
