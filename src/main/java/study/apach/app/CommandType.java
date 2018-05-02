package study.apach.app;

public enum CommandType {
    CREATE("create"),
    UPDATE("update"),
    DELETE("delete"),
    SEARCH_BY_NAME("search"),
    LIST("list"),
    INDEX("index"),
    EXIT("exit");

    CommandType(String commandType) {
        this.commandType = commandType;
    }

    private String commandType;

    public String getCommandType() {
        return commandType;
    }

    public static boolean contains(String type) {
        boolean result = false;
        for (CommandType commandType : CommandType.values()) {
            if (commandType.getCommandType().equals(type)) {
                result = true;
            }
        }
        return result;
    }
}
