public class Test
{
	public static void main(String[] args)
	{
		Transmitter t1 = new Transmitter(1.0, 0.5, 80.0);
		Transmitter t2 = new Transmitter(8.0, 1.2, 80.0);
		Transmitter t3 = new Transmitter(17.5, 17.0, 80.0);
		
		Transmitter t4 = new Transmitter(5.0, 3.0, 80.0);
		Transmitter t5 = new Transmitter(10.0, 2.0, 80.0);
		Transmitter t6 = new Transmitter(15.0, 15.0, 80.0);
		Network net = new Network();
		Network net2 = new Network();
		
		net.add(t1);
		net.add(t2);
		net.add(t3);
		
		net2.add(t4);
		net2.add(t5);
		net2.add(t6);
		SignalMap map = new SignalMap(20, 3.0, net);
		
		System.out.println(map);
		
		map.display();
		
		System.out.println(map.poorSignal());
		
		map.compare(net2);
	}
}
