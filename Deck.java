package blackjack;
class Deck
{
    private Card[]deck;
    private int top;
    public Deck()
    {
        deck= new Card[52];
        top=0;
        String[] ranks={"Ace","King","Queen","Jack","Ten","Nine","Eight","Seven","Six","Five","Four","Three","Two"};
        String[] suits={"Clubs","Hearts","Spades","Diamonds"};
        int[]values={11,10,10,10,10,9,8,7,6,5,4,3,2};
        for(int i=0;i<deck.length;i++)
        {
            deck[i]=new Card(ranks[i%13], values[i%13], suits[i%4]);
        }
    }
    public Card dealCard()
    {
        return deck[top++];
        //return deck[(int)(Math.random()*51)];
    }
    public void shuffle()
    {
        // top=(int)(Math.random()*51);
        //System.out.println(top);
        for(int i=0;i<deck.length;i++)
        {
            int irandom=(int)(Math.random()*51);
            Card temp=deck[i];
            deck[i]=deck[irandom];
            deck[irandom]=temp;
        }
    }
}