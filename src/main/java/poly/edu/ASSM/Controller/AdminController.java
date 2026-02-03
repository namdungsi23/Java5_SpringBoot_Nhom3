package poly.edu.ASSM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // TRANG MẶC ĐỊNH
    @GetMapping("")
    public String adminHome() {
        return "redirect:/admin/dashbroad";
    }

    @GetMapping("/dashbroad")
    public String dashbroad() {
        return "admin/dashbroad";
    }

 
    public String category() {
        return "admin/category";
    }

    @GetMapping("/product")
    public String product() {
        return "admin/product";
    }
    public String user() {
        return "admin/user";
    }
}


