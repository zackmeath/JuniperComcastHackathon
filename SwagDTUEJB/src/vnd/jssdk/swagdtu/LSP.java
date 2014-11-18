package vnd.jssdk.swagdtu;

import java.util.Arrays;
import java.util.List;

public class LSP {
	//Hard coded LSPs defined by list of links they move across
		public static final List<String> LSP1 = Arrays.asList("458783458773","458773458771","458779458771");
		public static final List<String> LSP2 = Arrays.asList("458787458783","458787458779");
		public static final List<String> LSP3 = Arrays.asList("458801458783","458801458795","458795458791","458791458779");
		public static final List<String> LSP4 = Arrays.asList("458783458773","458787458773","458787458771","458791458771","458791458779");
		//LSP attributes
		
		
		
		//lspID
		private int lspId;
		//interfaceToAccess the LSP from host
		private String lspInterface;
		//number of hops in lsp
		private int numHops;
		//average speed of total links
		private int speedAvg;
		//lowest speed of link in lsp
		private int lowestSpeed;
		//lowest MTU of link in hops
		private int lowestMtu;
		//whether the path is usable, if there's any down links. it's not
		private boolean pathUsable;
		
		//traffic data (calculated using the input on each interface on the LSP)
		
		//average bytes per second
		private float avgBps;
		//average packets on each interface
		private float avgPackets;
		//average bytes on each interface
		private float avgBytes;
		
		
		public float getAvgBytes(){
			return avgBytes;
		}
		public void setAvgBytes(float ab){
			avgBytes = ab;
		}
		public float getAvgBps() {
			return avgBps;
		}
		public float getAvgPackets() {
			return avgPackets;
		}
		public void setAvgBps(float bps) {
			avgBps = bps;
		}
		public void setAvgPackets(float avgp) {
			avgPackets = avgp;
		}
		public String getLspInterface() {
			return lspInterface;
		}
		public void setLspInterface(String lspInterface) {
			this.lspInterface = lspInterface;
		}
		public int getNumHops() {
			return numHops;
		}
		public void setNumHops(int numHops) {
			this.numHops = numHops;
		}
		public int getSpeedAvg() {
			return speedAvg;
		}
		public void setSpeedAvg(int speedAvg) {
			this.speedAvg = speedAvg;
		}
		public int getLowestSpeed() {
			return lowestSpeed;
		}
		public void setLowestSpeed(int lowestSpeed) {
			this.lowestSpeed = lowestSpeed;
		}
		public int getLowestMtu() {
			return lowestMtu;
		}
		public void setLowestMtu(int lowestMtu) {
			this.lowestMtu = lowestMtu;
		}
		public boolean isPathUsable() {
			return pathUsable;
		}
		public void setPathUsable(boolean pathUsable) {
			this.pathUsable = pathUsable;
		}
		public int getLspId() {
			return lspId;
		}
		public void setLspId(int lspId) {
			this.lspId = lspId;
		}
		
		
		
		
}
