
import java.util.Arrays;
import java.util.Objects;

public class SlotMachine{
    
    PlaySound playSound = new PlaySound();

    private final String[] _characters = {"$", "€", "*", "7", "L"};
    private String[] _RandomImageAfterPLayTheGame = {"$","$","$","$","$"};
    private String _winMessage = "   special Edition \"my first Java Project\"";

    private double _cachAccount = 100.0;
    private double _bet = 0.5;
    private double _lastWin = 0.0;


    public String get_winMessage() {
        return _winMessage;
    }

    public void set_winMessage(String winMessage) {
        this._winMessage = winMessage;
    }


    public double get_lastWin(){
        return _lastWin;
    }

    public void set_lastWin(double lastWin){
        if (lastWin <= 1.0) {
            this._lastWin = 0.0;
        } else {
            this._lastWin = lastWin;
        }
    }

    public double get_bet() {
        return _bet;
    }

    public String get_betToString(){
        return Double.toString(this._bet);
    }

    public void set_bet(double bet){
        if (bet >= 0.5)
            if (bet <= _cachAccount) {
                this._bet = bet;
            } else this._bet = 0.5;
        else this._bet = 0.5;
    }

    public String[] get_RandomImageAfterPLayTheGame(){
        return this._RandomImageAfterPLayTheGame;
    }

    public double get_cashAccount() {
        return _cachAccount;
    }

    public void set_cachAccount(double konto){

        this._cachAccount = Math.max(konto, 0.5);
    }


    public int randomNumber(){
        double z = Math.random() * 5;
        return (int) z;
    }


    public void spiel() {
        this._RandomImageAfterPLayTheGame[0] = this._characters[randomNumber()];
        this._RandomImageAfterPLayTheGame[1] = this._characters[randomNumber()];
        this._RandomImageAfterPLayTheGame[2] = this._characters[randomNumber()];
        this._RandomImageAfterPLayTheGame[3] = this._characters[randomNumber()];
        this._RandomImageAfterPLayTheGame[4] = this._characters[randomNumber()];

        System.out.println(Arrays.toString(this._RandomImageAfterPLayTheGame));

        double accountMinusBet = get_cashAccount() - get_bet();
        set_cachAccount(accountMinusBet);

    }

    public void calculatetWin(){

        boolean fiveEquals =
                Objects.equals(_RandomImageAfterPLayTheGame[0], _RandomImageAfterPLayTheGame[1])
                && Objects.equals(_RandomImageAfterPLayTheGame[1], _RandomImageAfterPLayTheGame[2])
                && Objects.equals(_RandomImageAfterPLayTheGame[2], _RandomImageAfterPLayTheGame[3])
                && Objects.equals(_RandomImageAfterPLayTheGame[3], _RandomImageAfterPLayTheGame[4]);

        if (fiveEquals){
            playSound.playSound("clapYourHands");
            double gewin4 = get_cashAccount() + (get_bet() * 1000);
            set_cachAccount(gewin4);
            double gewin4_netto = get_bet() * 1000;
            set_lastWin(gewin4_netto);
            set_winMessage("JACKPOT Meeeegaaa Hoooooog Wiiiiinnnn JACKPOT " + gewin4_netto + "$ gewonnen. \"JACKPOT\"");
            Gui.showInfo("JACKPOT\nSuper Meeeegaaa Hoooooog Wiiiiinnnn.\nYou are crazy\nDu hast den Jackpot" + gewin4_netto + "$ gewonnen. Meeegaa!");
            return;
        }

        boolean fourEquals = Objects.equals(_RandomImageAfterPLayTheGame[0], _RandomImageAfterPLayTheGame[1]) && Objects.equals(_RandomImageAfterPLayTheGame[2], _RandomImageAfterPLayTheGame[3]) && Objects.equals(_RandomImageAfterPLayTheGame[1], _RandomImageAfterPLayTheGame[2]);
        if (fourEquals){
            playSound.playSound("winHight");
            double gewin3 = get_cashAccount() + (get_bet() *100);
            set_cachAccount(gewin3);
            double gewin3_netto = get_bet() * 100;
            set_lastWin(gewin3_netto);
            set_winMessage("Super Meeeegaaa Wiiiin, du hast 4 Richtige " + gewin3_netto + "$ gewonnen. \"Meeegaa!\"");
            Gui.showInfo("Super Meeeegaaa Wiiiiinnnn.\nDu hast vier Richtige" + gewin3_netto + "$ gewonnen. Meeegaa!");
            return;
            }

        boolean threeEquals = Objects.equals(_RandomImageAfterPLayTheGame[0], _RandomImageAfterPLayTheGame[1]) && Objects.equals(_RandomImageAfterPLayTheGame[1], _RandomImageAfterPLayTheGame[2]);
        if (threeEquals) {
            playSound.playSound("winLow");
            double gewin2 = get_cashAccount() + (get_bet() * 15);
            set_cachAccount(gewin2);
            double gewin2_netto = get_bet() * 15;
            set_lastWin(gewin2_netto);
            set_winMessage("Meega, du hast 3 Richtige " + gewin2_netto + "$ gewonnen. \"top\"");
            Gui.showInfo("Meega\nDu hast drei Richtige" + gewin2_netto + "$ gewonnen. top");
            return;
            }

        boolean twoEquals = Objects.equals(_RandomImageAfterPLayTheGame[0], _RandomImageAfterPLayTheGame[1]);
        if (twoEquals){
            playSound.playSound("winLow");
            double gewin1 = get_cashAccount() + (get_bet() * 2);
            set_cachAccount(gewin1);
            double gewin1_netto = get_bet() * 2;
            set_lastWin(gewin1_netto);
            set_winMessage("Cool Du hast 2 Richtige " + gewin1_netto + "$ gewonnen \"super\"");
            Gui.showInfo("Cool \nDu hast zwei Richtige" + gewin1_netto + "$ gewonnen. super");
        }
        else {
            playSound.playSound("start");
        }

    }

    public void resetImage(){
        this._RandomImageAfterPLayTheGame[0] = this._characters[0];
        this._RandomImageAfterPLayTheGame[1] = this._characters[0];
        this._RandomImageAfterPLayTheGame[2] = this._characters[0];
        this._RandomImageAfterPLayTheGame[3] = this._characters[0];
        this._RandomImageAfterPLayTheGame[4] = this._characters[0];
    }

    public boolean isAccountGreaterThanBet()
    {
        return this._cachAccount > this._bet;
    }
}





