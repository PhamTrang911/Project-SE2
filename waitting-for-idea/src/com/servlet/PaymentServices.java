package com.servlet;
import java.util.*;

import com.model.OrderDetail;
import com.paypal.api.payments.*;
import com.paypal.base.rest.*;
 
public class PaymentServices {
    private static final String CLIENT_ID = "ATLgP_mjhDJs-znTJ0N31j-3a0gQmN2XkhbQZgbiruukjAdzJf4UmXZVohJq9uR7uRPkLTzz9CFJpxil";
    private static final String CLIENT_SECRET = "EEZhFFTHmIQQJO7fPXwbRJI_zBDIF9mFHnOMgNX4xgxEvDu19WWV1hzFNJHMirfvbgioQp1aP2ZWZPX1";
    private static final String MODE = "sandbox";
 
    public String authorizePayment(OrderDetail orderDetail)        
            throws PayPalRESTException {       
 
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);
         
        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(getPayerInformation(orderDetail.getPayerInfo()));
        requestPayment.setIntent("authorize");
 
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
 
        Payment approvedPayment = requestPayment.create(apiContext);
 
        return getApprovalLink(approvedPayment);
 
    }
    
    /*
     * set payer info to a Payer model
     */
    private Payer getPayerInformation(String payerInfor) {
    	String[] a = payerInfor.split(",");
    	Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName(a[0])
                 .setLastName(a[1])
                 .setEmail(a[2]);
         
        payer.setPayerInfo(payerInfo);
         
        return payer;
    }
     
    private RedirectUrls getRedirectURLs() {
    	RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("https://laleaf-hanu.herokuapp.com/user/cancel_payment");
        redirectUrls.setReturnUrl("https://laleaf-hanu.herokuapp.com/review_payment");
         
        return redirectUrls;
    }
     
    private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
    	Details details = new Details();
        details.setShipping(orderDetail.getShipping());
        details.setSubtotal(orderDetail.getSubtotal());
        details.setTax(orderDetail.getTax());
     
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(orderDetail.getTotal());
        amount.setDetails(details);
     
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(orderDetail.getProductName());
         
        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();
         
        Item item = new Item();
        item.setCurrency("USD");
        item.setName(orderDetail.getProductName());
        item.setPrice(orderDetail.getSubtotal());
        item.setTax(orderDetail.getTax());
        item.setQuantity("1");
         
        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);
     
        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);  
         
        return listTransaction;
    }
     
    private String getApprovalLink(Payment approvedPayment) {
    	 List<Links> links = approvedPayment.getLinks();
    	    String approvalLink = null;
    	     
    	    for (Links link : links) {
    	        if (link.getRel().equalsIgnoreCase("approval_url")) {
    	            approvalLink = link.getHref();
    	            break;
    	        }
    	    }      
    	     
    	    return approvalLink;
    }
    
    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }
    
    public Payment executePayment(String paymentId, String payerId)
            throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);
     
        Payment payment = new Payment().setId(paymentId);
     
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
     
        return payment.execute(apiContext, paymentExecution);
    }
}