package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User roma = new User("Roma", "Pupkin", "qweqwe@mail.io");
      User sanya = new User("Sanya", "Sidorov", "sidorov@mail.io");
      User katy = new User("Katy", "Petrova", "petrova@mail.io");
      User ogory = new User("Ogory", "Ivanova", "ivanova@mail.io");

      Car toyota = new Car("Toyota", 200);
      Car bmw = new Car("BMW", 325);
      Car audi = new Car("Audi", 7);
      Car lada = new Car("Lada", 21014);

      userService.add(roma.setCar(toyota).setUser(roma));
      userService.add(sanya.setCar(bmw).setUser(sanya));
      userService.add(katy.setCar(audi).setUser(katy));
      userService.add(ogory.setCar(lada).setUser(ogory));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("BMW", 325));

      context.close();
   }
}
