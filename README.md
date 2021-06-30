# pracownia
Po uruchomieniu programu bez parametrów, należy wprowadzić ścieżkę katalogu, w którym znajdują się pliki Excela (z rozszerzeniem xls lub xlsx) do przetworzenia. 
Można też podać katalog nadrzędny, pod którym są podkatalogi z odpowiednimi plikami.
Katalogi powinny zawierać wyłącznie pliki excela zgodne z formatem zawartym w przykładowych plikach w folderze \target\classes\2012

Można także wywołać program z lini komend dodając parametr -filename i ścieżkę w cudzysłowie.
Przykład
java -jar pracownia.jar -filename "c:\pracownia"

Uwaga: Nie należy kończyć ścieżki backslashem np nieprawidłowo będzie "c:\pracownia\" (*)

gotowy plik jar znajduje się w target\pracownia-1.0-SNAPSHOT-jar-with-dependencies.jar


(*) Nie znalazłem na to rozwiązania - jeśli ścieżkę wprowadza się z lini komend i jest zakończona \, aplikacja wogóle nie zaczyna się wykonywać
tylko wyświetla jakby prompta ">". Wygląda na to że nawet pierwsza linia maina nie jest wykonana. 