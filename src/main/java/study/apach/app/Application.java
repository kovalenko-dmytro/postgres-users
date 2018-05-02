package study.apach.app;

import study.apach.controllers.UserController;
import study.apach.controllers.RoleController;
import study.apach.controllers.MainController;

public class Application {

    private InputHelper helper;
    private MainController mainController;
    private UserController userController;
    private RoleController roleController;

    private int currentId = 0;
    private String input;

    public Application() {
        helper = new InputHelper();
        mainController = new MainController();
        userController = new UserController();
        roleController = new RoleController();
    }

    public void run() {

        mainController.index();

        input = helper.getOperation("Enter operation: ");

        while (!input.equals(CommandType.EXIT.getCommandType())) {

            if (CommandType.contains(input)) {

                switch (input) {
                    case "upload":
                        String path = helper.getOperation("Enter file path: ");
                        userController.insertUsers(helper.readUsersFromFile(path));
                        input = "list";
                        break;
                    case "list":
                        userController.getUsers();
                        input = helper.getOperation("");
                        indexOrId(input);
                        break;
                    case "create":
                        roleController.getRoles();
                        userController.createUser(helper.getInputData());
                        input = "list";
                        break;
                    case "update":
                        roleController.getRoles();
                        userController.updateUser(currentId, helper.getInputData());
                        input = "list";
                        break;
                    case "delete":
                        userController.deleteUser(currentId);
                        input = "list";
                        break;
                    case "search":
                        roleController.getRoles();
                        input = helper.getOperation("Enter role: ");
                        userController.getUsers(input);
                        input = helper.getOperation("");
                        indexOrId(input);
                        break;
                }

            } else {
                input = helper.getOperation("Operation name uncorrected. Enter operation: ");
            }

        }

    }

    private void indexOrId(String input) {
        if ("index".equals(input)) {
            mainController.index();
            this.input = helper.getOperation("Enter operation: ");
        } else {
            try {
                currentId = Integer.parseInt(input);
                userController.viewUser(currentId);
                this.input = helper.getOperation("");
            } catch (NumberFormatException e) {
                System.out.println("WARNING!!! ID is not number! Enter correct ID");
                this.input = "list";
            }
        }
    }
}
