package airlines;

import java.util.*;
/* 
 * Resources Used: I used the lecture slides that were given to us in class and implemented those lessons to this code.
 * Furthermore, the discord group chat had similar questions as I had and my peers helped answer those questions along
 * the way. ALso used the JAVA API to help me understand some resources. 
 */
public class FlightNet extends HashSet<Airport>
{
	public boolean nameIsAvailable(String name) {
		for (Airport a: this) {
			if (a.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}
	
	public void connect(Airport a1, Airport a2) {
		a1.connectTo(a2);
		a2.connectTo(a1);
	}
	
	public void disconnect(Airport a1, Airport a2) {
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}
	
	public void removeAndDisconnect(Airport removeMe) {
		this.remove(removeMe);
		for (Airport a: this) {
			if (a.isConnectedTo(removeMe)) {
				a.disconnectFrom(removeMe);
			}
		}
	}
	
	public Airport getAirportNearXY(int x, int y, int maximumDistance) {
		for (Airport a: this) {
			if (Math.hypot(a.getX() - x, a.getY()-y) <= maximumDistance) {
				return a;
			}
		}
		return null;
	}
}
