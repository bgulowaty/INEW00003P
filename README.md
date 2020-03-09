# Programowanie Obiektowe (INEW00003P)

## Aktualizacje
- **01.03.2020** | Podstawowe informacje 
- **07.03.2020** | Dodano przykładową aplikację ([`examples/index`](examples/index)) oraz sekcję materiały.
Zachęcam do zapoznania się z kodem. Zostało tam wykorzystanch kilka użytecznych technik programowania obiektowego 
i właściwości Javy. Proszę nie kopiować projektu, ale spróbować dogłębnie zrozumieć potrzebę 
zastosowanie konkretnych interfejsów i ogólny przepływ kodu. 
- **08.03.2020** | Dodano zgłoszone grupy

## Grupy

Proszę sprawdzić i w razie błędu mnie poinformować.

| hex(sha256(indeks))[:10] | temat symulacji | 
|--------------------------|--------| 
| 109aca0eb0, 10c0ab27d |        | 
| 6a56afc3b8, b503cd3e20 | szachy | 
| d6ee3d7bbb, 1bae221c16 |        | 
| b2f8d6c769, eeb47fdff5 | wirus  | 
| a89269eb1e, d3a3e6d07f |        | 
| 8830cbfb72, 94f8f513e4 |        | 
| fd462c3af6, 14d9355a25 |        | 
| 3ff598b1a9, eaef94617a |        | 
| 5368816403, f229286545 |        | 
| 198bc46d31, d3312c6248 |        | 
| 27b9f19ab7             |        | 
| 48745f1e83, f1cb147b76 |        | 
| 81737a5de6, 6a869198cb |        | 
| 873008d26f, 6159e817e3 |        | 
| 293d1e9078, 10ac38a456 |        | 
| 04a12548e9             |        | 
| 1770065c18, 4ec798a356 |        | 
| 08a1f76d44, 6b82b008b6 |        | 

Osoby bez grupy: 803e59f253, 2fc52d3924, 9c4f2e2c0a



## Cel projektu
Stworzenie prostej symulacji agentowej z wykorzystaniem technik projektowania
obiektowego.

Program modelujący wybrany wycinek rzeczywistości, a dokładniej obiekty i występujące
pomiędzy nimi interakcje.
Model ma być wprawiany w ruch wykorzystując generowane losowo zdarzenia, które
zmuszają obiekty do rozmaitych działań.

Program powinien informować (np. za pomocą wyjścia konsoli) o tym, w jakim stanie się znajduje i jak przebiega symulacja.

### Przykłady
- Symulacja życia kolonii różnego rodzaju organizmów. Każda z grup organizmów posiada odmienne właściwości i wzorce zachowań. Symulację rozpoczynamy od utworzenia losowej planszy z zasobami o zadanych wymiarach, następnie losowo rozmieszczamy na niej organizmy. Organizmy losowo poruszają się po planszy. Każde z pól może posiadać np. pożywienie. Organizmy różnego typu mogą umierać po jakiejś charakterystycznej liczbie bez pożywienia pól. Symulacja może kończyć się w momencie, gdy na planszy zostanie jeden (lub żaden) organizm.
- Poruszanie się oddziałów wojskowych po mapie. Wojska różnego typu poruszają się po mapie niewielkiej. Gdy spotykają się ze sobą, prowadzą bitwę (lub łączą się w jedną jednostkę, możliwości jest wiele)
- Symulacja lotniska


## Kamienie milowe

| | Data | Opis
| ------------ | ------------ | -------------
| :heavy_check_mark: | 05.03.2020 | Stworzenie grupy (2. zajęcia) - proszę wysłać mejlowo z wyszczególnionym Liderem.
| :white_check_mark: | 02.04.2020 | Opcjonalne zadanie, które wrzucę tutaj (niedługo).
| :white_check_mark: | 02.04.2020 | Wybór tematu (6. zajęcia). Każda grupa przedstawia **dwie** różne propozycje zadań symulacyjnych. Do każdego z tematów należy przygotować opis zakresu projektu.
| :white_check_mark: | (TBA) | Szczegółowy opis systemu (8. zajęcia).
| :white_check_mark: | (TBA) | Opis logiki symulacji (10. zajęcia).
| :white_check_mark: | (TBA) | Implementacja (12. zajęcia).
| :white_check_mark: | (TBA) | Prezentacja działającej symulacji (14. zajęcia).
| :white_check_mark: | (TBA) | Oddanie projektu (15. zajęcia).


> **UWAGA**:
Poza kamieniami milowymi spotykamy się w ramach konsultacji. Zachęcam do zjawienia się lub wyslania mejla, jeśli jakieś rzeczy związane z programowaniem są niezrozumiałe. 

## Minimalne wymagania
- Minimum 5 klas (bez interfejsów i abstrakcyjnych)
- Hermetyzacja metod i danynch
- Kompozycja/agregacja
- Polimorfizm


