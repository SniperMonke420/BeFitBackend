package com.example.BeFit.befit.config;

import com.example.BeFit.befit.model.Przepis;
import com.example.BeFit.befit.repository.PrzepisRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class przepisConfig {
    @Bean
    CommandLineRunner commandLineRunner(PrzepisRepository przepisRepository) {
        return (args) -> {
            // Przykładowe dane dla przepisu "Sałatka z soczewicy z jogurtem"
            Przepis salatka = new Przepis(

            );
            salatka.setNazwa("Sałatka z soczewicy z jogurtem");
            salatka.setPrzygotowanie("Marchewkę pokrój w pół plastry."+
                    " Następnie ugotuj soczewicę wraz z marchewką w lekko osolonej wodzie. Gotuj ok. 15 minut, aż warzywa będą miękkie."+
                    " Po ugotowaniu odcedź i odstaw do ostygnięcia."+
                    " Bakłażana pokrój w plastry, skrop oliwą i dopraw solą."+
                    " Następnie zgrilluj."+
                    " W dużej misce wymieszaj soczewicę z marchewką, pomidorami pokrojonymi w kostkę i bakłażanem. "+
                    "Dodaj posiekaną miętę i listki natki pietruszki."+
                    " Sos sałatkowy Knorr wymieszaj z jogurtem i sokiem z cytryny."+
                    " Sałatkę przełóż na talerz i polej ją sosem. "+
                    "Udekoruj ziołami, miętą i natką pietruszki.");

            salatka.setSkladniki(Arrays.asList(
                    "jogurt niskotłuszczowy: 80 mililitrów",
                    "Sos sałatkowy czosnkowy Knorr: 1 opakowanie",
                    "soczewica zielona: 150 gramów",
                    "świeża mięta: 0.5 pęczka",
                    "cytryna: 1 sztuka",
                    "dojrzały pomidor: 2 sztuki",
                    "bakłażan: 1 sztuka",
                    "marchew: 1 sztuka",
                    "sól: do smaku",
                    "natka pietruszki: 0.5 pęczka",
                    "oliwa do smażenia"
            ));

            Przepis szarlotka = new Przepis();
            szarlotka.setNazwa("Zdrowa szarlotka");
            szarlotka.setPrzygotowanie("Połącz wszystkie składniki na ciasto i wylej masę do formy wyłożonej papierem do pieczenia (o średnicy ok. 22 cm). "+
                    "Ciasto piecz przez 15 minut w 180 stopniach C, a następnie ostudź."+
                    " W międzyczasie wymieszaj żelatynę w proszku z gorącą wodą w misce i odstaw na chwilę."+
                    " Następnie dodaj mus jabłkowy i opcjonalnie także cynamon lub mak. "+
                    "Jabłka obierz i pokrój w cienkie plasterki. "+
                    "Połóż plastry na ostudzonym cieście. "+
                    "Na koniec polej jabłka przygotowanym musem jabłkowym i odstaw ciasto do lodówki na co najmniej 3 godziny. "+
                    "Gotowe ciasto (zanim zastygnie) można posypać makiem i podawać np. polane jogurtem.");

            szarlotka.setSkladniki(Arrays.asList(
                    "drobna mąka orkiszowa: 70 g",
                    "mak: 2 łyżki",
                    "dowolne mleko: 3 łyżki",
                    "miód/syrop daktylowy: 2 łyżki",
                    "mus jabłkowy (bez cukru): 500 g",
                    "jabłka: 1-2 sztuki",
                    "100% żelatyna: 20 g",
                    "gorąca woda: 3 łyżki",
                    "cynamon/mak (opcjonalnie)"
            ));

            Przepis makaron = new Przepis();
            makaron.setNazwa("Dietetyczny kremowy makaron z cukinią");
            makaron.setPrzygotowanie("Ugotuj makaron w osolonej, wrzącej wodzie do miękkości i odcedź."+
                    " Wymieszaj niewielką ilość mleka z 2 łyżkami mąki."+
                    " Podgrzej na małym ogniu pozostałe mleko w garnku, w którym ugotowałaś makaron."+
                    " Dodaj masło, mleko wymieszane z mąką, zmiażdżone ząbki czosnku, sól, pieprz i gotuj na wolnym ogniu."+
                    " Dodaj ser do sosu i pozwól mu się całkowicie roztopić, aby jeszcze bardziej zagęścić sos."+
                    " Na koniec wmieszaj startą cukinię i ugotowany makaron, i wszystko dobrze wymieszaj."+
                    " Można podawać razem z tuńczykiem.");

            makaron.setSkladniki(Arrays.asList(
                    "makaron pełnoziarnisty: 400 g",
                    "starta cukinia: 500 g",
                    "starta mozzarella (lub inny ser): 100 g",
                    "dowolne mleko: 380 ml",
                    "masło: 1 łyżka",
                    "dowolna mąka: 2 łyżki",
                    "sól: do smaku",
                    "mielony pieprz czarny: do smaku",
                    "ząbki czosnku: 2 sztuki",
                    "tuńczyk: 400 g"
            ));
            Przepis kotlety = new Przepis();
            kotlety.setNazwa("Kotlety z kaszy jaglanej z brokułami");
            kotlety.setPrzygotowanie("Cebulę drobno posiekać i podsmażyć na maśle (najlepiej klarowanym). "
                    + "Kaszę jaglaną ugotować (2 szklanki wody, 1 szklanka kaszy), w czasie gotowania dodać cebulę oraz przyprawy. "
                    + "Po ugotowaniu kaszę ostudzić, następnie zemleć przez maszynkę. Zemleć również ugotowane na parze brokuły, "
                    + "drugą cebulę oraz dodać czosnek i olej. Wszystkie składniki dobrze wymieszać. "
                    + "Z masy uformować kotlety i usmażyć. W przypadku wykorzystania masy na pasztet należy dodać więcej oleju, "
                    + "2 łyżki skrobi kukurydzianej i piec godzinę w temperaturze 160 stopni.");

            kotlety.setSkladniki(Arrays.asList(
                    "kasza jaglana: 1 szklanka",
                    "brokuł: 1 sztuka",
                    "cebule: 2 sztuki",
                    "czosnek: 3-4 ząbki",
                    "olej: 2-3 łyżki",
                    "przyprawy: czubryca, zielona pietruszka"
            ));
            Przepis kremZDyny = new Przepis();
            kremZDyny.setNazwa("Zdrowy krem z dyni");
            kremZDyny.setPrzygotowanie("Drobno pokrojoną cebulę podsmaż w garnku na rozgrzanym oleju lub maśle klarowanym.\n"
                    + "Dodaj obraną i startą dynię, dolej 50 ml wody, posól, dopraw i gotuj około 15 minut, od czasu do czasu mieszając. "
                    + "Dynia powinna być miękka.\n"
                    + "Śmietankę wymieszaj z dynią i zagotuj.\n"
                    + "Zdejmij garnek z ognia. Danie możesz podawać od razu.");

            kremZDyny.setSkladniki(Arrays.asList(
                    "oczyszczona i starta dynia Hokkaido lub piżmowa: 1 kg",
                    "śmietanka (mleczna lub sojowa): 200 ml",
                    "duża cebula: 1 sztuka",
                    "oliwa z oliwek: 1 łyżka",
                    "sól: 1/2 łyżeczki",
                    "mielony czarny pieprz: 1/2 łyżeczki",
                    "dymka"
            ));
            Przepis gofryOwsiane = new Przepis();
            gofryOwsiane.setNazwa("Gofry owsiane");
            gofryOwsiane.setPrzygotowanie("Wszystkie składniki odważamy w pojemniku miksującym i mieszamy ze sobą – wybieramy program gotowanie wg własnych ustawień / czas 40 sekund / obroty 8.\n"
                    + "Każdy gofr wypiekamy w rozgrzanej gofrownicy przez ok. 4 minuty. Podajemy je jeszcze ciepłe, np. z dodatkiem masła orzechowego, owoców i syropu klonowego.");

            gofryOwsiane.setSkladniki(Arrays.asList(
                    "płatki owsiane górskie: 130 g",
                    "banan: 2 sztuki",
                    "jajko: 2 sztuki",
                    "waniliowy napój proteinowy: 160 ml",
                    "ekstrakt waniliowy: 1 łyżeczka",
                    "proszek do pieczenia: 1 łyżeczka",
                    "olej kokosowy: 1 łyżka"
            ));
            Przepis zielonyShot = new Przepis();
            zielonyShot.setNazwa("Zielony shot witaminowy");
            zielonyShot.setPrzygotowanie("Cytrynę obieramy, a z jabłek usuwamy gniazda nasienne. Wszystkie składniki przekładamy do pojemnika miksującego i blendujemy, używając programy gotowanie wg własnych ustawień / czas 40 sekund / obroty 10.\n"
                    + "Gotowy napój przecedzamy przez sitko o drobnych oczkach i przelewamy do małych butelek idealnych na kilka łyków.");

            zielonyShot.setSkladniki(Arrays.asList(
                    "jabłko: 2 sztuki",
                    "ogórek: 1 sztuka",
                    "seler naciowy: 3 łodygi",
                    "cytryna: 1 sztuka"
            ));
            Przepis fitMakaronCarbonara = new Przepis();
            fitMakaronCarbonara.setNazwa("Fit makaron à la Carbonara");
            fitMakaronCarbonara.setPrzygotowanie("Wędzoną pierś kurczaka kroimy w dość drobną kostkę. Na rozgrzaną patelnię dodajemy 2 łyżki oliwy i krótko podsmażamy na niej kurczaka.\n"
                    + "Cukinię kroimy w bardzo drobną kostkę i dodajemy ją do podsmażonego kurczaka. Całość smażymy jeszcze kilka minut. Ok. 2 łyżki podsmażonych składników odkładamy na później, aby ozdobić gotowe danie.\n"
                    + "Makaron gotujemy ok. 2 minuty krócej, niż wskazuje instrukcja na opakowaniu, aby był al dente. Po ugotowaniu odlewamy ok. 0,33 szklanki wody – będzie potrzebna do przygotowania sosu.\n"
                    + "Sery ścieramy na tarce o drobnych oczkach. W misce dokładnie mieszamy żółtka z czarnym pieprzem i serami.\n"
                    + "Do podsmażonego kurczaka i cukinii dodajemy makaron, połowę zostawionej wody z jego gotowania i całość dokładnie mieszamy. Następnie dodajemy żółtka z serem i drobno posiekaną pietruszkę i ponownie mieszamy. W razie potrzeby dolewamy więcej wody po gotowaniu makaronu, aby sos miał odpowiednią konsystencję.\n"
                    + "Makaron nakładamy na talerze, ozdabiamy z wierzchu odłożonym wcześniej podsmażonym kurczakiem z cukinią, a także odrobiną startego pecorino romano.");

            fitMakaronCarbonara.setSkladniki(Arrays.asList(
                    "kurczak wędzona pierś: 50 g",
                    "oliwa z oliwek: 2 łyżki",
                    "makaron spaghetti: 150 g",
                    "cukinia: 0,5 sztuki",
                    "żółtka jaj: 2 sztuki",
                    "ser pecorino: 20 g",
                    "grana padano: 20 g",
                    "natka pietruszki: 0,25 pęczka",
                    "pieprz czarny: 0,25 łyżeczki"
            ));
            Przepis proteinowyDeser = new Przepis();
            proteinowyDeser.setNazwa("Proteinowy deser z ciasteczkami Cantuccini");
            proteinowyDeser.setPrzygotowanie("Ciastka cantuccini kroimy na mniejsze kawałki i połowę z nich wkładamy na dno pucharków.\n"
                    + "Do miski przekładamy serek wiejski wysokobiałkowy, skyr, syrop klonowy i masło orzechowe. Składniki blendujemy.\n"
                    + "Do pucharków przekładamy po ¼ masy serowej i po ½ musu owocowego. Na te składniki nakładamy pozostałe, jeszcze bardziej rozdrobnione ciasteczka. Na tę warstwę cantuccini nakładamy pozostałą masę serową.\n"
                    + "Kiwi obieramy i kroimy w drobną kostkę. Każdą porcję deseru ozdabiamy świeżymi owocami i listkami mięty.");

            proteinowyDeser.setSkladniki(Arrays.asList(
                    "Cantuccini: 100 g",
                    "serek wiejski wysokobiałkowy: 200 g",
                    "skyr naturalny: 200 g",
                    "syrop klonowy: 1 łyżka",
                    "masło orzechowe: 1 łyżka",
                    "kiwi: 2 sztuki",
                    "mięta świeża: 4 liście",
                    "mus mango-brzoskwinia: 200 g"
            ));

            przepisRepository.save(proteinowyDeser);
            przepisRepository.save(fitMakaronCarbonara);
            przepisRepository.save(zielonyShot);
            przepisRepository.save(gofryOwsiane);
            przepisRepository.save(kremZDyny);
            przepisRepository.save(kotlety);
            przepisRepository.save(salatka);
            przepisRepository.save(szarlotka);
            przepisRepository.save(makaron);
        };
    }
}
