
import java.util.Optional;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        repo.addUser(new User(1, "Ivan", "ivan@example.com"));
        repo.addUser(new User(2, "Oksana", "oksana@example.com"));

        int searchId = 1;
        Optional<User> userById = repo.findUserById(searchId);
        userById.ifPresentOrElse(
                user -> System.out.println("Знайдено за ID: " + user),
                () -> System.out.println("Користувача з ID " + searchId + " не знайдено.")
        );


        String searchEmail = "oksana@example.com";
        Optional<User> userByEmail = repo.findUserByEmail(searchEmail);
        userByEmail.ifPresentOrElse(
                user -> System.out.println("Знайдено за email: " + user),
                () -> System.out.println("Користувача з email " + searchEmail + " не знайдено.")
        );

        Optional<List<User>> allUsers = repo.findAllUsers();
        if (allUsers.isPresent()) {
            System.out.println("Кількість користувачів: " + allUsers.get().size());
            allUsers.get().forEach(System.out::println);
        } else {
            System.out.println("Список користувачів порожній.");
        }
    }
}
