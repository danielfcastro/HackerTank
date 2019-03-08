package br.com.daniel.challenges.advanced.covariantreturntypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Complete the classes below
class Flower {
	public String whatsYourName() {
		return "I have many names and types";
	}
}

class Jasmine extends Flower{
	@Override
	public String whatsYourName() {
		return "Jasmine";
	}
}

class Lily extends Flower{
	@Override
	public String whatsYourName() {
		return "Lily";
	}
}

class Region {
	protected Flower flower;
	public Flower getFlowerInstance() {
		if(null == flower) flower = new Flower();
		return flower;
	}
	public Flower yourNationalFlower() {
		return getFlowerInstance();
	}
}

class WestBengal extends Region{
	public WestBengal() {
		super();
		getFlowerInstance();
	}
	@Override
	public Flower getFlowerInstance() {
		if(null == flower) flower = new Jasmine();
		return flower;
	}
	@Override
	public Flower yourNationalFlower() {
		return getFlowerInstance();
	}	
}

class AndhraPradesh extends Region{
	public AndhraPradesh() {
		super();
		getFlowerInstance();
	}	
	@Override
	public Flower getFlowerInstance() {
		if(null == flower) flower = new Lily();
		return flower;
	}
	@Override
	public Flower yourNationalFlower() {
		return getFlowerInstance();
	}	
}


public class Solution {
  public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine().trim();
      Region region = null;
      switch (s) {
        case "WestBengal":
          region = new WestBengal();
          break;
        case "AndhraPradesh":
          region = new AndhraPradesh();
          break;
      }
      Flower flower = region.yourNationalFlower();
      System.out.println(flower.whatsYourName());
    }
}