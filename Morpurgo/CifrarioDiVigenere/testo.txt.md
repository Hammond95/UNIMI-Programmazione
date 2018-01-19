------------------------------------------------------------------
ESERCIZIO 3: UN ESEMPIO DI CIFRATURA (CIFRARIO DI VIGENERE)
==========================================================

Un noto metodo di cifratura consiste nel ruotare le lettere di 
una parola in base a una parola chiave, nota a mittente e 
destinatario, detta verme.

Per semplicita' consideriamo solamente parole contenenti solo 
lettere maiuscole.

Date due lettere maiuscole L1 e L2, scriviamo

  L1 + L2 = LROT

per indicare che la lettera LROT e' ottenuta ruotando L1 del 
numero di posti corrispondenti alla posizione di L2 nell'alfabeto 
(vedi Esercizio 1).

Ad esempio

  C + B = D

in quanto B ha posizione 1 e ruotando C di 1 si ottiene D.

Analogamente:

   X + A = X   // A ha posizione 0
   X + B = Y
   X + C = Z
   X + D = A 
   X + E = B


La cifratura avviene come segue.

Supponiamo che la parola in chiaro da cifrare sia

   ACCALAPPIAFANTASMI

e il verme sia VERME.

Scriviamo sotto la parola il verme tante volte quanto basta
per coprirne la lunghezza  (eventualmente l'ultimo verme e' troncato)

  ACCALAPPIAFANTASMI
  VERMEVERMEVERMEVER


La parola cifrata si ottiene  "sommando"  le lettere  sulla stessa colonna.

Poiche'

	A + V = V
	C + E = G
	C + R = T
	A + M = M
	L + E = P
	A + V = V
	P + E = T
	P + R = G
	I + M = U
	A + E = E
	F + V = A
	A + E = E
	N + R = E	
	T + M = F
	A + E = E
	S + V = N
	M + E = Q
	I + R = Z

la parola cifrata e'

VGTMPVTGUEAEEFENQZ


Scrivere un programma Vigenere che legge la parola da cifrare e 
il verme, trasformando tutte le lettere in maiuscole.

Il programma deve stampare le somme eseguite per cifrare la parola 
e la parola cifrata. 

Si noti NON e' necessario costruire la stringa contenente le 
ripetizoni del verme.

ESEMPI
-----

Parola? 
	fenicottero
Verme?  
	ape
	
F + A = F
E + P = T
N + E = R
I + A = I
C + P = R
O + E = S
T + A = T
T + P = I
E + E = I
R + A = R
O + P = D

FTRIRSTIIRD

----------

Parola? 
	accalappiafantasmi
Verme?  
	verme
	
A + V = V
C + E = G
C + R = T
A + M = M
L + E = P
A + V = V
P + E = T
P + R = G
I + M = U
A + E = E
F + V = A
A + E = E
N + R = E
T + M = F
A + E = E
S + V = N
M + E = Q
I + R = Z

VGTMPVTGUEAEEFENQZ

-------------------------------------------------------------------
ESERCIZIO 4: DECIFRAZIONE
=========================

Supponiamo ora di voler decifrare una parola cifrata  come 
nell'Esercizio 3 conoscendo il verme.
Una possibilita' e' quella  di modificare il programma Vigenere 
eseguendo le rotazioni in senso opposto (attenzione ai valori negativi).

Oppure,  si puo' usare il programma Vigenere usando come chiave un 
"antiverme" ottenuto  applicando le seguenti sostituzioni al verme:

	A ---> A
	B ---> Z
	C ---> Y
	D ---> X
	E ---> W
	F ---> V
	G ---> U
	H ---> T
	I ---> S
	J ---> R
	K ---> Q
	L ---> P
	M ---> O
	N ---> N
	O ---> M
	P ---> L
	Q ---> K
	R ---> J
	S ---> I
	T ---> H
	U ---> G
	V ---> F
	W ---> E
	X ---> D
	Y ---> C
	Z ---> B

Si noti che la seconda colonna  dal basso verso l'alto
contiene le lettere dell'alfabeto ruotate di uno.

Ad esempio, l'antiverme di APE e'  ALW
Codificando FTRIRSTIIRD con verme ALW si ottiene 
FENICOTTERO.

L'antiverme di VERME e'  FWJOW
Codificando VGTMPVTGUEAEEFENQZ con verme FWJOW si ottiene ACCALAPPIAFANTASMI

Scrivere un programma AntiVerme che, inserito un verme, stampa l'antiverme.

Per determinare come va trasformata una lettere e' sufficiente scrivere
una opportuna espressione aritmetica.


Cosa succede codificando un verme usando come verme il suo antiverme?
(ad esempio, codificando VERME usando come verme FWJOW, oppure APE con ALW)
