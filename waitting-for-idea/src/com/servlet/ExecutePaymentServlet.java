package com.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.cartDao;
import com.dao.orderedDao;
import com.dao.userDao;
import com.model.Cart;
import com.model.Order;
import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;
 
@WebServlet("/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private cartDao cd;
    private orderedDao od;
    private userDao ud;
 
    public ExecutePaymentServlet() {
    	cd = new cartDao();
    	od = new orderedDao();
    	ud = new userDao();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        Float total = Float.parseFloat(request.getParameter("total"));
        String ship = request.getParameter("shiping");
        String ship2 = request.getParameter("shiping2");
        String ship3 = request.getParameter("shiping3");
        try {
            PaymentServices paymentServices = new PaymentServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId);
             
            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
             
            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);
            
            int user_id = ud.getUserByEmail(request.getSession().getAttribute("user_email")).getUser_id();
            ArrayList<Cart> c = cd.allInCartOfUser(user_id);
            String carts = "";
            for(int i = 0; i< c.size();i++) {
            	if(i==0) {
                	carts +=c.get(i).getP_name();
            	}
            	carts += ","+c.get(i).getP_name();
            }
            od.insert(new Order(user_id, carts, total, ship+","+ship2+","+ship3, "pending"));
            cd.clear();
            request.setAttribute("cart", cd.allInCartOfUser(user_id).size());
            request.getRequestDispatcher("receipt.jsp").forward(request, response);
             
        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
 
}
