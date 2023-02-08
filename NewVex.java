package MeusRobos;
import robocode.*;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import java.awt.*;
import java.awt.Color;
import robocode.JuniorRobot;

/**
 * newVex - a robot by Ana Paula Militz Dorneles.
 */

public class newVex extends Robot
{
	  public void run() {
		setColors(Color.blue,Color.blue,Color.blue); 
		moveInCircle();
	}
	
	private void moveInCircle() {
		double BattleFieldCorners = Math.max(getBattleFieldHeight(), getBattleFieldWidth());
		turnRight(90);
		while(true) {
		ahead(BattleFieldCorners);
		turnLeft(90);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		double myEnergy = getEnergy();
		double enemyEnergy = e.getEnergy();
		double enemyDistance = e.getDistance();

		if(myEnergy >= enemyEnergy) {
			fire(3);
			goToEnemy(enemyDistance);
		}
		else {
			fire(1);
		}  
	}
	

	public void onHitByBullet(HitByBulletEvent e) {
		redirectAndAttack(e);
	}
	
    private void goToEnemy(double enemyDistance) {
		ahead(enemyDistance); 
	}
	
	private void redirectAndAttack(HitByBulletEvent e) {
		back(20);
		turnLeft(e.getBearing() + 90);
		ahead(40);
		turnGunLeft(e.getBearing() + 90);
		fire(1);
	}
	
	private void redirect(HitWallEvent e) {
		back(20);
		turnLeft(e.getBearing() + 90);
		ahead(40);
	}
	
	public void onHitWall(HitWallEvent e) {
		redirect(e);
	}
	
	public void onHitRobot(HitRobotEvent e)
	{
	    double myEnergy = getEnergy();
	 	  double enemyEnergy = e.getEnergy();
      double enemyBearing = e.getBearing();
	
		if (myEnergy >= enemyEnergy && enemyBearing <10)
		{
			goToEnemy(enemyBearing);
			fire(3);
		}
		else if(enemyBearing < 10 && myEnergy < enemyEnergy)
		{
			back(20);
			fire(1);
		}
		else if(enemyBearing > 10 && myEnergy < enemyEnergy)
		{
			back(20);
		}
		else {
			back(10);
	    }
		
    }
}
