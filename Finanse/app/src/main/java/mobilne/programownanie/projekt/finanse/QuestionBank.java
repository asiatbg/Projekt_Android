package mobilne.programownanie.projekt.finanse;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;



public class QuestionBank {
    List<Question> quesList = new ArrayList<>();
    DatabaseHelper databaseHelper;

    //method return number of question in list
    public int getLength() {

        return quesList.size();
    }

    //method return question from list instead on list index
    public String getQuestionList(int a) {

        return quesList.get(a).getQUESTION();
    }

    //method return a single multiple choice item for question based on list index,
   //based on number of multiple choice item in the list - 1, 2 or 3 as an argument
    public String getOption(int index, int num) {

        return quesList.get(index).getOption(num-1);
    }

    //method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {

        return quesList.get(a).getANSWER();
    }

    public void initQuestions(Context context) {
        databaseHelper = new DatabaseHelper(context);
        //get question, option and correct answer from database
        quesList = databaseHelper.getAllQuestions();

        if(quesList.isEmpty()) {
            databaseHelper.addQuestion(new Question("Co to jest barter?",
                            new String[] {"inaczej dyskonto",
                            "handel wymienny",
                            "handel walutami"},
                    "handel wymienny"));
            databaseHelper.addQuestion(new Question("Co to jest elastyczność dochodowa popytu?",
                            new String[] {"stosunek bezwzględnej zmiany rozmiarów popytu na określone dobro do względnej zmiany ceny",
                            "stosunek względnej zmiany rozmiarów popytu na określone dobro do względnej zmiany dochodu",
                            "stosunek popytu do dochodu"},
                    "stosunek względnej zmiany rozmiarów popytu na określone dobro do względnej zmiany dochodu"));
            databaseHelper.addQuestion(new Question("Kiedy popyt nazywamy doskonale nieelastycznym?",
                            new String[] {"kiedy jego elastyczność jest równa 0",
                            "kiedy elastyczność przyjmuje wartości między 0 i 1",
                            "kiedy elastyczność jest większa od 1"},
                    "kiedy jego elastyczność jest równa 0"));
            databaseHelper.addQuestion(new Question("Co to jest efekt substytucyjny zmiany cen?",
                            new String[] {"jest to dostosowanie popytu do samej zmiany relacji cen",
                            "jest to dostosowanie popytu do zmiany ceny poprzez zastąpienie relatywnie droższego dobra tańszym",
                            "jest to efekt zastąpienia jednego dobra przez drugie"},
                    "jest to dostosowanie popytu do zmiany ceny poprzez zastąpienie relatywnie droższego dobra tańszym"));
            databaseHelper.addQuestion(new Question("Co to jest elastyczność cenowa popytu?",
                            new String[] {"stosunek względnej zmiany wielkości zapotrzebowania na dane dobro do względnej zmiany ceny",
                            "stosunek bezwzględnej zmiany wielkości zapotrzebowania na dane dobro do bezwzględnej zmiany ceny",
                            "stosunek popytu do ceny"},
                    "stosunek względnej zmiany wielkości zapotrzebowania na dane dobro do względnej zmiany ceny"));
            databaseHelper.addQuestion(new Question("Co to jest rynkowa krzywa popytu?",
                             new String[] {"to suma indywidualnych krzywych popytu danego konsumenta",
                            "to suma indywidualnych krzywych popytu wszystkich konsumentów nabywających wszystkie dobra",
                            "to suma indywidualnych krzywych popytu wszystkich konsumentów nabywających określone dobro"},
                            "to suma indywidualnych krzywych popytu wszystkich konsumentów nabywających określone dobro"));
            databaseHelper.addQuestion(new Question("Kiedy występuje malejąca użyteczność krańcowa dobra?",
                            new String[] {"gdy z biegiem czasu dobro się zużywa i jest coraz mniej użyteczne",
                            "gdy każda dodatkowa jednostka dobra dostarcza konsumentowi coraz mniejszych przyrostów użyteczności",
                            "gdy każda dodatkowa jednostka dobra dostarcza producentowi coraz mniejszych przyrostów użyteczności"},
                    "gdy każda dodatkowa jednostka dobra dostarcza konsumentowi coraz mniejszych przyrostów użyteczności"));
            databaseHelper.addQuestion(new Question("Co to jest koszt krańcowy?",
                            new String[] {"to wzrost kosztów stałych wywołany wzrostem produkcji o jednostkę",
                            "to wzrost kosztów całkowitych wywołany wzrostem produkcji o jednostkę",
                            "to wzrost kosztów zmiennych wywołany wzrostem produkcji o jednostkę"},
                    "to wzrost kosztów całkowitych wywołany wzrostem produkcji o jednostkę"));
            databaseHelper.addQuestion(new Question("Co w teorii podaży określa funkcja produkcji?",
                            new String[] {"określa maksymalne rozmiary produkcji, jakie są możliwe do osiągnięcia przy różnym poziomie nakładów",
                            "określa maksymalną cenę danego produktu przy danym poziomie nakładów",
                            "określa minimalne rozmiary produkcji, jakie są możliwe do osiągnięcia przy różnym poziomie nakładów"},
                    "określa maksymalne rozmiary produkcji, jakie są możliwe do osiągnięcia przy różnym poziomie nakładów"));
            databaseHelper.addQuestion(new Question("Punkt, w którym przecinają się krzywa podaży i krzywa popytu to:",
                            new String[] {"punkt maximum popytu",
                            "punkt 0,0",
                            "punkt maximum podaży"},
                    "punkt maximum popytu"));
            databaseHelper.addQuestion(new Question("Co nie ma wpływu na krzywą popytu?",
                            new String[] {"liczba kupujących na danym rynku", "" +
                            "preferencje kupujących",
                            "koszt produkcji danego dobra"},
                    "koszt produkcji danego dobra"));
            databaseHelper.addQuestion(new Question("Co się dzieje zgodnie z prawem podaży, jeżeli cena rośnie (przy innych warunkach niezmienionych)?",
                            new String[] {"podaż rośnie",
                            "popyt spada",
                            "konsumenci zaprzestają kupować"},
                    "podaż rośnie"));
            databaseHelper.addQuestion(new Question("Co obrazuje funkcja oszczędności?",
                            new String[] {"obrazuje wielkość oszczędności w zależności od stopy redyskontowej",
                            "obrazuje wielkość zamierzonych oszczędności przypadających na jedną osobę",
                            "obrazuje wielkość zamierzonych oszczędności przy każdym poziomie dochodu"},
                    "obrazuje wielkość zamierzonych oszczędności przy każdym poziomie dochodu"));
            databaseHelper.addQuestion(new Question("Co nazywamy krańcową skłonnością do oszczędzania?",
                            new String[] {"jest to wskaźnik ilości dochodu przeznaczonego na oszczędności",
                            "obrazuje wielkość oszczędności w zależności od stopy redyskontowej",
                            "jest to część każdej dodatkowej jednostki produkcji zaniechanej przez przedsiębiorstwo na rzecz oszczędności"},
                    "jest to wskaźnik ilości dochodu przeznaczonego na oszczędności"));
            databaseHelper.addQuestion(new Question("Ekonometria to:",
                            new String[] {"gałąź ekonomii zajmująca się mierzeniem związków między wielkościami ekonomicznymi przy wykorzystaniu danych statystycznych",
                            "wszystkie odpowiedzi są poprawne", "dział nauki zajmujący się tworzeniem jednostek miar użytecznych w ekonomii"},
                    "wszystkie odpowiedzi są poprawne"));
            databaseHelper.addQuestion(new Question("Czym zajmuje się ekonomia?",
                            new String[] {"bada w jaki sposób społeczeństwo gospodarujące decyduje o tym, co, jak i dla kogo sprzedawać",
                            "analizuje oraz opisuje produkcję, dystrybucję oraz konsumpcję dóbr",
                            "bada w jaki sposób społeczeństwo gospodarujące decyduje o tym, co, jak i dla kogo kupować"},
                    "analizuje oraz opisuje produkcję, dystrybucję oraz konsumpcję dóbr"));
            databaseHelper.addQuestion(new Question("Prawo popytu mówi, że:",
                            new String[] {"występuje odwrotna zależność między ceną a wielkością popytu",
                            "wszelka zmiana ceny spowodowana jest zmianą popytu",
                            "występuje bezpośrednia zależność między ceną a wielkością popytu"},
                    "występuje odwrotna zależność między ceną a wielkością popytu"));
            databaseHelper.addQuestion(new Question("Co to jest technika w teorii podaży?",
                             new String[] {"to wytwarzanie dóbr przy pomocy narzędzi",
                            "to zbiór wszystkich technicznie efektywnych technologii (metod wytwarzania)",
                            "określona metoda łączenia czynników produkcji w procesie wytwarzania dóbr"},
                    "to zbiór wszystkich technicznie efektywnych technologii (metod wytwarzania)"));
            databaseHelper.addQuestion(new Question("Co to są koszty zmienne?",
                             new String[] {"są to koszty, które zmieniają się wraz ze zmianami wielkości popytu",
                            "są to koszty, które zmieniają się wraz ze zmianami ceny produktu",
                            "są to koszty, które zmieniają się wraz ze zmianami wielkości produkcji"},
                    "są to koszty, które zmieniają się wraz ze zmianami wielkości produkcji"));
            databaseHelper.addQuestion(new Question("Prawo jednej ceny sprawia że:",
                            new String[] {"cena danego dobra wyrównuje się na całym świecie",
                            "dane dobro ma jedną cenę w danym regionie", "dane dobro ma jedną cenę w danym okresie czasu"},
                    "cena danego dobra wyrównuje się na całym świecie"));
            databaseHelper.addQuestion(new Question("Co stanowi nadwyżka ceny nad kosztem krańcowym?",
                            new String[] {"stanowi kapitałochłonności produkcji",
                            "stanowi o wielkości przedsiębiorstwa",
                            "stanowi miarę siły monopolistycznej przedsiębiorstwa"},
                    "stanowi miarę siły monopolistycznej przedsiębiorstwa"));
            databaseHelper.addQuestion(new Question("Rynek, na którym zarówno sprzedający, jak i kupujący uznają, że ich decyzje o kupnie i sprzedaży nie wpływają na poziom ceny rynkowej to:",
                            new String[] {"rynek kapitalistyczny",
                            "rynek doskonale konkurencyjny",
                            "rynek socjalistyczny"},
                    "rynek doskonale konkurencyjny"));
            databaseHelper.addQuestion(new Question("Co to jest wartość dodana?",
                            new String[] {"suma wartości materiałów, które brały udział w procesie produkcji",
                            "przyrost wartości dóbr w wyniku określonego (danego) procesu produkcji",
                            "procentowy wzrost wartości dobra w ciągu roku"},
                    "przyrost wartości dóbr w wyniku określonego (danego) procesu produkcji"));
            databaseHelper.addQuestion(new Question("Co nie jest charakterystyczne dla gospodarki nakazowo-rozdzielczej?",
                            new String[] {"wyznaczanie przez władze celów ekonomicznych dla przedsiębiorstw",
                            "sporządzanie centralnego planu gospodarczego",
                            "dominacja własności prywatnej w gospodarce"},
                    "dominacja własności prywatnej w gospodarce"));
            databaseHelper.addQuestion(new Question("Cena równowagi to inaczej cena:",
                            new String[] {"cena, przy której wielkość popytu jest równa wielkości podaży",
                            "równa wielkości popytu danego dobra",
                            "równa wielkości podaży danego dobra"},
                    "cena, przy której wielkość popytu jest równa wielkości podaży"));
            databaseHelper.addQuestion(new Question("Co to jest cykl koniunkturalny?",
                            new String[] {"wahania ceny pieniądza",
                            "wahania popytu pieniądza",
                            "cykliczne wahania aktywności gospodarczej"},
                    "cykliczne wahania aktywności gospodarczej"));
            databaseHelper.addQuestion(new Question("Krzywa ilustrująca wielkość produkcji, którą przedsiębiorstwo chce wytwarzać przy różnych cenach jest nazywana:",
                            new String[] {"krzywą podaży przedsiębiorstwa",
                            "krzywą produktywności przedsiębiorstwa",
                            "krzywa popytu przedsiębiorstwa"},
                    "krzywą podaży przedsiębiorstwa"));   // 27 pytań

            databaseHelper.addQuestion(new Question("Zespół reform, które skutkowały przejściem polskiej gospodarki od gospodarki centralnie planowanej do gospodarki wolnorynkowej nazywany jest czasem:",
                    new String[] {"zapaścią",
                            "terapią szokową",
                            "gradualizmem"},
                    "terapią szokową"));

            databaseHelper.addQuestion(new Question("Jak w polskiej gospodarce przedstawia się udział rolnictwa odpowiednio w zatrudnieniu (odsetek liczby pracujących) i produkcji (procentowy udział PKB) wytworzonego w sektorze?",
                    new String[] {"poniżej 5% i poniżej 3,5%",
                            "między 10% a 13% i poniżej 4%",
                            "powyżej 15% i powyżej 20,6%"},
                    "między 10% a 13% i poniżej 4"));

            databaseHelper.addQuestion(new Question("Kiedy rząd napotyka problem wysokiego bezrobocia, może - oprócz działań długofalowych - próbować załagodzić problem, na przykład przez zorganizowanie:",
                    new String[] {"prac interwencyjnych",
                            "Dnia Bezrobotnego",
                            "referendum"},
                    "prac interwencyjnych"));

            databaseHelper.addQuestion(new Question("W gospodarce wolnorynkowej czynniki określające poziom cen to:",
                    new String[] {"popyt i sprzedaż",
                            "popyt i podaż",
                            "kupno i sprzedaż"},
                    "popyt i podaż"));

            databaseHelper.addQuestion(new Question("Poparta odpowiednimi zasobami umożliwiającymi transakcję, chęć nabycia dobra bądź usługi to:",
                    new String[] {"popyt",
                            "podaż",
                            "sprzedaż"},
                    "popyt"));

            databaseHelper.addQuestion(new Question("Prawo popytu głosi, że jeżeli wszystkie czynniki poza ceną pozostaną niezmienione, zaś cena spadnie, to wielkość zgłaszanego na dobro popytu:",
                    new String[] {"spadnie",
                            "wzrośnie",
                            "pozostanie bez zmian"},
                    "wzrośnie"));

            databaseHelper.addQuestion(new Question("Kiedy spożycie każdej kolejnej jednostki dobra przynosi ci coraz mniejsze zadowolenie (nazywane przez ekonomistów \"użytecznością\"), nazywa się to:",
                    new String[] {"malejąca użyteczność końcowa",
                            "spadające zadowolenie cząstkowe",
                            "malejąca użyteczność krańcowa"},
                    "malejąca użyteczność krańcowa"));

            databaseHelper.addQuestion(new Question("Ekonomiczny wskaźnik, który określa, jak bardzo zmienia się wielkość popytu wskutek zmiany ceny danego dobra, nazywamy:",
                    new String[] {"cenową elastycznością sprzedaży",
                            "cenową elastycznością popytu",
                            "cenową ekstatycznością popytu"},
                    "cenową elastycznością popytu"));

            databaseHelper.addQuestion(new Question("Na niektóre dobra zgłaszamy podobny popyt bez względu na ich cenę. Oznacza to, że popyt na nie jest wyjątkowo mało elastyczny. Do dóbr takich należą:",
                    new String[] {"dobra luksusowe",
                            "substytuty",
                            "dobra pierwszej potrzeby"},
                    "dobra pierwszej potrzeby"));
            databaseHelper.addQuestion(new Question("Wyobraź sobie sytuację, kiedy istotnie wzrasta cena płyt kompaktowych, na które popyt jest stosunkowo elastyczny. Wszystkie inne ceny jednak rosną także, więc cena płyt w stosunku do innych dóbr nie ulega zmianie. Oznacza to, że popyt na płyty:",
                    new String[] {"pozostanie na niezmienionym poziomie",
                            "zauważalnie spadnie",
                            "zauważalnie wzrośnie"},
                    "pozostanie na niezmienionym poziomie"));
            databaseHelper.addQuestion(new Question("Kiedy na skutek działania czynników innych, niż cena, występuje zjawisko wzrostu lub spadku popytu, ilustracją tego na wykresie krzywej popytu będzie:",
                    new String[] {"obrót krzywej popytu wokół osi wyznaczanej przez punkt równowagi rynkowej",
                            "przesunięcie całej krzywej popytu",
                            "przesunięcie się po krzywej popytu"},
                    "przesunięcie całej krzywej popytu"));
            databaseHelper.addQuestion(new Question("Dobra, które zaspakajają potrzeby tylko wtedy, gdy użytkowane są łącznie (na przykład benzyna i samochód), to dobra:",
                    new String[] {"komplementarne",
                            "substytucyjne",
                            "konkurencyjne"},
                    "komplementarne"));
            databaseHelper.addQuestion(new Question("Prawo podaży głosi, że jeżeli wszystkie czynniki poza ceną pozostaną niezmienione, zaś cena spadnie, to wielkość zgłaszanej podaży dobra:",
                    new String[] {"wzrośnie",
                            "pozostanie bez zmian",
                            "spadnie"},
                    "spadnie"));
            databaseHelper.addQuestion(new Question("Proces przekazywania państwowych zakładów pod kontrolę prywatnych inwestorów to:",
                    new String[] {"marnotrawstwo",
                            "ekonomizacja",
                            "prywatyzacja"},
                    "prywatyzacja"));
            databaseHelper.addQuestion(new Question("Cena równowagi rynkowej to:",
                    new String[] {"cena, przy której równoważy się wielkość podaży i popytu",
                            "cena zapewniająca maksymalne zatrudnienie",
                            "cena najkorzystniejsza dla konsumentów"},
                    "cena, przy której równoważy się wielkość podaży i popytu"));
            databaseHelper.addQuestion(new Question("Kiedy na rynku wielkość popytu przewyższa wielkość podaży, mówimy o:",
                    new String[] {"nadwyżce podaży",
                            "nadwyżce popytu",
                            "reglamentacji"},
                    "nadwyżce popytu"));
            databaseHelper.addQuestion(new Question("Każdy z nas, podobnie jak firmy, jednostki samorządowe, czy nawet państwa, może stworzyć własne zestawienie wydatków i dochodów, które pomoże efektywnie gospodarować zasobami. Takie zastawienie nazywamy:",
                    new String[] {"rachunkiem",
                            "budżetem",
                            "deficytem"},
                    "budżetem"));
            databaseHelper.addQuestion(new Question("Prawo ekonomiczne, które mówi, że w miarę wzrostu dochodów udział wydatków na dobra pierwszej potrzeby w całości dochodów spada, to:",
                    new String[] {"elastyczność cenowa popytu",
                            "aksjomat granicy konsumpcji",
                            "prawo Engla"},
                    "prawo Engla"));
            databaseHelper.addQuestion(new Question("Dokument, który zaświadcza, że pożyczyłeś swojemu państwu pieniądze, i uprawnia Cię do otrzymania ich z powrotem wraz z odsetkami to:",
                    new String[] {"obligacja skarbowa",
                            "akcja",
                            "świadectwo udziałowe"},
                    "obligacja skarbowa"));
            databaseHelper.addQuestion(new Question("Kiedy bank nalicza odsetki od oszczędności metodą procentu składanego (np. co miesiąc), po roku otrzymasz większą kwotę odsetek, niż wynikałoby to z nominalnego oprocentowania Twojego rachunku. Dzieje się tak, ponieważ w przypadku oszczędności roczna nominalna stopa procentowa jest niższa od:",
                    new String[] {"rocznej stopy inflacji",
                            "rocznej stopy kapitalizacji",
                            "efektywnej rocznej stopy procentowej"},
                    "efektywnej rocznej stopy procentowej"));  // 47 pytań

            databaseHelper.addQuestion(new Question("Agio to:",
                    new String[] {"zysk przedsiębiorstwa na jedną akcję",
                            "podatek od zysków z lokat kapitałowych",
                            "nadwyżka ceny emisyjnej papieru wartościowego ponad jego wartość nominalną"},
                    "nadwyżka ceny emisyjnej papieru wartościowego ponad jego wartość nominalną"));
            databaseHelper.addQuestion(new Question("Rentowność obligacji kuponowej kupionej na rynku pierwotnym jest:",
                    new String[] {"zawsze większa od oprocentowania obligacji",
                            "równa oprocentowaniu obligacji",
                            "to wielkość odsetek podzielona przez cenę obligacji"},
                    "równa oprocentowaniu obligacji"));
            databaseHelper.addQuestion(new Question("W przypadku obligacji zerokuponowych dyskonto stanowi:",
                    new String[] {"różnicę pomiędzy wartością realną a ceną emisyjną obligacji",
                            "różnicę pomiędzy wartością realną a ceną rynkową obligacji",
                            "różnicę pomiędzy wartością nominalną a ceną emisyjną obligacji"},
                    "różnicę pomiędzy wartością nominalną a ceną emisyjną obligacji"));
            databaseHelper.addQuestion(new Question("Jednostki uczestnictwa są oferowane przez:",
                    new String[] {"fundusze otwarte",
                            "fundusze zamknięte",
                            "banki"},
                    "fundusze otwarte"));
            databaseHelper.addQuestion(new Question("Certyfikaty inwestycyjne są emitowane przez:",
                    new String[] {"SKOKi",
                            "banki",
                            "fundusze zamknięte"},
                    "fundusze zamknięte"));
            databaseHelper.addQuestion(new Question("Jako fundusz portfelowy może działać tylko:",
                    new String[] {"fundusz inwestycyjny otwarty",
                            "fundusz inwestycyjny zamknięty",
                            "fundusz parasolowy"},
                    "fundusz inwestycyjny zamknięty"));
            databaseHelper.addQuestion(new Question("Fundusz sekurytyzacyjny może utworzyć tylko:",
                    new String[] {"fundusz parasolowy",
                            "fundusz inwestycyjny zamknięty",
                            "fundusz otwarty"},
                    "fundusz inwestycyjny zamknięty"));
            databaseHelper.addQuestion(new Question("Kto nadzoruje Towarzystwa Funduszy Inwestycyjnych w Polsce?",
                    new String[] {"Giełda Papierów Wartościowych",
                            "Komisja Nadzoru Finansowego",
                            "Minister Finansów"},
                    "Komisja Nadzoru Finansowego"));
            databaseHelper.addQuestion(new Question("Silny i długotrwały spadek kursu papierów wartościowych, notowanych na giełdzie to:",
                    new String[] {"a vista",
                            "hossa",
                            "bessa"},
                    "bessa"));
            databaseHelper.addQuestion(new Question("Jaka instytucja sprawuje nadzór nad polskim rynkiem ubezpieczeń?",
                    new String[] {"KNF",
                            "RPP",
                            "MF"},
                    "KNF"));
            databaseHelper.addQuestion(new Question("Od decyzji KNF można się odwołać do:",
                    new String[] {"Naczelnego Sądu Administracyjnego",
                            "Trybunału Konstytucyjnego",
                            "Ministra Finansów"},
                    "Naczelnego Sądu Administracyjnego"));
            databaseHelper.addQuestion(new Question("Co nazywamy krańcową skłonnością do oszczędzania?",
                    new String[] {"jest to % dochodu dyspozycyjnego przeznaczonego na oszczędności",
                            "jest to część każdej dodatkowej jednostki dochodu, przeznaczona przez gospodarstwa domowe na oszczędności",
                            "est to wskaźnik ilości dochodu przeznaczonego na oszczędności"},
                    "jest to część każdej dodatkowej jednostki dochodu, przeznaczona przez gospodarstwa domowe na oszczędności"));
            databaseHelper.addQuestion(new Question("Co to jest WIG-20?",
                    new String[] {"jest to zestawienie wartości akcji 20 losowo wybranych spółek w danym dniu",
                            "jest to indeks rynku równoległego",
                            "jest to indeks giełdowy obliczony na podstawie wartości portfela akcji 20 największych spółek o najwyższej płynności na Giełdzie Papierów Wartościowych w Warszawie"},
                    "jest to indeks giełdowy obliczony na podstawie wartości portfela akcji 20 największych spółek o najwyższej płynności na Giełdzie Papierów Wartościowych w Warszawie"));
            databaseHelper.addQuestion(new Question("Makler to osoba, która:",
                    new String[] {"jest uprawniona do przeprowadzania transakcji skupu i sprzedaży papierów wartościowych",
                            "zezwala spółce na emisję papierów wartościowych",
                            "prowadzi operacje skupu i sprzedaży walut zagranicznych"},
                    "jest uprawniona do przeprowadzania transakcji skupu i sprzedaży papierów wartościowych"));
            databaseHelper.addQuestion(new Question("Zadaniem Krajowego Depozytu Papierów Wartościowych jest:",
                    new String[] {"gromadzenie dokumentacji spółek wprowadzanych na giełdę, zwłaszcza sprawozdań finansowych",
                            "prowadzenie i nadzorowanie systemu depozytowo-rozliczeniowego w zakresie obrotu instrumentami finansowymi",
                            "ocena i weryfikacja sprawozdań finansowych spółek giełdowych"},
                    "prowadzenie i nadzorowanie systemu depozytowo-rozliczeniowego w zakresie obrotu instrumentami finansowymi"));
            databaseHelper.addQuestion(new Question("Sytuację inwestora, który posiada albo jest zobowiązany do zakupu w przyszłości jakichś instrumentów finansowych lub towarów określamy jako:",
                    new String[] {"pozycja wyczekująca",
                            "pozycja strategiczna",
                            "pozycja długa"},
                    "pozycja długa"));
            databaseHelper.addQuestion(new Question("Pierwszy fixing w systemie podwójnego fixingu na Warszawskiej Giełdzie Papierów Wartościowych w Warszawie jest przeprowadzany o godzinie:",
                    new String[] {"12:00",
                            "11:00",
                            "11:15"},
                    "11:00"));
            databaseHelper.addQuestion(new Question("Najszerszym indeksem giełdowym jest:",
                    new String[] {"WIG",
                            "WIRR",
                            "MIDWIG"},
                    "WIG"));
            databaseHelper.addQuestion(new Question("Ile firm wchodzi w skład indeksu mWIG40?",
                    new String[] {"20",
                            "40",
                            "100"},
                    "40"));
            databaseHelper.addQuestion(new Question("Kluczowym krokiem jaki musi wykonać firma przed wejściem na giełdę jest:",
                    new String[] {"reklama w gazetach",
                            "zorganizowanie konferencji prasowej",
                            "złożenie w Komisji Papierów Wartościowych i Giełd prospektu emisyjnego"},
                    "złożenie w Komisji Papierów Wartościowych i Giełd prospektu emisyjnego"));
            databaseHelper.addQuestion(new Question("Czy handlowanie prawami poboru w Polsce jest zakazane?",
                    new String[] {"nie",
                            "tak",
                            "tylko przez dwa tygodnie przed emisją publiczną"},
                    "nie"));
            databaseHelper.addQuestion(new Question("Czy każda spółka akcyjna jest notowana na giełdzie?",
                    new String[] {"tak",
                            "tak jeżeli jej kapitał zakładowy wynosi co najmniej 10 mln EURO",
                            "nie"},
                    "nie")); // 69 pytań
            databaseHelper.addQuestion(new Question("Osoba poręczająca weksel to:",
                    new String[] {"trasant",
                            "awalista",
                            "remitent"},
                    "awalista"));
            databaseHelper.addQuestion(new Question("Deklaracja wekslowa:",
                    new String[] {"wraz z wekslem trasowanym „realizuje” funkcję gwarancyjną weksla",
                            "wraz z wekslem in blanco „realizuje” funkcję gwarancyjną weksla",
                            "nie dotyczy weksli in blanco"},
                    "wraz z wekslem in blanco „realizuje” funkcję gwarancyjną weksla"));
            databaseHelper.addQuestion(new Question("Żyrant to:",
                    new String[] {"osoba, która wystawia weksel",
                            "osoba nie posiadająca wiarygodności kredytowej",
                            "inaczej poręczyciel"},
                    "inaczej poręczyciel"));
            databaseHelper.addQuestion(new Question("Odsetki dopisywane do kapitału jednorazowo po upływie okresu odsetkowego to:",
                    new String[] {"odsetki dyskontowe",
                            "odsetki redyskontowe",
                            "odsetki proste"},
                    "odsetki proste"));
            databaseHelper.addQuestion(new Question("Kredyt lombardowy:",
                    new String[] {"jest udzielany przez banki pod zastaw papierów wartościowych, towarów i wartościowych przedmiotów",
                            "jest wysoko oprocentowanym kredytem udzielanym tylko w dewizach",
                            "nie ma zastosowania w polskim systemie bankowym"},
                    "jest udzielany przez banki pod zastaw papierów wartościowych, towarów i wartościowych przedmiotów"));
            databaseHelper.addQuestion(new Question("Charakterystyczną cechą kredytu lombardowego jest:",
                    new String[] {"zawsze wysokie oprocentowanie",
                            "posiadanie przez bank przedmiotu zastawu",
                            "posiadanie przez kredytobiorcę przedmiotu zastawu"},
                    "posiadanie przez bank przedmiotu zastawu"));
            databaseHelper.addQuestion(new Question("Reforma pieniężna polegająca na wycofaniu znaków pieniężnych znajdujących się w obiegu i zastąpienie ich znakami o niższym nominale, przy równoczesnej zmianie skali cen to:",
                    new String[] {"deprecjacja",
                            "denominacja",
                            "deflacja"},
                    "denominacja"));
            databaseHelper.addQuestion(new Question("W którym roku polskie prawo dopuściło prowadzenie kantorów?",
                    new String[] {"1955",
                            "1989",
                            "1970"},
                    "1989"));
            databaseHelper.addQuestion(new Question("ELIXIR to:",
                    new String[] {"elektroniczny system rozliczeń międzybankowych",
                            "elektroniczny system rozliczeń międzybankowych",
                            "język programowania stosowany do programów bankowych"},
                    "elektroniczny system rozliczeń międzybankowych"));
            databaseHelper.addQuestion(new Question("SKARBNET to system rozliczeniowy dla:",
                    new String[] {"bonów pieniężnych",
                            "bonów skarbowych",
                            "weksli"},
                    "bonów skarbowych"));
            databaseHelper.addQuestion(new Question("Dewizy to inaczej:",
                    new String[] {"gotówka",
                            "banknoty dolarowe",
                            "papiery wartościowe i inne dokumenty pełniące funkcję środka płatniczego, wystawione w walutach obcych"},
                    "papiery wartościowe i inne dokumenty pełniące funkcję środka płatniczego, wystawione w walutach obcych"));
            databaseHelper.addQuestion(new Question("Euro jest walutą emitowaną przez:",
                    new String[] {"Radę Europy",
                            "NBP",
                            "Europejski Bank Centralny"},
                    "Europejski Bank Centralny"));
            databaseHelper.addQuestion(new Question("Zlecenie otwarcia akredytywy składa:",
                    new String[] {"importer w banku importera",
                            "importer w banku importera",
                            "eksporter w banku eksportera"},
                    "importer w banku importera"));
            databaseHelper.addQuestion(new Question("Gdy zobowiązania w danej walucie lub określonej grupie walut przeważają nad wierzytelnościami występuje pozycja walutowa:",
                    new String[] {"pasywna",
                            "krótka",
                            "długa"},
                    "krótka"));
            databaseHelper.addQuestion(new Question("Do biernych operacji bankowych zaliczamy:",
                    new String[] {"udzielanie kredytów",
                            "gromadzenie wkładów i lokat",
                            "udzielanie wyspecjalizowanych porad"},
                    "gromadzenie wkładów i lokat"));
            databaseHelper.addQuestion(new Question("Polskie prawo bankowe uzależnia decyzję o przyznaniu kredytu od:",
                    new String[] {"doświadczenia kredytobiorcy",
                            "wykształcenia kredytobiorc",
                            "zdolności kredytowej kredytobiorcy"},
                    "zdolności kredytowej kredytobiorcy"));
            databaseHelper.addQuestion(new Question("Gdy faktor nabywa należności bez prawa regresu to:",
                    new String[] {"przyjmuje na siebie pełne ryzyko niewypłacalności dłużnika",
                            "przyjmuje na siebie pełne ryzyko niewypłacalności wierzyciela",
                            "nie przyjmuje na siebie pełnego ryzyka niewypłacalności dłużnika"},
                    "przyjmuje na siebie pełne ryzyko niewypłacalności dłużnika"));
            databaseHelper.addQuestion(new Question("W Polsce banki hipoteczne mogą działać wyłącznie w formie:",
                    new String[] {"spółki akcyjnej",
                            "spółdzielni",
                            "przedsiębiorstw państwowych"},
                    "spółki akcyjnej"));
            databaseHelper.addQuestion(new Question("Jaka hipoteka nie występuje w polskim prawie:",
                    new String[] {"hipoteka zwykła",
                            "hipoteka wieczna",
                            "hipoteka przymusowa"},
                    "hipoteka wieczna"));
            databaseHelper.addQuestion(new Question("Zastaw to:",
                    new String[] {"blokada rachunku",
                            "ograniczone prawo rzeczowe, które ma na celu zabezpieczenie określonej wierzytelności",
                            "nieograniczone prawo rzeczowe, które ma na celu zabezpieczenie określonej wierzytelności"},
                    "ograniczone prawo rzeczowe, które ma na celu zabezpieczenie określonej wierzytelności")); // 89 pytań

            //get list from database again
            quesList = databaseHelper.getAllQuestions();
        }
    }
}
