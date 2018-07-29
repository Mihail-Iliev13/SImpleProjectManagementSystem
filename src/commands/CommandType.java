package commands;

import com.sun.org.apache.regexp.internal.RE;

public enum CommandType {
    ADD_TASK, ADD_TICKET, ADD_TODO, UPDATE_TODO, LIST_ALL, LIST_TODOS, LIST_TODOS_NOT_DONE, LIST_TICKETS, LIST_TASKS, EXIT,;


    public  static CommandType fromName(String commandPart) {

        switch (commandPart.toUpperCase()){
            case "ADD-TASK":
                return ADD_TASK;
            case "ADD-TICKET":
                return ADD_TICKET;
            case "ADD-TODO":
                return ADD_TODO;
            case "UPDATE-TODO":
                return UPDATE_TODO;
            case "LIST-ALL":
                return LIST_ALL;
            case "LIST-TODOS":
                return LIST_TODOS;
            case "LIST-TODOS-NOT-DONE":
                return LIST_TODOS_NOT_DONE;
            case "LIST-TICKETS":
                return LIST_TICKETS;
            case "LIST-TASKS":
                return LIST_TASKS;
            case "EXIT":
                return EXIT;
                default:
                    return null;
        }

    }
}
