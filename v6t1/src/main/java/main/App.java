package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Instrument> instruments = new ArrayList<>();

        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää soitin\r\n" + //
                                "2) Listaa soittimet\r\n" + //
                                "3) Viritä kielisoittimet\r\n" + //
                                "4) Soita rumpuja\r\n" + //
                                "0) Lopeta ohjelma");

            int i = Integer.parseInt(sc.nextLine());

            switch(i) {
                case 1:
                    System.out.println("Minkä soittimen haluat lisätä? 1) Kitara, 2) Viulu, 3) Rummut");
                    int type = Integer.parseInt(sc.nextLine());
                    
                    System.out.println("Anna valmistajan nimi:");
                    String man = sc.nextLine();
                    System.out.println("Anna hinta euroina:");
                    int price = Integer.parseInt(sc.nextLine());

                    switch(type) {
                        case 1:
                            Guitar guitar = new Guitar(man, price);
                            instruments.add(guitar);
                            System.out.println("Soitin lisätty listaan! ");
                            break;
                        case 2:
                            Violin violin = new Violin(man, price);
                            instruments.add(violin);
                            System.out.println("Soitin lisätty listaan! ");
                            break;
                        case 3:
                            Drum drum = new Drum(man, price);
                            instruments.add(drum);
                            System.out.println("Soitin lisätty listaan! ");
                            break;
                        default:
                            System.out.println("Virheellinen soitinvalinta.");
                            break;
                    }
                    break;
                case 2:
                    if (instruments.isEmpty()) {
                        System.out.println("Ei lisättyjä soittimia.");
                    } else {
                        for (Instrument instrument : instruments) {
                            System.out.println(instrument.getDetails());
                            }
                    }
                    break;
                case 3:
                    for (Instrument instrument : instruments) {
                        if (instrument instanceof StringInstrument) {
                            StringInstrument si = (StringInstrument) instrument;
                            si.tune();
                        }
                    }
                    break;
                case 4:
                    for (Instrument instrument : instruments) {
                        if (instrument instanceof Drum) {
                            Drum d = (Drum) instrument;
                            d.playBeat();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    exit = true;
                    break;
                default:
                    System.out.println("Virheellinen valinta.");
                    break;
            }
        }
        sc.close();
    }
}