## Zawartość projektu
- Program symulacyjny
  - Kod programu (Java, Kotlin, Groovy, JDK $\geq 8$)
  - Komentarze klas (tzw. Java Docs)
  - Pliki budowania (`build.gradle` lub `pom.xml`)
- Dokumentacja
  - Temat projektu, skład grupy
  - Opis zadania symulacji w języku naturalnym
  - Analiza czasownikowo - rzeczownikowa
  - Diagramy przypadków użycia
  - Karty CRC dla klas
  - Inne diagramy UML (co najmniej jeden):
    - diagram sekwencji
    - diagram aktywności
    - diagram maszyny stanów
  - Dokumentacja UML wygenerowana na podstawie komentarzy w kodzie
- Elementy dodatkowe:
  - Repozytorium projektu (obecine nie ma sensu uczyć się niczego innego niż `git`, mocno zachęcam do rozpoczęcia nauki już teraz - bardzo przyda się w przyszłości)
  - Unit testy (dla Javy najczęściej używane biblioteki to `JUnit 4/5` i `Mockito`)

## Ocenianie
<!-- Niestety, github nie wspiera LaTeXa -->

![P = \frac{\overline{K_1} + \overline{K_2}}{K_1 + K_2} * 100](https://render.githubusercontent.com/render/math?math=P%20%3D%20%5Cfrac%7B%5Coverline%7BK_1%7D%20%2B%20%5Coverline%7BK_2%7D%7D%7BK_1%20%2B%20K_2%7D%20*%20100)

![K_1](https://render.githubusercontent.com/render/math?math=K_1) - dokumentacja (0-20)

![K_2](https://render.githubusercontent.com/render/math?math=K_2) - jakość kodu (0-40)

![P \in \[0;50\] \rightarrow 2.0](https://render.githubusercontent.com/render/math?math=P%20%5Cin%20%5B0%3B50%5D%20%5Crightarrow%202.0) 

![P \in (50;60\] \rightarrow 3.0](https://render.githubusercontent.com/render/math?math=P%20%5Cin%20\(50%3B60%5D%20%5Crightarrow%203.0)

![P \in (60;70\] \rightarrow 3.5](https://render.githubusercontent.com/render/math?math=P%20%5Cin%20\(60%3B70%5D%20%5Crightarrow%203.5)

![P \in (70;80\] \rightarrow 4.0](https://render.githubusercontent.com/render/math?math=P%20%5Cin%20\(70%3B80%5D%20%5Crightarrow%204.0)

![P \in (80;90\] \rightarrow 4.5](https://render.githubusercontent.com/render/math?math=P%20%5Cin%20\(80%3B90%5D%20%5Crightarrow%204.5)

![P \in (90;100\] \rightarrow 5.0](https://render.githubusercontent.com/render/math?math=P%20%5Cin%20\(90%3B100%5D%20%5Crightarrow%205.0)


## Organizacja

>**UWAGA**: Przed przyjściem na konsultacje proszę napisać mejla z wyprzedzeniem.  


- Można łączyć się w grupy pomiędzy moimi zajęciami czwartek 17:05 i 18:55.
- **Grupy 2 osobowe.** W wyjątkowych sytuacjach 1 (tyle samo pracy) lub 3 (więcej pracy).
- Można przychodzić na wcześniejsze zajęcia, ale pierwszeństwo mają osoby z danego terminu
- Przekazywanie projektów:
  - Moodle (niedługo) 
  - Link do repozytorium git (najlepiej)
- Dokumentacja koniecznie w PDF
- Każda grupa ma Lidera, przy wysyłaniu mejli proszę dołączać drugą osobę w `cc` 

## Materiały

### Pierwsze zajęcia
- [Prezentacja z pierwszych zajęć (+ kod w LaTeXu)](https://www.overleaf.com/read/wzbrmyyvfdmc) (wiedza z zakresu składania tekstu w LaTeXu zaoszczędzi wiele nerwów przy pisaniu pracy inżynierskiej)
- Najpowszechniej używane środowisko do Javy - [Intellij IDEA](https://www.jetbrains.com/student/)
- Do diagramów polecam [PlantUML](https://plantuml.com/) lub [Visual Paradigm](https://www.visual-paradigm.com/)
- Proszę czasami zaglądać na tą stronę, postaram się powrzucać trochę przykładów
 
### Programowanie
- [Clean Code: A Handbook of Agile Software Craftsmanship](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882) - "must read" dla osób chcących pisać dobry kod. Nie wymagam przeczytania całej książki, proszę przynajmniej zapoznać się z podsumowaniami (poniżej).
- [Podsumowanie Clean Code #1](https://gist.github.com/wojteklu/73c6914cc446146b8b533c0988cf8d29) 
- [Podsumowanie Clean Code #2](http://www.inf.fu-berlin.de/inst/ag-se/teaching/K-CCD-2014/Clean-Code-summary.pdf)
- [Dlaczego lepiej jest stosować kompozycję, niż dziedziczenie](https://www.youtube.com/watch?v=wfMtDGfHWpA)
