# M223: Punchclock
Das ist die Erweiterung des Beispiel Projektes Punchclock. Es wurden folgende Dinge geändert: 
- Authentifizerung mittels JWT Token hinzugefügt.
- Neue Entität Role hinzugefügt 
- Neue Entität Task hinzugefügt 

## Starten
Bevor man die Applikation startet sollte man überprüfen ob die JDK 12 installiert ist.
Dannach geht man ins Stammverzeichniss der App, öffnet das Terminal und tippt folgenden Befehl ein: `./gradlew bootRun`

## Funktionen und Nutzerschnittstellen
- Unter http://localhost/sign-up.html befindet sich das Registrierungsformular
- Unter http://localhost/login.html befindet sich das Loginformular
- Unter http://localhost/user.html erreicht man die Nutzerschnitstelle für die User
- Unter http://localhost/role.html erreicht man die Nutzerschnitstelle für die Rollen
- Unter http://localhost/index.html erreicht man die Nutzerschnitstelle für die Entries
