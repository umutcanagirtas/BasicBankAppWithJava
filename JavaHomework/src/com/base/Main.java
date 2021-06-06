package com.base;

import com.testiniumBank.accountTransactions.AccountTransactions;
import com.testiniumBank.client.CorporateClient;
import com.testiniumBank.client.IndividualClient;
import com.testiniumBank.creator.ClientCreator;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CorporateClient corporateClient = new CorporateClient();
        IndividualClient individualClient = new IndividualClient();
        System.out.println("TestiniumBankasına Hoşgeldiniz.");
        System.out.println("İşlem Yapmak İstediğiniz Hesap Numarasını Giriniz");
        Scanner inputBankAccount = new Scanner(System.in);
        String clientType = "";
        String bankAccountClient = inputBankAccount.nextLine();
        try {
            for (Map.Entry<String, Object> entry : ClientCreator.clients().entrySet()) {
                if (entry.getKey().equals(bankAccountClient)) {
                    if (entry.getValue().getClass() == corporateClient.getClass()) {
                        corporateClient = (CorporateClient) entry.getValue();
                        System.out.println("İsim Soyisim:\t" + corporateClient.getNameAndSurname() + "\n"
                                        + "Müşteri Numarası:\t" + corporateClient.getBankClientNumber() + "\n"
                                        + "Hesap Bakiyesi:\t" + corporateClient.getAccountBalance() + "TL\n"
                                        + "TcNo:\t" + corporateClient.getTcNumber() + "\n"
                                        + "Şirket:\t" + corporateClient.getCompany()
                        );
                        clientType = "corporate";
                    } else if (entry.getValue().getClass() == individualClient.getClass()) {
                        individualClient = (IndividualClient) entry.getValue();
                        System.out.println("İsim Soyisim:\t" + individualClient.getNameAndSurname() + "\n"
                                        + "Müsteri Numarası:\t" + individualClient.getBankClientNumber() + "\n"
                                        + "Hesap Bakiyesi:\t" + individualClient.getAccountBalance() + "TL\n"
                                        + "TcNo:\t" + individualClient.getTcNumber() + "\n"
                                        + "Ev Adresi:\t" + individualClient.getHomeAddress()
                        );
                        clientType = "individual";
                    }
                } else {
                    System.out.println("Geçersiz Müşteri Numarası, Ana Ekrana Yönlendiriliyorsunuz");
                    main(args);
                }
            }
        } catch (Exception e) {
            System.out.println("Müşteri Bilgilerine Ulaşılamadı\t" + e.getMessage());
        }
        System.out.println("Para Yatırmak İçin 1" + "\n" + "Para Çekmek İçin 2");
        Scanner inputForBalanceTransactionChose = new Scanner(System.in);
        String chosen = inputForBalanceTransactionChose.nextLine();
        try {
            switch (chosen) {
                case "1":
                    System.out.println("Yatırmak İstediğiniz Tutarı Tuşlayınız");
                    Scanner put = new Scanner(System.in);
                    float moneyForPut = put.nextFloat();
                    if (clientType.equals("corporate")) {
                        corporateClient.setAccountBalance(AccountTransactions.putMoney(corporateClient.getAccountBalance(), moneyForPut));
                        System.out.println("Yeni Bakiyeniz:\t" + corporateClient.getAccountBalance() + "TL");
                    } else {
                        individualClient.setAccountBalance(AccountTransactions.putMoney(individualClient.getAccountBalance(), moneyForPut));
                        System.out.println("Yeni Bakiyeniz:\t" + individualClient.getAccountBalance() + "TL");
                    }
                    System.exit(0);
                    break;
                case "2":
                    System.out.println("Çekmek İstediğiniz Tutarı Tuşlayınız");
                    Scanner delete = new Scanner(System.in);
                    float moneyForDelete = delete.nextFloat();
                    if (clientType.equals("corporate")) {
                        corporateClient.setAccountBalance(AccountTransactions.deleteMoney(corporateClient.getAccountBalance(), moneyForDelete));
                        System.out.println("Yeni Bakiyeniz:\t" + corporateClient.getAccountBalance() + "TL");
                    } else {
                        individualClient.setAccountBalance(AccountTransactions.deleteMoney(individualClient.getAccountBalance(), moneyForDelete));
                        System.out.println("Yeni Bakiyeniz:\t" + individualClient.getAccountBalance() + "TL");
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("1 veya 2 yi tuşlamalısınız, Ana Ekrana Yönlendiriliyorsunuz");
                    main(args);
                    break;
            }
        } catch (Exception e) {
            System.out.println("İşlem Başarısız\t" + e.getMessage());
        }
    }
}