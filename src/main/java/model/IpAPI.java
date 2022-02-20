package model;

import services.IpAPIService;

public class IpAPI {
	public static IpAPIService getIpAPIService() {
		return new IpAPIService ("https://geo.ipify.org/","at_GGPalVeoUes9RHWopE8NDlFaMyIxI");
	}

}
