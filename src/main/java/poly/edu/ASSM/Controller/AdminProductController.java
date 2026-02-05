package poly.edu.ASSM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.ASSM.Entitty.Product;
import poly.edu.ASSM.Services.core.CategoryService;
import poly.edu.ASSM.Services.core.ProductService;

@Controller
public class AdminProductController {

    @Autowired
    ProductService prt;

    @Autowired
    CategoryService ctr;

    @GetMapping({"/admin/product", "/admin/product/index"})
    public String index(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "") String cat,
            @RequestParam(required = false) Integer editId
    ) {
        Page<Product> pages = prt.filterProducts(
                cat,
                keyword,
                null,
                null,
                PageRequest.of(page, size, Sort.by("id").descending())
        );

       
        Product product = (editId != null)
                ? prt.findById(editId)
                : new Product();

        model.addAttribute("product", product);
        model.addAttribute("products", pages.getContent());
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("cat", cat);
        model.addAttribute("categories", ctr.findAll());

        return "admin/product";
    }

    // SAVE (CREATE + UPDATE)
    @PostMapping("/admin/product/save")
    public String save(@ModelAttribute Product product) {
        prt.create(product);
        return "redirect:/admin/product";
    }

    // DELETE
    @GetMapping("/admin/product/delete/{id}")
    public String delete(@PathVariable Integer id) {
        prt.delete(id);
        return "redirect:/admin/product";
    }
}
