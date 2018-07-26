package letsDoIT;

import components.*;

public class App {

    public static void main(String[] args) {

        TaskList backlog = new TaskList();
        User user1 = new UserImpl("maja@lysiak.com.pl", "Maja", "12345");
        Task firstTask = new Task("Task1", Priority.LOW, Status.TODO );

        user1.addTask(firstTask, backlog);

        backlog.showContent();


    }
}


// For later - connection with database

//    Database database = new Database();
////        database.connect();
////
////                Task task1 = new Task("Task1", "Pierwszy task");
////
////                int ile = 20;
////                for(int i = 0;i < ile; i++){
////        System.out.println(("task: " + task1.getTitle() + " "+ task1.getDescription() + " has been added with id: ") + database.addRecord(task1)  );
////
////        }