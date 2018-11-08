package factorytest.creatorimpl;

import factorytest.Creator;
import factorytest.Product;
import factorytest.productimpl.ConcreteProduct1;

public class ConcreteCreator1 implements Creator {

	@Override
	public Product factory() {
		// TODO Auto-generated method stub
		return new ConcreteProduct1();
	}

}
