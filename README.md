# Sprawdzenie środowiska

1. Przeczytaj dokładnie wymagania techniczne dotyczące środowiska i upewnij się, że masz zainstalowane wymagane oprogramowanie w odpowiednich wersjach
2. Sklonuj projekt i zaimportuj go do IntelliJ
3. Uruchom komendę mvn clean install. Po jej uruchomieniu sprawdzone zostaną następujące rzeczy:
  * Czy masz dostęp do maven repository i czy wszystkie wymagane zależności poprawnie się ściągnęły
  * Czy Spring Boot jest w stanie się uruchomić
  * Czy Docker jest zainstalowany oraz czy jest w stanie ściągnąć obraz
  
W przypadku problemów skontaktuj się z trenerem na slacku.


# Podsumowanie

1. JUnit 5
 - biblioteka pozwalająca nam na pisanie, wykrywanie i uruchamianie testów jednostkowych
 - posiada wsparcie dla prostych i bardziej zaawansowanych asercji (_assertThrows_, _assertTimeout_)
 - przy użyciu adnotacji DisplayName jesteśmy w stanie wpływać na to, aby nazwa testu wyświetliła się w bardziej ludzkiej formie
 - korzystając z DisplayNameGenerator oraz junit-platform.properties jesteśmy w stanie skonfigurować w jaki sposób będą generowane nazwy testów w raporcie
 - warto ujednolicić sposób pisania testów - obiekt testowy ma zawsze nazwę _testObj_, dzielmy testy na trzy fazy given / when / then
 - bardzo dobra [dokumentacja](https://junit.org/junit5/docs/current/user-guide/)

2. AssertJ
 - zaawansowany biblioteka do sprawdzania rezultatów naszych testów
 - polecana nawet przez twórców JUnit 5
 
3. Mockito
 - pozwala na mockowanie obiektów w celu uniezależnienia się od innych klas
 - pozwala na określenie co ma zostać zwrócone z metody jeżeli zostanie wykonana z odpowiednimi parametrami
 - nagrywa wszystkie wywołania danej metody i pozwala na późniejszą weryfikację czy dana metoda została uruchomiona
 - pomimo, że oferuje szereg dodatkowych funkcjonalności takich jak matchery lub sprawdzanie kolejnośći wywołań należy uważać, żeby nie scementowac za bardzo testów. Powinniśmy zawsze testować zachowanie, a nie implementację
 
4. JUnit 5 Extension API
 - pozwalają na łatwe dodawanie nowych funkcjonalności do JUnit, np. MockitoExtension
 - warty przeczytania [artykuł](https://nipafx.dev/junit-5-extension-model) wyjaśniający koncepcję
 
5. Spring Boot Test
 - pozwala na pisanie testów przy uruchomionym kontekście Springa
 - zostaje wczytywana konfiguracja oraz uruchomione zostaną wszystkie autokonfiguracje
 - przydatne do testowania integracyjnego
 - aby przetestować endpointy należy wykorzystać narzędzie mockMVC dostarczane przez Spring Boot
 - beany można mockować korzystając z adnotacji @MockBean
 
6. Slice Test
 - pozwalają na załadowanie tylko części kontekstu, dzięki czemu testy wykonują się szybciej
 - np. WebMvcTest ładuje tylko wskazany controller oraz beany odpowiedzialne za walidację oraz serializację obiektu. Żadne inne klasy oznaczone jako @Component nie zostaną wczytane do kontekstu i należy je zamockować
 - istnieje wiele różnych typów slice testów np. @DataJpaTest, @DataRedisTest itp.
 
7. Spring Test Security
 - pozwala na łatwe testowanie aplikacji Springowych w kontekście Security
 - przy pomocy adnotacji @WithMockUser dostarczamy podstawowego użytkownika do SecurityContext i cała warstwa filtrów jest omijana
 - jeżeli chcemy dostarczyć własną implementację użytkownika należy użyć @WithUserDetails
 
8. Database provisioning
 - aby dostarczyć bazę danych do testów możemy skorzystać z wielu róznych opcji
 - InMemoryDatabase np. H2 - dobre rozwiązanie w większości przypadków, ale jeżeli korzystamy ze specyficznych funkcji danego silnika SQL nasze testy mogą przestać działać
 - EmbeddedDatabase - dobre rozwiązanie jeżeli nie mamy dostępu do dockera. Uruchamia prawdziwą bazę danych w kontekście testów, ale jesteśmy zdani na te wersje bazy danych które autor biblioteki wspiera,
 - TestContainers - jeżeli mamy dostęp do dockera jesteśmy w stanie dostarczyć dowolną bazę danych w dowolnej wersji, dzięki czemu nasze testy bardziej odwzorowują rzeczywiste środowisko
 
9. Data provisioning:
 - adnotacja @Sql pozwala na uruchomienie konkretnego pliku .sql z resources, który dostarczy nam dane do bazy danych
 - ObjectMother pattern - połączenie builderów, szablonów danych oraz DataManagera pozwala nam na łatwe dostarczanie prawdziwych danych do testów

10. Spring Contract
 - pozwala na łatwe testowanie zarówno producera endpointów restowych jak i consumera, dzięki czemu możemy mieć pewność, że obie aplikację będą w stanie się ze sobą skomunikować