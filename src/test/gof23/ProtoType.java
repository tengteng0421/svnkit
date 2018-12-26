package test.gof23;

import java.beans.Beans;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProtoType implements Cloneable, Serializable {
	List l = new ArrayList<>();

	// 浅克隆
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// 深克隆
	public ProtoType deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object object = ois.readObject();
		return (ProtoType) object;
	}

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		ProtoType p = new ProtoType();
		ProtoType p2 = p.deepClone();
		System.out.println(p + " " + p2);
		System.out.println(p.l == p2.l);
		java.beans.Beans bean = new Beans();
	}
}
