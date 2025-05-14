import java.util.*;

public class BankingManagementSystem {


    private static final String first = null;
        private static HashMap<String,Account> accounts = new HashMap<>();
        private static Scanner scanner = new Scanner(System.in);
    
        public static void main(String[] args) {
            do{
            System.out.println("Enter your choice, 1-Create account, 2-Deposit Money,3-Withdraw Money, 4-Balance Enquiry, 5-View Accounts Details");
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1 :
                System.out.println(" Create Account "  );
                createAccount();
                break;

                case 2 :
                System.out.println("Deposit Money ");
                depositMoney();
                break;

                case 3 :
                System.out.println("Withdraw Money ");
                withdrawal();
                break;

                case 4:
                System.out.println("Balance Enquiry");
                balanceEnquiry();
                break;

                case 5 :
                System.out.println("View Accounts Details");
                viewAccountDetails();
                break;

            default:
            System.out.println("Invalid choice.");
                break;
        
            }
        } while (true);
        
            
        
    }

    private static void createAccount () {
        System.out.println("Enter a Account Number-");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter  your Good Name-");
        String name = scanner.nextLine();
        System.out.println("Enter Your Phone Number-");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter your Email address-");
        String email = scanner.nextLine();
        System.out.println("Enter Amount to Deposit-");
        Double balance = scanner.nextDouble();
        scanner.nextLine();
        
        if (accounts.containsKey(accountNumber)){
            System.out.println("This Account is already Created");
            return ;
        }
        System.out.println("Creating a New Account");
        
        Account newAccount = new Account(accountNumber, balance, name, phoneNumber, email);
        
        accounts.put(accountNumber ,newAccount);
        System.out.println("Account has been created successfully.");

        

   }
    
    private static void depositMoney(){
        System.out.println("Enter a Account Number.");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter a Amount to be deposit.");
        Double depositMoney = scanner.nextDouble();
        scanner.nextLine();

        if (accounts.containsKey(accountNumber)){
            
            System.out.println("Deposit money into the Account. " );
            boolean status = accounts.get(accountNumber).updateBalance(depositMoney);
            if (status){
                System.out.println("Money has been deposited into the Account. Current balance is -" + accounts.get(accountNumber).getBalance() );  
            }
            
            
            
        } else{
            
            System.out.println("Account is not found " );
        }   
            
        
    }    

    private static void  withdrawal(){
        System.out.println("Enter a Account Number.");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter a Amount to be withdraw.");
        Double withdrawMoney = scanner.nextDouble();
        scanner.nextLine();

        if (accounts.containsKey(accountNumber)){
            
            System.out.println("Withdraw money from the Account. " );
            accounts.get(accountNumber).widthrawMoney(withdrawMoney);
            System.out.println("Money has been withdraw from the Account. " );
            
        } else{
            
            System.out.println("Account is not found " );
        }      

    }

    private static void balanceEnquiry(){
        System.out.println("Enter a Account Number.");
        String accountNumber = scanner.nextLine();
        if (accounts.containsKey(accountNumber)){
           
            
            Double balance = accounts.get(accountNumber).getBalance();
            System.out.println("Balance amount is-" + balance);
        } else{
            System.out.println("Account is not found " ); 
        }

    }
    private static void viewAccountDetails(){
        String accountNumber = scanner.nextLine();
        if (accounts.containsKey(accountNumber)){
            accounts.get(accountNumber).accountDetails();
            
        }else{
            System.out.println("Account has been found.");
        }
    }
}
  
class Account {
 private String accountNumber;  
 private Double balance; 
 private String name;
 private String phoneNumber;
 private String email;

  
   Account( String acc, Double bal , String name, String phno, String em ){

    this.accountNumber = acc;
    this.balance = bal;
    this.name = name;
    this.phoneNumber = phno;
    this.email = em;
   }
  
   public String getName(){
    return name;

   }
   public String getAccountNumber(){
    return accountNumber;
   }
   public Double getBalance(){
    return balance;
   }
   public String getEmail(){
    return email;
   }

   public boolean updateBalance( Double depositMoney ){
    
    if ( depositMoney < 0 ){
        System.out.println("Invalid amount." );
        return false;
    } 
    balance = balance + depositMoney;
    return true;
    }

   public boolean widthrawMoney( Double withdrawMoney ){
    if ( withdrawMoney < 0 ){
        
        System.out.println("invalid Withdrawal of money");
        return false;

    }
    if (withdrawMoney > balance){
        System.out.println("money is not sufficient");
        return false;
    }
    balance = balance - withdrawMoney;
    return true;
    
   }

   public void accountDetails(){
    System.out.println(" Display Name-"+ name );
    System.out.println(" Account Number-" + accountNumber );
    System.out.println(" Balance-"+ balance );
    System.out.println(" Email-" + email );

   }

}
