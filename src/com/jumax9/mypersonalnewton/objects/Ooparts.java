package com.jumax9.mypersonalnewton.objects;


public class Ooparts {

	public static Oopart eleccion(String s) {
		if (s == "Mulhacén") {
			return mulhacen();
		} else if (s == "Aneto") {
			return aneto();
		} else if (s == "Dólmenes de Menga") {
			return menga();
		} else if (s == "Teide") {
			return teide();
		} else if (s == "Calvitero") {
			return calvitero();
		} else if (s == "Peña Trevinca") {
			return trevinca();
		} else if (s == "Pica d\'Estats") {
			return estats();
		} else if (s == "Teleno") {
			return teleno();
		} else if (s == "Puig Major") {
			return puigMajor();
		} else if (s == "Everest") {
			return everest();
		}
		return null;
	}
	
	public static Oopart everest() {
		String name = "el Everest";
		float height = 8850f; // m
		float latitude = 27.987778f;
		float longitude = 86.944444f;
		Oopart mulh = new Oopart(name, latitude, longitude, height, 0);
		return mulh;
	}

	public static Oopart puigMajor() {
		String name = "el Puig Major";
		float height = 1445f; // m
		float latitude = 39.8075f;
		float longitude = 2.793333f;
		Oopart mulh = new Oopart(name, latitude, longitude, height, 0);
		return mulh;
	}

	public static Oopart teleno() {
		String name = "el Teleno";
		float height = 2188f; // m
		float latitude = 42.346944f;
		float longitude = -6.392222f;
		Oopart mulh = new Oopart(name, latitude, longitude, height, 0);
		return mulh;
	}

	public static Oopart estats() {
		String name = "el Pica d\'Estats";
		float height = 3143f; // m
		float latitude = 42.66695f;
		float longitude = 1.397894f;
		Oopart mulh = new Oopart(name, latitude, longitude, height, 0);
		return mulh;
	}

	public static Oopart trevinca() {
		String name = "Peña Trevinca";
		float height = 2127f; // m
		float latitude = 42.246567f;
		float longitude = -6.797444f;
		Oopart mulh = new Oopart(name, latitude, longitude, height, 0);
		return mulh;
	}

	public static Oopart calvitero() {
		String name = "el Calvitero";
		float height = 2400f; // m
		float latitude = 40.292222f;
		float longitude = -5.740833f;
		Oopart mulh = new Oopart(name, latitude, longitude, height, 0);
		return mulh;
	}

	public static Oopart mulhacen() {
		String name = "el Mulhacén";
		float height = 3479f; // m
		float latitude = 37.061671f;
		float longitude = -3.317767f;
		Oopart mulh = new Oopart(name, latitude, longitude, height, 0);
		return mulh;
	}

	public static Oopart aneto() {
		String name = "el Aneto";
		float height = 3404f; // m
		float latitude = 42.633333f;
		float longitude = 0.666667f;
		Oopart anet = new Oopart(name, latitude, longitude, height, 0);
		return anet;
	}

	public static Oopart menga() {
		String name = "los Dólmenes de Menga";
		double mass = 7E8; // kg, assuming every one of the 32 dolmenes weights as much as the heavier one
		float latitude = 37.023503f;
		float longitude = -4.547165f;
		Oopart menga = new Oopart(name, latitude, longitude, 0f, mass);
		return menga;
	}

	public static Oopart teide() {
		String name = "el Teide";
		float height = 3718f; // m
		float latitude = 28.2725f;
		float longitude = -16.6425f;
		Oopart anet = new Oopart(name, latitude, longitude, height, 0);
		return anet;
	}

}
