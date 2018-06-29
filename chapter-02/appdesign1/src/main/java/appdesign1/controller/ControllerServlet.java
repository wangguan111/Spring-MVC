package appdesign1.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appdesign1.action.SaveProductAction;
import appdesign1.form.ProductForm;
import appdesign1.model.Product;
import java.math.BigDecimal;

//http://localhost:8080/appdesign1/input-product

@WebServlet(
			name = "ControllerServlet", 
			urlPatterns = {"/input-product", "/save-product" }
			)
public class ControllerServlet extends HttpServlet
{
    private static final long serialVersionUID = 1579L;

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
    {
        System.out.println("git test");
    	testGit();
    	System.out.println("git add, commit, pull, push test");
    	testGit2();
    	process(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException 
    {
        process(request, response);      
        System.out.println("git test");
    	testGit();
    	System.out.println("git add, commit, pull, push test");
    	testGit2();
    }

    private void process(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
    {
        String uri = request.getRequestURI();
        /*
         * uri is in this form: /contextName/resourceName,
         * for example: /appdesign1/input-product.
         * However, in the event of a default context, the
         * context name is empty, and uri has this form
         * /resourceName, e.g.: /input-product
         */
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        
        // execute an action
        String dispatchUrl = null;
        if ("input-product".equals(action)) 
        {
            // no action class, just forward
            dispatchUrl = "/jsp/ProductForm.jsp";
        } 
        else if ("save-product".equals(action)) 
        {
            // create form
            ProductForm productForm = new ProductForm();
            // populate action properties
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            // create model
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try 
            {
            	product.setPrice(new BigDecimal(productForm.getPrice()));
            } 
	    catch (NumberFormatException e) 
            {
//            	throw Exception("error");
            }
            // execute action method
            SaveProductAction saveProductAction = new SaveProductAction();
            saveProductAction.save(product);

            // store model in a scope variable for the view
            request.setAttribute("product", product);
            dispatchUrl = "/jsp/ProductDetails.jsp";
        }

        if (dispatchUrl != null) 
        {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
    
    private void testGit()
    {
    	System.out.println("git stash, pull, stash pop, add, commit, push test");
    }
    
     private void testGit2()
    {
    	System.out.println("git add, commit, pull, push test");
    }
}
