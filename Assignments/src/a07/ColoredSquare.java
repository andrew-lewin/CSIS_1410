// Andrew Lewin
package a07;

import java.awt.Color;

public class ColoredSquare {
	int side;
	Color color;
	
	public ColoredSquare(int side, Color color) {
		this.side = side;
		this.color = color;
	}
	
	public int area() {
		return side*side;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + side;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ColoredSquare))
			return false;
		ColoredSquare other = (ColoredSquare) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (side != other.side)
			return false;
		return true;
	}

	@Override
    public String toString() {
        String hex = Integer.toHexString(color.getRGB() & 0xffffff).toUpperCase();
        if (hex.length() < 6){
            hex = "000000".substring(0, 6 - hex.length()) + hex;
        }
        return "side:" + side + " #" + hex;
    }

}
