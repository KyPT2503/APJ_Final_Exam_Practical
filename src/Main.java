import controller.Controller;
import view.UserInterface;

public class Main {
    public static void main(String[] args) {
        while (true) {
            UserInterface userInterface = UserInterface.getInstance();
            userInterface.displayMainMenu();
            Controller.getInstance().execute(userInterface.getOption());
        }
    }
}
// doc tu file csv
// chuc nang thu 5
// chuc nang thu 4: chua confirm ma van xoa trong database
// xem lai phan update va remove mot directory
// clean code