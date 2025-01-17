package com.store.beautyproducts.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.store.beautyproducts.domain.tb_Address;
import com.store.beautyproducts.domain.tb_Category;
import com.store.beautyproducts.domain.tb_City;
import com.store.beautyproducts.domain.tb_Client;
import com.store.beautyproducts.domain.tb_Estate;
import com.store.beautyproducts.domain.tb_ItemOrder;
import com.store.beautyproducts.domain.tb_Order;
import com.store.beautyproducts.domain.tb_Payment;
import com.store.beautyproducts.domain.tb_PaymentWithBankCard;
import com.store.beautyproducts.domain.tb_PaymentWithBankSlip;
import com.store.beautyproducts.domain.tb_Product;
import com.store.beautyproducts.domain.enums.ClientType;
import com.store.beautyproducts.domain.enums.Profile;
import com.store.beautyproducts.domain.enums.StatusPayment;
import com.store.beautyproducts.repositories.AddressRepository;
import com.store.beautyproducts.repositories.CategoryRepository;
import com.store.beautyproducts.repositories.CityRepository;
import com.store.beautyproducts.repositories.ClientRepository;
import com.store.beautyproducts.repositories.EstateRepository;
import com.store.beautyproducts.repositories.ItemOrderRepository;
import com.store.beautyproducts.repositories.OrderRepository;
import com.store.beautyproducts.repositories.PaymentRepository;
import com.store.beautyproducts.repositories.ProductRepository;

@Service
public class DBService {
    @Autowired
    private BCryptPasswordEncoder pe;
    @Autowired
    private ClientRepository clientRepository; // banco usando repository
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EstateRepository estateRepository;
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemOrderRepository itemOrderRepository;


