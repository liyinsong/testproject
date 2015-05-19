package lys.test.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestFileSystemJNDI {

	public static void main(String[] args) throws NamingException {

		Hashtable<String, String> env = new Hashtable<String, String>();
		String name = "C:\\easymock-3.2.zip";
		
		// 文件系统服务的提供者
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.RefFSContextFactory");
		Context ctx = new InitialContext(env);
		
		// 通过上下文查找名称对应的对象
		Object obj = ctx.lookup(name);
		System.out.println("名称：[" + name + "]绑定的对象是:" + obj);

	}

	public static void test() {
		Hashtable<String, String> env = new Hashtable<String, String>();
		//select a service provider factory
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.RefFSContextFactory");

		String name = "F://ecclient";
		try {
			// Create the initial context
			Context ctx = new InitialContext(env);

			// Look up an object
			Object obj = ctx.lookup(name);

			// Print it
			System.out.println(name + " is bound to: " + obj + "/t"
					+ obj.getClass());

		} catch (NamingException e) {
			System.err.println("Problem looking up " + name + ": " + e);
		}
	}
}
