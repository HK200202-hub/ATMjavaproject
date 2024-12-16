import  java.text.DecimalFormat;
import java.util.*;
public class Account{
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00 ");
    /*Set the customer number  */
    public int setCustomerNumber(int customerNumber){
      this.customerNumber = customerNumber;
      return customerNumber;
}
/* Get the customer number */
public int getCustomerNumber() {
    return customerNumber;
}
/* Set the Pin number */
public int setPinNumber(int pinNumber){
    this.pinNumber = pinNumber;
    return pinNumber;
}
/*Get the pin number  */
 public int getPinNumber(){
    return pinNumber;

 }
/* get the saving account balance  */
public double getSavingBalance(){
    return savingBalance;
}
/*get the checking balance  */
public double getCheckingBalance(){
    return savingBalance;
}
/*calculate checing accountwithdrawal */
public double CalcCheckingWithdraw(double amount){
    checkingBalance =(checkingBalance-amount);
return checkingBalance;
}
/* calculate savings account withdrawal */
public double CalcSavingWithdraw(double amount){
    savingBalance = (savingBalance - amount);
    return savingBalance;
}
/*calculate Savings account after funds added  */
public double CalsavingDeposit(double amount){
    savingBalance = (savingBalance+amount);
    return savingBalance;
}
/*calcuate checking accout after funds added  */
public double Calcheckingdeposit(double amount){
    checkingBalance = (checkingBalance+amount);
    return checkingBalance;
}
// Customer saving account withdrawal input
// Customer saving account withdrawal input
public void getSavingWithdrawInput(){
    System.out.println("Saving account balance: " + moneyFormat.format(savingBalance));
    System.out.println("Amount you want to withdraw from savings account: ");
    double amount = input.nextDouble();
    if ((savingBalance - amount) >= 0){
        CalcSavingWithdraw(amount);  // Correct method for withdrawal
        System.out.println("New Saving Account balance: " + savingBalance + "\n");
    } else {
        System.out.println("Balance cannot be negative " + "\n");
    }
}

// Customer checking account withdrawal input
public void getCheckingWithdrawInput(){
    System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
    System.out.print("Amount you want to withdraw from checking account: ");
    double amount = input.nextDouble();

    if ((checkingBalance - amount) >= 0) {
        CalcCheckingWithdraw(amount);  // Correct method for withdrawal
        System.out.println("New Checking Account balance: " + checkingBalance + "\n");
    } else {
        System.out.println("Balance cannot be negative." + "\n");
    }
}

// Customer checking account deposit input
public void getCheckingDepositInput(){
    System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
    System.out.print("Amount you want to deposit into checking account: ");
    double amount = input.nextDouble();

    if (amount >= 0) {
        Calcheckingdeposit(amount);  // Correct method for deposit
        System.out.println("New Checking Account balance: " + checkingBalance + "\n");
    } else {
        System.out.println("Deposit amount must be positive." + "\n");
    }
}

// Customer saving account deposit input
public void getSavingDepositInput(){
    System.out.println("Savings Account Balance: " + moneyFormat.format(savingBalance));
    System.out.print("Amount you want to deposit into saving account: ");
    double amount = input.nextDouble();

    if (amount >= 0) {
        CalsavingDeposit(amount);  // Correct method for saving account deposit
        System.out.println("New Saving Account balance: " + savingBalance + "\n");
    } else {
        System.out.println("Deposit amount must be positive." + "\n");
    }
}


private int customerNumber;
private int pinNumber;
private double checkingBalance = 1500 ;
private double savingBalance = 1500 ;
}