    public void instantiateTestDatabase() throws ParseException{


        tb_Category cat1 = new tb_Category(null, "Informática");
        tb_Category cat2 = new tb_Category(null, "Escritório");
        tb_Category cat3 = new tb_Category(null, "Cama, mesa e banho");
        tb_Category cat4 = new tb_Category(null, "Eletrônicos");
        tb_Category cat5 = new tb_Category(null, "Jardinagem");
        tb_Category cat6 = new tb_Category(null, "Decoração");
        tb_Category cat7 = new tb_Category(null, "Perfumaria");
   

        tb_Product p1 = new tb_Product(null, "Computador", (float) 2000.00);
        tb_Product p2 = new tb_Product(null, "Impressora", (float) 800.00);
        tb_Product p3 = new tb_Product(null, "Mouse", (float) 80.00);
        tb_Product p4 = new tb_Product(null, "Mesa de escritório", (float) 300.00);
        tb_Product p5 = new tb_Product(null, "Toalha", (float) 50.00);
        tb_Product p6 = new tb_Product(null, "Colcha", (float) 200.00);
        tb_Product p7 = new tb_Product(null, "TV true color", (float) 1200.00);
        tb_Product p8 = new tb_Product(null, "Roçadeira", (float) 800.00);
        tb_Product p9 = new tb_Product(null, "Abajour", (float) 100.00);
        tb_Product p10 = new tb_Product(null, "Pendente", (float) 180.00);
        tb_Product p11 = new tb_Product(null, "Shampoo", (float) 90.00);

        tb_Product p12 = new tb_Product(null, "tb_Product 12", (float)10.00);
        tb_Product p13 = new tb_Product(null, "tb_Product 13", (float)10.00);
        tb_Product p14 = new tb_Product(null, "tb_Product 14", (float)10.00);
        tb_Product p15 = new tb_Product(null, "tb_Product 15", (float)10.00);
        tb_Product p16 = new tb_Product(null, "tb_Product 16", (float)10.00);
        tb_Product p17 = new tb_Product(null, "tb_Product 17", (float)10.00);
        tb_Product p18 = new tb_Product(null, "tb_Product 18", (float)10.00);
        tb_Product p19 = new tb_Product(null, "tb_Product 19", (float)10.00);
        tb_Product p20 = new tb_Product(null, "tb_Product 20", (float)10.00);
        tb_Product p21 = new tb_Product(null, "tb_Product 21", (float)10.00);
        tb_Product p22 = new tb_Product(null, "tb_Product 22", (float)10.00);
        tb_Product p23 = new tb_Product(null, "tb_Product 23", (float)10.00);
        tb_Product p24 = new tb_Product(null, "tb_Product 24", (float)10.00);
        tb_Product p25 = new tb_Product(null, "tb_Product 25", (float)10.00);
        tb_Product p26 = new tb_Product(null, "tb_Product 26", (float)10.00);
        tb_Product p27 = new tb_Product(null, "tb_Product 27", (float)10.00);
        tb_Product p28 = new tb_Product(null, "tb_Product 28", (float)10.00);
        tb_Product p29 = new tb_Product(null, "tb_Product 29", (float)10.00);
        tb_Product p30 = new tb_Product(null, "tb_Product 30", (float)10.00);
        tb_Product p31 = new tb_Product(null, "tb_Product 31", (float)10.00);
        tb_Product p32 = new tb_Product(null, "tb_Product 32", (float)10.00);
        tb_Product p33 = new tb_Product(null, "tb_Product 33", (float)10.00);
        tb_Product p34 = new tb_Product(null, "tb_Product 34", (float)10.00);
        tb_Product p35 = new tb_Product(null, "tb_Product 35", (float)10.00);
        tb_Product p36 = new tb_Product(null, "tb_Product 36", (float)10.00);
        tb_Product p37 = new tb_Product(null, "tb_Product 37", (float)10.00);
        tb_Product p38 = new tb_Product(null, "tb_Product 38", (float)10.00);
        tb_Product p39 = new tb_Product(null, "tb_Product 39", (float)10.00);
        tb_Product p40 = new tb_Product(null, "tb_Product 40", (float)10.00);
        tb_Product p41 = new tb_Product(null, "tb_Product 41", (float)10.00);
        tb_Product p42 = new tb_Product(null, "tb_Product 42", (float)10.00);
        tb_Product p43 = new tb_Product(null, "tb_Product 43", (float)10.00);
        tb_Product p44 = new tb_Product(null, "tb_Product 44", (float)10.00);
        tb_Product p45 = new tb_Product(null, "tb_Product 45", (float)10.00);
        tb_Product p46 = new tb_Product(null, "tb_Product 46", (float)10.00);
        tb_Product p47 = new tb_Product(null, "tb_Product 47", (float)10.00);
        tb_Product p48 = new tb_Product(null, "tb_Product 48", (float)10.00);
        tb_Product p49 = new tb_Product(null, "tb_Product 49", (float)10.00);
        tb_Product p50 = new tb_Product(null, "tb_Product 50", (float)10.00);

        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().addAll(Arrays.asList(p2, p4));
        cat3.getProducts().addAll(Arrays.asList(p5, p6));
        cat4.getProducts().addAll(Arrays.asList(p1, p2, p3, p7));
        cat5.getProducts().addAll(Arrays.asList(p8));
        cat6.getProducts().addAll(Arrays.asList(p9, p10));
        cat7.getProducts().addAll(Arrays.asList(p11));
        cat1.getProducts()
                .addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27,
                        p28, p29, p30, p31, p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47,
                        p48, p49, p50));



        p1.getCategories().addAll(Arrays.asList(cat1, cat4));
        p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategories().addAll(Arrays.asList(cat1, cat4));
        p4.getCategories().addAll(Arrays.asList(cat2));
        p5.getCategories().addAll(Arrays.asList(cat3));
        p6.getCategories().addAll(Arrays.asList(cat3));
        p7.getCategories().addAll(Arrays.asList(cat4));
        p8.getCategories().addAll(Arrays.asList(cat5));
        p9.getCategories().addAll(Arrays.asList(cat6));
        p10.getCategories().addAll(Arrays.asList(cat6));
        p11.getCategories().addAll(Arrays.asList(cat7));

        p12.getCategories().add(cat1);
        p13.getCategories().add(cat1);
        p14.getCategories().add(cat1);
        p15.getCategories().add(cat1);
        p16.getCategories().add(cat1);
        p17.getCategories().add(cat1);
        p18.getCategories().add(cat1);
        p19.getCategories().add(cat1);
        p20.getCategories().add(cat1);
        p21.getCategories().add(cat1);
        p22.getCategories().add(cat1);
        p23.getCategories().add(cat1);
        p24.getCategories().add(cat1);
        p25.getCategories().add(cat1);
        p26.getCategories().add(cat1);
        p27.getCategories().add(cat1);
        p28.getCategories().add(cat1);
        p29.getCategories().add(cat1);
        p30.getCategories().add(cat1);
        p31.getCategories().add(cat1);
        p32.getCategories().add(cat1);
        p33.getCategories().add(cat1);
        p34.getCategories().add(cat1);
        p35.getCategories().add(cat1);
        p36.getCategories().add(cat1);
        p37.getCategories().add(cat1);
        p38.getCategories().add(cat1);
        p39.getCategories().add(cat1);
        p40.getCategories().add(cat1);
        p41.getCategories().add(cat1);
        p42.getCategories().add(cat1);
        p43.getCategories().add(cat1);
        p44.getCategories().add(cat1);
        p45.getCategories().add(cat1);
        p46.getCategories().add(cat1);
        p47.getCategories().add(cat1);
        p48.getCategories().add(cat1);
        p49.getCategories().add(cat1);
        p50.getCategories().add(cat1);



        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

        productRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25,
                p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46,
                p47, p48, p49, p50));

        tb_Estate est1 = new tb_Estate(null, "Minas Gerais");
        tb_Estate est2 = new tb_Estate(null, "São Paulo");

        tb_City c1 = new tb_City(null, "Uberlândia", est1);
        tb_City c2 = new tb_City(null, "São Paulo", est2);
        tb_City c3 = new tb_City(null, "Campinas", est2);

        est1.getCities().addAll(Arrays.asList(c1));
        est2.getCities().addAll(Arrays.asList(c2, c3));

        estateRepository.saveAll(Arrays.asList(est1, est2));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3));

        tb_Client cli1 = new tb_Client(null, "Maria Silva", "MariaSilva@gmail.com" , pe.encode("1234"), "363778912377", ClientType.PESSOAFISICA);
        cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

        tb_Client cli2 = new tb_Client(null, "Ana Costa", "anacosta@gmail.com", pe.encode("1234"), "85035575098", ClientType.PESSOAFISICA);
        cli1.getPhones().addAll(Arrays.asList("29998345", "93656768"));
        cli2.addProfile(Profile.ADMIN);

        tb_Address e1 = new tb_Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
        tb_Address e2 = new tb_Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
        tb_Address e3 = new tb_Address(null, "Avenida Floariano", "2016", null, "Centro", "23334445", cli2, c2);

        cli1.getAddresses().addAll(Arrays.asList(e1, e2));
        cli2.getAddresses().addAll(Arrays.asList(e3));

        clientRepository.saveAll(Arrays.asList(cli1,cli2));
        addressRepository.saveAll(Arrays.asList(e1, e2,e3));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        tb_Order ped1 = new tb_Order(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        tb_Order ped2 = new tb_Order(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

        tb_Payment pagto1 = new tb_PaymentWithBankCard(null, StatusPayment.PAIDORDER, ped1, 6);
        ped1.setPayment(pagto1);
        tb_Payment pagto2 = new tb_PaymentWithBankSlip(null, StatusPayment.PENDING, ped2, sdf.parse("20/10/2017 00:00"),
                null);
        ped2.setPayment(pagto2);

        cli1.getOrders().addAll(Arrays.asList(ped1, ped2));

        orderRepository.saveAll(Arrays.asList(ped1, ped2));
        paymentRepository.saveAll(Arrays.asList(pagto1));

        tb_ItemOrder ip1 = new tb_ItemOrder(ped1, p1, 0.00, 1, (float) 2000.0);
        tb_ItemOrder ip2 = new tb_ItemOrder(ped1, p3, 0.00, 2, (float) 80.00);
        tb_ItemOrder ip3 = new tb_ItemOrder(ped2, p2, 100.00, 1, (float) 800.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        itemOrderRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }
}
