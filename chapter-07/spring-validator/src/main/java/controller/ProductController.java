package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Product;
import validator.ProductValidator;

@Controller
public class ProductController 
{
    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping(value = "/add-product")
    public String inputProduct(Model model)
    {
        model.addAttribute("product", new Product());
        return "ProductForm";
    }

    @RequestMapping(value = "/save-product")
    public String saveProduct(@ModelAttribute Product product,BindingResult bindingResult, Model model) 
    {
        ProductValidator productValidator = new ProductValidator();
        productValidator.validate(product, bindingResult);

        if (bindingResult.hasErrors()) 
        {
            FieldError fieldError = bindingResult.getFieldError();
            logger.debug("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
            return "ProductForm";
        }

        // save product here
        model.addAttribute("product", product);
        return "ProductDetails";
    }
}
