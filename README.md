# Programowanie Obiektowe (INEW00003P)


## Cel projektu
Stworzenie prostej symulacji agentowej z wykorzystaniem technik projektowania
obiektowego.

Program modelujący wybrany wycinek rzeczywistości, a dokładniej obiekty i występujące
pomiędzy nimi interakcje.
Model ma być wprawiany w ruch wykorzystując generowane losowo zdarzenia, które
zmuszają obiekty do rozmaitych działań.

Program powinien informować (np. za pomocą wyjścia konsoli) o tym, w jakim stanie się znajduje i jak przebiega symulacja.

### Uwagi
#### Projektowe
- Interfejs (np. graficzny) nie jest wymagany - w zupełności wystarczające jest loggowanie informacji o stanie i przebiegu informacji do konsoli.
Można do tego wykorzystać po prostu `System.out.print` lub lepiej - [logger](https://www.baeldung.com/java-system-out-println-vs-loggers).
Jeżeli jednak zdecydują się Państwo na zaimplementowanie interfejsu (z perspektywy nabytych umiejętności, najlepiej wybrać [interfejs HTTP](https://www.baeldung.com/building-a-restful-web-service-with-spring-and-java-based-configuration)), to:
  - Jego klasy nie będą się wliczały do całkowitej liczby klas
  - Moduły symulacji nie mogą zależeć od klas interfejsu. Innymi słowy, żadna z klas symulacji nie może używać obiektów odpowiedzialnych za interfejs (w drugą stronę natomiast tak). 

#### Ogólne
- [Interfejs](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html) niekoniecznie musi opisywać tylko jakąś jedną wykonywaną czynność. 
Jest to kontrakt, często tworzony na potrzeby konkretnego modułu, lub nawet jednej klasy (np. w celu [odwrócenia zależności](https://bottega.com.pl/pdf/materialy/receptury/ioc.pdf)).
Interfejs może przykładowo definiować źródło i ujście danych dla jakiegoś modułu (mówimy wtedy o repozytorium) i posiadać metody `read` i `save` - samego modułu
 nie obchodzi to, czy odczytuje on dane z bazy relacyjnej, pliku czy z innego systemu poprzez `HTTP`. Dla danej klasy ważny jest sam kontrakt opisujący czynności niezbędne do jej poprawnego działania. 
- Odpowiadają sobie na pytanie na to, jakie metody powinien zawierać interfejs (i czy powinien w ogóle istnieć), dobrze jest spojrzeć na niego z perspektywy klasy, która go używa.
- Proszę unikać używania metod domyślnych w interfejsach.


### Przykłady
- Symulacja życia kolonii różnego rodzaju organizmów. Każda z grup organizmów posiada odmienne właściwości i wzorce zachowań. Symulację rozpoczynamy od utworzenia losowej planszy z zasobami o zadanych wymiarach, następnie losowo rozmieszczamy na niej organizmy. Organizmy losowo poruszają się po planszy. Każde z pól może posiadać np. pożywienie. Organizmy różnego typu mogą umierać po jakiejś charakterystycznej liczbie bez pożywienia pól. Symulacja może kończyć się w momencie, gdy na planszy zostanie jeden (lub żaden) organizm.
- Poruszanie się oddziałów wojskowych po mapie. Wojska różnego typu poruszają się po mapie niewielkiej. Gdy spotykają się ze sobą, prowadzą bitwę (lub łączą się w jedną jednostkę, możliwości jest wiele)
- Symulacja lotniska

## Wymagania

### Odnośnie zawartości projektu
- Minimum 5 klas (bez interfejsów i abstrakcyjnych)
- Hermetyzacja metod i danynch
- Kompozycja/agregacja
- Polimorfizm

## Materiały

### Pierwsze zajęcia
- Najpowszechniej używane środowisko do Javy - [Intellij IDEA](https://www.jetbrains.com/student/)
- Do diagramów polecam [PlantUML](https://plantuml.com/) lub [Visual Paradigm](https://www.visual-paradigm.com/)
### Programowanie
- [Clean Code: A Handbook of Agile Software Craftsmanship](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882) - "must read" dla osób chcących pisać dobry kod. Nie wymagam przeczytania całej książki, proszę przynajmniej zapoznać się z podsumowaniami (poniżej)
- [Podsumowanie Clean Code #1](https://gist.github.com/wojteklu/73c6914cc446146b8b533c0988cf8d29) 
- [Podsumowanie Clean Code #2](http://www.inf.fu-berlin.de/inst/ag-se/teaching/K-CCD-2014/Clean-Code-summary.pdf)
- [Dlaczego lepiej jest stosować kompozycję, niż dziedziczenie](https://www.youtube.com/watch?v=wfMtDGfHWpA)
- [Wzorce projektowe w Javie](https://java-design-patterns.com/patterns/) - na start polecam kategorię ["Gang of Four"](https://en.wikipedia.org/wiki/Design_Patterns)
- [Świetna prezentacja o modularności (dla zaawansowanych)](https://www.youtube.com/watch?v=ILBX9fa9aJo)
