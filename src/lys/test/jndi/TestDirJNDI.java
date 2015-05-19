package lys.test.jndi;

import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;


public class TestDirJNDI {

	public static void main(String[] args) {

		// The user should provide a file to lookup
		// if (argv.length != 1) {
		// System.err.println("Usage: java Resolve2 ");
		// System.exit(-1);
		// }
		// Here we use the file system service provider
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.FSContextFactory");
		env.put(Context.PROVIDER_URL, "file:/uddi"); //"file:///uddi", "file:///c:/uddi"
		try {
			// Create the initial context
			Context ctx = new InitialContext(env);
			NamingEnumeration ne = ctx.listBindings("");
			while (ne.hasMore()) {
				Binding b = (Binding) ne.next();
				System.out.println(b.getName() + " " + b.getObject());
				
				/**
				 * the results is:
				 * 		test01.txt C:\\uddi\\test01.txt
				 *		test02.txt C:\\uddi\\test02.txt
				 *		test03.txt C:\\uddi\\test03.txt
				 *
				 */
			}
			// close the context
			ctx.close();
		} catch (NamingException e) {
			System.err.println("Problem looking up " + "file:///uddi" + ": "
					+ e);
		}
	}

}
