package letsDoIT;

import components.Task;
import database.Database;

public class App {

    public static void main(String[] args) {

        Database database = new Database();
  //      database.connect();

        Task task1 = new Task("Task1", "Pierwszy task");

        int ile = 20;
        for(int i = 0;i < ile; i++){
            System.out.println(("task: " + task1.getTitle() + " "+ task1.getDescription() + " has been added with id: ") + database.addRecord(task1)  );

        }

    }
}
