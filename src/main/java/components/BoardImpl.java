package components;

import java.util.ArrayList;

public class BoardImpl implements Board {

    final private ArrayList<Project> projectsList = new ArrayList<>();
    final private ArrayList<User> userList = new ArrayList<>();
    final private ArrayList<Label> labelsList = new ArrayList<>();

    public BoardImpl() {
    }

    @Override
    public void showContent() {


    }
}
