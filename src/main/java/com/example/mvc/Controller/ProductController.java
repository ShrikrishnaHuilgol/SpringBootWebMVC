package com.example.mvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mvc.Model.Product;
import com.example.mvc.Service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService ps;
	
	@RequestMapping(path="/addProduct")
	public String show_add_product_page_controller(Model m) {
		Product p=new Product();
		m.addAttribute("pro", p);
		return "add_product";
	}
	
	@RequestMapping(path="/")
	public String show_index_page_controller(Model m) {
		List<Product> l=ps.getAllProducts();
		m.addAttribute("p1",l);
		return "index";
	}
	
	@RequestMapping(path="/save",method=RequestMethod.GET)
	public String insert_controller(@ModelAttribute("pro") Product p) {
		ps.insert(p);
		return "redirect:/";
	}
	
	@RequestMapping(path="edit/{id}")
	public ModelAndView showDetailsToEdit(@PathVariable(name="id") int id) {
		ModelAndView mav=new ModelAndView("edit_product");
		Product p=ps.getProduct(id);
		mav.addObject("pro",p);
		return mav;
	}
	
	@RequestMapping(path="delete/{id}")
	public String deleteController(@PathVariable(name="id") int id) {
		ps.delete(id);
		return "redirect:/";
	}
}
