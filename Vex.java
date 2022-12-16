package MeusRobos;
import robocode.*;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import java.awt.*;
import java.awt.Color;
import robocode.JuniorRobot;



/**
 * Vex - a robot by Ana Paula Militz Dorneles.
 */

public class Vex extends Robot
{
	public void run() {
		double BattleFieldCorners = Math.max(getBattleFieldHeight(), getBattleFieldWidth());
		setColors(Color.blue,Color.blue,Color.blue); // body,gun,radar
	//	turnRight(90);
		//ahead(BattleFieldCorners);
		while(true) {
			ahead(BattleFieldCorners);
			turnLeft(90);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
	 double myEnergy = getEnergy();
	 double enemyEnergy = e.getEnergy();
     double enemyDistance = e.getDistance();
	 
    	if(myEnergy >= enemyEnergy){ 
		/*Se a vida dele estiver menor que a minha ou a vida dele estiver muito baixa:
             Ir pra cima e atirar bastante (dar muito dano). */
	       fire(3);
		   ahead(enemyDistance); //vai na direcao do robo
		   //fire(3);
		  }
		else {
		/*Do contrário:
             Atirar de longe, com balas menos potentes.*/
			fire(1);
		}  
	}
	public void onHitByBullet(HitByBulletEvent e) {
		//Escaneia pra ver onde está o inimigo, se afasta pra longe e da um tiro no robo escaneado.
		back(20);
		turnLeft(e.getBearing()+ 90);
		ahead(40);
		turnGunLeft(e.getBearing()+ 90);
		fire(1);
		
	}
	
	public void onHitWall(HitWallEvent e) {
		//   Escaneia os inimigos mais próximos, vai bem rápido na direção de um ângulo em que não tenha inimigos e nem a parede.
		back(20);
		turnLeft(e.getBearing()+ 90);
		ahead(40);
	}	
	
	public void onHitRobot(HitRobotEvent e)
	{
     double myEnergy = getEnergy();
	 double enemyEnergy = e.getEnergy();
    // double enemyDistance = e.getDistance();
	/*
		if (myEnergy >= enemyEnergy)
		{
			fire(3);
			ahead(20);
			fire(1);
		}
		else if(enemyDistance < 10 && myEnergy < enemyEnergy)
		{
			back(20);
			fire(1);
		}
		else if(enemyDistance > 10 && myEnergy < enemyEnergy)
		{
			fire(1);
		}
		else {
			back(10);
		}*/
	back(10);
	}
		
}
