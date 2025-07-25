package vn.edu.eiu;

import vn.edu.eiu.data.EwalletPayment;
import vn.edu.eiu.data.PaymentMethod;
import vn.edu.eiu.service.PaymentService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PaymentMethod method = new EwalletPayment();


        PaymentService paymentService = new PaymentService(method);


        paymentService.processPayment(150.75);
    }
}