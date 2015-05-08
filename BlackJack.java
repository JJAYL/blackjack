package blackjack;
import java.util.*;
class BlackJack
{
    public static void main(String[]args)
    {

        Scanner in= new Scanner(System.in);
        double totalmoney=1000;
        double bettings = 0;
        Player me=new Player(totalmoney);
        Player dealer=new Player(0);
        Deck myDeck= new Deck();
        myDeck.shuffle();
        Card c= myDeck.dealCard();
        System.out.println("Your first card is "+c);
        me.hit(c);
        System.out.println("total hand "+me.totalHand());
        c= myDeck.dealCard();
        dealer.hit(c);
        System.out.println("Dealer is showing "+c);

        //me.hit(c);
        c=myDeck.dealCard();
        me.hit(c);
        System.out.println("Your second card is "+c);
        System.out.println("total hand "+me.totalHand());
        System.out.println("How much will you bet? ");
        bettings=in.nextDouble();
        System.out.println("Bet is "+bettings);
        String answer;
        answer=in.nextLine();
        c=myDeck.dealCard();
        dealer.hit(c);
        System.out.println("Dealer is showing "+c);
        Card dealerHoldCard= c;
        System.out.println("More cards? ");
        answer=in.nextLine();
        while((answer.equals("yes"))&&(me.totalHand()<=21))
        {
            System.out.println("total hand "+me.totalHand());
            System.out.println("Dealers hand "+dealer.totalHand());
            me.hit(c);
            c= myDeck.dealCard();
            System.out.println("Your card is "+c);
            if(me.totalHand()<=21)
            {
                System.out.println("total hand "+me.totalHand());
                System.out.println("total hand "+dealer.totalHand());
                System.out.print("Do you want to hit?" );
                answer=in.nextLine();
            }
        }
        while(dealer.totalHand()<17)
        {
            dealer.hit(c);
            c= myDeck.dealCard();
            System.out.println("Dealer's card is "+c);
        }
        if(dealer.totalHand()>21)
        {
            System.out.println("Dealer Bust");
        }
        if((me.totalHand()>dealer.totalHand())&&(me.totalHand()<=21)) //if total hand is less than or equal to 21
        {
            System.out.println("winner");
            me.setMoney(totalmoney+bettings);

        }
        else
        if(dealer.totalHand()<=21)
        {
            System.out.println("Loser");
            me.setMoney(totalmoney-bettings);
        }
    }
}
