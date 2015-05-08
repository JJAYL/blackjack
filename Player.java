package blackjack;
import java.util.*;
class Player
{
    private double cash;
    private ArrayList<Card>hand;
    public Player(double aCash)
    {
        cash=aCash;
        hand= new ArrayList<Card>();
    }
    public void setMoney(double acash)
    {
        cash=acash;
    }

    public void hit(Card c)
    {
        hand.add(c);
    }
    public int totalHand()
    {
        int count=0;
        int acecount=0;
        for(int i=0;i<hand.size();i++)
        {
            Card c= hand.get(i);
            count=count+c.getValue();
            if(hand.get(i).getValue()==11)
            {
                acecount++;
            }
        }
        if((count>=21)&&(acecount>0))
        {
            count=count-10;
            acecount--;
        }

        return count;
    }
}