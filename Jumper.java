public class Jumper implements Actor{
import info.gridworld.actor.Actor; 
import info.gridworld.actor.Flower; 
import info.gridworld.actor.Rock; 
import info.gridworld.grid.Grid; 
import info.gridworld.grid.Location; 
import java.awt.Color; 
 

 public Jumper() 
 { 
 setColor(Color.GREEN); 
 } 

 public Jumper(Color c) 
 { 
 setColor(c); 
 } 
 
 public void act() 
 { 
 if (canJump()) 
 jump(); 
 else 
 turn(); 
 } 
 

 public void turn() 
 { 
 setDirection(getDirection() + 90); 
 } 
 
 public void jump() 
 { 
 Grid<Actor> g = getGrid(); 
 if (g == null) 
 return; 
 Location l = getLocation(); 
 Location next = l.getAdjacentLocation(getDirection()); 
 Location twext = next.getAdjacentLocation(getDirection()); 
 if (g.isValid(twoAway)) 
 moveTo(twext); 
 else 
 removeSelfFromGrid(); 
 } 
 

 public boolean canJump() 
 { 
 Grid<Actor> g = getGrid(); 
 Location l = getLocation(); 
 Location next = l.getAdjacentLocation(getDirection()); 
 if (!g.isValid(next)) 
 return false; 
 Actor neighbor = g.get(next); 
 if (!((neighbor == null) || (neighbor instanceof Flower) 
 || (neighbor instanceof Rock))) 
 return false; 
 
 twext = next.getAdjacentLocation(getDirection()); 
 if (!g.isValid(twext)) 
 return false; 
 
 neighbor = g.get(twoAway); 
 return (neighbor == null) || (neighbor instanceof Flower); 
 } 
}
