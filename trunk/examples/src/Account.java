class Account
{ static int balance=1000;
   static int expense=0;
   public synchronized void withdrawl(int amount)
   { if (amount<=balance)
      {    balance-=amount;
            expense+=amount;}
      else 
     {  System.out.println("bounced: "+amount);}
    }
}
