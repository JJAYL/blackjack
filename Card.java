package blackjack;
class Card
{
    private String rank;
    private String suit;
    private int value;
    public String getRank()
    {
        return rank;
    }
    public String getSuit()
    {
        return suit;
    }
    public int getValue()
    {
        return value;
    }
    public void set(int val)
    {
        value= val;//for aces
    }
    public Card(String rk,int val, String st)
    {
        rank=rk; //constructor
        suit=st;
        value=val;
    }
    public String toString()
    {
        return rank+" of "+suit;
    }
}