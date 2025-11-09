package Command;

// Invoker - Cart Manager
class CartManager {
    private java.util.Stack<Command> commandHistory = new java.util.Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
            System.out.println("Đã hoàn tác hành động cuối cùng");
        } else {
            System.out.println("Không có hành động nào để hoàn tác");
        }
    }

    public void showHistory() {
        System.out.println("Lịch sử commands: " + commandHistory.size() + " hành động");
    }
}
