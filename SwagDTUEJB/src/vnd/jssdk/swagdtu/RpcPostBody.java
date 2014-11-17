package vnd.jssdk.swagdtu;

public class RpcPostBody {	
	public static String generatePostBodyForDevice(String interfaceId){
		return "<netconf>"
				+ "<rpcCommands>"
				+ "<rpcCommand>"
				+"<![CDATA[<get-interface-information>"
				+ "<interface-name>"+interfaceId+"</interface-name>"
						+ "<extensive/>"
						+ "/get-interface-information>"
						+ "]]>"
						+ "</rpcCommand>"
						+ "</rpcCommands>"
						+ "</netConf>";
	}
}
