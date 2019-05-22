

public class SampleApplet {
    public String NamePlayerNow ;

    public SampleApplet(){
        Playback plabey = new Playback();
        NamePlayerNow = plabey.NameSetting();


    }
    public static void main(String[] args) {
         SampleApplet sma = new SampleApplet();
//        System.out.println(plabey.NameGetter("Name"));
        System.out.println(sma.NamePlayerNow);



    }
}