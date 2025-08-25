package Adapter_Pttern_structural;
interface Englishspeaker{
    void speaker(String words);
}
class Spanish{
    public  void spanish(String spanishwords){
        System.out.println("Spanish word" + spanishwords);
    }
}

class translator implements Englishspeaker{
    private Spanish spanishspeaker;

    public translator(Spanish spanishspeaker) {
        this.spanishspeaker = spanishspeaker;
    }

    @Override
    public void speaker(String words) {
        String translated=englishtospanish(words);
        spanishspeaker.spanish(translated);
    }
    private String englishtospanish(String words)
    {
        if(words.equalsIgnoreCase("Heelo"))return "holla";
        if(words.equalsIgnoreCase("How are you"))return "youarehow";

        return "[Translated Spanish for: " + words + "]";
    }
}
public class Main {
    public static void main(String[] args) {
        Spanish spanish=new Spanish();
        Englishspeaker eng=new translator(spanish);
        eng.speaker("Heelo");
        eng.speaker("How are you");
    }
}

/*
✅ Here:
You (Client) → Always speaks English (speakEnglish())
Friend (Adaptee) → Only understands Spanish (hablarEspanol())
Translator (Adapter) → Converts your English into Spanish
 */
