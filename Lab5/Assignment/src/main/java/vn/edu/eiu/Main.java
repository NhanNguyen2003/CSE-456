package vn.edu.eiu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.edu.eiu.entity.Customer;
import vn.edu.eiu.service.CustomerService;
import vn.edu.eiu.service.InvoiceService;
import vn.edu.eiu.service.ProductService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        InvoiceService invoiceService = context.getBean("invoiceService", InvoiceService.class);

        // Tạo khách hàng mới
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setAddress("123 Main St");

        customerService.saveCustomer(customer);

        // Tạo hóa đơn cho khách hàng với các sản phẩm
        List<Integer> selectedProductIds = Arrays.asList(1, 2); // Ví dụ ID sản phẩm
        invoiceService.generateInvoice(customer.getId(), selectedProductIds);
    }
}
