## Trabalho personalizado - README.md

### 1. Motivações
As principais motivações são:
- Aprender a criar um robô;
- Aprender a usar um software novo (neste caso, o Robocode);
- Adquirir experência em programação participando de uma primeira competição do gênero;
- Construir um robô capaz de participar de uma competição de Robocode;
- Desenvolver habilidades na linguagem Java;
- Utilizar Java em uma aplicação de contexto real.

### 2. Resultados do trabalho
Um robô baseado na personagem Vex, capaz de:
- Manter ações constantes (loop do método run());
- Escanear outros robos;
- Agir quando atingido por uma bala;
- Agir quando atinge uma parede;
- Agir quando atinge outro robô;

### 3. Modificações

**Herança:** Não consegui criar novas classes para serem utilizadas com a principal, pois o software do Robocode não permite a criação de múltiplos arquivos, aparentemente. E criando uma classe que extendia a outra dentro de um único arquivo também não funcionou, independemente de eu ter deixado as classes em público ou em privado.

**Encapsulamento:** Utilizei encapsulamento em alguns métodos criados: moveInCircle(), goToEnemy, evadeAndAttack(HitByBulletEvent e), evade(HitWallEvent e). Os demais métodos como onHitWall(), onHitByBullet(), etc., não puderam ser encapsulados porque a superclasse "Robot", que é disponibilizada pelo software Robocode, já define o acesso destes métodos como público por padrão.

**Polimorfismo:** Tecnicamente a sobrescrita foi utilizda quando sobrescrevi os métodos disponibilizados pela superclasse "Robot", que por padrão não fazem nada e foram feitos para serem sobrescritos, mas nos demais métodos deste código não houve a necessidade de sobrescrita, pois nenhuma outra classe os utilizou de maneira diferente.

**No código:**
O código foi atualizado para possuir a mesma finalidade anterior, mas com uma divisão de métodos mais bem definida (métodos maiores foram divididos em métodos menores para serem reutilizados com mais facilidade). Além disso, o método onHitRobot() possuia um código comentado e este código foi descomentado e adaptado com o uso dos novos métodos criados (foi utilizado o novo método goToEnemy(enemyBearing) nele, por exemplo).

**Explicação do código:**
O código define uma classe newVex que extende a superclasse Robot.
O código possui os seguintes métodos:

**run():** define as cores e chama o método moveInCircle() para definir o comportamento padrão do robo.

**moveInCircle():** avança pelo tamanho do campo de batalha e gira 90 graus à esquerda a cada iteração do while.

**onScannedRobot():** verifica a distância e a energia do inimigo. Sendo a energia do inimigo menor ou igual a dele, atira 3 tiros nele para dar mais dano e vai pra cima do outro robô, do contrário, só atira 1 tiro.

**onHitByBullet():** chama o método redirectAndAttack().

**goToEnemy():** usa o método ahead() para ir para cima do inimigo na distância em que ele estiver. 

**redirectAndAttack():** recua, girar 90 graus na direção da origem da bala, avança 40 unidades e depois atira 1 bala.

**redirect():** recua, gira 90 graus e vai em frente 40 unidades. É chamado quando o robô bate em uma parede. 

**onHitWall():** chama o método redirect().

**onHitRobot():** Este é o método onde foram feitas mais alterações e onde o código, que havia sido comentado, foi descomentado. Ele verifica a energia da newVex em relação à energia do robô atingido e toma ações que se parecem com as da personagem Vex de acordo com a comparação. Ex: Se a energia da NewVex for maior ou igual a do robô atingido e se a direção em graus dele for menor que 10, chama o método goToEnemy() (que vai pra cima do inimigo) e atira 3 balas. 

No geral, o comportamento do robô ainda visa se assemelhar com o comportamento da personagem Vex do League of Legends, atacando e indo na direção inimiga quando eles estão com pouca vida e recuando e atirando de longe quando ela está com pouca vida (ou pelo menos com a vida menor que a deles).

### Referências:
https://robowiki.net/wiki/Robocode

https://robowiki.net/wiki/Robocode/My_First_Robot

https://robowiki.net/wiki/Melee_Strategy 

https://stackoverflow.com/questions/9727485/need-help-to-make-a-good-robocode-robot

https://robocode.sourceforge.io/docs/robocode/robocode/AdvancedRobot.html

http://mark.random-article.com/weber/java/robocode/lesson3.html

https://github.com/mgalushka/robocode-robots/tree/master/src/main/java/sample (utilizado para análise dos códigos dos robos sample, que são fornecidos pelo Robocode)

https://sic2.me/resources/robocode.pdf (deu a ideia de projetar uma estratégia pro robô antes de já começar criando ele sem propósito definido).
