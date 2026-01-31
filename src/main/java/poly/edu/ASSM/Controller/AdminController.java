package poly.edu.ASSM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
@RequestMapping("/home")
public String home() {
	return "fragments/home";
}
@GetMapping("/category")
public String category() {
	return "admin/category";
}
@GetMapping("/dashbroad")
public String dashbroad() {
	return "admin/dashbroad";
}
@GetMapping("/managerproduct")
public String product() {
	return "admin/product";
}
}
