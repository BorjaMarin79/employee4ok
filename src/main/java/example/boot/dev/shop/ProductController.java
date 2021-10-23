package example.boot.dev.shop;

import java.io.OutputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*import com.example.shopExemple.boot.model.Product;
import com.example.shopExemple.boot.service.CustomerService;
import com.example.shopExemple.boot.service.ProductService;
*/
@Controller
@RequestMapping("/products")
public class ProductController {
	

	@Autowired
	ProductRepository productRepository;

	/*
	 * @Autowired ProductService service;
	 */

	@RequestMapping("/show")
	public String showProducts (Model model) {

		model.addAttribute("items", productRepository.findAll());
		return "items.html";
	}

	@RequestMapping("/addItem")
	public String addProduct (Model model) {

		return "addItem.html";
	}

	@RequestMapping("/insertItem")
	public String insertProduct (Product product, Model model) {

		productRepository.save (product);

		//model.addAttribute("items", productRepository.findAll());
		return "redirect:/products/show";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detailShow(@RequestParam("itemId") int id,  Model model) {
	
		model.addAttribute("item", productRepository.findById(id));
		
		
		return "shoping/detail.html";
	}
	
	@RequestMapping(value = "/modifyItem", method = RequestMethod.GET)
	public String modifyProduct (@RequestParam("itemId") int id, Model model) {
		
		model.addAttribute("item", productRepository.findById(id).get());
		//System.out.println(service.findById(id));
		return "shoping/updateItem.html";
	}
	
	@RequestMapping("/updateItem")
	public String updateProduct (Product product, Model model) {

		//System.out.println(product);
		productRepository.save (product);
		return "redirect:/products/show";
	}
	
	@RequestMapping("/deleteItem")
	public String removeProduct(int id, Model model) {

		// System.out.println("inside removeEmployee" + id);
		Optional<Product> productFound = findOneProductById(id);

		// System.out.println("find inside removeEmployee" + employeeFound.get());

		if (productFound.isPresent()) {

			productRepository.deleteById(id);
			model.addAttribute("message", "deleted item confirmation");
			model.addAttribute("productDeleted", productFound.get());
		}

		else {
			model.addAttribute("message", "deleted product error, maybe there is no id .... or network connection .. or is already deleted few miliseconds ago .. or ...");
		}

		// System.out.println("finishing removeEmployee" + id);
		return "deletedProduct.html";
	}
	
	
	//--------------------------------------------------------------------------------------------------
	
	public Optional<Product> findOneProductById(int id) {

		// System.out.println("inside findEmployee" + id);
		Optional<Product> productFound = productRepository.findById(id);
		// System.out.println("finishing findEmployee" + id);
		// System.out.println("finishing findEmployee" + employeeFound.get());
		return productFound;
	}

}