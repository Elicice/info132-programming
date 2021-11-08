Cecilie Lyshoel, cly062

-Sentrale begreper-

Klasse: En mal for objektene i klassen der objektenes oppførsel og tilstand er definert gjennom metoder og konstruktører.

Objekt: Et objekt er instansen i en klasse. Objekter blir opprettet ved å kalle konstruktører, hvis oppgave er å opprette instansene i klassen.
		Et objekt har tilstand og oppførsel som er definert i klassen, og kan endres ved hjelp av konstruktører og metoder.

Felt: Felt er hvor man deklarer variablene i klassen. 

Tilstand: En tilstand er den verdien et objekt har. Tilstanden kan legges til eller endres ved Ved hjelp av metoder og konstruktører. 

Hvordan jeg fant navnet til avsender i metoden reciveMessage:
I klassen Person har jeg opprettet variablen name. Denne variablen har en getter-metode i klassen Person.
Klassen Message oppretter Person sender fra klassen Person. Den er avhengig at konstruktøren i klassen Person for å delarere variablen Person sender.
Det er også en getter på variablen sender i klassen Message som klassen Person kaller i metoden reciveMassage. 

Når man skal laget et et objekt som skal være sender så må man i BlueJ først lage to objekt i klassen Person og så et objekt for klassen Message, 
når man oppretter objektet massage så skriver man hvilke av de to Person-objektene som skal være avsender. Den andre blir da mottaker.
Hadde man brukt en kontrolleklasse, kunne man laget disse objektene manuelt i stede for "interativt".