package vnd.jssdk.swagdtu;

public class RpcStats {
	private int inputBytes;
	private int inputBps;
	private int outputBytes;
	private int outputBps;
	private int inputPackets;
	private int outputPackets;
	private int inputPps;
	private int outputPps;
	
	public int getInputBytes() {
		return inputBytes;
	}
	public void setInputBytes(int inputBytes) {
		this.inputBytes = inputBytes;
	}
	public int getInputBps() {
		return inputBps;
	}
	public void setInputBps(int bpsInt) {
		this.inputBps = bpsInt;
	}
	public int getOutputBytes() {
		return outputBytes;
	}
	public void setOutputBytes(int outputBytes) {
		this.outputBytes = outputBytes;
	}
	public int getOutputBps() {
		return outputBps;
	}
	public void setOutputBps(int outputBps) {
		this.outputBps = outputBps;
	}
	public int getOutputPackets() {
		return outputPackets;
	}
	public void setOutputPackets(int outputPackets) {
		this.outputPackets = outputPackets;
	}
	public int getInputPackets() {
		return inputPackets;
	}
	public void setInputPackets(int inputPackets) {
		this.inputPackets = inputPackets;
	}
	public int getInputPps() {
		return inputPps;
	}
	public void setInputPps(int inputPps) {
		this.inputPps = inputPps;
	}
	public int getOutputPps() {
		return outputPps;
	}
	public void setOutputPps(int outputPps) {
		this.outputPps = outputPps;
	}
	
}
