package balloon;

import javax.swing.Icon;

public class Balloon {
	private Size size;
	private boolean helium;
	private Icon icon;
	
	public Balloon(Size size, boolean helium, Icon icon) {
		this.size = size;
		this.helium = helium;
		this.icon = icon;
	}

	public Balloon(Size size, boolean helium) {
		this.size = size;
		this.helium = helium;
	}
	
	public Icon getIcon() {
		return icon;
	}
	
	public Size getSize() {
		return size;
	}
	
	public boolean isHelium() {
		return helium;
	}
	
	@Override
	public String toString() {
		return (helium ? "helium " : "air ") + size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (helium ? 1231 : 1237);
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Balloon))
			return false;
		Balloon other = (Balloon) obj;
		if (helium != other.helium)
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	
}
