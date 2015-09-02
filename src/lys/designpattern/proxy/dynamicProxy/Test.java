package lys.designpattern.proxy.dynamicProxy;

interface ClothesFactory {
	void productClothes();
}

//被代理类
class NikeFactory implements ClothesFactory {

	@Override
	public void productClothes() {
		System.out.println("product clothes by nike factory");
	}
	
}

//代理类
class NikeProxy implements ClothesFactory {

	ClothesFactory factory;
	
	//创建代理类的对象时，传入被代理类的对象
	public NikeProxy(ClothesFactory factory) {
		this.factory = factory;
	}

	@Override
	public void productClothes() {
		System.out.println("开始处理。。。－代理");
		factory.productClothes();
		System.out.println("结束处理。。。－代理");
	}
	
}
public class Test {

	public static void main (String[] args) {
		NikeFactory cf = new NikeFactory();
		
		NikeProxy np = new NikeProxy(cf);
		
		np.productClothes();
	}
}
