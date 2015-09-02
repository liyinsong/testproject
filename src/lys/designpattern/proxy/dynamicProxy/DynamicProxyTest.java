package lys.designpattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
	void action();
}

//被代理类
class RealSubject implements Subject {

	@Override
	public void action() {
		System.out.println("我是被代理类。。。执行我哦。。。");
	}
	
}


class MyInvocationHandler implements InvocationHandler {

	Object obj; //实现了接口的被代理对象的声明
	
	//1.被代理类对象的实例化，2. 返回一个代理类对象
	public Object bind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	//当通过代理类的对象发起对重写的被代理类的方法调用时候，都会转化为对下面invoke方法的调用。
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//做其它一些为被代理类的服务。。。
		System.out.println("before do the real, do something...");
		//method方法的返回值
		Object returnVal = method.invoke(obj, args);
		
		System.out.println("after do the real, do something...");
		
		return returnVal;
	}
	
}


public class DynamicProxyTest {

	public static void main(String[] args) {
		
		//1.被代理类的对象
		RealSubject real = new RealSubject();
		//2.创建一个实现了InvocationHandler接口的对象
		MyInvocationHandler handler = new MyInvocationHandler();
		//3.调用bind方法，动态的返回一个同样实现了real所在类实现的接口Subject的代理类
		Object obj = handler.bind(real);
		
		Subject sub = (Subject)obj;//此时sub就是代理类的对象
		
		sub.action();//转到对InvocationHandler实现类的invoke方法的调用
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<");
		
		/**
		 * 体现动态生成代理类的例子:动态的生成代理类，相比较于静态代理、不必每个都写代理类，
		 * 动态代理在运行期间确定代理类类型从而动态都创建代理类。
		 */
		NikeFactory nike = new NikeFactory();
		ClothesFactory proxyFactory = (ClothesFactory)handler.bind(nike); //返回代理类对象
		proxyFactory.productClothes();
	}

}
