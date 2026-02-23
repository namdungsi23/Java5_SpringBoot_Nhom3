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

import jakarta.servlet.http.HttpSession;
import poly.edu.ASSM.Entity.Accounts;
import poly.edu.ASSM.Services.core.AccountService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    AccountService accSer;

    // ===== LIST + SEARCH =====
    @GetMapping
    public String index(
            Model model,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page
    ) {
        int size = 5;

        Page<Accounts> pages = keyword.isEmpty()
                ? accSer.findAll(page, size)
                : accSer.search(keyword, page, size);

        model.addAttribute("users", pages.getContent());
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("user", new Accounts());

        return "admin/user";
    }

    // ===== EDIT =====
    @GetMapping("/edit/{username}")
    public String edit(
            @PathVariable String username,
            Model model,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page
    ) {
        int size = 5;

        Page<Accounts> pages = keyword.isEmpty()
                ? accSer.findAll(page, size)
                : accSer.search(keyword, page, size);

        model.addAttribute("users", pages.getContent());
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("user", accSer.findByUsername(username));

        return "admin/user";
    }

    // ===== UPDATE ONLY =====
    @PostMapping("/save")
    public String save(
            @ModelAttribute("user") Accounts acc,
            HttpSession session
    ) {
        Accounts currentUser = (Accounts) session.getAttribute("user");
        if (currentUser == null) return "redirect:/login";

        Accounts target = accSer.findByUsername(acc.getUsername());
        if (target == null) return "redirect:/admin/user?error=notfound";

        // ❌ Admin thường KHÔNG sửa SuperAdmin
        if (target.getSuperAdmin() && !currentUser.getSuperAdmin()) {
            return "redirect:/admin/user?error=permission";
        }

        accSer.update(acc);
        return "redirect:/admin/user?success=updated";
    }

    // ===== DELETE (SUPERADMIN ONLY) =====
    @GetMapping("/delete/{username}")
    public String delete(
            @PathVariable String username,
            HttpSession session
    ) {
        Accounts currentUser = (Accounts) session.getAttribute("user");
        if (currentUser == null) return "redirect:/login";

        // ❌ Không phải SuperAdmin
        if (!currentUser.getSuperAdmin()) {
            return "redirect:/admin/user?error=permission";
        }

        // ❌ Không xoá chính mình
        if (currentUser.getUsername().equals(username)) {
            return "redirect:/admin/user?error=selfdelete";
        }

        Accounts target = accSer.findByUsername(username);
        if (target == null) return "redirect:/admin/user?error=notfound";

        // ❌ Không xoá SuperAdmin
        if (target.getSuperAdmin()) {
            return "redirect:/admin/user?error=superadmin";
        }

        accSer.delete(username);
        return "redirect:/admin/user?success=deleted";
    }
}


