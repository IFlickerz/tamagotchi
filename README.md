## Especificações do Tamagotchi
<br>

O Tamagotchi tem cansaço (sono), fome e felicidade (tédio). Cada uma dessas características será um Range inteiro de 0 à 10.

<br>

### Ações
<br>

* Ao sentir fome
  * Comer muito: Aumenta 5 quilos e deve dormir **[perde 10 de fome]**
      * Se o Tamagotchi ultrapassar 20 quilos ele explode!
  * Comer pouco: Aumenta 1 quilo **[perde 3 de fome]**
  * Não comer: Perde 2 quilos
    * Se o Tamagotchi chegar aos 0 quilos ele morre desnutrido!
* Ao sentir sono
  * Dormir: Aumenta a idade em 1 dia **[perde 10 de sono]**
    * Morre no 15º dia! 
  * Permanecer acordado: Ao avisar pela 5ª vez seguida, dorme automaticamente (ninguém é de ferro)
* Ao sentir tédio
  * Correr 10 minutos: Perde 4 quilos e automaticamente come muito **[perde 10 de tédio]**
  * Caminhar 10 minutos: Perde 1 quilo e sente fome **[perde 3 de tédio]**
* Passar o tempo (realizar qualquer ação faz o tempo passar)
  * Fome aumenta em 1 (menos se estiver correndo ou caminhando)
  * Sono aumenta em 1 (menos se estiver dormindo)
  * Tédio aumenta em 1 (menos se estiver correndo ou caminhando)

<br>

### Características
<br>

* Sono
  * Caso o sono esteja ao menos em 9, o Tamagotchi ***sente sono***
* Fome
  * Caso a fome esteja ao menos no 7, o Tamagotchi ***sente fome***
* Tédio
  * Caso o tédio esteja ao menos em 7, o tamagotchi ***sente tédio***