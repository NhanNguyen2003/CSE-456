package vn.edu.eiu.service;

import vn.edu.eiu.entity.Customer;
import vn.edu.eiu.entity.Invoice;
import vn.edu.eiu.entity.Product;
import vn.edu.eiu.repo.InvoiceRepo;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    private InvoiceRepo invoiceRepository;
    private ProductService productService;
    private CustomerService customerService;

    public void generateInvoice(int customerId, List<Integer> productIds) {
        Customer customer = customerService.getCustomer(customerId);
        List<Product> products = productService.getAllProducts();

        List<Product> selectedProducts = new ArrayList<>();
        double totalPrice = 0;

        for (Integer productId : productIds) {
            for (Product product : products) {
                if (product.getId() == productId) {
                    selectedProducts.add(product);
                    totalPrice += product.getPrice();
                }
            }
        }

        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setProducts(selectedProducts);
        invoice.setTotalPrice(totalPrice);

        invoiceRepository.saveInvoice(invoice);

        // Mô phỏng việc in lên màn hình (trong ứng dụng thực tế, có thể là tạo PDF)
        System.out.println("Hóa đơn cho Khách hàng: " + customer.getName());
        for (Product product : selectedProducts) {
            System.out.println("Sản phẩm: " + product.getName() + ", Giá: " + product.getPrice());
        }
        System.out.println("Tổng giá trị: " + totalPrice);
    }
}

