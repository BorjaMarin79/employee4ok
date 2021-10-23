package example.boot.dev.shop;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller  // Etiqueta on diem que aquesta clase es la Controller
@RequestMapping("/user")  // Etiqueta per mappejar a user

public class UserController {
	
	@Autowired // Autorellenado UserRepository
	UserRepository userRepository;

	@RequestMapping("/allUser")
	public String getAllUser(Model boxToView) {

		boxToView.addAttribute("userListfromControllerAndDB", userRepository.findAll());

		return "users";
	}

	@RequestMapping("/deleteUser")
	public String removeUser(int id, Model model) {

		// System.out.println("inside removeEmployee" + id);
		Optional<User> userFound = findOneUserById(id);

		// System.out.println("find inside removeEmployee" + employeeFound.get());

		if (userFound.isPresent()) {

			userRepository.deleteById(id);
			model.addAttribute("message", "deleted user confirmation");
			model.addAttribute("userDeleted", userFound.get());
		}

		else {
			model.addAttribute("message", "deleted user error, maybe there is no id .... or network connection .. or is already deleted few miliseconds ago .. or ...");
		}

		// System.out.println("finishing removeEmployee" + id);
		return "deleteduser.html";
	}

	@RequestMapping("/newUser")
	public String newUser() {

		return "newuser.html";
	}

	@RequestMapping("/addUser")
	public String insertUser(User user) {

		userRepository.save(user);

		return "redirect:/user/allUser";
	}

	@RequestMapping("/updateUser")
	public String updateUser(int id, Model model) {

		Optional<User> userFound = findOneUserById(id);

		if (userFound.isPresent()) {

			model.addAttribute("userfromController", userFound.get());
			return "updateuser";
		}

		else
			return "notfound.html";
	}

	@PostMapping("/replaceUser/{idFromView}")
	public String replaceUser(@PathVariable("idFromView") int id, User user) {

		Optional<User> userFound = findOneUserById(id);

		if (userFound.isPresent()) {

			if (user.getName() != null)
				userFound.get().setName(user.getName());
			if (user.getSurname() != null)
				userFound.get().setSurname(user.getSurname());
			if (user.getPassword() != null)
				userFound.get().setPassword(user.getPassword());
			if (user.getEmail() != null)
				userFound.get().setEmail(user.getEmail());
			if (user.getAge() != 0)
				userFound.get().setAge(user.getAge());
			if (user.getAdress() != "")
				userFound.get().setAdress(user.getAdress());

			userRepository.save(userFound.get());
			return "redirect:/user/allUsers";

		} else
			return "notfound.html";

	}
	
	@RequestMapping("/detailUser")
	public String detailUser(int id, Model model) {

		Optional<User> userFound = findOneUserById(id);

		if (userFound.isPresent()) {

			model.addAttribute("userfromController", userFound.get());
			return "detailuser";
		}

		else
			return "notfound.html";
	}
	
	@RequestMapping("/deleteAllUser")
	public String deleteAllUsers () {

		
		 userRepository.deleteAll();
		

		return "redirect:/user/allUsers";

	}

//--------------------------------------------------------------------------------
//------------------------- service to controller --------------------------------
//--------------------------------------------------------------------------------

	public Optional<User> findOneUserById(int id) {

		// System.out.println("inside findEmployee" + id);
		Optional<User> userFound = userRepository.findById(id);
		// System.out.println("finishing findEmployee" + id);
		// System.out.println("finishing findEmployee" + employeeFound.get());
		return userFound;
	}



	
	

}
