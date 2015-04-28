/**
Shows whether or not the signal in a certain area is poor
*/
public class SignalMap
{
	private boolean[][] map;
	private int size;
	private double threshold;
	private Network net;
	
	/**
	Create a signal map with a given size and provide a network and signal threshold.
	@param size The size of the map
	@param threshold The threshold below which the signal is considered poor
	@param net The network which the map represents
	*/
	public SignalMap(int size, double threshold, Network net)
	{
		this.size = size;
		this.threshold = threshold;
		this.net = net;
		map = new boolean[size][size];
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j< size; j++)
			{
				if(net.getSignal(i, j) < threshold)
				{
					map[i][j] = true;
				}
				else
				{
					map[i][j] = false;
				}
			}
		}
	}
	
	
	public String toString()
	{
		return "The map has size " + size + " and the threshold is " + threshold;
	}
	
	/**
	Output a visual representation of the map array which displays an x if the area has poor signal or a - if the area has good signal
	*/
	public void display()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(map[i][j] == true)
				{
					System.out.print("x ");
				}
				else
				{
					System.out.print("- ");
				}
			}
			System.out.println("");
		}
	}
	
	/**
	Returns the fraction of the signal map which has a poor signal
	@return The fraction of the map which has a poor signal
	*/
	public double poorSignal()
	{
		double f = 0.0;
		double fraction = 0.0;
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(map[i][j] == true)
				{
					f++;
				}
			}
		}
		fraction = f / (size * size);
		return fraction;
	}
	
	/**
	Compares a new given network with the original signal map to see the difference in signal strength.
	It displays x if the area is not covered, - if the old network covers that area but not the new network,
	! if the new network covers the area but the old one doesn't and = if both networks cover that area.
	@param net The new network
	*/
	public void compare(Network net)
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(map[i][j] == true)
				{
					if(net.getSignal(i, j) < threshold)
					{
						System.out.print("x ");
					}
					else
					{
						System.out.print("! ");
					}
				}
				else
				{
					if(net.getSignal(i, j) < threshold)
					{
						System.out.print("- ");
					}
					else
					{
						System.out.print("= ");
					}
				}
			}
			System.out.println("");
		}
	}
}
