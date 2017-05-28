## Przygotowanie do rozmowy kwalifikacyjnej

## Autorzy projektu
1. Patrycja Kazek s186799 KrDZIs3012Io
2. Joanna Kolańczyk s186883 KrDZIs3012Io

## Opis Aplikacji

Aplikacja służy do przypomnienia najważniejszych definicji z zakresu finansów. Przeznaczona jest dla użytkowników, którzy pragną odświeżyć sobie zagadnienia finansowe przed rozmową o pracę czy przed ważnymi egzaminami. Aplikacja będzie działa w formie testu(quizu). Pytania są przechowywane w wewnętrznej bazie danych użytkownika (SQLite) z możliwością aktualizacji. Dostępne są również statystyki wszystkich graczy przechowywane w zewnętrznej bazie danych.

## Funkcjonalności
- 3 poziomy trudnośc: łatwy, średni, trudny;
- możliwość ustawienia własnego nicku;
- zapis wyniku do bazy danych;
- Wyświetlanie statystyk wszystkich graczy;

## Użyta technologia

Projekt powstał w oparciu o Android SDK z wykorzystaniem pakietu Android Studio i jezyka Java. 

## Dokumentacja

**Wykorzystane klasy**

W projekcie wykorzystane zostały zagadnienia znane z zajęć. Użyte zostały m.in aktywności, intencje, preferencje, AsyncTask, SQLiteOpenHelper, alertDialog.


**Obsługa Aplikacji**

Po włączeniu programu włączona zostaje krótka animacja. Po jej zakończeniu użytkownik proszony jest o padanie nicku, który będzie go identyfikował w czasie dalszego kożystania z funkcjonalności aplikacji.Po wpisaniu nicku i zatwierdzeniu, włączane jest główne menu aplikacji z czterema przyciskami. Użytkownik ma możliwość sprawdzania swojej wiedzy na 3 poziomach trudności, które różnią się czasem, który jest przewidziany na udzielanie odpowiedzi na poszczególne pytania, jest on rózny w zależności od wybranego poziomu trudności. Po upływie czasu wyświetlany jest procentowy wynik jaki osiągnął użytkownik wraz z obrazującym go poziomem wypełnienia Progressbar. Jeżeli użytkownik ma połączenie z Internetem jego wynik wraz z nickiem jest zapisywany w bazie danych, w przeciwnym wypadku wyświetlany jest komunikat informujący, że wynik nie zostanie zapisany. Użytkownik ma również możliwość porówania swoich wyników z wynikami innych jeżeli oczywiście posiada połączenie z internetem, jego brak sygnalizowany jest odpowiednim komunikatem. 

**Wygląd aplikacji**

Wygląd poszczególnych aktywności aplikacji widoczny jest w albumie umieszczonym na stronie imgur.com. Link do strony znajduje się poniżej:

[Aplikacja](http://imgur.com/a/tIP5g)
