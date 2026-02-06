package poly.edu.ASSM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.ASSM.Entitty.Accounts;
import poly.edu.ASSM.Services.core.AccountService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    AccountService accSer;

    // HIỂN THỊ TRANG
 @GetMapping
    public String index(
            Model model,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page
    ) {
        int size = 5; // số dòng mỗi trang

        Page<Accounts> pages =
                keyword.isEmpty()
                ? accSer.findAll(page, size)
                : accSer.search(keyword, page, size);

        model.addAttribute("users", pages.getContent());
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);

        model.addAttribute("user", new Accounts());
        return "admin/user";
    }

 @GetMapping("/edit/{username}")
 public String edit(
         @PathVariable String username,
         Model model,
         @RequestParam(defaultValue = "") String keyword,
         @RequestParam(defaultValue = "0") int page
 ) {
     int size = 5;

     Page<Accounts> pages =
             keyword.isEmpty()
             ? accSer.findAll(page, size)
             : accSer.search(keyword, page, size);

     model.addAttribute("users", pages.getContent());
     model.addAttribute("pages", pages);
     model.addAttribute("keyword", keyword);

     model.addAttribute("user", accSer.findByUsername(username));

     return "admin/user";
 }


    // SAVE
    @PostMapping("/save")
    public String save(@ModelAttribute("user") Accounts acc) {
        accSer.update(acc);
        return "redirect:/admin/user";
    }

    // DELETE
    @GetMapping("/delete/{username}")
    public String delete(@PathVariable String username) {
        accSer.delete(username);
        return "redirect:/admin/user";
    }
}

