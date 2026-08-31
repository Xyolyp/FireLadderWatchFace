# Drehleiter Watchface (Pixel Watch / Wear OS)

Ein Watch Face Format (WFF) v1 Watchface mit einer Feuerwehr-Drehleiter als analoger Uhr.

![Preview des Watchfaces (10:00 Uhr)](watchface/src/main/res/drawable/preview.png)

## Anzeige

- Feuerwehrfahrzeug von oben = Stundenzeiger
- Drehteller = Mittelpunkt
- ausgefahrene Drehleiter + Korb = Minutenzeiger
- zur vollen Stunde (`MINUTE == 0`) blinken die beiden Blaulichter 60 Sekunden lang abwechselnd
- Blaulicht ist im Ambient / Always-on-Display deaktiviert
- das dezente Zifferblatt reagiert leicht auf die Neigung der Uhr; die eigentlichen Zeiger bleiben geometrisch am Mittelpunkt, damit die Uhrzeit korrekt bleibt

## Projekt

Das Watchface ist deklarativ in `watchface/src/main/res/raw/watchface.xml` umgesetzt. Es enthält absichtlich keinen App-Code; das Manifest verwendet `android:hasCode="false"`.

## In Android Studio installieren

1. Projektordner in Android Studio öffnen.
2. Falls Android Studio nach dem Android SDK 35 fragt, installieren lassen.
3. Falls noch kein Gradle Wrapper verfügbar ist, in einer vorhandenen Gradle-Installation einmal ausführen:
   `gradle wrapper --gradle-version 9.2.1`
4. Pixel Watch per Wireless Debugging / ADB mit Android Studio verbinden.
5. Run-Konfiguration für das Modul `watchface` starten.
6. Das Watchface `Drehleiter` auf der Uhr auswählen.

## Hinweise

- Das Projekt ist auf Wear OS API 33+ ausgelegt und damit für die Pixel Watch 1 geeignet.
- Die Blaulichter blinken absichtlich statt dauerhaft zu leuchten. Die Logik steht direkt in `watchface.xml` und kann leicht auf Dauerlicht geändert werden.
- Die Geometrie ist komplett aus WFF-Vektorprimitiven aufgebaut; es gibt keine Bitmap-Abhängigkeit für das eigentliche Watchface.
