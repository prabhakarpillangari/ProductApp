package org.jsp.productapp.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.jsp.productapp.dao.ProductDao;
import org.jsp.productapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {
	@Autowired
	private ProductDao productDao;

	@RequestMapping(value = "/open-login")
	public String home(Model model) {
		List<Product> products = productDao.getProducts();
		model.addAttribute("products", products);
		return "login";
	}

	// show to add form
	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "add product");
		return "add_product_form";
	}
	// to handle the form

	@PostMapping(value = "/handle-product")
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		productDao.saveProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/open-login");
		return redirectView;
	}

	// delete handler
	@GetMapping("/open-login/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/open-login");
		return redirectView;
	}
	@GetMapping("/open-login/update/{productId}")
	public String updateUser(@PathVariable("productId") int productId, Model model) {
		Product product=productDao.updateProduct(productId);
		model.addAttribute("product",product);
		return "update_form";
	}
}
