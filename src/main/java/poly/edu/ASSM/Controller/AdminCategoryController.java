package poly.edu.ASSM.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.ASSM.Entity.Category;
import poly.edu.ASSM.Services.core.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {
	  @Autowired
	    private CategoryService categoryService;

	    // ================== LIST ==================
	  @GetMapping("")
	  public String index(
	          Model model,
	          @RequestParam(required = false) String keyword,
	          @RequestParam(required = false) String size,
	          @RequestParam(defaultValue = "0") int page
	  ) {
	      List<Category> categories;
	      int totalPages = 1;

	      if (size == null || size.equals("all")) {
	          // 👉 HIỂN THỊ TẤT CẢ
	          categories = categoryService.findAll();
	      } else {
	          int pageSize = Integer.parseInt(size);

	          Page<Category> result = categoryService.search(
	                  keyword,
	                  PageRequest.of(page, pageSize)
	          );

	          categories = result.getContent();
	          totalPages = result.getTotalPages();
	      }
	     
	      model.addAttribute("categories", categories);
	      model.addAttribute("totalPages", totalPages);
	      model.addAttribute("currentPage", page);
	      model.addAttribute("keyword", keyword);
	      model.addAttribute("size", size);
	      model.addAttribute("category", new Category());

	      return "admin/category";
	  }



	    // ================== CREATE ==================
	    @PostMapping("/create")
	    public String create(@ModelAttribute("category") Category category) {
	        categoryService.create(category);
	        return "redirect:/admin/category";
	    }

	    // ================== EDIT ==================
	    @GetMapping("/edit/{id}")
	    public String edit(
	            @PathVariable String id,
	            Model model,
	            @RequestParam(required = false) String keyword,
	            @RequestParam(required = false) String size,
	            @RequestParam(defaultValue = "0") int page
	    ) {
	        // load lại list giống index
	        index(model, keyword, size, page);

	        // category cần sửa
	        model.addAttribute("category", categoryService.findById(id));

	        return "admin/category";
	    }


	    // ================== UPDATE ==================
	    @PostMapping("/update")
	    public String update(@ModelAttribute("category") Category category) {
	        if (category.getId() == null || category.getId().isEmpty()) {
	            throw new RuntimeException("Cập nhật danh mục bắt buộc phải có ID");
	        }
	        categoryService.update(category);
	        return "redirect:/admin/category";
	    }


	    // ================== DELETE ==================
	    @GetMapping("/delete/{id}")
	    public String delete(@PathVariable("id") String id) {
	        categoryService.delete(id);
	        return "redirect:/admin/category";
	    }
}
