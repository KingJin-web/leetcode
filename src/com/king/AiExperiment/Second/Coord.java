package com.king.AiExperiment.Second;
/**
 * 
 * ClassName: Coord
 * 
 * @Description: 坐标
 * @author kesar
 */
public class Coord
{

	public int x;
	public int y;

	public Coord(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) return false;
		if (obj instanceof com.king.AiExperiment.Second.a.Coord)
		{
			com.king.AiExperiment.Second.a.Coord c = (com.king.AiExperiment.Second.a.Coord) obj;
			return x == c.x && y == c.y;
		}
		return false;
	}
}
