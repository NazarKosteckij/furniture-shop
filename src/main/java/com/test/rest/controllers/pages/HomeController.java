package com.test.rest.controllers.pages;

import com.test.rest.dao.ImagesDao;
import com.test.rest.dao.ProductDao;
import com.test.rest.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchProviderException;
import java.util.Locale;
import java.util.logging.Logger;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	ProductDao productDao;

	@Autowired
	ImagesDao imagesDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws NoSuchProviderException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
	 	return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String contacts(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
	 	return "contacts";
	}

	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String catalog(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		return "catalog";
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ModelAndView product(@PathVariable Integer id) {

		Product product =  productDao.read(id);

		ModelAndView modelAndView;

		if (product == null ) {
			modelAndView = new ModelAndView("error");
			modelAndView.addObject("message", "Not found");
			modelAndView.addObject("code", "404");
			return modelAndView;
		}

		modelAndView = new ModelAndView("product");

		modelAndView.addObject("product", product);
		modelAndView.addObject("images", imagesDao.getByProductId(product.getId()));

		return modelAndView;
	}

}
