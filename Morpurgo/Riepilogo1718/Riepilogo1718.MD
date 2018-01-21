Laboratorio 12 - Esercizi di ripasso
------------------------------------

Conta le potenze di due
=======================

Descrizione
-----------

Un numero è una potenza di due se è uguale a 1, o se si può 
ottenere moltiplicando successivamente 2 per se stesso. 
I primi numeri potenza di due sono 1, 2, 4, 8, 16, 32, 64...

Scrivere un programma PotenzeDiDue che, data una sequenza di 
interi positivi terminata da 0 su standard input, emetta in 
uscita quanti tra essi sono potenze di due.


Vincoli
-------

Tutti i numeri coinvolti possono essere rappresentati con 
variabili di tipo long, viceversa non c'è vincolo sul 
numero di interi nella sequenza che (a parte lo 0 finale) 
puo` essere anche vuota.
______________________________________________________________

Disegna rettangoli e triangoli
==============================

Descrizione
-----------

Si considerino le due figure, 

triangolo:

	  *
	 ***
	*****

e rettangolo:

	*****
	*****
	*****

Scrivete un programma DisegnaRT che, data una sequenza 
di lettere "T" e "R" come argomenti sulla linea di comando, 
emetta in uscita una "riga" di triangoli e quadrati, a 
seconda delle lettere specificate, separati da "|".

Ad esempio, data la sequenza

	T R R T

il programma emette

	  *  |*****|*****|  *
	 *** |*****|*****| ***
	*****|*****|*****|*****

Vincoli
-------

Gli argomenti sulla linea di comando sono dati da lettere 
"T" e "R", ma non ci sono vincoli sul loro numero.
______________________________________________________________

Parole crescenti
================

Descrizione
-----------

Diciamo che una parola è crescente se i suoi caratteri sono 
in ordine alfabetico strettamente crescente (ossia se ogni 
carattere viene dopo il precedente in ordine alfabetico).

Ad esempio, sono crescenti: "abet", "benz",  e "struz"; non 
sono invece crescenti: "casa" (perche' la "a" viene prima della 
"c" che la precede) e "struzz" (perchè la seconda "z" non 
viene strettamente dopo la prima "z" in ordine alfabetico).

Scrivere un programma ParoleCrescenti che, data una sequenza 
di parole su standard input, emetta in uscita il numero di 
parole crescenti della sequenza.

Ad esempio, avendo

	abet
	casa
	struzzo
	xyz

in input, il programma emette

	2

in output, in quanto solo "abet" e "xyz" sono crescenti.


Vincoli
-------

Non si possono fare assunzioni sul numero di caratteri presenti 
su ciascuna linea. Le parole sono costituite da lettere minuscole 
e separate tra di loro da simboli di spaziatura (ossia "white-space" 
come ad esempio spazio, "a capo" e segni di tabulazione).

Il numero di parole e` rappresentabile con variabili di tipo long 
(ma non si possono assumere altri vincoli sul numero massimo, o 
sulla lunghezza massima delle parole.
______________________________________________________________

Calcolatrice RPN
================

Descrizione
-----------

In una calcolatrice RPN (notazione polacca inversa) prima si inseriscono 
gli operandi e poi gli operatori e non sono necessarie le parentesi.
Ad esempio l'espressione (4 + 5) * 7 viene rappresentata cosi':
4 5 + 7 *

Scrivere un programma CalcolatriceRPN che legge una serie di operandi 
e operatori da linea di comando, e emette in uscita il valore 
dell'espressione. Per semplicita` consideriamo solo operatori binari
(i quattro operatori aritmetici di base).

Ad esempio, con input 

4 5 + 7 *

il risultato e` 63
______________________________________________________________
